package com.juneNine.composeWithMVVM.utils

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters

object Time {
    fun getFirstDayOfMonthFromTimestamp(timestamp: Long): LocalDate {
        val instant = Instant.ofEpochMilli(timestamp)
        val zoneId = ZoneId.systemDefault()
        val date = instant.atZone(zoneId).toLocalDate()
        return date.withDayOfMonth(1)
    }

    fun getLastDayOfMonthFromTimestamp(timestamp: Long): LocalDate {
        val instant = Instant.ofEpochMilli(timestamp)
        val zoneId = ZoneId.systemDefault()
        val yearMonth = YearMonth.from(instant.atZone(zoneId))
        return yearMonth.atEndOfMonth()
    }

    fun getLocalDateFromTimestamp(timestamp: Long): LocalDate {
        val instant = Instant.ofEpochMilli(timestamp)
        val zoneId = ZoneId.systemDefault()
        return instant.atZone(zoneId).toLocalDate()
    }


    fun Long.toDateFormat(pattern: String? = null): String {
        try {
            val pt = pattern ?: "dd/MM/yyyy"
            val date = getLocalDateFromTimestamp(this)
            return date.format(DateTimeFormatter.ofPattern(pt))
        } catch (e: Exception) {
            return ""
        }
    }

    fun getFirstDayOfPast12Months(): List<LocalDate> {
        val currentDate = LocalDate.now()
        val firstDayOfCurrentMonth = currentDate.with(TemporalAdjusters.firstDayOfMonth())
        val months = mutableListOf<LocalDate>()
        for (i in 0 until 12) {
            val month = firstDayOfCurrentMonth.minusMonths(i.toLong())
            val firstDayOfMonth = month.with(TemporalAdjusters.firstDayOfMonth())
            months.add(firstDayOfMonth)
        }
        return months
    }

    fun getMonthYear(localDate: LocalDate): String {
        return localDate.format(DateTimeFormatter.ofPattern("MMM yyyy"))
    }

    fun LocalDate.getMillis(): Long {
        val zonedDateTime = this.atStartOfDay().atZone(ZoneOffset.UTC)
        return zonedDateTime.toInstant().toEpochMilli()
    }
}