package com.example.caremark.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.caremark.R
import com.example.caremark.models.Medication

class HomeMedicationAdapter( var medsList:List<Medication>):
    RecyclerView.Adapter<HomeMedicationAdapter.MedicationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
        val itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.list_meds_item, parent,false)
        return MedicationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeMedicationAdapter.MedicationViewHolder, position: Int) {
        val currentItem = medsList[position]
        holder.medicationName.text=currentItem.medicationName
        holder.doses.text= currentItem.doses.toString()
        holder.time.text=currentItem.time.toString()
    }



    override fun getItemCount(): Int {
        return medsList.size
    }

    class MedicationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val medicationName: TextView =itemView.findViewById(R.id.tvName)
        val doses: TextView =itemView.findViewById(R.id.tvDose)
        val time: TextView =itemView.findViewById(R.id.tvHour)
    }



}