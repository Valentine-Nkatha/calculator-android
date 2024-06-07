package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var etNum1: EditText
    lateinit var etNum2: EditText
    lateinit var btnAdd: Button
    lateinit var btnSubtract: Button
    lateinit var btnMultiply: Button
    lateinit var btnDivide: Button
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
        btnAdd.setOnClickListener {
            validate("+")
        }
        btnSubtract.setOnClickListener {
            validate("_")
        }
        btnMultiply.setOnClickListener {
            validate("*")
        }
        btnDivide.setOnClickListener {
            validate("/")
        }

    }

    fun castViews() {
        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivision)
        tvResult = findViewById(R.id.tvResult)


    }
    fun validate(sign:String){
        val num1 = etNum1.text.toString()
        val num2 = etNum2.text.toString()
        var inputError= false
        if (num1.isBlank()){
            inputError = true
            etNum1.error = "Num 1 is required"
        }
        if (num2.isBlank()){
            inputError = true
            etNum2.error = "Num 2 is required"
        }
        if (!inputError){ //if  no error has occured//never trust user input
            calculate(num1.toDouble(),num2.toDouble(),sign)
        }
    }
    fun calculate(num1: Double, num2:Double, sign:String){

        var result = 0.0
        when(sign){
            "+" -> result= num1+num2
            "-" -> result= num1-num2
            "*"-> result= num1*num2
            "/"-> result = num1/num2
        }
        tvResult.text = result.toString()
    }
}