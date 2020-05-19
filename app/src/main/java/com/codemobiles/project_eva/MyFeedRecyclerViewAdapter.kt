package com.codemobiles.project_eva

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.codemobiles.project_eva.MyFeedRecyclerViewHolder.Companion.currCondo
import com.codemobiles.project_eva.MyFeedRecyclerViewHolder.Companion.currcondoCode
import com.codemobiles.project_eva.MyFeedRecyclerViewHolder.Companion.dataArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
class MyFeedRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private var itemClickListener: ItemClickListener? = null

    var mIdView: TextView
    var mContentView: TextView
    val mPicture: ImageView
    var layout_feed: LinearLayout

    companion object {
        lateinit var currCondo: ProjectRow
        var dataArray = arrayListOf<DataRow>()
        lateinit var currcondoCode :String

    }

    init {

        mIdView = itemView.findViewById(R.id.item_list_title)
        mContentView = itemView.findViewById(R.id.item_list_subtitle)
        mPicture = itemView.findViewById(R.id.item_list_image)
        layout_feed = itemView.findViewById(R.id.layout_feed)
        layout_feed.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        itemClickListener!!.onClick(v, adapterPosition, false)
    }
}

class MyFeedRecyclerViewAdapter(
    private val mValues: List<ProjectRow>,
    private val mPicture: Array<Int>,
    private val mListener: FeedFragment.OnListFragmentInteractionListener?,
    private val context: Context
) :
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
        currcondoCode = item.projectName
//        var picture = item.tabpicture?.toInt()

        val pjName :String = item.projectName.split(".")[0]
        holder.mIdView.text = pjName
        holder.mContentView.text = item.buildingName
        holder.mPicture.setImageResource(mPicture[position%4])

        setOnClickLayout(holder.layout_feed, item.projectName!!, item.inspectiondate!!)

    }

    private fun setOnClickLayout(layout: LinearLayout, title: String, id: String) {
        layout.setOnClickListener {
            for (item in FeedActivity.condoList) {
                if (id == item.projectName) {
                    currCondo = item
                }
            }

            getData()

//            val intent = Intent(context, MenuActivity::class.java)
            val intent = Intent(context, FillActivity::class.java)
//            intent.putExtra("title", title);
//            intent.putExtra("id", id);
            val extras: Bundle? = bundleOf("id" to id, "title" to title)

//            val extras: Bundle? = intent.getExtras()
//            extras?.putString(title, id)
            startActivity(context, intent, extras)


        }
    }

    private fun getData() {
        val api = RetrofitClient.login_create()
        val call = api.getData(currcondoCode)
        call.enqueue(object : Callback<DataClass> {

            override fun onFailure(call: Call<DataClass>, t: Throwable) {
                Toast.makeText(context, "Failed To connect", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                dataArray.clear()
                response.body()?.rows?.let { dataArray.addAll(it) }

            }

        })
    }


    override fun getItemCount(): Int {
        val limit: Int = 20
        if (mValues.size > limit) {
            return limit;
        } else {
            return mValues.size
        }
    }
}