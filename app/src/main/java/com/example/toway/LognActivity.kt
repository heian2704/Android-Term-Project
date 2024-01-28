package com.example.toway

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.toway.databinding.ActivityLoginBinding
import com.example.toway.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private val view: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        firebaseAuth = FirebaseAuth.getInstance()

        view.loginButton.setOnClickListener{
            val loginUsername = view.loginUsername.text.toString()
            val loginPassword = view.loginPassword.text.toString()

            if(loginUsername.isNotEmpty() && loginPassword.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(loginUsername, loginPassword)
                    .addOnCompleteListener(this){task ->
                        if(task.isSuccessful){
                            Toast.makeText(this,"Login Successful", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this@LoginActivity, "All fields are mandatory", Toast.LENGTH_SHORT).show()
            }
        }
        view.signupRedirect.setOnClickListener{
            startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
            finish()
        }
    }
}