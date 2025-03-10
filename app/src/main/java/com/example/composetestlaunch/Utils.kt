package com.example.composetestlaunch

import android.icu.util.Calendar

fun calculateAge(birthYear: Int): Int {
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    return if (birthYear in 1900..currentYear) currentYear - birthYear else 0
}