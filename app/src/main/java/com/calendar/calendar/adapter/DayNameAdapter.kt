package com.calendar.calendar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calendar.R
import kotlinx.android.synthetic.main.item_day_name.view.*

class DayNameAdapter(val dayNames: Array<String>): RecyclerView.Adapter<DayNameAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day_name, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dayNames.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(dayNames[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindItems(name: String) {
            itemView.tv_day_name.text = "$name"
        }

    }
}