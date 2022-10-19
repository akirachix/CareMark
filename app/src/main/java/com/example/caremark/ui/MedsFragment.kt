package com.example.caremark.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
//import androidx.activity.viewModels
import com.example.caremark.Database.CareMarkDb
import com.example.caremark.R
import com.example.caremark.ViewModel.MedicationViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"





/**
 * A simple [Fragment] subclass.
 * Use the [MedsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MedsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

//    val contactsViewModel:MedicationViewModel by viewModels

//    private lateinit var adapter: MedicationAdapter
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var medsArrayList: ArrayList<Medication>

//    private val medsDatabase by lazy { CareMarkDb.getDatabase(this
//    ).MedicationDAO() }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meds, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }




}