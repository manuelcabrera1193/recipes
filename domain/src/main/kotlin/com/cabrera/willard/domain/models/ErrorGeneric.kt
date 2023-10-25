/* Willard Cabrera - 2023 */
package com.cabrera.willard.domain.models

class ErrorGeneric(
    val code: Int,
    val description: String,
) : Exception(description)
