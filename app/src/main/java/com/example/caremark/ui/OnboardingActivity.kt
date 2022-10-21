package com.example.caremark.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.caremark.OnboardingItem
import com.example.caremark.OnboardingItemsAdapter
import com.example.caremark.R
import com.example.caremark.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var adapter: OnboardingItemsAdapter
    private lateinit var indicatorsContainerLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        indicatorsContainerLayout = binding.indicatorsContainer
        setOnboardingItems()
        setupIndicators()
        setCurrentIndicator(0)
        setViewPagerListener()
        setClickListeners()
    }

    private fun setOnboardingItems() = with(binding) {
        adapter = OnboardingItemsAdapter()
        adapter.setItems(
            listOf(
                OnboardingItem(
                    image = R.drawable.onboardone,
                    title = "Daily Reminder",
                    description = "You will always remember your medicine.\n" +
                            "  You got a caring friend to remind you everyday.\n."
                ),
                OnboardingItem(
                    image = R.drawable.onboardtwo,
                    title = "Track Medication",
                    description = "Verify and keep on track every month.\n" +
                            "  You unlock badges and gifts from family and friends.\n."
                ),
                OnboardingItem(
                    image = R.drawable.onboardthree,
                    title = "Measure Progress",
                    description = "We will always remind your medication.\n" +
                            "  It is now our responsibility to protect our health.\n."

                )
            )
        )
        onboardingViewPager.adapter = adapter
    }

    private fun setClickListeners() = with(binding) {

      tvSkip.setOnClickListener {
//         if (onboardingViewPager.currentItem + 1 < adapter.itemCount) {
//              onboardingViewPager.currentItem += 1
//          } else {
//          }

          navigateToLogin()
      }
    }

    private fun navigateToLogin() {
        startActivity(LoginActivity.getIntent(this@OnboardingActivity))
        finish()
    }

    private fun setViewPagerListener() = with(binding) {
        onboardingViewPager.adapter = adapter
        onboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
    }

    //We will now iterate through the size of the adapter and create multiple inactive background states
    private fun setupIndicators() = with(binding) {
        indicatorsContainerLayout = indicatorsContainer
        val indicators = arrayOfNulls<ImageView>(adapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8, 8, 8, 0)

        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.icon_outer_background
                    )
                )
                it.layoutParams = layoutParams
                indicatorsContainerLayout.addView(it)
            }
        }
    }

    private fun setCurrentIndicator(position: Int) = with(binding) {
        val childCount = indicatorsContainerLayout.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorsContainerLayout.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }
}