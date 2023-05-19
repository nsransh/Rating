package com.example.ratingapplication.ui

import android.os.Bundle
import android.util.Log
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

            swTips.setOnClickListener {
                swTips.setTextColor(resources.getColor(R.color.pinkpaw))
            }

            btnSubmit.setOnClickListener {
                if (swTips.isChecked){
                    Toast.makeText(requireContext(),"$star Rate with Tips",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(requireContext(),"$star Rate and No Tips",Toast.LENGTH_LONG).show()
                }
                resetRating()
                reset()
            }
        }
    }

    fun clickStar(jmlh:Int){
        binding.apply {
            tvRating.setTextColor(resources.getColor(R.color.pinkpaw))
            resetRating()
            for (i in 1..jmlh){
                when (i){
                    1 -> iv1.setImageResource(R.drawable.pawprint)
                    2 -> iv2.setImageResource(R.drawable.pawprint)
                    3 -> iv3.setImageResource(R.drawable.pawprint)
                    4 -> iv4.setImageResource(R.drawable.pawprint)
                    5 -> iv5.setImageResource(R.drawable.pawprint)
                }
            }
            if (jmlh<5){
                Log.e("jmlh", "$jmlh")
                for (i in jmlh+1..5){
                    when(i){
                        1 -> iv1.setColorFilter(resources.getColor(R.color.pinkpaw))
                        2 -> iv2.setColorFilter(resources.getColor(R.color.pinkpaw))
                        3 -> iv3.setColorFilter(resources.getColor(R.color.pinkpaw))
                        4 -> iv4.setColorFilter(resources.getColor(R.color.pinkpaw))
                        5 -> iv5.setColorFilter(resources.getColor(R.color.pinkpaw))
                    }
                }
            }
            btnSubmit.isVisible = true
        }

    }

    fun resetRating(){
        binding.apply {
            iv1.setImageResource(R.drawable.pawprint1)
            iv2.setImageResource(R.drawable.pawprint1)
            iv3.setImageResource(R.drawable.pawprint1)
            iv4.setImageResource(R.drawable.pawprint1)
            iv5.setImageResource(R.drawable.pawprint1)
            iv1.setColorFilter(null)
            iv2.setColorFilter(null)
            iv3.setColorFilter(null)
            iv4.setColorFilter(null)
            iv5.setColorFilter(null)
        }


    }

    fun reset(){
        binding.apply {
            tvRating.setTextColor(resources.getColor(R.color.black))
            swTips.isChecked = false
            swTips.setTextColor(resources.getColor(R.color.black))
            btnSubmit.isVisible = false
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RatingFragment()
    }
}