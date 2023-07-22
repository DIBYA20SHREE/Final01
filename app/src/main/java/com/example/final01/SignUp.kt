package com.example.final01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {

    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val etname= findViewById<TextInputEditText>(R.id.etname)
        val etmail=findViewById<TextInputEditText>(R.id.etMail)
        val etphno=findViewById<TextInputEditText>(R.id.etPhNo)
        val etpswrd=findViewById<TextInputEditText>(R.id.etPassword)
        val etsu=findViewById<Button>(R.id.btnFinalSU)


        database = FirebaseDatabase.getInstance().getReference("users")

        etsu.setOnClickListener{
            val name= etname.text.toString()
            val mail= etmail.text.toString()
            val phone= etphno.text.toString()
            val password= etpswrd.text.toString()

            val user = User(name, mail, phone, password)

            database= FirebaseDatabase.getInstance().getReference("users")

            database.child(phone).setValue(user).addOnSuccessListener {
                etname.text?.clear()
                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }

    }
}