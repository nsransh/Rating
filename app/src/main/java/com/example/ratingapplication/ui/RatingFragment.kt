package com.example.ratingapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.ratingapplication.R
import com.example.ratingapplication.databinding.FragmentRatingBinding

class RatingFragment : Fragment() {
    private lateinit var binding: FragmentRatingBinding
    private var star = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRatingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnSubmit.isVisible = false
            ivFive.setOnClickListener {
                ivOne.setImageResource(R.drawable.baseline_star_24_yellow)
                ivTwo.setImageResource(R.drawable.baseline_star_24_yellow)
                ivThree.setImageResource(R.drawable.baseline_star_24_yellow)
                ivFour.setImageResource(R.drawable.baseline_star_24_yellow)
                ivFive.setImageResource(R.drawable.baseline_star_24_yellow)
                star = 5
                btnSubmit.isVisible = true
            }

            ivFour.setOnClickListener {
                ivOne.setImageResource(R.drawable.baseline_star_24_yellow)
                ivTwo.setImageResource(R.drawable.baseline_star_24_yellow)
                ivThree.setImageResource(R.drawable.baseline_star_24_yellow)
                ivFour.setImageResource(R.drawable.baseline_star_24_yellow)
                ivFive.setImageResource(R.drawable.baseline_star_border_24_yellow)
                star = 4
                btnSubmit.isVisible = true
            }

            ivThree.setOnClickListener {
                ivOne.setImageResource(R.drawable.baseline_star_24_yellow)
                ivTwo.setImageResource(R.drawable.baseline_star_24_yellow)
                ivThree.setImageResource(R.drawable.baseline_star_24_yellow)
                ivFour.setImageResource(R.drawable.baseline_star_border_24_yellow)
                ivFive.setImageResource(R.drawable.baseline_star_border_24_yellow)
                star = 3
                btnSubmit.isVisible = true
            }

            ivTwo.setOnClickListener {
                ivOne.setImageResource(R.drawable.baseline_star_24_yellow)
                ivTwo.setImageResource(R.drawable.baseline_star_24_yellow)
                ivThree.setImageResource(R.drawable.baseline_star_border_24_yellow)
                ivFour.setImageResource(R.drawable.baseline_star_border_24_yellow)
                ivFive.setImageResource(R.drawable.baseline_star_border_24_yellow)
                star = 2
                btnSubmit.isVisible = true
            }

            ivOne.setOnClickListener {
                ivOne.setImageResource(R.drawable.baseline_star_24_yellow)
                ivTwo.setImageResource(R.drawable.baseline_star_border_24_yellow)
                ivThree.setImageResource(R.drawable.baseline_star_border_24_yellow)
                ivFour.setImageResource(R.drawable.baseline_star_border_24_yellow)
                ivFive.setImageResource(R.drawable.baseline_star_border_24_yellow)
                star = 1
                btnSubmit.isVisible = true
            }

            btnSubmit.setOnClickListener {
                if (swTips.isChecked){
                    Toast.makeText(requireContext(),"$star Star with Tips",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(requireContext(),"$star Star and no Tips",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RatingFragment()
    }
}