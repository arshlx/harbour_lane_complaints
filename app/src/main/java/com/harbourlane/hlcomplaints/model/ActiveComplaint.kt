package com.harbourlane.hlcomplaints.model

data class ActiveComplaint(
    val complaintNum: String,
    val customerName: String,
    val complaintState: String,
    val complaintDescription: String,
    val complaintLogDate: String,
    val complaintLogLocation: String,
    val complaintLogDays: Int,
    val complaintReviewStartDate: String,
    val complaintReviewRequired: Boolean
)