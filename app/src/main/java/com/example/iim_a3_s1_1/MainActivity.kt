package com.example.iim_a3_s1_1

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.g123k.ilv.Product
import com.g123k.ilv.generateFakeProduct
import kotlinx.android.synthetic.main.list.*
import kotlinx.android.synthetic.main.list_item.view.*

/*class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_main)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ic_nav_bar_gradient))

        Log.v("verbose", "Hello World")
        Toast.makeText(getApplicationContext(), "Hello Word", Toast.LENGTH_LONG).show()
    }
}*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.list)

        // Créer 15 items
        var products = Array(15) { generateFakeProduct() }

        // recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.adapter = ListAdapter(products, this)
    }
}

class ListAdapter(val data: Array<Product>, val context: Context) : RecyclerView.Adapter<ListCell>() {

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCell {
        return ListCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListCell, position: Int) {
        val item = data[position]

        val imgURL = "nutri_score_" + item.nutriscore.label.lowercase()
        println(imgURL)

        holder.line1.text = item.name
        holder.line2.text = item.thumbnail

        val r: Resources = context.resources
        val drawableId: Int = r.getIdentifier(imgURL, "mipmap", "com.example.iim_a3_s1_1")

        holder.nutriscore.setImageDrawable(ContextCompat.getDrawable(context, drawableId))
    }
}


class ListCell(v: View) : RecyclerView.ViewHolder(v) {

    val line1: TextView = v.cell_line1
    val line2: TextView = v.cell_line2
    val nutriscore : ImageView = v.nutriscore
}

