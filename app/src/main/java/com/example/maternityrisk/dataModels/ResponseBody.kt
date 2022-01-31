package com.example.maternityrisk.dataModels

import com.google.gson.annotations.SerializedName

data class ResponseBody(
    @SerializedName("Results") val results: Results
)

data class Results(
    @SerializedName("output1") val output: Output
)

data class Output(
    val value: Value
)

data class Value(
    @SerializedName("Values") val values: List<List<String>>
)