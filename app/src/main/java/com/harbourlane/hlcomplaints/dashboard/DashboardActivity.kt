package com.harbourlane.hlcomplaints.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harbourlane.hlcomplaints.R
import com.harbourlane.hlcomplaints.databinding.ActivityDashboardBinding
import com.harbourlane.hlcomplaints.databinding.ActivityLoginBinding

class DashboardActivity : AppCompatActivity() {

    private var _binding: ActivityDashboardBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}