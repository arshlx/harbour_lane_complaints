package com.harbourlane.hlcomplaints.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.harbourlane.hlcomplaints.model.ActiveComplaint

class DashboardViewModel(app: Application) : AndroidViewModel(app) {
    init {

    }
    val activeComplaintList = mutableListOf<ActiveComplaint>()
}