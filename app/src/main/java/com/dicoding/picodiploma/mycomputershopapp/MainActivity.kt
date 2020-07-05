package com.dicoding.picodiploma.mycomputershopapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvItems: RecyclerView
    private var list: ArrayList<Items> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Amazing Electornics")

        rvItems = findViewById(R.id.id_rvitems)
        rvItems.setHasFixedSize(true)

        list.addAll(ItemsData.listData)
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_user_details, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_user_details -> {
                val moveToAbout = Intent(this@MainActivity, AboutActivity::class.java)
                moveToAbout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(moveToAbout)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        rvItems.layoutManager = LinearLayoutManager(this)
        val listItemsAdapter = ListItemsAdapter(list)
        rvItems.adapter = listItemsAdapter

        listItemsAdapter.setOnItemClickCallback(object : ListItemsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Items) {
                showSelectedItems(data)
            }
        })

    }

    private fun showSelectedItems(item: Items) {
        val moveWithDataItem = Intent(this@MainActivity, ItemDetailActivity::class.java)
        moveWithDataItem.putExtra(ItemDetailActivity.EXTRA_NAME, item.itemName)
        moveWithDataItem.putExtra(ItemDetailActivity.EXTRA_DETAIL, item.itemDetail)
        moveWithDataItem.putExtra(ItemDetailActivity.EXTRA_PRICE, item.itemPrice)
        moveWithDataItem.putExtra(ItemDetailActivity.EXTRA_IMG, item.itemPhoto)
        startActivity(moveWithDataItem)

    }


}