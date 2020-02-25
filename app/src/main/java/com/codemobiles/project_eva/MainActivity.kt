package com.codemobiles.project_eva

import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pixplicity.easyprefs.library.Prefs
import kotlinx.android.synthetic.main.activity_main.*


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
            val _username = Prefs.getString(Constants.COLUMN_USERNAME, "")
            val _password = Prefs.getString(Constants.COLUMN_PASSWORD, "")

            usernameEditText.setText(_username)
            passwordEditText.setText(_password)

        }
    }

    fun onClickLogin(view: View) {

        val _username = Prefs.getString(Constants.COLUMN_USERNAME, "")
        val _password = Prefs.getString(Constants.COLUMN_PASSWORD, "")
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (_username == username && _password == password){
            Prefs.putBoolean(Constants.IS_LOGGED_IN, true)
            val i = Intent(this, FeedActivity::class.java)
            val userBean = UserBean(_username, _password, 0)
            i.putExtra(Constants.USER_BEAN, userBean)

            startActivity(i)
        }else{
            Prefs.putBoolean(Constants.IS_LOGGED_IN, false)
            Toast.makeText(this, "Login failed!", Toast.LENGTH_LONG).show()
        }


    }


}
