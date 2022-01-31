package com.example.maternityrisk.dataModels

data class Features(
    var age: Int,
    var systolicBP: Int,
    var diastolicBP: Int,
    var BS: Double,
    var bodyTemp: Int,
    var heartRate: Int ,
    var riskLevel: String
)
