package com.codemobiles.project_eva

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.codemobiles.project_eva.dummy.DummyContent
import com.codemobiles.project_eva.dummy.DummyContent.DummyItem
import kotlinx.android.synthetic.main.content_feed.*
import kotlinx.android.synthetic.main.fragment_report.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ReportFragment.OnListFragmentInteractionListener] interface.
 */
class ReportFragment : Fragment() {


    val mDataArray = arrayListOf<Condo>()
    // TODO: Customize parameters
    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mRecyclerView.adapter = CustomAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.content_feed, container, false)

        // Set the adapter
//        if (view is RecyclerView) {
//            with(view) {
//                layoutManager = when {
//                    columnCount <= 1 -> LinearLayoutManager(context)
//                    else -> GridLayoutManager(context, columnCount)
//                }
//                adapter = MyReportRecyclerViewAdapter(DummyContent.ITEMS, listener)
//            }
//        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "15" //column-count

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ReportFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    inner class CustomAdapter : RecyclerView.Adapter<CustomHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
            val layout = LayoutInflater.from(activity).inflate(R.layout.content_feed, null, false)
            return CustomHolder(layout)
        }

        override fun getItemCount(): Int {
            return mDataArray.count()
        }

        override fun onBindViewHolder(holder: CustomHolder, position: Int) {
            val item = mDataArray[position]
            holder.itemView.item_list_title.text = "CodeMobiles ${position}"
//            Glide.with(activity!!).load(item.youtube_image).into(holder.itemView.item_list_youtube_image)
        }

    }

    class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        init {
//
//            itemView.setOnClickListener { v->
//                val item = v.getTag(R.id.item_list_title) as Youtube
////               Toast.makeText(activity, item.title, Toast.LENGTH_LONG).show()
//                YouTubeApp.startVideo(activity!!,item.id)
//            }
//        }
    }
}
