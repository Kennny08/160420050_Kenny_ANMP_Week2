package com.kenny.adv160420050week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {

    var score = 0;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtAnswer = view.findViewById<EditText>(R.id.txtAnswer)
        val txtQuestion = view.findViewById<TextView>(R.id.txtQuestion)
        val txtTurn = view.findViewById<TextView>(R.id.txtTurn)

        arguments?.let {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }

        var firstNumber = (0..100).shuffled().first()
        var secondNumber = (0..100).shuffled().last()
        txtQuestion.text = firstNumber.toString() + " + " + secondNumber.toString()
        var resultQuestion = (firstNumber + secondNumber).toString()

        val btnSubmitAnswer = view.findViewById<Button>(R.id.btnSubmitAnswer)
        btnSubmitAnswer.setOnClickListener{
            var playerAnswer = txtAnswer.text.toString()

            if (resultQuestion == playerAnswer){
                score+=1
                firstNumber = (0..100).shuffled().first()
                secondNumber = (0..100).shuffled().last()
                txtQuestion.text = firstNumber.toString() + " + " + secondNumber.toString()
                resultQuestion = (firstNumber + secondNumber).toString()
                txtAnswer.setText("")
            }else{
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}