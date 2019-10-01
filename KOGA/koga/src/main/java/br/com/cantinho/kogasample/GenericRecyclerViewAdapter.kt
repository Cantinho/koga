package br.com.cantinho.kogasample

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import br.com.cantinho.kogasample.listeners.BaseRecyclerListener
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.annotation.LayoutRes
import android.view.View
import androidx.annotation.Nullable

/**
 * @author Samir Trajano Feitosa (samircc20092@gmail.com)
 * @since 1.0.0
 */
abstract class GenericRecyclerViewAdapter<T, L: BaseRecyclerListener, VH : BaseViewHolder<T, L>>(
    context: Context, private var listener: L) : RecyclerView.Adapter<VH>() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    private val items: MutableList<T> = mutableListOf()

    /**
     * To be implemented in as specific adapter.
     * Here you should return new ViewHolder instance.
     * You may also return different ViewHolders according to a view type.
     * In this case you shoulf also override [RecyclerView.Adapter.getItemViewType]
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the itemView to reflect the item at the given
     * position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: VH, position: Int) {
        if (items.size <= position) {
            return
        }
        val item = items[position]
        holder.onBind(item)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * Sets items to the adapter and notifies that data set has been changed.
     *
     * @param items items to set to the adapter
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    fun setItems(items: List<T>) {
        setItems(items, true)
    }

    /**
     * Sets items to the adapter and notifies that data set has been changed.
     * Typically this method should be use with `notifyChanges = false` in case you are using DiffUtil
     * [android.support.v7.util.DiffUtil] in order to delegate it do all the updating job.
     *
     * @param items         items to set to the adapter
     * @param notifyChanges pass in `true` to call notifiDatasetChanged [RecyclerView.Adapter.notifyDataSetChanged] or `false` otherwise
     * @throws IllegalArgumentException in case of setting `null` items
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    @Throws(IllegalArgumentException::class)
    fun setItems(items: List<T>?, notifyChanges: Boolean) {
        if (items == null) {
            throw IllegalArgumentException("Cannot set `null` item to the Recycler adapter")
        }
        this.items.clear()
        this.items.addAll(items)
        if (notifyChanges) {
            notifyDataSetChanged()
        }
    }

    /**
     * Updates items list.
     * Typically to be used for the implementation of DiffUtil [android.support.v7.util.DiffUtil]
     *
     * @param newItems new items
     */
    fun updateItems(newItems: List<T>) {
        setItems(newItems, false)
    }

    /**
     * Updates items with use of DiffUtil callback [DiffUtil.Callback]
     *
     * @param newItems     new items
     * @param diffCallback DiffUtil callback
     */
    fun updateItems(newItems: List<T>, diffCallback: DiffUtil.Callback) {
        val result = DiffUtil.calculateDiff(diffCallback, false)
        setItems(newItems, false)
        result.dispatchUpdatesTo(this)
    }

    /**
     * Returns all items from the data set held by the adapter.
     *
     * @return All of items in this adapter.
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    fun getItems(): List<T> {
        return items
    }

    /**
     * Returns an items from the data set at a certain position.
     *
     * @return All of items in this adapter.
     */
    fun getItem(position: Int): T {
        return items[position]
    }


    /**
     * Adds item to the end of the data set.
     * Notifies that item has been inserted.
     *
     * @param item item which has to be added to the adapter.
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    fun add(item: T?) {
        if (item == null) {
            throw IllegalArgumentException("Cannot add null item to the Recycler adapter")
        }
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    /**
     * Adds item to the beginning of the data set.
     * Notifies that item has been inserted.
     *
     * @param item item which has to be added to the adapter.
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    fun addToBeginning(item: T?) {
        if (item == null) {
            throw IllegalArgumentException("Cannot add null item to the Recycler adapter")
        }
        items.add(0, item)
        notifyItemInserted(0)
    }

    /**
     * Adds list of items to the end of the adapter's data set.
     * Notifies that item has been inserted.
     *
     * @param items items which has to be added to the adapter.
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    fun addAll(items: List<T>?) {
        if (items == null) {
            throw IllegalArgumentException("Cannot add `null` items to the Recycler adapter")
        }
        this.items.addAll(items)
        notifyItemRangeInserted(this.items.size - items.size, items.size)
    }

    /**
     * Clears all the items in the adapter.
     *
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    /**
     * Removes an item from the adapter.
     * Notifies that item has been removed.
     *
     * @param item to be removed
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    fun remove(item: T) {
        val position = items.indexOf(item)
        if (position > -1) {
            items.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    /**
     * Returns whether adapter is empty or not.
     *
     * @return `true` if adapter is empty or `false` otherwise
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    fun isEmpty(): Boolean {
        return itemCount == 0
    }


    /**
     * Set click listener, which must extend [BaseRecyclerListener]
     *
     * @param listener click listener
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    fun setListener(listener: L) {
        this.listener = listener
    }

    /**
     * Get listener [BaseRecyclerListener]
     *
     * @return click listener
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    fun getListener(): L {
        return listener
    }

    /**
     * Inflates a view.
     *
     * @param layout       layout to me inflater
     * @param parent       container where to inflate
     * @param attachToRoot whether to attach to root or not
     * @return inflated View
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    protected fun inflate(@LayoutRes layout: Int, @Nullable parent: ViewGroup, attachToRoot: Boolean): View {
        return layoutInflater.inflate(layout, parent, attachToRoot)
    }

    /**
     * Inflates a view.
     *
     * @param layout layout to me inflater
     * @param parent container where to inflate
     * @return inflated View
     * @author Samir Trajano Feitosa (samircc20092@gmail.com)
     * @since 1.0.0
     */
    protected fun inflate(@LayoutRes layout: Int, @Nullable parent: ViewGroup): View {
        return inflate(layout, parent, false)
    }

}