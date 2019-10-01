package br.com.cantinho.kogasample.listeners

import androidx.recyclerview.widget.RecyclerView

/**
 * @author Samir Trajano Feitosa (samircc20092@gmail.com)
 * @since 1.0.0
 */
interface OnRecyclerItemClickListener : BaseRecyclerListener {

    /**
     * Returns clicked item position [RecyclerView.ViewHolder.getAdapterPosition]
     *
     * @param position clicked item position.
     */
    fun onItemClick(position: Int)

}