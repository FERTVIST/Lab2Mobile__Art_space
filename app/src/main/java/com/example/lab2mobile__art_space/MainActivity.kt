package com.example.lab2mobile__art_space

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var imageViewArtwork: ImageView
    private lateinit var textViewTitle: TextView
    private lateinit var textViewArtist: TextView
    private lateinit var textViewYear: TextView
    private lateinit var buttonPrevious: Button
    private lateinit var buttonNext: Button

    private var currentIndex = 0
    private val artworks = DataSource.artworks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupClickListeners()

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt("CURRENT_INDEX", 0)
        }

        updateArtwork()
    }

    private fun initViews() {
        imageViewArtwork = findViewById(R.id.imageViewArtwork)
        textViewTitle = findViewById(R.id.textViewTitle)
        textViewArtist = findViewById(R.id.textViewArtist)
        textViewYear = findViewById(R.id.textViewYear)
        buttonPrevious = findViewById(R.id.buttonPrevious)
        buttonNext = findViewById(R.id.buttonNext)
    }

    private fun setupClickListeners() {
        buttonPrevious.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateArtwork()
            }
        }

        buttonNext.setOnClickListener {
            if (currentIndex < artworks.size - 1) {
                currentIndex++
                updateArtwork()
            }
        }
    }

    private fun updateArtwork() {
        val artwork = artworks[currentIndex]

        imageViewArtwork.setImageResource(artwork.imageResId)
        textViewTitle.text = getString(artwork.titleResourceId)
        textViewArtist.text = getString(artwork.artistResourceId)
        textViewYear.text = getString(artwork.year)

        imageViewArtwork.contentDescription = getString(artwork.titleResourceId)

        updateButtonsState()
    }

    private fun updateButtonsState() {
        buttonPrevious.isEnabled = currentIndex > 0
        buttonNext.isEnabled = currentIndex < artworks.size - 1

        val disabledColor = ContextCompat.getColorStateList(this, R.color.button_background_disabled)
        val enabledColor = ContextCompat.getColorStateList(this, R.color.button_background)

        buttonPrevious.backgroundTintList = if (buttonPrevious.isEnabled) enabledColor else disabledColor
        buttonNext.backgroundTintList = if (buttonNext.isEnabled) enabledColor else disabledColor
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("CURRENT_INDEX", currentIndex)
    }
}