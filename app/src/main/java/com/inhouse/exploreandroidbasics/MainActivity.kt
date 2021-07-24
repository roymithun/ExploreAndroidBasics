package com.inhouse.exploreandroidbasics

import android.app.Activity
import android.content.Intent
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

        val implicitLauncher: ActivityResultLauncher<String> =
            registerForActivityResult(ActivityResultContracts.GetContent()) {
                Log.d(TAG, "onActivityResult $it")
                it?.let { iv_test_result.setImageURI(it) }
            }

        btn_implicit_intent.setOnClickListener { implicitLauncher.launch("image/*") }

        val explicitLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                it?.let {
                    if (it.resultCode == Activity.RESULT_OK) {
                        it.data?.run {
                            Log.d(
                                TAG,
                                "result key1=${getStringExtra("key1")} | key2=${getStringExtra("key1")} | key3=${
                                    getStringExtra("key1")
                                }"
                            )
                        }
                    }
                }
            }
        btn_explicit_intent.setOnClickListener {
            explicitLauncher.launch(
                Intent(
                    this,
                    SecondaryActivity::class.java
                )
            )
        }
    }
}