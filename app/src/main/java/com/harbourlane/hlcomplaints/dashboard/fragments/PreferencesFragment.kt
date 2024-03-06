package com.harbourlane.hlcomplaints.dashboard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.harbourlane.hlcomplaints.databinding.FragmentAllComplaintsBinding

class PreferencesFragment : Fragment() {

    private var _binding: FragmentAllComplaintsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllComplaintsBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = PreferencesFragment().apply {
            arguments = Bundle()
        }
    }
}