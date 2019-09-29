package br.com.cantinho.kogasample.sample.simple

import android.content.Context
import android.view.ViewGroup
import br.com.cantinho.kogasample.R
import br.com.cantinho.kogasample.GenericRecyclerViewAdapter
import br.com.cantinho.kogasample.listeners.OnRecyclerItemClickListener
import br.com.cantinho.kogasample.model.CardContent
import br.com.cantinho.kogasample.sample.common.CardContentViewHolder

class SimpleAdapter(context: Context, listener: OnRecyclerItemClickListener) : GenericRecyclerViewAdapter<CardContent, OnRecyclerItemClickListener, CardContentViewHolder>(context, listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardContentViewHolder {
        return CardContentViewHolder(inflate(R.layout.item_card_content, parent), getListener())
    }

}