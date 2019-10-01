package br.com.cantinho.kogasample.decorator

import android.graphics.Canvas
import androidx.recyclerview.widget.RecyclerView
import android.graphics.drawable.Drawable
import android.widget.LinearLayout

/**
 * @author Samir Trajano Feitosa (samircc20092@gmail.com)
 * @since 1.0.0
 */
class DrawableItemDecorator(private val dividerDrawable: Drawable) :
    RecyclerView.ItemDecoration() {

    init {
        DrawableUtils.validateDrawableOrThrow(dividerDrawable)
    }

    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val adapter = parent.adapter ?: return
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        for (i in 0 until adapter.itemCount - 2) {
            val child = parent.getChildAt(i) ?: continue
            val params = child.layoutParams as LinearLayout.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + dividerDrawable.intrinsicHeight
            dividerDrawable.setBounds(left, top, right, bottom)
            dividerDrawable.draw(canvas)
        }
    }

}