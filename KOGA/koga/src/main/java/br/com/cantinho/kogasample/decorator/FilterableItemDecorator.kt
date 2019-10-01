package br.com.cantinho.kogasample.decorator

import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Samir Trajano Feitosa (samircc20092@gmail.com)
 * @since 1.0.0
 */
class FilterableItemDecorator(
    private val dividerDrawable: Drawable, private @LayoutRes val viewType: Int) :
    RecyclerView.ItemDecoration() {

    init {
        DrawableUtils.validateDrawableOrThrow(dividerDrawable)
    }

    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val adapter = parent.adapter ?: return
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val itemCount = adapter.itemCount
        for (i in 0 until itemCount - 1) {

            val child = parent.getChildAt(i) ?: continue
            val position = parent.getChildAdapterPosition(child)

            if (viewType <= 0 || (position > 0 && position < adapter.itemCount - 1
                        && adapter.getItemViewType(position) == viewType
                        && adapter.getItemViewType(position + 1) == viewType)
            ) {
                // we are between two needed view types, draw the divider
                val params = child.layoutParams as RecyclerView.LayoutParams
                val top = child.bottom + params.bottomMargin
                val bottom = top + dividerDrawable.intrinsicHeight
                dividerDrawable.setBounds(left, top, right, bottom)
                dividerDrawable.draw(canvas)
            }
        }
    }

}