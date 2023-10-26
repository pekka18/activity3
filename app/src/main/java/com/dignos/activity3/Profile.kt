package com.dignos.activity3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dignos.activity3.constants.Constants
import com.dignos.activity3.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra(Constants.PARAM_ID, 0)

        // Get the parameter coming from PersonAdapter.
        // Default value for 'getStringExtra' is null.
        val name = intent.getStringExtra(Constants.PARAM_NAME)
        val email = intent.getStringExtra(Constants.PARAM_EMAIL)
        val message = intent.getStringExtra(Constants.PARAM_MESSAGE)

        val title = "[$id] $name"

        binding.name.text = title
        binding.email.text = email
        binding.message.text = message
    }
}