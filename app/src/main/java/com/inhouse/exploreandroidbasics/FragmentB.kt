package com.inhouse.exploreandroidbasics

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import kotlinx.android.synthetic.main.fragment_b.*

class FragmentB : Fragment(R.layout.fragment_b) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_send_back_result.setOnClickListener {
            val result = "I am sending back this!"
            setFragmentResult("myRequestKey", bundleOf("bundleKey" to result))
//            parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            parentFragmentManager.popBackStack()
        }
    }
}
