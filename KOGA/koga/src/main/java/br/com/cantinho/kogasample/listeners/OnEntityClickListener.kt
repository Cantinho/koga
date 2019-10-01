package br.com.cantinho.kogasample.listeners

/**
 * @author Samir Trajano Feitosa (samircc20092@gmail.com)
 * @since 1.0.0
 */
interface OnEntityClickListener<T> : BaseRecyclerListener {

    /**
     * Item has been clicked.
     * Here you retrieve an entity associated with the clicked item and you are free to use it in any way.
     *
     * @param item object associated with the clicked item.
     * @author Samir Trajano Feitosa (samircc20092@outlook.com)
     * @since 1.0.0
     */
    fun onItemClicked(item: T)
}