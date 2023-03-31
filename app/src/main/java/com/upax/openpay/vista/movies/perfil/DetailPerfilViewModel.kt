package com.upax.openpay.vista.movies.perfil

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upax.openpay.BuildConfig
import com.upax.openpay.api.Repository
import com.upax.openpay.model.Response_review
import com.upax.openpay.model.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList

class DetailPerfilViewModel : ViewModel() {

    private val TAG = this::class.java.simpleName
    val _loading = MutableLiveData<Boolean>()
    val _error = MutableLiveData<String>()
    val _perfil = MutableLiveData<Response_review?>()

    fun getPerfil() {
        _loading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = Repository.getRepositoryApi().getRequestPerfil()
                _loading.postValue(false)
                if (response.isSuccessful && response.code() == 200) {
                    val ServiceResponse = response.body() ?: null

                    if (ServiceResponse != null) {
                        Log.d(
                            TAG,
                            "DESCRIPCION DEL SERVICIO : ${ServiceResponse.author}"
                        )
                    }

                       _perfil.postValue(ServiceResponse)
                        Log.d(TAG, "RESPONSE _messages: ${_perfil}")
                    } else {
                        Log.d(
                            TAG,
                            "RESPONSE ERROR "
                        )
                    }
            } catch (e: Exception) {
                _loading.postValue(false)
                _error.postValue("Error al obtener la información del servidor")
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "Error: ${e.printStackTrace()}")
            }
        }
    }
}

