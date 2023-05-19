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
            iv5.setOnClickListener {
                star = 5
                clickStar(star)
            }

            iv4.setOnClickListener {
                star = 4
                clickStar(star)
            }

            iv3.setOnClickListener {
                star = 3
                clickStar(star)
            }

            iv2.setOnClickListener {
                star = 2
                clickStar(star)
            }

            iv1.setOnClickListener {
                star = 1
                clickStar(star)
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

    fun clickStar(jmlh:Int){
        binding.apply {
            for (i in 1..5){
                when (i){
                    1 -> iv1.setImageResource(R.drawable.baseline_star_border_24_yellow)
                    2 -> iv2.setImageResource(R.drawable.baseline_star_border_24_yellow)
                    3 -> iv3.setImageResource(R.drawable.baseline_star_border_24_yellow)
                    4 -> iv4.setImageResource(R.drawable.baseline_star_border_24_yellow)
                    5 -> iv5.setImageResource(R.drawable.baseline_star_border_24_yellow)
                }
            }
            for (i in 1..jmlh){
                when (i){
                    1 -> iv1.setImageResource(R.drawable.baseline_star_24_yellow)
                    2 -> iv2.setImageResource(R.drawable.baseline_star_24_yellow)
                    3 -> iv3.setImageResource(R.drawable.baseline_star_24_yellow)
                    4 -> iv4.setImageResource(R.drawable.baseline_star_24_yellow)
                    5 -> iv5.setImageResource(R.drawable.baseline_star_24_yellow)
                }
            }

            btnSubmit.isVisible = true
        }

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RatingFragment()
    }
}