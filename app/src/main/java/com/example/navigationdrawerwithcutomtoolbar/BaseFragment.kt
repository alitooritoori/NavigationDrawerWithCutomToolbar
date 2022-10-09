package com.example.navigationdrawerwithcutomtoolbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {


    private var mPreviousView: View? = null
    open fun isFullScreenWithTransparentHeader(): Boolean {
        return false;
    }

    @LayoutRes
    abstract fun getLayoutResId(): Int

    abstract fun inOnCreateView(
        mRootView: ViewGroup, savedInstanceState: Bundle?
    )

    open fun themeInflater(baseInflater: LayoutInflater): LayoutInflater? = null

    open fun initializeView(view: View) {}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        mPreviousView?.let { return it }
//        if (isFullScreenWithTransparentHeader())
//            setTopTransparentHeader()
//        else {
//            setTopDefaultHeader()
//        }
        val newInflater = themeInflater(inflater) ?: inflater
        val mView = newInflater.inflate(getLayoutResId(), container, false)
        initializeView(mView)
        inOnCreateView(mView as ViewGroup, savedInstanceState)
        return mView.also {
            mPreviousView = it
        }
    }


   fun  setUpAppBar(
        mRootView: ViewGroup,
        title: String? = null,
        isShowCart: Boolean = false,
        isShowFilter: Boolean = false,
        onFilterClick: () -> Unit = {},
        onCartClick: () -> Unit = {},
        onClickDrawerIcon: () -> Unit = {}
    ) {
        val layout = mRootView.findViewById<LinearLayout>(R.id.top_app_bar)
        val pageTitle = layout.findViewById<TextView>(R.id.app_bar_title)
        val filter = layout.findViewById<ImageView>(R.id.filter_icon)
        val cart = layout.findViewById<ImageView>(R.id.cart_icon)
        val drawerIcon = layout.findViewById<ImageView>(R.id.drawer_icon)

        if (title != null) {
            pageTitle.text = title
        }
        if (isShowFilter) {
//            filter.setImageResource(R.drawable.ic_baseline_filter)
            filter.visibility = View.VISIBLE
            cart.visibility = View.GONE
        } else {
            cart.visibility = View.GONE
        }

        if (isShowCart) {
            cart.visibility = View.VISIBLE
            filter.visibility = View.GONE
        } else {
            cart.visibility = View.GONE
        }

        filter.setOnClickListener {
            onFilterClick.invoke()
        }

        cart.setOnClickListener {
            onCartClick.invoke()
        }

       drawerIcon.setOnClickListener {
           onClickDrawerIcon.invoke()
       }

//        back_btn?.setOnClickListener {
//            if (overrideBackClick) {
//                onBackClick.invoke()
//            } else
//                findNavController().popBackStack()
//        }

    }

}