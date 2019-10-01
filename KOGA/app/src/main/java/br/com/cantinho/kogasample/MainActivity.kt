package br.com.cantinho.kogasample

import br.com.cantinho.kogasample.R
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cantinho.kogasample.listeners.OnRecyclerItemClickListener
import br.com.cantinho.kogasample.model.CardContent
import br.com.cantinho.kogasample.model.EmailAddress
import br.com.cantinho.kogasample.model.NumericId
import br.com.cantinho.kogasample.sample.simple.SimpleAdapter


class MainActivity : AppCompatActivity(), OnRecyclerItemClickListener {

    private lateinit var adapter: SimpleAdapter
    private lateinit var recycler: RecyclerView

    override fun onItemClick(position: Int) {
        // get the User entity, associated with the clicked item.
        val clickedUser = adapter.getItem(position)
        // now you are free to do whatever you want with it.
        // We just show a Toast message
        showToast(clickedUser.content)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //EmailAddress("numeric.id@email.com", NumericId(10))
        //EmailAddress("text.id@email.com", TextId("10"))
        initViews()
        // TODO in real life app it should be done by a Presenter or a ViewModel.
        adapter.setItems(generateMockUsers())
    }


    private fun initViews() {
        recycler = findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
        recycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter = SimpleAdapter(this, this)
        recycler.adapter = adapter
    }

    /**
     * Shows a Toast message.
     *
     * @param message message to show
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Creates some mock users.
     */
    private fun generateMockUsers(): List<CardContent> {
        val totalCards = 25
        val users = ArrayList<CardContent>(totalCards)
        for (i in 1..totalCards) {
            val randomAge =  getRandomAge()
            users.add(EmailAddress( "Card $i", NumericId(randomAge)))
        }
        return users
    }

    /**
     * Generates random age between 0 and 110 (excluded)
     *
     * @return random age value
     */
    private fun getRandomAge(): Long {
        return (Math.random() * 110).toLong()
    }
}
