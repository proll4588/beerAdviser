package com.example.beeradviser

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findBeer = findViewById<Button>(R.id.find_beer)
        findBeer.setOnClickListener {
            val brands = findViewById<TextView>(R.id.brands)
            val beerColor = findViewById<Spinner>(R.id.beer_color)

            val color = beerColor.selectedItem.toString()
            val beers = getBeersByColor(color).toString()
            brands.text = "Beer color is $beers"
        }
    }
}

/**
 * Получение наименование пива по его цвету
 * @param color Цвет пива
 */
fun getBeersByColor(color: String): List<String> {
    return when (color) {
        "Light" -> listOf("Jail Pale Ale")
        "Amber" -> listOf("Jack Amber")
        "Brown" -> listOf("Brown Bear Beer")
        else -> listOf("Gout Stout")
    }
}