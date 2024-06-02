package com.example.turkey.views

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.turkey.R
import com.example.turkey.databinding.FragmentLoginBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class login : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginGoSingupButton: Button
    private lateinit var loginAuth: FirebaseAuth
    private lateinit var loginNavController: NavController
    private lateinit var loginMailEditText: EditText
    private lateinit var loginPswdEditText: EditText
    private lateinit var loginLoginButton: Button
    private lateinit var rememberBox: CheckBox
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginGoSingupButton = binding.loginGoSingupButton
        loginMailEditText = binding.loginMailEditText
        loginPswdEditText = binding.loginPswdEditText
        loginLoginButton = binding.loginLoginButton
        rememberBox = binding.rememberBox

        loginGoSingupButton.setOnClickListener {
            val goSingupPage = R.id.action_login_to_singUp
            it.findNavController().navigate(goSingupPage)
        }


        loginInit(view)
        loginEvent()
    }

    private fun loginInit(view: View) {
        loginNavController = Navigation.findNavController(view)
        loginAuth = FirebaseAuth.getInstance()
        sharedPreferences = requireActivity().getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)
        rememberBox.isChecked = sharedPreferences.getBoolean("isChecked", false)
        if (rememberBox.isChecked) {
            loginMailEditText.setText(sharedPreferences.getString("email", ""))
            loginPswdEditText.setText(sharedPreferences.getString("password", ""))
        }
    }

    private fun loginEvent() {
        loginLoginButton.setOnClickListener {
            val loginEmail = loginMailEditText.text.toString()
            val loginPassword = loginPswdEditText.text.toString()

            if (loginEmail.isNotEmpty() && loginPassword.isNotEmpty()) {
                loginAuth.signInWithEmailAndPassword(loginEmail, loginPassword)
                    .addOnCompleteListener(
                        OnCompleteListener {
                            if (it.isSuccessful) {
                                Toast.makeText(context,"Başarıyla Giriş Yapıldı",Toast.LENGTH_SHORT).show()
                                if (rememberBox.isChecked) {
                                    val editor = sharedPreferences.edit()
                                    editor.putString("email", loginEmail)
                                    editor.putString("password", loginPassword)
                                    editor.putBoolean("isChecked", true)
                                    editor.apply()
                                } else {
                                    val editor = sharedPreferences.edit()
                                    editor.remove("email")
                                    editor.remove("password")
                                    editor.putBoolean("isChecked", false)
                                    editor.apply()
                                }
                                loginNavController.navigate(R.id.action_login_to_homeActivity)
                            } else {
                                Toast.makeText(context, it.exception?.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
            }
        }
    }
}
