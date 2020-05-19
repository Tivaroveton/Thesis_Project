package com.codemobiles.project_eva

import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pixplicity.easyprefs.library.Prefs
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()

        loadLastLoggedInUsernamePassword()

    }

    private fun loadLastLoggedInUsernamePassword() {

        val isLoggedIn = Prefs.getBoolean(Constants.IS_LOGGED_IN, false)
        if (isLoggedIn) {
            val _username = Prefs.getString(Constants.USERNAME, "")
            val _password = Prefs.getString(Constants.PASSWORD, "")

            usernameEditText.setText(_username)
            passwordEditText.setText(_password)

        }
    }

    fun onClickLogin(view: View) {

        loginCheck()
//        val i = Intent(this@MainActivity, FeedActivity::class.java)
//        i.putExtra("staffID", staffID)
//        startActivity(i)
    }

    val mDataArray = arrayListOf<Row>()

    companion object {
        var staffID: String = ""
    }

    fun loginCheck() {

        val username = usernameEditText.text.toString()

        val password = passwordEditText.text.toString()
        val _username = Prefs.getString(Constants.USERNAME, "")
        val _password = Prefs.getString(Constants.PASSWORD, "")
        val userBean = UserBean(_username, _password)


        val api = RetrofitClient.login_create()
        val call = api.getLogin(username, password)
        call.enqueue(object : Callback<LoginClass> {

            override fun onFailure(call: Call<LoginClass>, t: Throwable) {
                Toast.makeText(applicationContext, t.toString(), Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(call: Call<LoginClass>, response: Response<LoginClass>) {

                mDataArray.clear()
                response.body()?.rows?.let { mDataArray.addAll(it) }

                if (mDataArray[0].staffID == "2") {
                    Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT)
                        .show()

                    Prefs.putString(Constants.USERNAME, username)
                    Prefs.putString(Constants.PASSWORD, password)
                    Prefs.putBoolean(Constants.IS_LOGGED_IN, true)
                    val i = Intent(this@MainActivity, FeedActivity::class.java)
                    staffID = mDataArray[0].staffID
                    i.putExtra(Constants.USER_BEAN, userBean)
                    i.putExtra("staffID", staffID)
                    startActivity(i)

                } else {
                    Toast.makeText(applicationContext, "Wrong Staff Type", Toast.LENGTH_SHORT)
                        .show()
                }

            }


        })


    }

}
