package com.example.randompicker

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val list = intent.getStringArrayListExtra("list")

        randombtn.setOnClickListener{
            if (!list.isNullOrEmpty()){
                val randomItem = list.random()
                TV.setText(randomItem)
            }else{
                Toast.makeText(this,"List can't be empty, please add items", Toast.LENGTH_SHORT).show()
            }
        }

        val intent = Intent(this@MainActivity, ListActivity::class.java).apply {
            putExtra("list1",list)
        }
        listBtn.setOnClickListener{ startActivity(intent) }

    }


    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}