package com.krdzy.easyui

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.WindowInsets

/**
 * Simple [ConstraintLayout] subclass which doesn't incorporate window insets, meaning
 * content of this view will draw behind status bar if [Activity] holding it has [windowDrawsSystemBarBackgrounds]
 * property set.
 */
class FitSystemConstraintLayout: ConstraintLayout {

    var interceptTouch: Boolean = false

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onApplyWindowInsets(insets: WindowInsets): WindowInsets {
        // just return insets without consuming it
        return insets
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return if (interceptTouch) true
        else super.onInterceptTouchEvent(ev)
    }
}