package com.saico.victor.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import com.saico.victor.poketinder.util.SharedPreferenceUtil
import com.saico.victor.poketinder.data.model.User
import com.saico.victor.poketinder.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreferences(this)
        }

        binding.btnRegister.setOnClickListener {
            val userId = "1"

            val userName = binding.edtUserName.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            val user = User(
                userId,
                userName,
                email,
                password
            )

            sharedPreferenceUtil.saveUser(user)
            startActivity(Intent(this, LoginActivity::class.java))
        }


        binding.btnGoLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}