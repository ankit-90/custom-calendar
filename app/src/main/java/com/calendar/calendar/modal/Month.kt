package com.calendar.calendar.modal

import android.os.AsyncTask
import android.text.format.DateFormat
import android.text.format.DateUtils
import com.calendar.base.BaseApp
import com.calendar.calendar.utils.DateUtils.getDaysInMonth
import timber.log.Timber
import java.util.*
import java.util.logging.Handler
import kotlin.collections.ArrayList

data class Month(var number:String, var name:String,var year:Int,var time:Long) {


    var days:ArrayList<Day> = ArrayList()


    fun isCurrentDay():Boolean{
        return DateUtils.isToday(time)
    }

    fun monthAndYear():String{
        return "$name, $year"
    }

    fun getTotalDaysInMonth():Int{
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = time
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    }

    fun getDaysInMonth():ArrayList<Day>{
        val instance = Calendar.getInstance()
        var dayCounter = 0
        for (i in 1..getTotalDaysInMonth()){
            instance.add(Calendar.DATE,dayCounter)
            Timber.d("${Calendar.getInstance().time}==== ${instance.time}")
            val day  = Day(i,instance.timeInMillis)
            days.add(day)
            dayCounter++
        }
        return days
    }






}