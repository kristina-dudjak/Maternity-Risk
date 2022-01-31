package com.example.maternityrisk.services

import com.example.maternityrisk.dataModels.RequestBody
import com.example.maternityrisk.dataModels.ResponseBody
import com.example.maternityrisk.interfaces.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiService {
    fun predictRisk(entryData: RequestBody, onResult: (ResponseBody?) -> Unit){
        val retrofit = ServiceBuilder.buildService(APIInterface::class.java)
        retrofit.predictRisk(entryData).enqueue(
            object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    val prediction = response.body()
                    onResult(prediction)
                }
            }
        )
    }
}