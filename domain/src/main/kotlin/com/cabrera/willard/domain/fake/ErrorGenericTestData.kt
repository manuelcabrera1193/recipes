/* Willard Cabrera - 2023 */
package com.cabrera.willard.domain.fake

import com.cabrera.willard.domain.models.ErrorGeneric

object ErrorGenericTestData {
    const val code: Int = 404
    const val description: String = "Not Found"

    fun create() = ErrorGeneric(code, description)
}
