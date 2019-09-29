package br.com.cantinho.kogasample.sample.multiple

import android.content.Context
import android.view.ViewGroup
import br.com.cantinho.kogasample.BaseViewHolder
import br.com.cantinho.kogasample.R
import br.com.cantinho.kogasample.GenericRecyclerViewAdapter
import br.com.cantinho.kogasample.listeners.OnRecyclerItemClickListener
import br.com.cantinho.kogasample.model.CardContent
import br.com.cantinho.kogasample.model.EmailAddress
import br.com.cantinho.kogasample.model.MobilePhoneNumber
import br.com.cantinho.kogasample.sample.common.EmailAddressViewHolder
import br.com.cantinho.kogasample.sample.common.MobilePhoneNumberViewHolder
import java.lang.IllegalArgumentException


class MultipleAdapter(context: Context, listener: OnRecyclerItemClickListener) : GenericRecyclerViewAdapter<CardContent, OnRecyclerItemClickListener, BaseViewHolder<CardContent, OnRecyclerItemClickListener>>(context, listener) {

    companion object {
        private const val VIEW_TYPE_EMAIL_ADDRESS = R.layout.item_email_address_card_content
        private const val VIEW_TYPE_MOBILE_PHONE_NUMBER  = R.layout.item_mobile_phone_number_card_content
    }

    /**
     * Create here appropriate ViewHolder for each view type
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View. It corresponds to layout resource id {@link android.support.annotation.LayoutRes} for convenience
     * @return ViewHolder which corresponds to needed view type
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CardContent, OnRecyclerItemClickListener> {
        return when(viewType) {
            VIEW_TYPE_EMAIL_ADDRESS -> EmailAddressViewHolder(inflate(R.layout.item_email_address_card_content, parent), getListener())
            VIEW_TYPE_MOBILE_PHONE_NUMBER  -> MobilePhoneNumberViewHolder(inflate(R.layout.item_mobile_phone_number_card_content, parent), getListener())
            else -> throw IllegalArgumentException("Unexpected view type $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItems()[position]) {
            is EmailAddress -> VIEW_TYPE_EMAIL_ADDRESS
            is MobilePhoneNumber -> VIEW_TYPE_MOBILE_PHONE_NUMBER
            else -> throw IllegalArgumentException("Unexpected view type at $position")
        }
    }

}