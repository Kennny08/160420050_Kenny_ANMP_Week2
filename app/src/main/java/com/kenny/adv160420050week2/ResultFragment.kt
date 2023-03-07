package com.kenny.adv160420050week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*


class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtScore = view.findViewById<TextView>(R.id.txtScore)
        val btnBackToMain = view.findViewById<Button>(R.id.btnBackToMainScreen)
        arguments?.let {
            val playerScore = ResultFragmentArgs.fromBundle(requireArguments()).playerScore
            txtScore.text = "Your score is $playerScore"
        }

        btnBackToMain.setOnClickListener{
            val action = ResultFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}