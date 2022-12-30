package com.lambda.shoppinglist.ui


import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lambda.shoppinglist.R
import com.lambda.shoppinglist.model.ShoppingItem
import kotlinx.android.synthetic.main.shopping_item_layout.view.*
import java.util.ArrayList

class ShoppingListAdapter (private val dataList: List<ShoppingItem>) :
    RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return dataList.size
    }
    private var context : Context? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image  = view.item_image as ImageView
        val name  = view.item_name as TextView
        val card = view.card_view as CardView
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        context = viewGroup.context
        val view= LayoutInflater.from(context).inflate(R.layout.shopping_item_layout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        val data = dataList[i]
        val formattedName = data.name.replace("_"," ").replace("[^A-Za-z]","")

        viewHolder.image.setImageDrawable(context?.getDrawable(data.drawableId))
        viewholder.name.text = formattedName
        viewHolder.card.tag = data.selected

        if(data.selected){
            viewHolder.card.setCardBackgroundColor(ContextCompat.getColor(viewHolder.card.context,R.color.colorAccent))
        }else{
            viewHolder.card.setCardBackgroundColor(ContextCompat.getColor(viewHolder.card.context,R.color.cardview_light_background))
        }

        viewHolder.card.setOnClickListener { view->
            if (view.tag as Boolean) {
                view.tag = false
                data.selected = false
                viewHolder.card.setCardBackgroundColor(ContextCompat.getColor(viewHolder.card.context,
                    R.color.cardview_light_background))
            }else{
                view.tag=true
                data.selected=true
                viewHolder.card.setCardBackgroundColor(ContextCompat.getColor((viewHolder.card.context,R.color.colorAccent)))

    }
    }
    }
}


