package com.saico.victor.poketinder.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saico.victor.poketinder.data.model.User
import com.saico.victor.poketinder.util.SharedPreferenceUtil

class LoginViewModel(private val context: Context): ViewModel() {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    val emptyFieldsError = MutableLiveData<Boolean>()
    val fieldsAuthenticateError = MutableLiveData<Boolean>()
    val goSuccesActivity = MutableLiveData<Boolean>()

    init {
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreferences(context)
        }
    }

    fun validateInputs(email:String, password:String ) {
        if (email.isEmpty() && password.isEmpty()) {
            emptyFieldsError.postValue(true)
        }

        val user: User? = sharedPreferenceUtil.getUser()

        if (email == user?.email && password == user?.password) {
            goSuccesActivity.postValue(true)
        } else {
            fieldsAuthenticateError.postValue(true)
        }
    }
}