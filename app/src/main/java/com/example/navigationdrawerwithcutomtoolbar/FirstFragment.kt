package com.example.navigationdrawerwithcutomtoolbar

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class FirstFragment : BaseFragment() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_first
    }

    override fun inOnCreateView(mRootView: ViewGroup, savedInstanceState: Bundle?) {
        setUpAppBar(
            mRootView = mRootView,
            title = "First Fragment",
            isShowFilter = false,
            isShowCart = true,
            onCartClick = {
                Log.i("dd", "Cart is clicked...")
            },
            onFilterClick = {
                Log.i("dd", "Filter is clicked...")
            },
            onClickDrawerIcon = {

            }
        )
    }


}