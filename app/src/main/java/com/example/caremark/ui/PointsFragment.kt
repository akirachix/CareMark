package com.example.caremark.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caremark.R
import com.example.caremark.ViewModel.BlisterImagesViewModel
import com.example.caremark.ViewModel.MedicationViewModel
import com.example.caremark.databinding.FragmentHomeBinding
import com.example.caremark.databinding.FragmentPointsBinding
import com.example.caremark.databinding.FragmentTrackBinding
import com.example.caremark.models.BlisterImage
import com.example.caremark.models.Medication

class PointsFragment: Fragment () {
//
//    private lateinit var binding: FragmentPointsBinding
//    val blisterImangeViewModel: BlisterImagesViewModel by activityViewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        binding = FragmentPointsBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    private fun countPictures(blisterImages:List<BlisterImage>):Int{
//
//        var numberOfPictures=blisterImages.count()
//        numberOfPictures=0
//
//         while (0<numberOfPictures){
//             numberOfPictures * 100
//             numberOfPictures++
//
//
//        }
//        return numberOfPictures
//
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        blisterImangeViewModel.BlisterImagesLiveData.observe(viewLifecycleOwner, Observer { numberOfPictures->countPictures(numberOfPictures)
//
//
//        })
//
//    }
}
