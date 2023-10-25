/* Willard Cabrera - 2023 */
package com.cabrera.willard.data.entities

import com.squareup.moshi.Json

class LocationEntity(
    @Json(name = "latitude") val latitude: String?,
    @Json(name = "longitude") val longitude: String?,
)
