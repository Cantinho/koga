package br.com.cantinho.kogasample

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cantinho.kogasample.listeners.BaseRecyclerListener
import kotlinx.android.extensions.LayoutContainer

/**
 * Base ViewHolder to be used with the generic adapter.
 * [GenericRecyclerViewAdapter]
 *
 * @param <T> type of objects, which will be used in the adapter's data set
 * @param <L> click listener [BaseRecyclerListener]
 * @author Samir Trajano Feitosa (samircc20092@gmail.com)
 * @since 1.0.0 */
abstract class BaseViewHolder<T, L : BaseRecyclerListener> : RecyclerView.ViewHolder, LayoutContainer {

    protected lateinit var listener: L

    override val containerView: View?
        get() = itemView

    constructor(itemView: View) : super(itemView) {}

    constructor(itemView: View, listener: L) : super(itemView) {
        this.listener = listener
    }

    /**
     * Bind data to the item.
     * Make sure not to perform any expensive operations here.
     *
     * @param item object, associated with the item.
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    abstract fun onBind(item: T)

    /**
     * Bind data to the item.
     * Override this method for using the payloads in order to achieve the full power of DiffUtil.
     * Remove @Suppress("UNUSED_PARAMETER") when user [payloads] parameter
     * [android.support.v7.util.DiffUtil.Callback]
     *
     * @param item object, associated with the item.
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    fun onBind(item: T, @Suppress("UNUSED_PARAMETER") payloads: List<Any>) {
        onBind(item)
    }
}
