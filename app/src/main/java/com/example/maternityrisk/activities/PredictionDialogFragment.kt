package com.example.maternityrisk.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.maternityrisk.R
import java.math.BigDecimal
import java.math.RoundingMode

class PredictionDialogFragment : DialogFragment() {

    private lateinit var probHigh: String
    private lateinit var probLow: String
    private lateinit var probMid: String
    private lateinit var risk: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.fragment_custom_dialog, container, false)

        rootView.findViewById<TextView>(R.id.text_probHigh).text = getString(R.string.text_highRisk, probHigh)
        rootView.findViewById<TextView>(R.id.text_probLow).text = getString(R.string.text_lowRisk, probLow)
        rootView.findViewById<TextView>(R.id.text_probMid).text = getString(R.string.text_midRisk, probMid)
        rootView.findViewById<TextView>(R.id.text_risk).text = risk

        rootView.findViewById<ImageButton>(R.id.img_btn_back).setOnClickListener {
            dismiss()
        }
        return rootView
    }

    fun setTexts(probHigh: String, probLow: String, probMid: String, risk: String){
        val high:BigDecimal = probHigh.toBigDecimal().setScale(3, RoundingMode.HALF_EVEN)
        val low:BigDecimal = probLow.toBigDecimal().setScale(3, RoundingMode.HALF_EVEN)
        val mid:BigDecimal = probMid.toBigDecimal().setScale(3, RoundingMode.HALF_EVEN)

        this.probHigh = high.toString()
        this.probLow = low.toString()
        this.probMid = mid.toString()
        this.risk = risk.uppercase()
    }
}