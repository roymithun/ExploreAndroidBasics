package com.inhouse.exploreandroidbasics

import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.setFragmentResultListener
import kotlinx.android.synthetic.main.fragment_a.*

class FragmentA : Fragment(R.layout.fragment_a) {
    private lateinit var photoLauncher: ActivityResultLauncher<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Use the Kotlin extension in the fragment-ktx artifact
        setFragmentResultListener("myRequestKey") { _, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported
            val result = bundle.getString("bundleKey")
            tv_test_result.text = result
        }
        photoLauncher =
            registerForActivityResult(ActivityResultContracts.GetContent()) {
                it?.let { iv_photo.setImageURI(it) }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_start_for_result.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<FragmentB>(R.id.fragment_container_view)
                // Add this transaction to the back stack.
                // This means that the transaction will be remembered after it is committed,
                // and will reverse its operation when later popped off the stack.
                addToBackStack(null)
            }
        }
        btn_start_for_photo.setOnClickListener {
            photoLauncher.launch("image/*")
        }
    }
}