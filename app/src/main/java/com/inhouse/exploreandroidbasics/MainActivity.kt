package com.inhouse.exploreandroidbasics

import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registerForActivityResult: ActivityResultLauncher<String> =
            registerForActivityResult(ActivityResultContracts.GetContent()) {
                Log.d(TAG, "onActivityResult $it")
                it?.let { iv_test_result.setImageURI(it) }
            }

        btn_implicit_intent.setOnClickListener { registerForActivityResult.launch("image/*") }
    }
}