package com.codemobiles.project_eva

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.codemobiles.project_eva.FillActivity.Companion.area
import com.codemobiles.project_eva.FillActivity.Companion.btsmrt
import com.codemobiles.project_eva.MyFeedRecyclerViewHolder.Companion.dataArray
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_fill3.*
import kotlinx.android.synthetic.main.fragment_fill3.view.*
import java.text.SimpleDateFormat
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fill3Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fill3Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var button_map: Button? = null

    var button_date: Button? = null
    var textview_date: TextView? = null
    var cal = Calendar.getInstance()

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
        val view: View = inflater!!.inflate(R.layout.fragment_fill3, container, false)
        val context: Context = requireActivity()

        button_map = view.button_map
        button_map!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, MapsActivity::class.java)
            startActivity(intent)
        })

        textview_date = view.text_view_date
        button_date = view.button_date
//        button_date!!.text = "Today"

        // create an OnDateSetListener
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        button_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    context,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

        })

        // Return the fragment view/layout
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context: Context = requireActivity()

        Thread.sleep(150)

        val textview_reportNo: TextInputEditText? =
            getView()!!.findViewById<TextInputEditText>(R.id.textview_reportNo)
        textview_reportNo!!.setText(dataArray[0].projectName)

        val textview_buildingName: TextInputEditText? =
            getView()!!.findViewById<TextInputEditText>(R.id.textview_buildingName)
        textview_buildingName!!.setText(dataArray[0].buildingName)

        val textview_alwaysCondo: TextInputEditText? =
            getView()!!.findViewById<TextInputEditText>(R.id.textview_alwaysCondo)
        textview_alwaysCondo!!.setText("ห้องชุดพักอาศัย")

        text_view_date!!.setText(dataArray[0].inspectiondate)

        val textview_btsDistance: TextInputEditText? =
            getView()!!.findViewById<TextInputEditText>(R.id.textview_btsDistance)
        if (dataArray[0].distanceFromBTS != null) {
            textview_btsDistance!!.setText(dataArray[0].distanceFromBTS.toString() + "")
        }

        val Spinner_buildingControlAct =
            getView()!!.findViewById<Spinner>(R.id.Spinner_buildingControlAct)
        val buildingControlAct = resources.getStringArray(R.array.`ข้อบังคับผัง`)


        if (Spinner_buildingControlAct != null) {
            val adapter = ArrayAdapter(
                context,
                R.layout.spinner_item, buildingControlAct
            )
            Spinner_buildingControlAct.adapter = adapter
            Spinner_buildingControlAct.setSelection(dataArray[0].buildingControlAct)

            Spinner_buildingControlAct.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    temp_buildingControl = position
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }

        }

        val spinner_district = getView()!!.findViewById<Spinner>(R.id.Spinner_district)
        val district = resources.getStringArray(R.array.District)
        val spinner_area = getView()!!.findViewById<Spinner>(R.id.Spinner_area)

        val subdistrictVal: List<Int> = listOf(
            0,
            3,
            6,
            11,
            12,
            16,
            17,
            21,
            22,
            29,
            30,
            35,
            37,
            40,
            52,
            55,
            59,
            62,
            67,
            69,
            71,
            72,
            76,
            77,
            81,
            82,
            84,
            86,
            90,
            91,
            99,
            101,
            103,
            105,
            111,
            113,
            115,
            116,
            119,
            124,
            127,
            134,
            140,
            145,
            147,
            148,
            150,
            152,
            155
        )
        var realsubdistrict =
            dataArray[0].subdistrictID - subdistrictVal[dataArray[0].districtID]
        if (spinner_district != null) {
            val adapter = ArrayAdapter(
                context,
                R.layout.spinner_item, district
            )
            spinner_district.adapter = adapter
            spinner_district.setSelection(dataArray[0].districtID)

            spinner_district.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {

                    temp_districtID = position
                    temp_district = district[position]

                    if (district[position] == "คลองเตย") {
                        FillActivity.area = resources.getStringArray(R.array.คลองเตย)
                    }
                    if (district[position] == "คลองสาน") {
                        FillActivity.area = resources.getStringArray(R.array.คลองสาน)
                    }
                    if (district[position] == "คลองสามวา") {
                        FillActivity.area = resources.getStringArray(R.array.คลองสามวา)
                    }
                    if (district[position] == "คันนายาว") {
                        FillActivity.area = resources.getStringArray(R.array.`คันนายาว`)
                    }
                    if (district[position] == "จตุจักร") {
                        FillActivity.area = resources.getStringArray(R.array.`จตุจักร`)
                    }
                    if (district[position] == "จอมทอง") {
                        FillActivity.area = resources.getStringArray(R.array.จอมทอง)
                    }
                    if (district[position] == "ดอนเมือง") {
                        FillActivity.area = resources.getStringArray(R.array.`ดอนเมือง`)
                    }
                    if (district[position] == "ดินแดง") {
                        FillActivity.area = resources.getStringArray(R.array.`ดินแดง`)
                    }
                    if (district[position] == "ดุสิต") {
                        FillActivity.area = resources.getStringArray(R.array.`ดุสิต`)
                    }
                    if (district[position] == "ตลิ่งชัน") {
                        FillActivity.area = resources.getStringArray(R.array.`ตลิ่งชัน`)
                    }
                    if (district[position] == "ทวีวัฒนา") {
                        FillActivity.area = resources.getStringArray(R.array.`ทวีวัฒนา`)
                    }
                    if (district[position] == "ทุ่งครุ") {
                        FillActivity.area = resources.getStringArray(R.array.`ทุ่งครุ`)
                    }
                    if (district[position] == "ธนบุรี") {
                        FillActivity.area = resources.getStringArray(R.array.`ธนบุรี`)
                    }
                    if (district[position] == "บางเขน") {
                        FillActivity.area = resources.getStringArray(R.array.บางเขน)
                    }
                    if (district[position] == "บางแค") {
                        FillActivity.area = resources.getStringArray(R.array.บางแค)
                    }
                    if (district[position] == "บางกอกใหญ่") {
                        FillActivity.area = resources.getStringArray(R.array.`บางกอกใหญ่`)
                    }
                    if (district[position] == "บางกอกน้อย") {
                        FillActivity.area = resources.getStringArray(R.array.`บางกอกน้อย`)
                    }
                    if (district[position] == "บางกะปิ") {
                        FillActivity.area = resources.getStringArray(R.array.`บางกะปิ`)
                    }
                    if (district[position] == "บางขุนเทียน") {
                        FillActivity.area = resources.getStringArray(R.array.`บางขุนเทียน`)
                    }
                    if (district[position] == "บางคอแหลม") {
                        FillActivity.area = resources.getStringArray(R.array.บางคอแหลม)
                    }
                    if (district[position] == "คลองสาน") {
                        FillActivity.area = resources.getStringArray(R.array.คลองสาน)
                    }
                    if (district[position] == "บางซื่อ") {
                        FillActivity.area = resources.getStringArray(R.array.`บางซื่อ`)
                    }
                    if (district[position] == "บางนา") {
                        FillActivity.area = resources.getStringArray(R.array.บางนา)
                    }
                    if (district[position] == "บางบอน") {
                        FillActivity.area = resources.getStringArray(R.array.บางบอน)
                    }
                    if (district[position] == "บางพลัด") {
                        FillActivity.area = resources.getStringArray(R.array.`บางพลัด`)
                    }
                    if (district[position] == "บางรัก") {
                        FillActivity.area = resources.getStringArray(R.array.`บางรัก`)
                    }
                    if (district[position] == "บึงกุ่ม") {
                        FillActivity.area = resources.getStringArray(R.array.`บึงกุ่ม`)
                    }
                    if (district[position] == "ปทุมวัน") {
                        FillActivity.area = resources.getStringArray(R.array.`ปทุมวัน`)
                    }
                    if (district[position] == "ป้อมปราบศัตรูพ่าย") {
                        FillActivity.area = resources.getStringArray(R.array.`ป้อมปราบศัตรูพ่าย`)
                    }
                    if (district[position] == "พญาไท") {
                        FillActivity.area = resources.getStringArray(R.array.พญาไท)
                    }
                    if (district[position] == "พระโขนง") {
                        FillActivity.area = resources.getStringArray(R.array.พระโขนง)
                    }
                    if (district[position] == "พระนคร") {
                        FillActivity.area = resources.getStringArray(R.array.พระนคร)
                    }
                    if (district[position] == "ภาษีเจริญ") {
                        FillActivity.area = resources.getStringArray(R.array.`ภาษีเจริญ`)
                    }
                    if (district[position] == "มีนบุรี") {
                        FillActivity.area = resources.getStringArray(R.array.`มีนบุรี`)
                    }
                    if (district[position] == "ยานนาวา") {
                        FillActivity.area = resources.getStringArray(R.array.ยานนาวา)
                    }
                    if (district[position] == "ราชเทวี") {
                        FillActivity.area = resources.getStringArray(R.array.`ราชเทวี`)
                    }
                    if (district[position] == "ราษฎร์บูรณะ") {
                        FillActivity.area = resources.getStringArray(R.array.`ราษฎร์บูรณะ`)
                    }
                    if (district[position] == "ลาดกระบัง") {
                        FillActivity.area = resources.getStringArray(R.array.`ลาดกระบัง`)
                    }
                    if (district[position] == "ลาดพร้าว") {
                        FillActivity.area = resources.getStringArray(R.array.`ลาดพร้าว`)
                    }
                    if (district[position] == "วังทองหลาง") {
                        FillActivity.area = resources.getStringArray(R.array.`วังทองหลาง`)
                    }
                    if (district[position] == "วัฒนา") {
                        FillActivity.area = resources.getStringArray(R.array.`วัฒนา`)
                    }
                    if (district[position] == "สวนหลวง") {
                        FillActivity.area = resources.getStringArray(R.array.สวนหลวง)
                    }
                    if (district[position] == "สะพานสูง") {
                        FillActivity.area = resources.getStringArray(R.array.`สะพานสูง`)
                    }
                    if (district[position] == "สัมพันธวงศ์") {
                        FillActivity.area = resources.getStringArray(R.array.`สัมพันธวงศ์`)
                    }
                    if (district[position] == "สาทร") {
                        FillActivity.area = resources.getStringArray(R.array.สาทร)
                    }
                    if (district[position] == "สายไหม") {
                        FillActivity.area = resources.getStringArray(R.array.สายไหม)
                    }
                    if (district[position] == "หนองแขม") {
                        FillActivity.area = resources.getStringArray(R.array.หนองแขม)
                    }
                    if (district[position] == "หนองจอก") {
                        FillActivity.area = resources.getStringArray(R.array.หนองจอก)
                    }
                    if (district[position] == "หลักสี่") {
                        FillActivity.area = resources.getStringArray(R.array.`หลักสี่`)
                    }
                    if (district[position] == "ห้วยขวาง") {
                        FillActivity.area = resources.getStringArray(R.array.`ห้วยขวาง`)
                    }
                    var adapter = ArrayAdapter(
                        context,
                        R.layout.spinner_item, FillActivity.area
                    )
                    spinner_area.adapter = adapter
                    spinner_district.setSelection(realsubdistrict)
                    spinner_district.onItemSelectedListener = object :
                        AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>,
                            view: View, position: Int, id: Long
                        ) {
                            temp_subdistrictID = position
                            temp_subdistrict = area[position]
                            spinner_district.setSelection(dataArray[0].districtID)
                        }

                        override fun onNothingSelected(parent: AdapterView<*>?) {}
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }



        val spinner_haveBTS = getView()!!.findViewById<Spinner>(R.id.Spinner_haveBTS)
        val haveBTS = resources.getStringArray(R.array.haveBTS)
        val spinner_btsmrt = getView()!!.findViewById<Spinner>(R.id.Spinner_btsmrt)


        var subnearestBts : Array<String> = arrayOf("","")
        if (dataArray[0].nearestBTS != null) {
            subnearestBts[0] = dataArray[0].nearestBTS.split(" ")[0]
            subnearestBts[1] = dataArray[0].nearestBTS.split(" ")[1]
        }
        else{
            subnearestBts[0] =="-"
            subnearestBts[1] =="-"
        }


        if (spinner_haveBTS != null) {
            val adapter = ArrayAdapter(
                context,
                R.layout.spinner_item, haveBTS
            )
            spinner_haveBTS.adapter = adapter
            spinner_haveBTS.setSelection(adapter.getPosition(subnearestBts[0]))

            //Inner Spinner
            spinner_haveBTS.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    temp_bts = haveBTS[position]

                    if (haveBTS[position] == "-") {
                        FillActivity.btsmrt = resources.getStringArray(R.array.na)
                    }
                    if (haveBTS[position] == "BTS") {
                        FillActivity.btsmrt = resources.getStringArray(R.array.bts)
                    }
                    if (haveBTS[position] == "MRT") {
                        FillActivity.btsmrt = resources.getStringArray(R.array.mrt)
                    }
                    if (haveBTS[position] == "BRT") {
                        FillActivity.btsmrt = resources.getStringArray(R.array.brt)
                    }
                    if (haveBTS[position] == "Airport Rail Link") {
                        FillActivity.btsmrt = resources.getStringArray(R.array.airport_rail_link)
                    }
                    var adapter = ArrayAdapter(
                        context,
                        R.layout.spinner_item, FillActivity.btsmrt
                    )
                    spinner_btsmrt.adapter = adapter
                    spinner_btsmrt.setSelection(adapter.getPosition(subnearestBts[1]))

                    spinner_btsmrt.onItemSelectedListener = object :
                        AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>,
                            view: View, position: Int, id: Long
                        ) {
                            temp_btsName = btsmrt[position]
                        }

                        override fun onNothingSelected(parent: AdapterView<*>?) {}
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }

            }

        }


    }

    fun onClickMap(view: View) {
        val intent = Intent(context, MapsActivity::class.java)
        startActivity(intent)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fill3Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fill3Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        var temp_district = ""
        var temp_districtID = 0
        var temp_subdistrict = ""
        var temp_subdistrictID = 0
        var temp_bts = ""
        var temp_btsName = ""
        var temp_buildingControl = 0

    }

    //Date Picker
    private fun updateDateInView() {
        val myFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textview_date!!.text = sdf.format(cal.getTime())
    }

    private fun getIndex(spinner: Spinner, myString: String): Int {
        var index = 0
        for (i in 0 until spinner.count) {
            if (spinner.getItemAtPosition(i) == "เขต" + myString) {
                index = i
            }
        }
        return index
    }


}
