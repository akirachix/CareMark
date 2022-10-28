package com.example.caremark.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.caremark.R
import com.example.caremark.models.Medication

class MedicationAdapter( var medsList:List<Medication>):
    RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.list_meds_item, parent,false)
        return MedicationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MedicationViewHolder, position: Int) {
        val currentItem = medsList[position]
        holder.medicationName.text=currentItem.medicationName

        holder.time.text=currentItem.time.toString()
    }

    override fun getItemCount(): Int {
        return medsList.size
    }

    class MedicationViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val medicationName:TextView=itemView.findViewById(R.id.tvName)

        val time:TextView=itemView.findViewById(R.id.tvHour)
    }


}