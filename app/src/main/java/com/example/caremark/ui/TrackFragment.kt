package com.example.caremark.ui

import android.R
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.caremark.ViewModel.BlisterImagesViewModel
import com.example.caremark.ViewModel.MedicationViewModel
import com.example.caremark.databinding.FragmentTrackBinding
import com.example.caremark.models.BlisterImage
import com.example.caremark.models.Medication
import com.github.mikephil.charting.charts.PieChart
import com.github.sundeepk.compactcalendarview.domain.Event
import java.text.SimpleDateFormat
import java.util.*


class TrackFragment: Fragment (){
    private lateinit var binding :FragmentTrackBinding
    // on below line we are creating
    // variables for our pie chart
    lateinit var pieChart: PieChart
    lateinit var dateTV: TextView
//    lateinit var calendarView: CalendarView
    val blisterImagesViewModel: BlisterImagesViewModel by activityViewModels()
    val medicationViewModel:MedicationViewModel by activityViewModels()

    @RequiresApi(Build.VERSION_CODES.N_MR1)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentTrackBinding.inflate(inflater,container,false)

        return binding.root
    }

//    fun setMedicationPeriod(dateRange:Medication){
//        var start=dateRange.startDate
//        val formatter= SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH)
//        val date = formatter.parse(start)!!
//        val cal = Calendar.getInstance()
//        cal.time = date
//        val starting = cal.timeInMillis
//
//
//        var end=dateRange.endDate
//        val format= SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH)
//        val datee = formatter.parse(end)!!
//        val call = Calendar.getInstance()
//        cal.time = datee
//        val ending = cal.timeInMillis
//
////
//
//    }


    private fun trackVerifications(blisterImages: List<BlisterImage>){

        var dates=blisterImages.forEach { image ->
            val formatter= SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH)
            val date = formatter.parse(image.blisterImageDate)!!

            val cal = Calendar.getInstance()
            cal.time = date
            val millis = cal.timeInMillis
            val allDates= listOf(millis)
            for (millis in allDates){
            val trackColor = Event(Color.GREEN,  millis)
                binding.calendarView.addEvent(trackColor)

        Log.d("BlisterImage","${millis}")}}
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // on below line we are initializing our
        // variable with their ids.

        dateTV = binding.idTVDate
        var calendarView=binding.calendarView
//        calendarView = binding.calendarView

        var x= blisterImagesViewModel.getAllBlisterImages()
        trackVerifications(x.value?: listOf(BlisterImage(0,"","2022-11-03")))

        // get the reference of CalendarView



        // on below line we are adding set on
        // date change listener for calendar view.
//        calendarView
//            .setOnDateChangeListener(
//                CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
//                    // In this Listener we are getting values
//                    // such as year, month and day of month
//                    // on below line we are creating a variable
//                    // in which we are adding all the variables in it.
//                    val Date = (dayOfMonth.toString() + "-"
//                            + (month + 1) + "-" + year)
//
//                    // set this date in TextView for Display
//                    dateTV.setText(Date)
//
//                })




        // on below line we are setting user percent value,
        // setting description as enabled and offset for pie chart
//        pieChart.setUsePercentValues(true)
//        pieChart.getDescription().setEnabled(false)
//        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)

        // on below line we are setting drag for our pie chart
//        pieChart.setDragDecelerationFrictionCoef(0.95f)

        // on below line we are setting hole
        // and hole color for pie chart
//        pieChart.setDrawHoleEnabled(false)
//        pieChart.setHoleColor(Color.WHITE)

        // on below line we are setting circle color and alpha
//        pieChart.setTransparentCircleColor(Color.WHITE)
//        pieChart.setTransparentCircleAlpha(110)

        // on below line we are setting hole radius
//        pieChart.setHoleRadius(58f)
//        pieChart.setTransparentCircleRadius(61f)

        // on below line we are setting center text
//        pieChart.setDrawCenterText(true)

        // on below line we are setting
        // rotation for our pie chart
//        pieChart.setRotationAngle(0f)

        // enable rotation of the pieChart by touch
//        pieChart.setRotationEnabled(true)
//        pieChart.setHighlightPerTapEnabled(true)

        // on below line we are setting animation for our pie chart
//        pieChart.animateY(1400, Easing.EaseInOutQuad)

        // on below line we are disabling our legend for pie chart
//        pieChart.legend.isEnabled = false
//        pieChart.setEntryLabelColor(Color.WHITE)
//        pieChart.setEntryLabelTextSize(12f)

        // on below line we are creating array list and
        // adding data to it to display in pie chart
//        val entries: ArrayList<PieEntry> = ArrayList()
//        entries.add(PieEntry(70f))
//        entries.add(PieEntry(20f))
//        entries.add(PieEntry(10f))

        // on below line we are setting pie data set
//        val dataSet = PieDataSet(entries, "Mobile OS")

        // on below line we are setting icons.
//        dataSet.setDrawIcons(false)

        // on below line we are setting slice for pie
//        dataSet.sliceSpace = 3f
//        dataSet.iconsOffset = MPPointF(0f, 40f)
//        dataSet.selectionShift = 5f

        // add a lot of colors to list
//        val colors: ArrayList<Int> = ArrayList()
//        colors.add(resources.getColor(R.color.purple_200))
//        colors.add(resources.getColor(R.color.yellow))
//        colors.add(resources.getColor(R.color.red))

        // on below line we are setting colors.
//        dataSet.colors = colors

        // on below line we are setting pie data set
//        val data = PieData(dataSet)
//        data.setValueFormatter(PercentFormatter())
//        data.setValueTextSize(15f)
//        data.setValueTypeface(Typeface.DEFAULT_BOLD)
//        data.setValueTextColor(Color.WHITE)
//        pieChart.setData(data)

        // undo all highlights
//        pieChart.highlightValues(null)

        // loading chart
//        pieChart.invalidate()



    }
}

