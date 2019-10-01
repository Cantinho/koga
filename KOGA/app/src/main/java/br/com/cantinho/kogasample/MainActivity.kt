package br.com.cantinho.kogasample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController


class MainActivity : AppCompatActivity(), HomeFragment.OnFragmentInteractionListener {

    override fun onNavigation(viewId: Int) {
        when (viewId) {
            R.id.btnGoToSimpleAdapter -> {
                findNavController(viewId).navigate(R.id.action_homeFragment_to_simpleAdapterFragment)
            }
            R.id.btnGoToMultipleAdapter -> {
                findNavController(viewId).navigate(R.id.action_homeFragment_to_multipleAdapterFragment)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
