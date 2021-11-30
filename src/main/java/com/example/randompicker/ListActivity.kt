package com.example.randompicker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.list.*
import java.lang.NullPointerException

class ListActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list)

        val actionBar = supportActionBar
        actionBar!!.title = "List of items"
        actionBar.setDisplayHomeAsUpEnabled(true)


        var itemList = arrayListOf<String?>()

        try {
            itemList = intent.getStringArrayListExtra("list1")!!
        }catch (e:NullPointerException){
            e.printStackTrace()
        }


        val adapter: ArrayAdapter<*>

        val mListView = findViewById<ListView>(R.id.listView)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)
        mListView.adapter = adapter

        addBtn.setOnClickListener {
            val value = inputLine.text.toString()


            if (value.isEmpty()) {
                Toast.makeText(this@ListActivity, "Item cannot be empty", Toast.LENGTH_SHORT).show()
            } else if (value.length > 30) {
                Toast.makeText(this@ListActivity, "Please enter max 30 characters", Toast.LENGTH_SHORT).show()
            } else {
                itemList.add(value)
                inputLine.setText("")
                adapter.notifyDataSetChanged()
            }
      }

        listView.onItemLongClickListener = AdapterView.OnItemLongClickListener { _, _, position, _ ->
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Do you want to remove this element?")

            builder.setPositiveButton("Yes") { dialog, which ->
                itemList.removeAt(position)
                adapter.notifyDataSetChanged()
                Toast.makeText(applicationContext,"Item removed successfully", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("No") { dialog, which -> }

            builder.show()

            true
        }

        val intent = Intent(this,MainActivity::class.java).apply {
            putExtra("list", itemList)

        }
        sendBtn.setOnClickListener { startActivity(intent) }

    }

    override fun onSupportNavigateUp():Boolean {
        onBackPressed()
        return true
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
