/* Willard Cabrera - 2023 */
package com.cabrera.willard.data.entities

import com.cabrera.willard.data.fake.LocationEntityTestData
import org.junit.Assert.assertEquals
import org.junit.Test

class LocationEntityTest {
    @Test
    fun testLocationEntityInitialization() {
        val locationEntity = LocationEntityTestData.createLocationEntity()

        assertEquals(LocationEntityTestData.latitude, locationEntity.latitude)
        assertEquals(LocationEntityTestData.longitude, locationEntity.longitude)
    }

    @Test
    fun testLocationEntityEquality() {
        val locationEntity1 = LocationEntityTestData.createLocationEntity()
        val locationEntity2 = LocationEntityTestData.createLocationEntity()

        assertEquals(locationEntity1.latitude, locationEntity2.latitude)
        assertEquals(locationEntity1.longitude, locationEntity2.longitude)
    }
}
