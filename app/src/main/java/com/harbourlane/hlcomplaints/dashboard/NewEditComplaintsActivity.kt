package com.harbourlane.hlcomplaints.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harbourlane.hlcomplaints.R
import com.harbourlane.hlcomplaints.databinding.ActivityDashboardBinding
import com.harbourlane.hlcomplaints.databinding.ActivityNewEditComplaintsBinding

class NewEditComplaintsActivity : AppCompatActivity() {

    private var _binding: ActivityNewEditComplaintsBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNewEditComplaintsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}