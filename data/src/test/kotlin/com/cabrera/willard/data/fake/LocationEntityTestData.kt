/* Willard Cabrera - 2023 */
package com.cabrera.willard.data.fake

import com.cabrera.willard.data.entities.LocationEntity

object LocationEntityTestData {
    const val latitude = "42.12345"
    const val longitude = "12.34567"
    fun createLocationEntity(): LocationEntity {
        return LocationEntity(
            latitude = latitude,
            longitude = longitude
        )
    }
}
