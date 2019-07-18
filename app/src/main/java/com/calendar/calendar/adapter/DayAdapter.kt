package com.calendar.calendar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calendar.R
import com.calendar.calendar.modal.Day
import kotlinx.android.synthetic.main.item_day.view.*
import timber.log.Timber

class DayAdapter(val days: ArrayList<Day>) : RecyclerView.Adapter<DayAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return days.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(days[position])
    }

   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

       fun bindItems(day:Day){
           itemView.tv_day.text = "${day.dayNumber}"
           
           itemView.tv_day
               .setCompoundDrawablesWithIntrinsicBounds(0,0,0,day.getCurrentDayBackground())


       }
    }


}