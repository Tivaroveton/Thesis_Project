package com.codemobiles.project_eva

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity ////
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_feed.view.*



//class MyFeedRecyclerViewAdapter(
//    private val mValues: MutableList<Condo>,
//    private val mListener: FeedFragment.OnListFragmentInteractionListener?,
//    private val context: Context
//) : RecyclerView.Adapter<MyFeedRecyclerViewAdapter.ViewHolder>(), View.OnClickListener  {
//    override fun onClick(v: View?) {
//        itemClickListener!!.onClick(v, adapterPosition, false)
//    }
//
//    private val mOnClickListener: View.OnClickListener
//    private var itemClickListener: ItemClickListener? = null
//    init {
//        //introTxt.setOnClickListener(this)
//        mOnClickListener = View.OnClickListener { v ->
//            val item = v.tag as Condo
//
//            // Notify the active callbacks interface (the activity, if the fragment is attached to
//            // one) that an item has been selected.
//            mListener?.onListFragmentInteraction(item, context)
//
//            Toast.makeText(context, "It's ${item}", Toast.LENGTH_SHORT)
//
////            val intent = Intent(context, MenuActivity::class.java)
////            val extras:Bundle = bundleOf("id" to item.id)
////            startActivity(context, intent, extras)
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.fragment_feed, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = mValues[position]
//        holder.mIdView.text = item.title
//        holder.mContentView.text = item.subtitle
//        changePage()
//        with(holder.mView) {
//            tag = item
//            setOnClickListener(mOnClickListener)
//        }
//        layout_feed.setOnClickListener(this)
//    }
//
//    private fun changePage(){
//
//    }
//
//    override fun getItemCount(): Int = mValues.size
//
//    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView){
//        val mIdView: TextView = mView.item_list_title
//        val mContentView: TextView = mView.item_list_subtitle
//        val layout_feed:LinearLayout = mView.layout_feed
//
//        override fun toString(): String {
//            return super.toString() + " '" + mContentView.text + "'"
//        }
//    }
//
//}
class MyFeedRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var itemClickListener: ItemClickListener? = null

    var mIdView: TextView
    var mContentView: TextView
    var layout_feed:LinearLayout


    init {

        mIdView = itemView.findViewById(R.id.item_list_title)
        mContentView = itemView.findViewById(R.id.item_list_subtitle)
        layout_feed = itemView.findViewById(R.id.layout_feed)
        layout_feed.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        itemClickListener!!.onClick(v, adapterPosition, false)
    }
}

class MyFeedRecyclerViewAdapter(private val mValues: MutableList<Condo>, private val mListener: FeedFragment.OnListFragmentInteractionListener?, private val context: Context) :
    RecyclerView.Adapter<MyFeedRecyclerViewHolder>() {


    private val inflater: LayoutInflater
    private val marginLayout: Int

    init {
        inflater = LayoutInflater.from(context)
        marginLayout = 60
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFeedRecyclerViewHolder {

        val itemView = inflater.inflate(R.layout.fragment_feed, parent, false)
        return MyFeedRecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyFeedRecyclerViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.title
        holder.mContentView.text = item.subtitle

        setOnClickLayout(holder.layout_feed,item.title!!)

    }



    private fun setOnClickLayout(layout: LinearLayout,id:String) {
        layout.setOnClickListener {
            Toast.makeText(context,"Hi $id",Toast.LENGTH_SHORT).show()
        }
    }


    override fun getItemCount(): Int {
        return mValues.size
    }
}