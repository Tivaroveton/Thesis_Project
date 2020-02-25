package com.codemobiles.project_eva

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fill.*
import java.text.SimpleDateFormat
import java.util.*

class FillActivity : AppCompatActivity() {
    //    For Date Picker
    var button_date: Button? = null
    var textview_date: TextView? = null
    var cal = Calendar.getInstance()

    companion object {
        var area = arrayOf<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.codemobiles.project_eva.R.layout.activity_fill)


//        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
//        view_pager.adapter = sectionsPagerAdapter

//        val for spinner
        val spinner_district = findViewById<Spinner>(R.id.Spinner_district)
        val spinner_area = findViewById<Spinner>(R.id.Spinner_area)
        val district = resources.getStringArray(R.array.District)
        area = resources.getStringArray(R.array.คลองสาน)

        val Spinner_buildingControlAct = findViewById<Spinner>(R.id.Spinner_buildingControlAct)
        val buildingControlAct = resources.getStringArray(R.array.`ข้อบังคับผัง`)

        val Spinner_roomType = findViewById<Spinner>(R.id.Spinner_roomType)
        val roomType = resources.getStringArray(R.array.`ประเภทห้อง`)

        val Spinner_roomPosition = findViewById<Spinner>(R.id.Spinner_roomPosition)
        val roomPosition = resources.getStringArray(R.array.`ตำแหน่งห้อง`)

        val Spinner_roomView = findViewById<Spinner>(R.id.Spinner_roomPosition)
        val roomView = resources.getStringArray(R.array.`วิวห้อง`)

        if (spinner_district != null) {
            val adapter = ArrayAdapter(
                this,
                R.layout.spinner_item, district
            )
            spinner_district.adapter = adapter

            spinner_district.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@FillActivity,
                        getString(R.string.selected_item) + " " +
                                "" + district[position], Toast.LENGTH_SHORT
                    ).show()

                    if (district[position] == "คลองเตย") {
                        area = resources.getStringArray(R.array.คลองเตย)
                    }
                    if (district[position] == "คลองสาน") {
                        area = resources.getStringArray(R.array.คลองสาน)
                    }
                    if (district[position] == "คลองสามวา") {
                        area = resources.getStringArray(R.array.คลองสามวา)
                    }
                    if (district[position] == "คันนายาว") {
                        area = resources.getStringArray(R.array.`คันนายาว`)
                    }
                    if (district[position] == "จตุจักร") {
                        area = resources.getStringArray(R.array.`จตุจักร`)
                    }
                    if (district[position] == "จอมทอง") {
                        area = resources.getStringArray(R.array.จอมทอง)
                    }
                    if (district[position] == "ดอนเมือง") {
                        area = resources.getStringArray(R.array.`ดอนเมือง`)
                    }
                    if (district[position] == "ดินแดง") {
                        area = resources.getStringArray(R.array.`ดินแดง`)
                    }
                    if (district[position] == "ดุสิต") {
                        area = resources.getStringArray(R.array.`ดุสิต`)
                    }
                    if (district[position] == "ตลิ่งชัน") {
                        area = resources.getStringArray(R.array.`ตลิ่งชัน`)
                    }
                    if (district[position] == "ทวีวัฒนา") {
                        area = resources.getStringArray(R.array.`ทวีวัฒนา`)
                    }
                    if (district[position] == "ทุ่งครุ") {
                        area = resources.getStringArray(R.array.`ทุ่งครุ`)
                    }
                    if (district[position] == "ธนบุรี") {
                        area = resources.getStringArray(R.array.`ธนบุรี`)
                    }
                    if (district[position] == "บางเขน") {
                        area = resources.getStringArray(R.array.บางเขน)
                    }
                    if (district[position] == "บางแค") {
                        area = resources.getStringArray(R.array.บางแค)
                    }
                    if (district[position] == "บางกอกใหญ่") {
                        area = resources.getStringArray(R.array.`บางกอกใหญ่`)
                    }
                    if (district[position] == "บางกอกน้อย") {
                        area = resources.getStringArray(R.array.`บางกอกน้อย`)
                    }
                    if (district[position] == "บางกะปิ") {
                        area = resources.getStringArray(R.array.`บางกะปิ`)
                    }
                    if (district[position] == "บางขุนเทียน") {
                        area = resources.getStringArray(R.array.`บางขุนเทียน`)
                    }
                    if (district[position] == "บางคอแหลม") {
                        area = resources.getStringArray(R.array.บางคอแหลม)
                    }
                    if (district[position] == "คลองสาน") {
                        area = resources.getStringArray(R.array.คลองสาน)
                    }
                    if (district[position] == "บางซื่อ") {
                        area = resources.getStringArray(R.array.`บางซื่อ`)
                    }
                    if (district[position] == "บางนา") {
                        area = resources.getStringArray(R.array.บางนา)
                    }
                    if (district[position] == "บางบอน") {
                        area = resources.getStringArray(R.array.บางบอน)
                    }
                    if (district[position] == "บางพลัด") {
                        area = resources.getStringArray(R.array.`บางพลัด`)
                    }
                    if (district[position] == "บางรัก") {
                        area = resources.getStringArray(R.array.`บางรัก`)
                    }
                    if (district[position] == "บึงกุ่ม") {
                        area = resources.getStringArray(R.array.`บึงกุ่ม`)
                    }
                    if (district[position] == "ปทุมวัน") {
                        area = resources.getStringArray(R.array.`ปทุมวัน`)
                    }
                    if (district[position] == "ป้อมปราบศัตรูพ่าย") {
                        area = resources.getStringArray(R.array.`ป้อมปราบศัตรูพ่าย`)
                    }
                    if (district[position] == "พญาไท") {
                        area = resources.getStringArray(R.array.พญาไท)
                    }
                    if (district[position] == "พระโขนง") {
                        area = resources.getStringArray(R.array.พระโขนง)
                    }
                    if (district[position] == "พระนคร") {
                        area = resources.getStringArray(R.array.พระนคร)
                    }
                    if (district[position] == "ภาษีเจริญ") {
                        area = resources.getStringArray(R.array.`ภาษีเจริญ`)
                    }
                    if (district[position] == "มีนบุรี") {
                        area = resources.getStringArray(R.array.`มีนบุรี`)
                    }
                    if (district[position] == "ยานนาวา") {
                        area = resources.getStringArray(R.array.ยานนาวา)
                    }
                    if (district[position] == "ราชเทวี") {
                        area = resources.getStringArray(R.array.`ราชเทวี`)
                    }
                    if (district[position] == "ราษฎร์บูรณะ") {
                        area = resources.getStringArray(R.array.`ราษฎร์บูรณะ`)
                    }
                    if (district[position] == "ลาดกระบัง") {
                        area = resources.getStringArray(R.array.`ลาดกระบัง`)
                    }
                    if (district[position] == "ลาดพร้าว") {
                        area = resources.getStringArray(R.array.`ลาดพร้าว`)
                    }
                    if (district[position] == "วังทองหลาง") {
                        area = resources.getStringArray(R.array.`วังทองหลาง`)
                    }
                    if (district[position] == "วัฒนา") {
                        area = resources.getStringArray(R.array.`วัฒนา`)
                    }
                    if (district[position] == "สวนหลวง") {
                        area = resources.getStringArray(R.array.สวนหลวง)
                    }
                    if (district[position] == "สะพานสูง") {
                        area = resources.getStringArray(R.array.`สะพานสูง`)
                    }
                    if (district[position] == "สัมพันธวงศ์") {
                        area = resources.getStringArray(R.array.`สัมพันธวงศ์`)
                    }
                    if (district[position] == "สาทร") {
                        area = resources.getStringArray(R.array.สาทร)
                    }
                    if (district[position] == "สายไหม") {
                        area = resources.getStringArray(R.array.สายไหม)
                    }
                    if (district[position] == "หนองแขม") {
                        area = resources.getStringArray(R.array.หนองแขม)
                    }
                    if (district[position] == "หนองจอก") {
                        area = resources.getStringArray(R.array.หนองจอก)
                    }
                    if (district[position] == "หลักสี่") {
                        area = resources.getStringArray(R.array.`หลักสี่`)
                    }
                    if (district[position] == "ห้วยขวาง") {
                        area = resources.getStringArray(R.array.`ห้วยขวาง`)
                    }
                    var adapter = ArrayAdapter(
                        this@FillActivity,
                        R.layout.spinner_item, area
                    )
                    spinner_area.adapter = adapter
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        if (Spinner_buildingControlAct != null) {
            val adapter = ArrayAdapter(
                this,
                R.layout.spinner_item, buildingControlAct
            )
            Spinner_buildingControlAct.adapter = adapter
        }

        if (Spinner_roomType != null) {
            val adapter = ArrayAdapter(
                this,
                R.layout.spinner_item, roomType
            )
            Spinner_roomType.adapter = adapter
        }

        if (Spinner_roomPosition != null) {
            val adapter = ArrayAdapter(
                this,
                R.layout.spinner_item, roomPosition
            )
            Spinner_roomPosition.adapter = adapter
        }

        if (Spinner_roomView != null) {
            val adapter = ArrayAdapter(
                this,
                R.layout.spinner_item, roomView
            )
            Spinner_roomView.adapter = adapter
        }


        //        tabs.setupWithViewPager(viewPager)

//        view_pager.offscreenPageLimit = 3
//        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
//        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(view_pager))


//        Date Picker
        textview_date = this.text_view_date_1
        button_date = this.button_date_1
        textview_date!!.text = "--/--/----"

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

        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        button_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    this@FillActivity,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

        })


// Get radio group selected item using on checked change listener
        radio_group_lobby.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
//                Toast.makeText(applicationContext," On checked change :"+
//                        " ${radio.text}",
//                    Toast.LENGTH_SHORT).show()
            })

        // Get the selected radio button text using radio button on click listener
        fun radio_button_click(view: View) {
            // Get the clicked radio button instance
            val radio: RadioButton = findViewById(radio_group_lobby.checkedRadioButtonId)
        }

        fun onClickSave(view: View) {

//        var id: Int = radio_group_lobby.checkedRadioButtonId
//        var string:String = ""


        }

        //    fun checkIfhave(view: View,id: Int,string: String){
//        if (id != -1) { // If any radio button checked from radio group
//            // Get the instance of radio button using id
//            val radio: RadioButton = findViewById(id)
//            Toast.makeText(
//                applicationContext, "On button click :" +
//                        " ${radio.text}",
//                Toast.LENGTH_SHORT
//            ).show()
//        } else {
//            // If no radio button checked in this radio group
//            Toast.makeText(
//                applicationContext, "On button click :" +
//                        " nothing selected",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//    }
//
//    fun re_0or1 (boolean: String){
//        if (boolean == "มี"){
//            boolean "0,"
//        }
//    }
        fun onClickChangeDate() {
            DatePickerDialog(
                this@FillActivity,
                dateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun updateDateInView() {
        val myFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textview_date!!.text = sdf.format(cal.getTime())
    }
}


