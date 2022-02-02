package com.wksy.theblossomshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wksy.theblossomshop.databinding.FragmentBlossomBinding

class BlossomFragment : Fragment() {

    private lateinit var viewBinding: FragmentBlossomBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentBlossomBinding.inflate(layoutInflater)
        return viewBinding.root.rootView
//        return super.onCreateView(inflater, container, savedInstanceState)
    }
}