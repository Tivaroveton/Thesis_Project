package com.codemobiles.project_eva

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity ////
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_feed.view.*


/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyFeedRecyclerViewAdapter(
    private val mValues: MutableList<Condo>,
    private val mListener: FeedFragment.OnListFragmentInteractionListener?,
    private val context: Context
) : RecyclerView.Adapter<MyFeedRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Condo

            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item, context)

            Toast.makeText(context, "It's ${item}", Toast.LENGTH_SHORT)

            val intent = Intent(context, MenuActivity::class.java)
            val extras:Bundle = bundleOf("id" to item.id)
            startActivity(context, intent, extras)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_feed, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.title
        holder.mContentView.text = item.subtitle

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView){
        val mIdView: TextView = mView.item_list_title
        val mContentView: TextView = mView.item_list_subtitle

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }

}
