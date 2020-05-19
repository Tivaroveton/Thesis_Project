package com.codemobiles.project_eva

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codemobiles.project_eva.FillActivity.Companion.isNewProject
import com.codemobiles.project_eva.MainActivity.Companion.staffID
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_feed.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class FeedActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    companion object {
        lateinit var condoList: List<ProjectRow>
        lateinit var latestReportNo : String
    }

    //    lateinit var dataReference: DatabaseReference
    val mListener: FeedFragment.OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        val userBean = intent.getParcelableExtra<UserBean>(Constants.USER_BEAN)
        Toast.makeText(this, userBean.username, Toast.LENGTH_LONG).show()
        val userBundle = Bundle()
        userBundle.putParcelable(Constants.USER_BEAN, userBean)

        val mFab = findViewById<FloatingActionButton>(R.id.fab)
        mFab.setOnClickListener {
            Toast.makeText(this, "New Report Created", Toast.LENGTH_LONG).show()
            isNewProject = 1
            val intent = Intent(this, FillActivity::class.java)

//            MyFeedRecyclerViewHolder.dataArray.clear()
//            MyFeedRecyclerViewHolder.dataArray = arrayListOf<DataRow>()
            newReport()
            startActivity(intent)
        }

        var imageList = arrayOf<Int>(
            R.drawable.condo_001,
            R.drawable.condo_002,
            R.drawable.condo_003,
            R.drawable.condo_ex2
        )
        val Rid: String = "R.drawable."
        val condo1 = Condo.Builder()
            .id("001")
            .title("LM-fa-001")
            .subtitle("คอนโดมิเนียมเอบีซี")
            .tabpicture(Rid + "condo_001")
            .build()
        val condo2 = Condo.Builder()
            .id("002")
            .title("LM-fa-002")
            .subtitle("The Condo Name")
            .tabpicture(Rid + "condo_002")
            .build()


        val testcondo1 = Condotest("Condo1", "The Test Condo", "Gas Gas Gas")

//
        val project1 = ProjectRow("xls-1","2","Condo ZZ","LC61-1234","19/94/7458")
        val project2 = ProjectRow("xls-2","2","Condo oo","LC61-1235", "19/94/7458")
        val project3 = ProjectRow("xls-3","2","Condo kk","LC61-1236", "19/94/7458")

        val dummyProject: List<ProjectRow>
        dummyProject = listOf(project1, project2, project3)


        linearLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = linearLayoutManager
        var mRecyclerView = findViewById(R.id.mRecyclerView) as RecyclerView

        feed()

        val context: Context = this@FeedActivity
        val adapter = MyFeedRecyclerViewAdapter(
            mDataArray, //condoList
            imageList,
            mListener,
            context
        )
        mRecyclerView.adapter = adapter

    }

    private fun newReport() {
        var newPjName :String = latestReportNo.split(".")[0]
        var newNo : Int = newPjName.split("-")[2].toInt() + 1
        newPjName = newPjName.split("-")[0] +"-" +newPjName.split("-")[1] +"-" +
                newNo.toString() +"." + latestReportNo.split(".")[1]
        MyFeedRecyclerViewHolder.dataArray[0].projectName = newPjName
        MyFeedRecyclerViewHolder.dataArray[0].buildingName = ""
        val currentDateTime = LocalDateTime.now()
        MyFeedRecyclerViewHolder.dataArray[0].inspectiondate = currentDateTime.format(
            DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()
        MyFeedRecyclerViewHolder.dataArray[0].latitude = 0.0F
        MyFeedRecyclerViewHolder.dataArray[0].longtitude = 0.0F
        MyFeedRecyclerViewHolder.dataArray[0].districtID = 0
        MyFeedRecyclerViewHolder.dataArray[0].subdistrictID = 0
        MyFeedRecyclerViewHolder.dataArray[0].nearestBTS = ""
        MyFeedRecyclerViewHolder.dataArray[0].distanceFromBTS = 0
        MyFeedRecyclerViewHolder.dataArray[0].buildingControlAct = 0
        MyFeedRecyclerViewHolder.dataArray[0].haveBTS = 0
        MyFeedRecyclerViewHolder.dataArray[0].haveBRT = 0
        MyFeedRecyclerViewHolder.dataArray[0].haveMRT = 0

        MyFeedRecyclerViewHolder.dataArray[0].buildingFloor = 0
        MyFeedRecyclerViewHolder.dataArray[0].units = 0
        MyFeedRecyclerViewHolder.dataArray[0].buildingAge = 0
        MyFeedRecyclerViewHolder.dataArray[0].buildingCondition = 0
        MyFeedRecyclerViewHolder.dataArray[0].lobby = 0
        MyFeedRecyclerViewHolder.dataArray[0].lift = 0
        MyFeedRecyclerViewHolder.dataArray[0].swimmingPool = 0
        MyFeedRecyclerViewHolder.dataArray[0].fitness = 0
        MyFeedRecyclerViewHolder.dataArray[0].suana = 0
        MyFeedRecyclerViewHolder.dataArray[0].jacuzzi = 0
        MyFeedRecyclerViewHolder.dataArray[0].steam = 0
        MyFeedRecyclerViewHolder.dataArray[0].library = 0
        MyFeedRecyclerViewHolder.dataArray[0].garden = 0
        MyFeedRecyclerViewHolder.dataArray[0].units = 0
        MyFeedRecyclerViewHolder.dataArray[0].kidplay = 0
        MyFeedRecyclerViewHolder.dataArray[0].parklot = 0
        MyFeedRecyclerViewHolder.dataArray[0].automateParklot = 0
        MyFeedRecyclerViewHolder.dataArray[0].golfCourse = 0
        MyFeedRecyclerViewHolder.dataArray[0].movieRoom = 0
        MyFeedRecyclerViewHolder.dataArray[0].shop = 0
        MyFeedRecyclerViewHolder.dataArray[0].camFee = 0.0F

        MyFeedRecyclerViewHolder.dataArray[0].floor = ""
        MyFeedRecyclerViewHolder.dataArray[0].areaRoom = 0.0F
        MyFeedRecyclerViewHolder.dataArray[0].pricebyGov = 0
        MyFeedRecyclerViewHolder.dataArray[0].fireInsurance = 0
        MyFeedRecyclerViewHolder.dataArray[0].roomType = 0
        MyFeedRecyclerViewHolder.dataArray[0].roomPosition = 0
        MyFeedRecyclerViewHolder.dataArray[0].roomView = 0
        MyFeedRecyclerViewHolder.dataArray[0].materialDesign = 0
        MyFeedRecyclerViewHolder.dataArray[0].maintananceCondition = 0
    }

    var mDataArray = arrayListOf<ProjectRow>()

    fun feed() {

        val api = RetrofitClient.data_create()
        val call = api.getLProject(staffID)
        call.enqueue(object : Callback<ProjectClass> {

            override fun onFailure(call: Call<ProjectClass>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed To connect", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(call: Call<ProjectClass>, response: Response<ProjectClass>) {

                mDataArray.clear()
                mDataArray.addAll(response.body()!!.rows!!)

                condoList = mDataArray
                latestReportNo = mDataArray[0].projectName.toString()
//                mRecyclerView.adapter?.notifyDataSetChanged()
//                mRefreshView.isRefreshing = false
            }

        })

    }

}
