package com.harbourlane.hlcomplaints.global_objects

object Constants {
    const val LOGIN = "login"
    const val LOGGED_IN = "logged in"
    const val NUM_SCREENS = 3
}

object ScreenName {
    const val NAV_ACTIVE_COMPLAINTS = 0
    const val NAV_ALL_COMPLAINTS = 1
    const val NAV_PREFERENCES = 2
}

object ComplaintState {
    const val RECEIVED = "received"
    const val INSPECTION_REQUIRED = "inspection required"
    const val INSPECTION_UNDERWAY = "inspection underway"
    const val UNDER_REVIEW = "under review"
    const val DISPUTED_FT = "disputed fair trading"
    const val AWAITING_RESPONSE = "awaiting response"
    const val CLOSED = "closed"
    const val OVERDUE = "overdue"
    const val AUTO_CLOSED = "complaint auto-closed"
}