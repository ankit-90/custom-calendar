package com.calendar.calendar.utils

import timber.log.Timber
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author Ankit Chandel
 * @since 17 July, 2019
 *
 * <h1>Date Utils</h1>
 * <p>Utility class for dates</p>
 * */
object DateUtils {

    /**
     * @param YEAR_END set this for how many years you want to create dates
     * */
    private const val YEAR_END = 2
    private val calendar = Calendar.getInstance()
    private val anotherCalendar = Calendar.getInstance()


    init {

    }


    fun createDatesFromCurrentDay(): ArrayList<Date> {
        anotherCalendar.add(Calendar.YEAR, YEAR_END)
        val format = DateFormat.getDateInstance().format(calendar.time)




        val df = SimpleDateFormat("dd MMM yyyy")
        val formatEnd = DateFormat.getDateInstance().format(anotherCalendar.time)

        var dates = ArrayList<Date>()

        calendar.time = df.parse(format)
        anotherCalendar.time = df.parse(formatEnd)


        while (!calendar.after(anotherCalendar)) {
            val date = Date(calendar.timeInMillis)
            dates.add(date)
            calendar.add(Calendar.DATE, 1)

        }

        return dates

    }


    fun getDaysInMonth():Int{
       return calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    }

    fun getMonthDifference():Int{
        anotherCalendar.add(Calendar.YEAR, YEAR_END)
        val diffYear = anotherCalendar.get(Calendar.YEAR) - calendar.get(Calendar.YEAR)

        val diffMonth = diffYear * 12 + anotherCalendar.get(Calendar.MONTH) - calendar.get(Calendar.MONTH)
        Timber.d("$diffYear== $diffMonth")
        return  diffMonth
    }


}