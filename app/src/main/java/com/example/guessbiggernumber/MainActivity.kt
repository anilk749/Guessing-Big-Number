package com.example.guessbiggernumber

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.guessbiggernumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var leftBtn:Button
    private lateinit var rightBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        leftBtn = binding.leftBtn
        rightBtn = binding.rightBtn
        leftBtn.setOnClickListener{
            checkAnswer(true)
        }
        rightBtn.setOnClickListener{
            checkAnswer(false)
        }
    }
    private fun checkAnswer(isLeftButtonClicked:Boolean){
            // when right button is clicked compare left and right button numbers
            val leftNum = leftBtn.text.toString().toInt()
            val rightNum = rightBtn.text.toString().toInt()
            val isAnsCorrect:Boolean = if(isLeftButtonClicked) leftNum > rightNum else leftNum < rightNum
            if(isAnsCorrect){
                //change the background color to green as answer is correct
                binding.backgroundView.setBackgroundColor(Color.GREEN)
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
            }else {
                //change the background color to red as answer is incorrect
                binding.backgroundView.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }
            // get random numbers for left and right boxes
            getRandomNumbers()
        }
    private fun getRandomNumbers(){
        val leftNum = (0..100).random()
        var rightNum = leftNum
        while (rightNum == leftNum){
            rightNum = (0..100).random()
        }
        leftBtn.text = leftNum.toString()
        rightBtn.text = rightNum.toString()
    }
}