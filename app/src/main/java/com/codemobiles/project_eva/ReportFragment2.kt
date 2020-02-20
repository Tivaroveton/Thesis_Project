package com.codemobiles.project_eva

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.content_feed.*
import kotlinx.android.synthetic.main.fragment_report.view.*


class ReportFragment2: Fragment() {

    private var listener: ReportFragment.OnListFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_report, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mRecyclerView.adapter = CustomAdater()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ReportFragment.OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    inner class CustomAdater : RecyclerView.Adapter<CustomHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
            val layout = LayoutInflater.from(activity).inflate(R.layout.fragment_report, null, false)
            return CustomHolder(layout)
        }

        override fun getItemCount(): Int {
            return 100
        }

        override fun onBindViewHolder(holder: CustomHolder, position: Int) {
            holder.itemView.item_list_title.text = "CodeMobiles ${position}"
//            Glide.with(activity!!).load("http://www.codemobiles.com/biz/img/banner_home.gif").into(holder.itemView.item_list_youtube_image)
        }

    }

    class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {

//            itemView.setOnClickListener { v->
//                val item = v.getTag(R.id.item_list_title) as Youtube
////                Toast.makeText(activity, item.title, Toast.LENGTH_LONG).show()
//            }
        }
    }

}