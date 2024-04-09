package com.example.thehistoryapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.EditText
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btnSearch = findViewById<Button>(R.id.button2)
        var btnClear = findViewById<Button>(R.id.button1)
        var searchField = findViewById<EditText>(R.id.editText)
        val resultViewText = findViewById<TextView>(R.id.textView2)
        var historicalArr = arrayListOf<Figures>(
            Figures(95,"Nelson Mandela","Statesman/Anti-Apartheid Activist"),
            Figures(27,"Jon-Michel Basquiat","Neo-expressionism style artist"),
            Figures(75,"Oliver Reginald Tambo","Anti-Apartheid activist"),
            Figures(70,"Niki Lauda","Austrian racing driver/aviation entrepreneur"),
            Figures(39,"Martin Luther King.JR","Baptist and social activist"),
            Figures(91,"Muhammad Ali","American Boxer and activist"),
            Figures(41,"Shaka Zulu","19th Century Zulu king"),
            Figures(79,"Jim Rohn","Entrepreneur and Author"),
            Figures(67,"George Duke","American Jazz musician"),
            Figures(77,"Al Jarreau","American singer/songwriter")

        )


        btnClear.setOnClickListener {
            searchField.text.clear()
            resultViewText.text = " "

        }
        btnSearch.setOnClickListener {
            val searchedText = searchField.text.toString()

            if (searchedText.isBlank()) {
                resultViewText.text = "The Field cannot be Empty"

            } else if (searchedText.toInt() < 20 || searchedText.toInt() > 100) {
                resultViewText.text = "the age cannot be less than 20 or greater than 100"
            } else {
                for (i in historicalArr) {


                    if (i.age == searchedText.toInt()) {
                        resultViewText.text = "The matching historical Figure is ${i.name} ${i.fact} "
                        break
                    } else if (searchedText.toInt() != i.age) {
                        resultViewText.text =
                            "There's no historical figure matching the age $searchedText"
                        searchField.text.clear()

                    }
                }
            }
        }
    }
}
class Figures(val age:Int,val name:String,val fact:String){







}

