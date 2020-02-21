package com.codemobiles.project_eva

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codemobiles.project_eva.dummy.DummyContent
import kotlinx.android.synthetic.main.content_feed.*


class FeedActivity : AppCompatActivity() {

    lateinit var condoList: MutableList<Condo>
    private lateinit var linearLayoutManager: LinearLayoutManager

    //    lateinit var dataReference: DatabaseReference
    val mListener: FeedFragment.OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)


        var dummyList: List<DummyContent.DummyItem>
        dummyList = listOf(DummyContent.DummyItem("1", "Test", "test"))
//        dataReference = FirebaseDatabase.getInstance().getReference("userProfile")

        linearLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = linearLayoutManager
        var mRecyclerView = findViewById(R.id.mRecyclerView) as RecyclerView


        val adapter = MyFeedRecyclerViewAdapter(
//            condoList,
            dummyList,
            mListener
        )
        mRecyclerView.adapter = adapter
    }


}
