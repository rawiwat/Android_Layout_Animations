package com.lambda.shoppinglist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lambda.shoppinglist.utils.NotificationGenerator
import com.lambda.shoppinglist.R
import com.lambda.shoppinglist.utils.ShoppingItemConstants
import com.lambda.shoppinglist.model.ShoppingItem
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        list.layoutManager = layoutManager
        list.adapter = ItemListAdapter (ShoppingItemConstants.generateItems())
    }
}
