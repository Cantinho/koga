package br.com.cantinho.kogasample.decorator

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Samir Trajano Feitosa (samircc20092@gmail.com)
 * @since 1.0.0
 */
object DrawableUtils {

    /**
     * Validates a divider drawable.
     *
     * @param drawable which has to be used as a divider between [RecyclerView] items
     * @throws IllegalArgumentException in case drawable is `null` or has illegal size.
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    @Throws(IllegalArgumentException::class)
    fun validateDrawableOrThrow(drawable: Drawable?) {
        if (drawable == null) {
            throw IllegalArgumentException("Divider cannot be null")
        } else if (drawable.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0) {
            throw IllegalArgumentException("Illegal divider drawable. Wrong size: width = " + drawable.intrinsicWidth + ", height = " + drawable.intrinsicHeight)
        }
    }

}