package com.java90.simplemoviesapp.domain.utils


enum class MoviesGenre(var value: Int) {
    ACTION(28),
    SCIENCE_FICTION(878),
    ROMANCE(10749);

    fun getNumber() : Int {
        return value
    }
}

enum class SeriesGenre(var value: Int) {
    COMEDY(35),
    KIDS(10762),
    DRAMA(18);

    fun getNumber() : Int {
        return value
    }
}