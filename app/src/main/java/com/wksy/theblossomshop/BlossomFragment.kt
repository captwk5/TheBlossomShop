package com.wksy.theblossomshop

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.wksy.theblossomshop.databinding.FragmentBlossomBinding

class BlossomFragment : Fragment() {

    private lateinit var viewBinding: FragmentBlossomBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentBlossomBinding.inflate(layoutInflater)
    }
}