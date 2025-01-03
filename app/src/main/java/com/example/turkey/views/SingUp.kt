package com.example.turkey.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.turkey.R
import com.example.turkey.databinding.FragmentSingupBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

private lateinit var binding: FragmentSingupBinding
private lateinit var singupAuth: FirebaseAuth
private lateinit var singupNavController: NavController

private lateinit var singupEmailEditText: EditText
private lateinit var singUpGoBackToLoginButton: Button
private lateinit var singupSingupButton: Button
private lateinit var singupPasswordEditText: EditText
private lateinit var singupPasswordControlEditText: EditText

class SingUp : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingupBinding.inflate(inflater, container, false)
        singUpGoBackToLoginButton = binding.singUpGoBackToLoginButton
        singupSingupButton = binding.singupSingupButton
        singupEmailEditText = binding.singupEmailEditText
        singupPasswordEditText = binding.singupPasswordEditText
        singupPasswordControlEditText = binding.singupPasswordControlEditText

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        singUpGoBackToLoginButton.setOnClickListener {
            singupNavController.navigate(R.id.action_singUp_to_login)
        }

        singupInit(view)
        registerEvent()
    }

    private fun singupInit(view: View) {
        singupNavController = Navigation.findNavController(view)
        singupAuth = FirebaseAuth.getInstance()
    }

    private fun registerEvent() {


        singupSingupButton.setOnClickListener {
            val singupEmail = singupEmailEditText.text.toString()
            val singupPassword = singupPasswordEditText.text.toString()
            val singupControlPassowrd = singupPasswordControlEditText.text.toString()

            if (singupEmail.isNotEmpty() && singupPassword.isNotEmpty() && singupControlPassowrd.isNotEmpty()) {
                if (singupPassword == singupControlPassowrd) {
                    singupAuth.createUserWithEmailAndPassword(singupEmail, singupPassword).addOnCompleteListener(
                        OnCompleteListener {
                            if (it.isSuccessful) {
                                Toast.makeText(context,"Kayıt Başarıyla Oluşturuldu",Toast.LENGTH_SHORT).show()
                                singupNavController.navigate(R.id.action_singUp_to_homeActivity)
                            } else {
                                Toast.makeText(context,it.exception?.message,Toast.LENGTH_SHORT).show()
                            }
                        }
                    )

                }

            }
        }

    }

}

