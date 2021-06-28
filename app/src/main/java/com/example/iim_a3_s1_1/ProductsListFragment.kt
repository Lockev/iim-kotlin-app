package com.example.iim_a3_s1_1

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list.*
import kotlinx.android.synthetic.main.list_item.view.*

class ProductsListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Créer 15 items
        var products = Array(15) { generateFakeProduct() }

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        recyclerView.adapter = ListAdapter(products, requireContext())
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

        holder.line1.text = item.name
        holder.line2.text = item.brand

        val r: Resources = context.resources

        val nutriscoreDrawableId: Int = r.getIdentifier(imgURL, "mipmap", "com.example.iim_a3_s1_1")
        holder.nutriscore.setImageDrawable(ContextCompat.getDrawable(context, nutriscoreDrawableId))

        val thumbnailDrawableId: Int = r.getIdentifier("placeholder", "drawable", "com.example.iim_a3_s1_1")
        holder.thumbnail.setImageDrawable(ContextCompat.getDrawable(context, thumbnailDrawableId))
    }
}


class ListCell(v: View) : RecyclerView.ViewHolder(v) {

    val line1: TextView = v.cell_line1
    val line2: TextView = v.cell_line2
    val nutriscore : ImageView = v.nutriscore
    val thumbnail : ImageView = v.thumbnail
}