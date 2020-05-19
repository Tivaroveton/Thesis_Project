package com.codemobiles.project_eva

import android.app.DatePickerDialog
import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import com.codemobiles.project_eva.MyFeedRecyclerViewHolder.Companion.dataArray
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_fill1.*
import kotlinx.android.synthetic.main.fragment_fill1.view.*
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fill1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fill1Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var button_date: Button? = null
    var textview_date: TextView? = null
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Arguments
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_fill1, container, false)
        val context: Context = requireActivity()

        // Return the fragment view/layout
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context: Context = requireActivity()

        Thread.sleep(150)

        //set Save Invisible for old report
        if (FillActivity.isNewProject == 0) {
            btn_save.isClickable = false
            btn_save.visibility = View.INVISIBLE
        } else {
            btn_save.isClickable = true
            btn_save.visibility = View.VISIBLE
        }

        val text_view_floor: TextInputEditText? =
            getView()!!.findViewById<TextInputEditText>(R.id.text_view_floor)
        text_view_floor!!.setText(MyFeedRecyclerViewHolder.dataArray[0].floor)

        val textview_roomArea: TextInputEditText? =
            getView()!!.findViewById<TextInputEditText>(R.id.textview_roomArea)
        textview_roomArea!!.setText(MyFeedRecyclerViewHolder.dataArray[0].areaRoom.toString())

        val textview_priceByGov: TextInputEditText? =
            getView()!!.findViewById<TextInputEditText>(R.id.textview_priceByGov)
        textview_priceByGov!!.setText(MyFeedRecyclerViewHolder.dataArray[0].pricebyGov.toString())

        val textview_fireInsurance: TextInputEditText? =
            getView()!!.findViewById<TextInputEditText>(R.id.textview_fireInsurance)
        textview_fireInsurance!!.setText(MyFeedRecyclerViewHolder.dataArray[0].fireInsurance.toString())

        val Spinner_roomType = getView()!!.findViewById<Spinner>(R.id.Spinner_roomType)
        val roomType = resources.getStringArray(R.array.`ประเภทห้อง`)

        val Spinner_roomPosition = getView()!!.findViewById<Spinner>(R.id.Spinner_roomPosition)
        val roomPosition = resources.getStringArray(R.array.`ตำแหน่งห้อง`)

        val Spinner_roomView = getView()!!.findViewById<Spinner>(R.id.Spinner_roomView)
        val roomView = resources.getStringArray(R.array.`วิวห้อง`)

        if (Spinner_roomType != null) {
            val adapter = ArrayAdapter(
                context,
                R.layout.spinner_item, roomType
            )
            Spinner_roomType.adapter = adapter
            Spinner_roomType.setSelection(dataArray[0].roomType)
            Spinner_roomType.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {}
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                     temp_roomType = position
                }
            }
        }

        if (Spinner_roomPosition != null) {
            val adapter = ArrayAdapter(
                context,
                R.layout.spinner_item, roomPosition
            )
            Spinner_roomPosition.adapter = adapter
            Spinner_roomPosition.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {}
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    temp_roomPosition = position
                }
            }
        }

        if (Spinner_roomView != null) {
            val adapter = ArrayAdapter(
                context,
                R.layout.spinner_item, roomView
            )
            Spinner_roomView.adapter = adapter
            Spinner_roomView.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {}
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    temp_roomView = position
                }
            }
        }

        when (dataArray[0].materialDesign) {
            4 -> materialDesign_4.isChecked = true
            3 -> materialDesign_3.isChecked = true
            2 -> materialDesign_2.isChecked = true
            1 -> materialDesign_1.isChecked = true
        }
        when (dataArray[0].maintananceCondition) {
            4 -> roomStat_4.isChecked = true
            3 -> roomStat_3.isChecked = true
            2 -> roomStat_2.isChecked = true
            1 -> roomStat_1.isChecked = true
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fill1Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fill1Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
        var temp_roomType = 0
        var temp_roomPosition = 0
        var temp_roomView = 0


        var area = arrayOf<String>()
    }


}


