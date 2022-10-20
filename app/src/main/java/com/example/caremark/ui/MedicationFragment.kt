package com.example.caremark.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.caremark.R
import com.example.caremark.ViewModel.MedicationViewModel
import com.example.caremark.databinding.FragmentMedicationBinding
import com.example.caremark.models.Medication
class MedicationFragment: Fragment (){

//    lateinit var adapter: MedicationAdapter
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var medsArrayList: List<Medication>
    lateinit var binding: FragmentMedicationBinding
    val medsViewModel: MedicationViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentMedicationBinding.inflate(inflater,container,false)
        medsViewModel.getAllMedication()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        medsViewModel.MedicationsLiveData.observe(viewLifecycleOwner, Observer { meds->
            displayMeds(meds)

        })

    }

    fun displayMeds(medications: List<Medication>){
        var medsAdapter=MedicationAdapter(medications)
        binding.rvMeds.layoutManager= LinearLayoutManager(context)
        binding.rvMeds.adapter=medsAdapter
    }
}


