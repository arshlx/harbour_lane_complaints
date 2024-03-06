package com.harbourlane.hlcomplaints.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.harbourlane.hlcomplaints.R
import com.harbourlane.hlcomplaints.dashboard.DashboardActivity
import com.harbourlane.hlcomplaints.databinding.ActivityLoginBinding
import com.harbourlane.hlcomplaints.global_objects.Constants.LOGGED_IN
import com.harbourlane.hlcomplaints.global_objects.Constants.LOGIN

class LoginActivity : AppCompatActivity() {
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
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
                            finish()
                            startActivity(Intent(this@LoginActivity, DashboardActivity::class.java))
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
        resetErrors()
        binding.apply {
            loginBtn.apply {
                isEnabled = !idEdt.text.isNullOrEmpty() && !passwordEdt.text.isNullOrEmpty()
                /* if (isEnabled) setBackgroundColor(applicationContext.getColor(R.color.hl_official_colour)) else setBackgroundColor(
                     applicationContext.getColor(R.color.color_divider)
                 )*/
            }

        }
    }
}