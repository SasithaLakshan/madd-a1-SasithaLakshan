package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityPaymentReceiptBinding

class PaymentReceipt : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentReceiptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentReceiptBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var cardType = intent.getStringExtra("cardType").toString()
        val cardNumber = intent.getStringExtra("cardNumber").toString()
        val cardName = intent.getStringExtra("cardName").toString()
        val cardExp = intent.getStringExtra("cardExp").toString()
        val cardCVV = intent.getStringExtra("cardCVV").toString()
        val paymentId = intent.getStringExtra("paymentId").toString()
        val totFee = intent.getStringExtra("totFee").toString()

        binding.tvName.text = cardName
        binding.tvAmt.text = totFee

        binding.btnOk.setOnClickListener {
            startActivity(Intent(this,Home::class.java))
        }

        binding.btnUpdate.setOnClickListener {
            intent = Intent(applicationContext, UpdatePayment::class.java).also {
                it.putExtra("cardType", cardType)
                it.putExtra("cardNumber", cardNumber)
                it.putExtra("cardName", cardName)
                it.putExtra("cardExp", cardExp)
                it.putExtra("cardCVV", cardCVV)
                it.putExtra("paymentId", paymentId)
                it.putExtra("totFee", totFee)
                startActivity(it)
            }
        }
    }
}