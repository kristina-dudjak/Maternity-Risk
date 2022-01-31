package com.example.maternityrisk.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.maternityrisk.R
import com.example.maternityrisk.services.ApiService
import com.example.maternityrisk.dataModels.Features
import com.example.maternityrisk.dataModels.RequestBody

class EntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        findViewById<Button>(R.id.btn_predict).setOnClickListener {

            val editAge= findViewById<EditText>(R.id.edit_age).text
            val editSysBP= findViewById<EditText>(R.id.edit_systolicBP).text
            val editDisBP= findViewById<EditText>(R.id.edit_diastolicBP).text
            val editBS= findViewById<EditText>(R.id.edit_BS).text
            val editBodyTemp= findViewById<EditText>(R.id.edit_bodyTemp).text
            val editHeartRate= findViewById<EditText>(R.id.edit_heartRate).text

            if(editAge.isEmpty() || editSysBP.isEmpty() || editDisBP.isEmpty() ||
                editBS.isEmpty() || editBodyTemp.isEmpty() || editHeartRate.isEmpty()){
                Toast.makeText(baseContext, "ALL FIELDS ARE REQUIRED!", Toast.LENGTH_SHORT).show()
            }
            else{

                val apiService = ApiService()
                val age =  editAge.toString().toInt()
                val sysBP = editSysBP.toString().toInt()
                val disBP = editDisBP.toString().toInt()
                val bloodSugar = editBS.toString().toDouble()
                val bodyTemp = editBodyTemp.toString().toInt()
                val heartRate = editHeartRate.toString().toInt()

                val entryData = RequestBody.create(Features(age, sysBP, disBP, bloodSugar, bodyTemp, heartRate, ""))

                apiService.predictRisk(entryData){
                    if(it?.results?.output?.value?.values != null){
                        val probHigh = it.results.output.value.values[0][7]
                        val probLow = it.results.output.value.values[0][8]
                        val probMid = it.results.output.value.values[0][9]
                        val risk = it.results.output.value.values[0][10]

                        val dialog = PredictionDialogFragment()
                        dialog.setTexts(probHigh, probLow, probMid, risk)
                        dialog.show(supportFragmentManager, "customDialog")

                    }
                }
            }
        }
    }


}