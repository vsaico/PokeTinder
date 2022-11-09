package com.saico.victor.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.saico.victor.poketinder.databinding.ActivityLoginBinding
import com.saico.victor.poketinder.ui.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = LoginViewModel(this)

        binding.btnLogin.setOnClickListener {
            startLogin()
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        loginViewModel.emptyFieldsError.observe(this) {
            Toast.makeText(this, "Ingrese los datos del usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.fieldsAuthenticateError.observe(this) {
            Toast.makeText(this, "Error usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.goSuccesActivity.observe(this) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun startLogin() {
        loginViewModel.validateInputs(
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString()
        )
    }
}