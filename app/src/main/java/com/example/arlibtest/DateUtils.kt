package com.example.arlibtest

import android.content.Context
import java.util.*

fun getCurrentDayTime(): DayTime {
    val calendar = Calendar.getInstance()
    return when (calendar.get(Calendar.HOUR_OF_DAY)) {
        in 0..11 -> DayTime.MORNING
        in 12..15 -> DayTime.AFTERNOON
        else -> DayTime.EVENING
    }
}

fun getGreetingWord(context: Context, dayTime: DayTime): String {
    return when (dayTime) {
        DayTime.MORNING -> context.getString(R.string.good_morning)
        DayTime.AFTERNOON -> context.getString(R.string.good_afternoon)
        DayTime.EVENING -> context.getString(R.string.good_evening)
    }
}

enum class DayTime {
    MORNING, AFTERNOON, EVENING
}