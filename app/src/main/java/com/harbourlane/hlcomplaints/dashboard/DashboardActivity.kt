package com.harbourlane.hlcomplaints.dashboard

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.harbourlane.hlcomplaints.R
import com.harbourlane.hlcomplaints.databinding.ActivityDashboardBinding
import com.harbourlane.hlcomplaints.global_objects.ScreenName
import interfaces.PositionInterface

class DashboardActivity : AppCompatActivity(), PositionInterface {

    private var _binding: ActivityDashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var bottomPagerAdapter: DashboardBottomPagerAdapter
    private var exit = false
    private lateinit var toast: Toast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBottomNav()
    }

    private fun setUpBottomNav() {
        bottomPagerAdapter = DashboardBottomPagerAdapter(supportFragmentManager, lifecycle, this)
        binding.apply {
            fragmentPager.apply {
                adapter = bottomPagerAdapter
                currentItem = ScreenName.NAV_ACTIVE_COMPLAINTS
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        bottomNav.selectedItemId = when (position) {
                            0 -> R.id.nav_active_complaints
                            1 -> R.id.nav_all_complaints
                            else -> R.id.nav_preferences
                        }
                        super.onPageSelected(position)
                    }
                })
            }
            bottomNav.apply {
                setOnItemSelectedListener {
                    fragmentPager.currentItem = when (it.itemId) {
                        R.id.nav_active_complaints -> {
                            title = getString(R.string.nav_active_complaints)
                            binding.btnNewComplaint.show()
                            ScreenName.NAV_ACTIVE_COMPLAINTS
                        }

                        R.id.nav_preferences -> {
                            title = getString(R.string.nav_preferences)
                            binding.btnNewComplaint.hide()
                            ScreenName.NAV_PREFERENCES
                        }

                        else -> {
                            title = getString(R.string.nav_all_complaints)
                            binding.btnNewComplaint.hide()
                            ScreenName.NAV_ALL_COMPLAINTS
                        }
                    }
                    true
                }
            }
        }
    }

    override fun onPositionChanged(position: Int) {
        binding.bottomNav.selectedItemId = position
    }
}