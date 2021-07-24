package com.inhouse.exploreandroidbasics

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_secondary.*

class SecondaryActivity : AppCompatActivity(R.layout.activity_secondary) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btn_send_results_back.setOnClickListener {
            val intent = Intent().apply {
                putExtra("key1", "value1")
                putExtra("key2", "value2")
                putExtra("key3", "value3")
            }

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}