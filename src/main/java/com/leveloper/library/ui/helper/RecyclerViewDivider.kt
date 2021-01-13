package com.leveloper.library.ui.helper

import android.graphics.Canvas
import android.graphics.Paint
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView

/**
 * RecyclerViewDivider
 * RecyclerView 의 divider 를 그릴 때 사용한다.
 */
class RecyclerViewDivider(
        @ColorInt
        private val color: Int,
        private val height: Float,
        private val padding: Float
) : RecyclerView.ItemDecoration() {

    private val paint = Paint()

    init {
        paint.color = color
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.itemAnimator?.isRunning == true) return

        val left = parent.paddingStart + padding
        val right = parent.width - parent.paddingEnd - padding
        val childCount = parent.childCount

        for (i in 0 until childCount) {
            if (i == (childCount - 1)) continue

            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = (child.bottom + params.bottomMargin).toFloat()
            val bottom = top + height

            c.drawRect(left, top, right, bottom, paint)
        }
    }
}