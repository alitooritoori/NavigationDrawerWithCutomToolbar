package com.example.navigationdrawerwithcutomtoolbar

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast


class BlankFragment : BaseFragment() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_blank
    }

    override fun inOnCreateView(mRootView: ViewGroup, savedInstanceState: Bundle?) {
        val myText = mRootView.findViewById<TextView>(R.id.fragment_hello_text)
        myText.setOnClickListener {
            myText.text = "Nice!"
        }

        setUpAppBar(
            mRootView = mRootView,
            title = "Blank Fragment",
            isShowFilter = false,
            isShowCart = true,
            onCartClick = {
                Log.i("dd", "Cart is clicked...")
            },
            onFilterClick = {
                Log.i("dd", "Filter is clicked...")
            },
        )
    }


//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val view =  inflater.inflate(R.layout.fragment_blank, container, false)
//
//        return view
//    }


}
