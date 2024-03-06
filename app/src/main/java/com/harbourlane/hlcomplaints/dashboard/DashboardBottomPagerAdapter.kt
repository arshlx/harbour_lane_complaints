package com.harbourlane.hlcomplaints.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.harbourlane.hlcomplaints.dashboard.fragments.ActiveComplaintsFragment
import com.harbourlane.hlcomplaints.dashboard.fragments.AllComplaintsFragment
import com.harbourlane.hlcomplaints.dashboard.fragments.PreferencesFragment
import com.harbourlane.hlcomplaints.global_objects.Constants
import com.harbourlane.hlcomplaints.global_objects.ScreenName
import interfaces.PositionInterface

class DashboardBottomPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val listener: PositionInterface
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = Constants.NUM_SCREENS
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            ScreenName.NAV_ACTIVE_COMPLAINTS -> {
                listener.onPositionChanged(position)
                ActiveComplaintsFragment.newInstance()
            }

            ScreenName.NAV_ALL_COMPLAINTS -> {
                listener.onPositionChanged(position)
                AllComplaintsFragment.newInstance()
            }

            else -> {
                listener.onPositionChanged(position)
                PreferencesFragment.newInstance()
            }
        }
    }

}