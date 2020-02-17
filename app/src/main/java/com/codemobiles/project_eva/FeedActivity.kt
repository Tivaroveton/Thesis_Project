package com.codemobiles.project_eva

import android.content.Context
import android.graphics.drawable.DrawableContainer
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.codemobiles.project_eva.ReportFragment.Companion.ARG_COLUMN_COUNT
import com.google.android.material.tabs.TabLayout

import kotlinx.android.synthetic.main.activity_feed.*
import kotlinx.android.synthetic.main.content_feed.*

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        setSupportActionBar(toolbar)

        ReportFragment.newInstance(15)

        val layoutInflater:LayoutInflater = LayoutInflater.from(applicationContext)

        val mparent : LinearLayout = findViewById(R.id.root_layout)
        // Inflate the layout using LayoutInflater
        val view: View = layoutInflater.inflate(
            R.layout.fragment_report_list, // Custom view/ layout
            null, // Root layout to attach the view
            false // Attach with root layout or not
        )



//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

    }

    fun onClickCamera(view: View) {}
    fun onClickPhoto(view: View) {}
    fun onClickFill(view: View) {}


}
