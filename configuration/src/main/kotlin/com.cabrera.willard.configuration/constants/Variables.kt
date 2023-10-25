/* Willard Cabrera - 2023 */
package com.cabrera.willard.configuration.constants

import com.android.build.gradle.internal.dsl.BuildType
import java.util.Locale

object Variables {
    private const val APP_NAME = "Recipes"

    private fun BuildType.addVariable(
        typeVariable: TypeVariable,
        typeData: String,
        name: String,
        value: String,
    ) {
        when (typeVariable) {
            TypeVariable.ResValue -> {
                resValue(typeData.lowercase(Locale.getDefault()), name, "\"$value\"")
            }

            TypeVariable.BuildConfigField -> {
                buildConfigField(
                    typeData.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.getDefault()
                        ) else it.toString()
                    },
                    name, "\"$value\""
                )
            }
        }
    }

    private fun addAppName(buildType: BuildTypeCulqi): Pair<String, Pair<String, String>> {
        if (buildType == BuildTypeCulqi.Release) {
            return Pair(TypeData.String.name, Pair("app_name", APP_NAME))
        }
        return Pair(TypeData.String.name, Pair("app_name", "$APP_NAME $buildType"))
    }

    private fun addUrlBase(buildType: BuildTypeCulqi): Pair<String, Pair<String, String>> {
        val url = "http://demo5823315.mockable.io/"
        return when (buildType) {
            BuildTypeCulqi.Debug -> Pair(TypeData.String.name, Pair("url_name", url))
            // BuildTypeCulqi.UAT -> Pair(TypeData.String.name, Pair("url_name", url))
            BuildTypeCulqi.Release -> Pair(TypeData.String.name, Pair("url_name", url))
        }
    }

    private fun BuildType.addVariables(list: List<Pair<TypeVariable, Pair<String, Pair<String, String>>>>) {
        list.forEach {
            addVariable(
                typeVariable = it.first,
                typeData = it.second.first,
                name = it.second.second.first.lowercase(Locale.getDefault()),
                value = it.second.second.second,
            )
        }
    }

    fun BuildType.addAppVariables(buildType: BuildTypeCulqi) {
        val appName: Pair<String, Pair<String, String>> = addAppName(buildType)

        val listVariables: List<Pair<TypeVariable, Pair<String, Pair<String, String>>>> = listOf(
            Pair(TypeVariable.ResValue, appName),
        )

        addVariables(listVariables)
    }

    fun BuildType.addLibraryVariables(buildType: BuildTypeCulqi) {

        val endpoints: MutableList<Pair<TypeVariable, Pair<String, Pair<String, String>>>> =
            Endpoints.addEndpoints().map {
                Pair(TypeVariable.BuildConfigField, Pair(TypeData.String.name, it))
            }.toMutableList()

        val urlBase: Pair<String, Pair<String, String>> = addUrlBase(buildType)
        endpoints.add(Pair(TypeVariable.BuildConfigField, urlBase))

        addVariables(endpoints)
    }

    enum class TypeVariable {
        ResValue,
        BuildConfigField
    }

    sealed class TypeData : NameTypeData {
        object String : TypeData() {
            override val name = "String"
        }
    }

    internal interface NameTypeData {
        val name: String
    }
}
