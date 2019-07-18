package com.calendar.calendar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper

import com.calendar.calendar.adapter.MonthAdapter
import kotlinx.android.synthetic.main.calendar_view.view.*
import java.util.*
import kotlin.collections.ArrayList
import com.calendar.R
import com.calendar.calendar.adapter.DayNameAdapter
import com.calendar.calendar.modal.Month
import com.calendar.calendar.utils.DateUtils
import kotlinx.android.synthetic.main.item_month.view.*
import timber.log.Timber
import java.text.SimpleDateFormat


class CalendarView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    RelativeLayout(context, attrs, defStyleAttr) {

    private var months: ArrayList<Month> = ArrayList()


    init {
        init(context)
    }


    private fun init(context: Context) {

        LayoutInflater.from(context).inflate(R.layout.calendar_view, this, true)

        val dates = DateUtils.createDatesFromCurrentDay()

        val adapter = MonthAdapter(months)
        rv_calendar.adapter = adapter
        rv_calendar.isNestedScrollingEnabled = false
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_calendar)
        var lastMonth = "0"
        for (i in 0..dates.size-1) {

            val year = SimpleDateFormat("yyyy").format(dates[i].time)
            val name = SimpleDateFormat("MMMM").format(dates[i].time)
            val number = SimpleDateFormat("M").format(dates[i].time)
            if(!lastMonth.equals(number)){
                val month = Month(number,name,year.toInt(),dates[i].time)
                months.add(month)

            }
            lastMonth = number
        }

        adapter.updateAdapter(months)

    }


}