package com.calendar.calendar

import android.os.AsyncTask

class doAsynch(val handler: () -> Unit) : AsyncTask<Void, Void, Void>() {
    override fun doInBackground(vararg p0: Void?): Void? {
        handler()
        return null
    }

}