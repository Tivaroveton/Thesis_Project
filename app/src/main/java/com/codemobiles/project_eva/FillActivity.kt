package com.codemobiles.project_eva


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.codemobiles.project_eva.Fill1Fragment.Companion.temp_roomPosition
import com.codemobiles.project_eva.Fill1Fragment.Companion.temp_roomType
import com.codemobiles.project_eva.Fill1Fragment.Companion.temp_roomView
import com.codemobiles.project_eva.Fill3Fragment.Companion.temp_bts
import com.codemobiles.project_eva.Fill3Fragment.Companion.temp_btsName
import com.codemobiles.project_eva.Fill3Fragment.Companion.temp_buildingControl
import com.codemobiles.project_eva.Fill3Fragment.Companion.temp_district
import com.codemobiles.project_eva.Fill3Fragment.Companion.temp_districtID
import com.codemobiles.project_eva.Fill3Fragment.Companion.temp_subdistrict
import com.codemobiles.project_eva.Fill3Fragment.Companion.temp_subdistrictID
import com.codemobiles.project_eva.MyFeedRecyclerViewHolder.Companion.dataArray
import com.google.android.material.tabs.TabLayout
import com.skydoves.elasticviews.ElasticCheckButton
import kotlinx.android.synthetic.main.activity_fill_tab.*
import kotlinx.android.synthetic.main.fragment_fill1.*
import kotlinx.android.synthetic.main.fragment_fill2.*
import kotlinx.android.synthetic.main.fragment_fill3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class FillActivity : AppCompatActivity() {
    //    For Date Picker
    var button_date: Button? = null
    var textview_date: TextView? = null
    var cal = Calendar.getInstance()

//    val id = intent.getStringExtra("id")

    companion object {
        var area = arrayOf<String>()
        var btsmrt = arrayOf<String>()
        var isNewProject = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill_tab)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
//        tabs.setupWithViewPager(viewPager)

        view_pager.offscreenPageLimit = 3
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(view_pager))
        

    fun checkButtons(v: View) {
        val elasticCheckButton = v as ElasticCheckButton

        if (!elasticCheckButton.isChecked) {
            elasticCheckButton.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.check_elastic,
                0,
                0,
                0
            )
        } else {
            elasticCheckButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
        }
    }

    fun onClickBack(view: View) {
        finish()
    }

    fun onClickSave(view: View) {
        finish()

        //TextView from Fill3
        dataArray[0].projectName = textview_reportNo.text.toString()
        dataArray[0].buildingName = textview_buildingName.text.toString()
        dataArray[0].projectName = textview_reportNo.text.toString()
        dataArray[0].inspectiondate = text_view_date.text.toString()
        //Maps from Fill3
        dataArray[0].latitude = MapsActivity.condolatLng?.latitude!!.toFloat()
        dataArray[0].longtitude = MapsActivity.condolatLng?.longitude!!.toFloat()
        //Spinner from Fill3
        dataArray[0].buildingControlAct = temp_buildingControl.toInt()
        dataArray[0].districtID = temp_districtID
        dataArray[0].districtName = temp_district
        dataArray[0].subdistrictID = temp_subdistrictID
        dataArray[0].subdistrictName = temp_subdistrict
        var trainName = ""
        when (temp_bts) {
            "BTS" -> {
                dataArray[0].haveBTS = 1
                trainName = "BTS"
            }
            "MRT" -> {
                dataArray[0].haveMRT = 1
                trainName = "MRT"
            }
            "BRT" -> {
                dataArray[0].haveBRT = 1
                trainName = "BRT"
            }
        }
        dataArray[0].nearestBTS = trainName + " " + temp_btsName

        //TextView from Fill2
        dataArray[0].buildingFloor = textview_buildingFloor.text.toString().toInt()
        dataArray[0].units = textview_unit.text.toString().toInt()
        dataArray[0].buildingAge = textview_buildingAge.text.toString().toInt()
        dataArray[0].camFee = textview_camFee.text.toString().toFloat()

        //RadioButton from Fill2
        when (true) {
            bdCondition_4.isChecked -> dataArray[0].buildingCondition = 4
            bdCondition_3.isChecked -> dataArray[0].buildingCondition = 3
            bdCondition_2.isChecked -> dataArray[0].buildingCondition = 2
            bdCondition_1.isChecked -> dataArray[0].buildingCondition = 1
        }

        //Elastic Button from Fill3
        if (!elastic_lobby.isChecked) {
            dataArray[0].lobby = 1
        } else {
            dataArray[0].lobby = 0
        }
        if (!elastic_lift.isChecked) {
            dataArray[0].lift = 1
        } else {
            dataArray[0].lift = 0
        }
        if (!elastic_swimmingPool.isChecked) {
            dataArray[0].swimmingPool = 1
        } else {
            dataArray[0].swimmingPool = 0
        }
        if (!elastic_suana.isChecked) {
            dataArray[0].suana = 1
        } else {
            dataArray[0].suana = 0
        }
        if (!elastic_jacuzzi.isChecked) {
            dataArray[0].jacuzzi = 1
        } else {
            dataArray[0].jacuzzi = 0
        }
        if (!elastic_steam.isChecked) {
            dataArray[0].steam = 1
        } else {
            dataArray[0].steam = 0
        }
        if (!elastic_fitness.isChecked) {
            dataArray[0].fitness = 1
        } else {
            dataArray[0].fitness = 0
        }
        if (!elastic_library.isChecked) {
            dataArray[0].library = 1
        } else {
            dataArray[0].library = 0
        }
        if (!elastic_garden.isChecked) {
            dataArray[0].garden = 1
        } else {
            dataArray[0].garden = 0
        }
        if (!elastic_kidplay.isChecked) {
            dataArray[0].kidplay = 1
        } else {
            dataArray[0].kidplay = 0
        }
        if (!elastic_parklot.isChecked) {
            dataArray[0].parklot = 1
        } else {
            dataArray[0].parklot = 0
        }
        if (!elastic_automateParklot.isChecked) {
            dataArray[0].automateParklot = 1
        } else {
            dataArray[0].automateParklot = 0
        }
        if (!elastic_golfCourse.isChecked) {
            dataArray[0].golfCourse = 1
        } else {
            dataArray[0].golfCourse = 0
        }
        if (!elastic_movieRoom.isChecked) {
            dataArray[0].movieRoom = 1
        } else {
            dataArray[0].movieRoom = 0
        }
        if (!elastic_shop.isChecked) {
            dataArray[0].shop = 1
        } else {
            dataArray[0].shop = 0
        }

        //TextView from Fill1
        dataArray[0].floor = text_view_floor.text.toString()
        dataArray[0].areaRoom = textview_roomArea.text.toString().toFloat()
        dataArray[0].pricebyGov = textview_priceByGov.text.toString().toInt()
        dataArray[0].fireInsurance = textview_fireInsurance.text.toString().toInt()

        //Spinner from Fill1
        dataArray[0].roomType = temp_roomType + 1
        dataArray[0].roomPosition = temp_roomPosition + 1
        dataArray[0].roomView = temp_roomView + 1

        //Radio Button From Fill1
        when (true) {
            materialDesign_4.isChecked -> dataArray[0].materialDesign = 4
            materialDesign_3.isChecked -> dataArray[0].materialDesign = 3
            materialDesign_2.isChecked -> dataArray[0].materialDesign = 2
            materialDesign_1.isChecked -> dataArray[0].materialDesign = 1
        }
        when (true) {
            roomStat_4.isChecked -> dataArray[0].maintananceCondition = 4
            roomStat_3.isChecked -> dataArray[0].maintananceCondition = 3
            roomStat_2.isChecked -> dataArray[0].maintananceCondition = 2
            roomStat_1.isChecked -> dataArray[0].maintananceCondition = 1
        }

        postNewProject()
        postNewProjectDM()
        isNewProject = 0
        finish()
    }

    fun postNewProject() {

        val api = RetrofitClient.dataPost_create()
        val call = api.postData(
            dataArray[0].projectName,
            dataArray[0].buildingName,
            dataArray[0].inspectiondate,
            dataArray[0].latitude,
            dataArray[0].longtitude,
            dataArray[0].districtID,
            dataArray[0].districtName,
            dataArray[0].subdistrictID,
            dataArray[0].subdistrictName,
            dataArray[0].haveBTS,
            dataArray[0].haveMRT,
            dataArray[0].haveBRT,
            dataArray[0].nearestBTS,
            dataArray[0].distanceFromBTS,
            dataArray[0].buildingFloor,
            dataArray[0].units,
            dataArray[0].buildingAge,
            dataArray[0].buildingCondition,
            dataArray[0].lobby,
            dataArray[0].lift,
            dataArray[0].swimmingPool,
            dataArray[0].fitness,
            dataArray[0].suana,
            dataArray[0].jacuzzi,
            dataArray[0].steam,
            dataArray[0].library,
            dataArray[0].garden,
            dataArray[0].kidplay,
            dataArray[0].parklot,
            dataArray[0].automateParklot,
            dataArray[0].golfCourse,
            dataArray[0].movieRoom,
            dataArray[0].shop,
            dataArray[0].camFee,
            dataArray[0].floor,
            dataArray[0].areaRoom,
            dataArray[0].pricebyGov,
            dataArray[0].fireInsurance,
            dataArray[0].roomType,
            dataArray[0].roomPosition,
            dataArray[0].roomView,
            dataArray[0].materialDesign,
            dataArray[0].maintananceCondition
        )

        call?.enqueue(object : Callback<DataClass?> {

            override fun onFailure(call: Call<DataClass>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed To connect", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                Toast.makeText(applicationContext, "Sucessfully Save", Toast.LENGTH_SHORT)
                    .show()
            }

        })

    }

    fun postNewProjectDM() {

        val api = RetrofitClient.dataPost_create()
        val call = api.postDataDM(
            dataArray[0].floor,
            dataArray[0].distanceFromBTS,
            dataArray[0].buildingFloor,
            dataArray[0].camFee,
            dataArray[0].buildingAge,
            dataArray[0].pricebyGov,
            dataArray[0].materialDesign,
            dataArray[0].units,
            dataArray[0].areaRoom,
            dataArray[0].lobby,
            dataArray[0].lift,
            dataArray[0].swimmingPool,
            dataArray[0].fitness,
            dataArray[0].suana,
            dataArray[0].jacuzzi,
            dataArray[0].steam,
            dataArray[0].library,
            dataArray[0].garden,
            dataArray[0].kidplay,
            dataArray[0].parklot,
            dataArray[0].automateParklot,
            dataArray[0].golfCourse,
            dataArray[0].movieRoom,
            dataArray[0].shop,
            dataArray[0].roomPosition,
            dataArray[0].roomType,
            dataArray[0].roomView,
            dataArray[0].buildingControlAct,
            dataArray[0].districtID,
            dataArray[0].subdistrictID,
            dataArray[0].haveBTS,
            dataArray[0].haveMRT,
            dataArray[0].haveBRT,
            dataArray[0].latitude,
            dataArray[0].longtitude,
            dataArray[0].buildingCondition
        )
        call.enqueue(object : Callback<DataClass?> {

            override fun onFailure(call: Call<DataClass>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed To connect", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                Toast.makeText(applicationContext, "Sucessfully Save", Toast.LENGTH_SHORT)
                    .show()
            }

        })

    }

}


