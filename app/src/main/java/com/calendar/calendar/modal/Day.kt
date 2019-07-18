package com.calendar.calendar.modal

import android.graphics.drawable.Drawable
import android.text.format.DateUtils
import com.calendar.R

data class Day(var dayNumber:Int,
               var time:Long,
               var isSelected:Boolean=false,
               var isDisabled:Boolean=false
               ){


    fun getCurrentDayBackground():Int{
        if (DateUtils.isToday(time)) {
            return R.drawable.ic_arrow_drop_down
        }
        return 0
    }


}