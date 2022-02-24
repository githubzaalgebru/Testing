package com.algebra.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.algebra.testing.utils.*

class MainActivity : AppCompatActivity() {

    private lateinit var etFirst   : EditText
    private lateinit var etSecond  : EditText
    private lateinit var bMultiply : Button
    private lateinit var bDivide   : Button
    private lateinit var bAdd      : Button
    private lateinit var bSubtract : Button
    private lateinit var tvResult  : TextView

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        initWidgets( )
        setupListeners( )
    }

    private fun setupListeners( ) {
        bAdd.setOnClickListener {
            val first = transformToNumber( etFirst.text.toString( ) )
            val second = transformToNumber( etSecond.text.toString( ) )

            if( validateInputs( first, second ) ) {
                val result = add( first!!, second!! )
                clearFields( )
                tvResult.text = "$first + $second = $result"
            }
        }
        bSubtract.setOnClickListener {
            val first = transformToNumber( etFirst.text.toString( ) )
            val second = transformToNumber( etSecond.text.toString( ) )

            if( validateInputs( first, second ) ) {
                val result = subtract( first!!, second!! )
                clearFields( )
                tvResult.text = "$first - $second = $result"
            }
        }
        bMultiply.setOnClickListener {
            val first = transformToNumber( etFirst.text.toString( ) )
            val second = transformToNumber( etSecond.text.toString( ) )

            if( validateInputs( first, second ) ) {
                val result = multiply( first!!, second!! )
                clearFields( )
                tvResult.text = "$first * $second = $result"
            }

        }
        bDivide.setOnClickListener {
            val first = transformToNumber( etFirst.text.toString( ) )
            val second = transformToNumber( etSecond.text.toString( ) )

            if( validateInputs( first, second ) ) {
                val result = divide( first!!, second!! )
                clearFields( )
                tvResult.text = "$first / $second = $result"
            }
        }
    }

    private fun clearFields() {
        etFirst.setText( "" )
        etSecond.setText( "" )
    }

    private fun initWidgets( ) {
        etFirst   = findViewById( R.id.etFirstNumber )
        etSecond  = findViewById( R.id.etSecondNumber )
        bMultiply = findViewById( R.id.bMultiply )
        bDivide   = findViewById( R.id.bDivide )
        bAdd      = findViewById( R.id.bAdd )
        bSubtract = findViewById( R.id.bSubtract )
        tvResult  = findViewById( R.id.tvResult )
    }

    private fun validateInputs( num1 : Int?, num2 : Int? ) : Boolean {
        if( num1==null )
            etFirst.error = "Missing first number"
        if( num2==null )
            etSecond.error = "Missing second number"

        return !(num1==null || num2==null)
    }

}