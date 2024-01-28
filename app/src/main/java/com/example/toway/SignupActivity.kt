package com.example.toway

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.toway.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    private val view: ActivitySignupBinding by lazy { ActivitySignupBinding.inflate(layoutInflater) }
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        firebaseAuth = FirebaseAuth.getInstance()

        view.signupButton.setOnClickListener{
            val signupUsername = view.signupUsername.text.toString()
            val signupPassword = view.signupPassword.text.toString()

            if(signupUsername.isNotEmpty() && signupPassword.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(signupUsername, signupPassword)
                    .addOnCompleteListener(this){task ->
                        if(task.isSuccessful){
                            Toast.makeText(this,"Signup Successful", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, LoginActivity:: class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this,"Signup Unsuccessful", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this@SignupActivity, "All fields are mandatory", Toast.LENGTH_SHORT).show()
            }
        }

        view.loginRedirect.setOnClickListener{
            startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
            finish()
        }
    }
}