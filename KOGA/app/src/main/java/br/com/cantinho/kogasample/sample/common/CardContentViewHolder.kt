package br.com.cantinho.kogasample.sample.common


import android.view.View
import br.com.cantinho.kogasample.BaseViewHolder
import br.com.cantinho.kogasample.listeners.OnRecyclerItemClickListener
import br.com.cantinho.kogasample.model.CardContent
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_card_content.view.*


class CardContentViewHolder(itemView: View, listener: OnRecyclerItemClickListener) : BaseViewHolder <CardContent, OnRecyclerItemClickListener>(itemView, listener), LayoutContainer {

    override fun onBind(item: CardContent) {
        // bind data to the views
        containerView?.tvContent?.text = item.content
    }

}