package com.codemobiles.project_eva

import android.R
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_feed.*
import kotlinx.android.synthetic.main.activity_fill.*
import kotlinx.android.synthetic.main.activity_fill_tab.*

class FillActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.codemobiles.project_eva.R.layout.activity_fill)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        //        tabs.setupWithViewPager(viewPager)

//        view_pager.offscreenPageLimit = 3
//        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
//        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(view_pager))
//
//        // access the items of the list
//        val languages = resources.getStringArray(com.codemobiles.project_eva.R.array.Languages)
//
//        //Spinner Adapter
//        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, languages)
//        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
//        Spinner_type.adapter = adapter
//
//        Spinner_type.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//            }
//
//            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
//                val item = adapter.getItem(position)
//                Toast.makeText(this@FillActivity,
//                    getString(com.codemobiles.project_eva.R.string.selected_item) + " " +
//                            "" + languages[position], Toast.LENGTH_SHORT).show()
//            }
//        }
    }




}
