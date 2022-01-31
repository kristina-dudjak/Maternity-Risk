package com.example.maternityrisk.interfaces

import com.example.maternityrisk.dataModels.RequestBody
import com.example.maternityrisk.dataModels.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIInterface {
    @Headers(
        "Authorization: Bearer k0N2LJBSGGYftADTJ50fXJo3AVipnJ18yctG0cHkMkF80Df62B3iyJzSJS9akpFgGPEHHWk101e0fSs1778Rng==",
        "Content-Type: application/json")
    @POST("execute?api-version=2.0")
    fun predictRisk(@Body entryData: RequestBody) : Call<ResponseBody>


}