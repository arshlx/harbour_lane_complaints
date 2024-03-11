package com.harbourlane.hlcomplaints.dashboard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.harbourlane.hlcomplaints.adapters.ActiveComplaintsAdapter
import com.harbourlane.hlcomplaints.databinding.FragmentActiveComplaintsBinding


class ActiveComplaintsFragment : Fragment() {
    private var _binding: FragmentActiveComplaintsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ActiveComplaintsAdapter

    companion object {
        @JvmStatic
        fun newInstance() = ActiveComplaintsFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActiveComplaintsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

        }
    }
}