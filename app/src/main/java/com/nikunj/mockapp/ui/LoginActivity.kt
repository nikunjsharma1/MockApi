package com.nikunj.mockapp.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.nikunj.mockapp.R
import com.nikunj.mockapp.ui.main.HomeFragment
import com.nikunj.mockapp.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class LoginActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val currentDateTime = LocalDateTime.now()
        val data=currentDateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)).toString()
        btn_login.setOnClickListener {
            if (et_username.text.isNullOrEmpty() || et_password.text.isNullOrEmpty()){
                Toast.makeText(this, "All Fields are Required",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                val intent= Intent(this@LoginActivity,MainActivity::class.java)

                intent.putExtra("name",et_username.text.toString())
                intent.putExtra("time",data)
                startActivity(intent)
                Toast.makeText(this@LoginActivity,"Welcome"+"    "+et_username.text.toString() +"    "+data, Toast.LENGTH_SHORT).show()

            }

        }
    }
}