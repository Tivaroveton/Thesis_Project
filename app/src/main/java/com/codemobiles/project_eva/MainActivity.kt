package com.codemobiles.project_eva

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClickLogin(view: View) {
        val intent = Intent(this, FeedActivity::class.java)
        startActivity(intent)
    }


}
