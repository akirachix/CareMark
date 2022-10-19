package com.example.caremark.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.caremark.R
import com.example.caremark.models.Medication

class MedicationAdapter(private val medsList:ArrayList<Medication>):
    RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.fragment_meds, parent,false)
        return MedicationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MedicationViewHolder, position: Int) {
        val currentItem = medsList[position]
        holder.medicationName.text=currentItem.medicationName
        holder.doses.text= currentItem.doses.toString()
        holder.time.text=currentItem.time
    }

    override fun getItemCount(): Int {
        return medsList.size
    }

    class MedicationViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
     val medicationName:TextView=itemView.findViewById(R.id.tvCardMed)
        val doses:TextView=itemView.findViewById(R.id.tvCardDoses)
        val time:TextView=itemView.findViewById(R.id.tvCardTime)
    }


}