package com.calendar.calendar.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/** @param layoutId id of layout which you want to inflate
 * This is a extention function for layout inflator in recyclerview
 */
fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, true)
}