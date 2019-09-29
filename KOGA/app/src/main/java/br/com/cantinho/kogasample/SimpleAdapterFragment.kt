package br.com.cantinho.kogasample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cantinho.kogasample.ext.toast
import br.com.cantinho.kogasample.listeners.OnRecyclerItemClickListener
import br.com.cantinho.kogasample.model.CardContent
import br.com.cantinho.kogasample.model.EmailAddress
import br.com.cantinho.kogasample.model.NumericId
import br.com.cantinho.kogasample.sample.simple.SimpleAdapter
import br.com.cantinho.kogasample.util.generateMockUsers

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SimpleAdapterFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SimpleAdapterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SimpleAdapterFragment : Fragment(), OnRecyclerItemClickListener {

    private lateinit var adapter: SimpleAdapter
    private lateinit var recycler: RecyclerView

    override fun onItemClick(position: Int) {
        // get the User entity, associated with the clicked item.
        val clickedUser = adapter.getItem(position)
        // now you are free to do whatever you want with it.
        // We just show a Toast message
        toast(clickedUser.content)
    }

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO in real life app it should be done by a Presenter or a ViewModel.
        adapter.setItems(generateMockUsers())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_simple_adapter, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        context?.let {
            recycler = view.findViewById(R.id.recycler)
            recycler.layoutManager = LinearLayoutManager(activity)
            recycler.setHasFixedSize(true)
            recycler.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            adapter = SimpleAdapter(it, this)
            recycler.adapter = adapter
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SimpleAdapterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SimpleAdapterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
