package com.example.get_giphy_retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DataAdapter(val context: Context,val giflist:List<DataObject>) :
    RecyclerView.Adapter<DataAdapter.DataHolder>() {

    class DataHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        val images=itemview.findViewById<ImageView>(R.id.image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {

        val view:View=LayoutInflater.from(context).inflate(R.layout.data_layout,parent,false)
        return DataHolder(view)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
       val data=giflist[position]
        Glide.with(context).load(data.images.ogImage.url).into(holder.images)
    }

    override fun getItemCount()=giflist.size
}