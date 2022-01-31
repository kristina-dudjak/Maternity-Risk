package com.example.maternityrisk.dataModels

import com.google.gson.annotations.SerializedName

data class RequestBody(

    @SerializedName("Inputs") val inputs: Inputs?,
    @SerializedName("GlobalParameters") val globalParameters: String
){
    companion object {
        fun create(features: Features): RequestBody {
            val columnNames = getColumnNames()
            val values = listOf(getFeatures(features))
            val input = Input(columnNames, values)
            val inputs = Inputs(input)
            return RequestBody(inputs, "")
        }
    }
}
data class Inputs(
    @SerializedName("input1") val input: Input?
)
data class Input(
    @SerializedName("ColumnNames") val columnNames: List<String>?,
    @SerializedName("Values") val values: List<List<String>>
)

fun getFeatures(features: Features) : List<String> {
    return listOf(features.age.toString(), features.systolicBP.toString(), features.diastolicBP.toString(),
    features.BS.toString(), features.bodyTemp.toString(), features.heartRate.toString(), features.riskLevel)
}

fun getColumnNames() : List<String>{
    return listOf( "Age", "SystolicBP", "DiastolicBP", "BS", "BodyTemp", "HeartRate", "RiskLevel")
}
