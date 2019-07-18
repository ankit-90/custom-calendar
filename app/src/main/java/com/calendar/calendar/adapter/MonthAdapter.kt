package com.calendar.calendar.adapter

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.calendar.R
import com.calendar.calendar.modal.Month
import kotlinx.android.synthetic.main.item_month.view.*
import timber.log.Timber
import kotlin.collections.ArrayList


class MonthAdapter(var months:ArrayList<Month>) : RecyclerView.Adapter<MonthAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_month, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(months[position])


    }

    override fun getItemCount(): Int {
        return months.size
    }

    fun updateAdapter(months: java.util.ArrayList<Month>) {
        this.months =  months

        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(month: Month){

            itemView.tv_date.text = month.monthAndYear()
            //val dayAdapter = DayAdapter(month.getTotalDaysInMonth())
            val dayAdapter = DayAdapter( month.getDaysInMonth())

            val gridLayoutManager = GridLayoutManager(itemView.context, 7)
            val dayNames = itemView.context.resources.getStringArray(R.array.days)
            val dayNamesAdapter = DayNameAdapter(dayNames)
            itemView.rv_day_name.adapter = dayNamesAdapter
            itemView.rv_day_name.layoutManager = GridLayoutManager(itemView.context, 7)
            itemView.rv_month.layoutManager = gridLayoutManager
            itemView.rv_month.adapter = dayAdapter

        }


    }


}