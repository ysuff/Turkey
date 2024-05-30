package com.example.turkey.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.turkey.databinding.FragmentChatbotBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class ChatBot : Fragment() {
    private lateinit var binding: FragmentChatbotBinding
    private lateinit var chatBotEditText: EditText
    private lateinit var chatBotButton: Button
    private lateinit var chatBotTextView: TextView
    private val client = OkHttpClient()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatbotBinding.inflate(inflater, container, false)
        chatBotEditText = binding.chatBotEditText
        chatBotButton = binding.chatBotButton
        chatBotTextView = binding.chatBotTextView

        chatBotButton.setOnClickListener {
            val question = chatBotEditText.text.toString()
            Toast.makeText(context, question, Toast.LENGTH_SHORT).show()
            getResponse(question) { response ->
                requireActivity().runOnUiThread {
                    chatBotTextView.text = response
                }
            }
        }

        return binding.root
    }

    private fun getResponse(question: String, callback: (String) -> Unit) {
        val apiKey = "sk-proj-JehaHf2i0kUyymMyqdT1T3BlbkFJVlElPJ0lMKGP0w5VjgLR"
        val url = "https://api.openai.com/v1/chat/completions"
        val requestBody = """
            {
              "model": "gpt-3.5-turbo",
              "messages": [{"role": "user", "content": "$question"}],
              "max_tokens": 150,
              "temperature": 0.7
            }
        """.trimIndent()

        val request = Request.Builder()
            .url(url)
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer $apiKey")
            .post(requestBody.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("error", "API failed", e)
                callback("API request failed")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                if (body != null) {
                    Log.v("API Response", body)
                    try {
                        val jsonObject = JSONObject(body)
                        if (jsonObject.has("choices")) {
                            val choices = jsonObject.getJSONArray("choices")
                            if (choices.length() > 0) {
                                val text = choices.getJSONObject(0).getJSONObject("message").getString("content")
                                callback(text)
                            } else {
                                callback("No response")
                            }
                        } else {
                            callback("Unexpected response structure: No 'choices' key")
                        }
                    } catch (e: JSONException) {
                        Log.e("error", "JSON parsing error", e)
                        callback("JSON parsing error")
                    }
                } else {
                    callback("Empty response")
                }
            }
        })
    }
}
