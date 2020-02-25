package com.codemobiles.project_eva

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codemobiles.project_eva.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.content_feed.*


class FeedActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    companion object{
        lateinit var condoList: MutableList<Condo>
    }
    //    lateinit var dataReference: DatabaseReference
    val mListener: FeedFragment.OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

//        dataReference = FirebaseDatabase.getInstance().getReference("userProfile")

        val condo1 = Condo.Builder()
            .id("001")
            .title("LM-fa-001")
            .subtitle("The Condo Name")
            .build()
        val condo2 = Condo.Builder()
            .id("002")
            .title("LM-fa-002")
            .subtitle("The Condo Name")
            .build()
        val condo3 = Condo.Builder()
            .id("003")
            .title("LM-fa-003")
            .subtitle("The Condo Name")
            .build()
        val condo4 = Condo.Builder()
            .id("003")
            .title("LM-fa-004")
            .subtitle("The Condo Name")
            .build()



        condoList = mutableListOf(condo1, condo2, condo3, condo4)


//        var dummyList: List<DummyContent.DummyItem>
//        dummyList = listOf(DummyContent.DummyItem("1", "Test", "test"))

        linearLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = linearLayoutManager
        var mRecyclerView = findViewById(R.id.mRecyclerView) as RecyclerView

        val context: Context = this@FeedActivity
        val adapter = MyFeedRecyclerViewAdapter(
            condoList,
//            dummyList,
            mListener,
            context
        )
        mRecyclerView.adapter = adapter

    }

    fun onClickFeed(view: View) {
        val item = view.tag as Condo
        Toast.makeText(this, "It's ${item?.id}", Toast.LENGTH_SHORT)

        val intent = Intent(this, MenuActivity::class.java)
        val extras:Bundle = bundleOf("id" to item?.id)
        ContextCompat.startActivity(this, intent, extras)
    }





}
