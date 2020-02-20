package com.codemobiles.project_eva

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class ReportAdapter (val mContext: Context, val layoutResId: Int, val condoList : List<Condo>): ArrayAdapter<Condo>(mContext, layoutResId, condoList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflator: LayoutInflater = LayoutInflater.from(mContext)
        val view:View = layoutInflator.inflate(layoutResId, null)
        val usrTextView = view.findViewById<TextView>(R.id.mRecyclerView)


        val usr = condoList[position]

        usrTextView.text = usr.title
        return view
    }
}