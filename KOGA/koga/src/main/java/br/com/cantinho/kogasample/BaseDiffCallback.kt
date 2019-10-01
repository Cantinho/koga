package br.com.cantinho.kogasample

import androidx.recyclerview.widget.DiffUtil
import androidx.annotation.Nullable

/**
 * @author Samir Trajano Feitosa (samircc20092@gmail.com)
 * @since 1.0.0
 */
abstract class BaseDiffCallback<T>(
    private val oldItems: List<T>, private val newItems: List<T>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    @Nullable
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

    fun getOldItems(): List<T> {
        return oldItems
    }

    fun getNewItems(): List<T> {
        return newItems
    }

}