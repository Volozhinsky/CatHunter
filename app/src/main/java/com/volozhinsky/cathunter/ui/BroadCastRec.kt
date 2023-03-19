package com.volozhinsky.cathunter.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadCastRec(): BroadcastReceiver() {
    override fun onReceive(p0: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false)
        Toast.makeText(p0,isAirplaneModeEnabled.toString(), Toast.LENGTH_SHORT).show()
    }
}