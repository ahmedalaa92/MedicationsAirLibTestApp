package com.example.arlibtest

import io.mockk.every
import io.mockk.mockkStatic
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.Calendar

class DateUtilsKtTest {

    @Before
    fun setup() {
        mockkStatic(Calendar::class)
    }

    @Test
    fun testGetCurrentDayTime_WithAMorningHour_VerifyReturnDayTimeMORNING() {
        every { Calendar.getInstance().get(Calendar.HOUR_OF_DAY) } returns 4
        assertEquals(DayTime.MORNING, getCurrentDayTime())
    }

    @Test
    fun testGetCurrentDayTime_WithAEveningHour_VerifyReturnDayTimeEVENING() {
        every { Calendar.getInstance().get(Calendar.HOUR_OF_DAY) } returns 22
        assertEquals(DayTime.EVENING, getCurrentDayTime())
    }

    @Test
    fun testGetCurrentDayTime_WithAnAfternoonHour_VerifyReturnDayTimeAFTERNOON() {
        every { Calendar.getInstance().get(Calendar.HOUR_OF_DAY) } returns 15
        assertEquals(DayTime.AFTERNOON, getCurrentDayTime())
    }

}