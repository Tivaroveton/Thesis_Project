package com.codemobiles.project_eva

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_feed.*


class FeedActivity : AppCompatActivity() {

    lateinit var condoList: MutableList<Condo>
//    lateinit var dataReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

//        val condos : MutableList<Condo> = ArrayList()
//        val dummyList :List<DummyContent.DummyItem>()
////        condos.add()
//
//        val adapter: MyReportRecyclerViewAdapter = MyReportRecyclerViewAdapter(, )
//
//        val listView: ListView = findViewById(R.id.mRecyclerView)
//        listView.adapter = adapter


        condoList = mutableListOf()
//        dataReference = FirebaseDatabase.getInstance().getReference("userProfile")

        val adapter = ReportFragment2().CustomAdater()
        mRecyclerView.adapter = adapter



//        ReportFragment.newInstance(15)
//        val layoutInflater:LayoutInflater = LayoutInflater.from(this)
//        val mparent : LinearLayout = findViewById(R.id.root_layout)
//
//        // Inflate the layout using LayoutInflater
//        val view: View = layoutInflater.inflate(
//            R.layout.content_feed, // Custom view/ layout
//            null, // Root layout to attach the view
//            false // Attach with root layout or not
//        )



//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

    }


}
