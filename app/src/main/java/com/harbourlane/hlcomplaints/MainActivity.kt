package com.harbourlane.hlcomplaints

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.harbourlane.hlcomplaints.databinding.ActivityMainBinding
import com.harbourlane.hlcomplaints.global_objects.Constants.LOGGED_IN
import com.harbourlane.hlcomplaints.global_objects.Constants.LOGIN
import com.harbourlane.hlcomplaints.global_objects.DashboardActivity

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        editTextSetup()
    }

    private fun editTextSetup() {
        binding.apply {
            idEdt.apply {
                setOnFocusChangeListener { _, _ -> resetErrors() }
                doOnTextChanged { _, _, _, _ -> enableLoginBtn() }
            }
            passwordEdt.apply {
                setOnFocusChangeListener { _, _ -> resetErrors() }
                doOnTextChanged { _, _, _, _ -> enableLoginBtn() }
            }
            loginBtn.setOnClickListener {
                if (!idEdt.text.isNullOrEmpty() && !passwordEdt.text.isNullOrEmpty()) {
                    when {
                        !idEdt.text.toString().trim()
                            .equals(getString(R.string.id), false) -> {
                            idEdtLayout.error = getString(R.string.invalid_id)
                        }

                        !passwordEdt.text.toString()
                            .trim().equals(getString(R.string.pass), false) -> {
                            passwordEdtLayout.error = getString(R.string.incorrect_password)
                        }

                        else -> {
                            getSharedPreferences(LOGIN, MODE_PRIVATE)
                                .edit().putBoolean(LOGGED_IN, true).apply()
                            startActivity(Intent(this@MainActivity, DashboardActivity::class.java))
                        }
                    }
                }
            }
        }
    }

    private fun resetErrors() {
        binding.apply {
            idEdtLayout.error = null
            passwordEdtLayout.error = null
        }
    }

    private fun enableLoginBtn() {
        binding.apply {
            loginBtn.isEnabled = !idEdt.text.isNullOrEmpty() && !passwordEdt.text.isNullOrEmpty()
        }
    }
}