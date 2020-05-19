package com.codemobiles.project_eva

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codemobiles.project_eva.MyFeedRecyclerViewHolder.Companion.dataArray
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_fill2.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fill2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fill2Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        return inflater.inflate(R.layout.fragment_fill2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context: Context = requireActivity()

        Thread.sleep(150)

        val textview_buildingFloor: TextInputEditText? =
            getView()!!.findViewById<TextInputEditText>(R.id.textview_buildingFloor)
        textview_buildingFloor!!.setText(dataArray[0].buildingFloor.toString())

        val textview_unit: TextInputEditText? =
            getView()!!.findViewById<TextInputEditText>(R.id.textview_unit)
        textview_unit!!.setText(dataArray[0].units.toString())

        val textview_buildingAge: TextInputEditText? =
            getView()!!.findViewById<TextInputEditText>(R.id.textview_buildingAge)
        textview_buildingAge!!.setText(dataArray[0].buildingAge.toString())

        val textview_camFee: TextInputEditText? =
            getView()!!.findViewById<TextInputEditText>(R.id.textview_camFee)
        textview_camFee!!.setText(dataArray[0].camFee.toString())


        when (dataArray[0].buildingCondition) {
            4  -> bdCondition_4.isChecked = true
            3  -> bdCondition_3.isChecked = true
            2  -> bdCondition_2.isChecked = true
            1  -> bdCondition_1.isChecked = true
        }


        if( dataArray[0].lobby == 1){
            elastic_library.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_library.alpha = 1.0F
        }
        if( dataArray[0].lift == 1){
            elastic_lift.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_lift.alpha = 1.0F
        }
        if( dataArray[0].swimmingPool == 1){
            elastic_swimmingPool.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_swimmingPool.alpha = 1.0F
        }
        if( dataArray[0].suana == 1){
            elastic_suana.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_suana.alpha = 1.0F
        }
        if( dataArray[0].jacuzzi == 1){
            elastic_jacuzzi.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_jacuzzi.alpha = 1.0F
        }
        if( dataArray[0].steam == 1){
            elastic_steam.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_steam.alpha = 1.0F
        }
        if( dataArray[0].fitness == 1){
            elastic_fitness.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_fitness.alpha = 1.0F
        }
        if( dataArray[0].library == 1){
            elastic_library.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_library.alpha = 1.0F
        }
        if( dataArray[0].garden == 1){
            elastic_garden.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_garden.alpha = 1.0F
        }
        if( dataArray[0].kidplay == 1){
            elastic_kidplay.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_kidplay.alpha = 1.0F
        }
        if( dataArray[0].parklot == 1){
            elastic_parklot.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_parklot.alpha = 1.0F
        }
        if( dataArray[0].automateParklot == 1){
            elastic_automateParklot.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_automateParklot.alpha = 1.0F
        }
        if( dataArray[0].golfCourse == 1){
            elastic_golfCourse.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_golfCourse.alpha = 1.0F
        }
        if( dataArray[0].movieRoom == 1){
            elastic_movieRoom.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_movieRoom.alpha = 1.0F
        }
        if( dataArray[0].shop == 1){
            elastic_shop.setBackgroundColor(Color.parseColor("#40739e"))
            elastic_shop.alpha = 1.0F
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fill2Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fill2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }
}
