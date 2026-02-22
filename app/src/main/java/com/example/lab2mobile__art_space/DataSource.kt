package com.example.lab2mobile__art_space

object DataSource {
    val artworks = listOf(
        Artwork(
            titleResourceId = R.string.artwork_1_title,
            artistResourceId = R.string.artwork_1_artist,
            year = R.string.artwork_1_year,
            imageResId = R.drawable.artwork_1_morning_pine
        ),
        Artwork(
            titleResourceId = R.string.artwork_2_title,
            artistResourceId = R.string.artwork_2_artist,
            year = R.string.artwork_2_year,
            imageResId = R.drawable.artwork_2_mona_lisa
        ),
        Artwork(
            titleResourceId = R.string.artwork_3_title,
            artistResourceId = R.string.artwork_3_artist,
            year = R.string.artwork_3_year,
            imageResId = R.drawable.artwork_3_sunflowers
        ),
        Artwork(
            titleResourceId = R.string.artwork_4_title,
            artistResourceId = R.string.artwork_4_artist,
            year = R.string.artwork_4_year,
            imageResId = R.drawable.artwork_4_sistine_madonna
        )
    )
}