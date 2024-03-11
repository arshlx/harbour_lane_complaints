package com.harbourlane.hlcomplaints.model

data class ActiveComplaint(
    val invoiceNumber: String,
    val customerName: String,
    val state: String,
    val description: String,
    val logDate: String,
    val logLocation: String,
    val logDays: Int,
    val reviewStartDate: String,
    val reviewRequired: Boolean,
    val phoneNumber: Int,
    val complaintNumber: String,
    val storeCode: String
)