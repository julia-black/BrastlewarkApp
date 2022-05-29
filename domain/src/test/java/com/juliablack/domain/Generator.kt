package com.juliablack.domain

import com.juliablack.domain.model.Gender
import com.juliablack.domain.model.Inhabitant

fun generateList() = listOf(
    Inhabitant(
        0,
        "Tobus Quickwhistle",
        "http://www.publicdomainpictures.net/pictures/10000/nahled/thinking-monkey-11282237747K8xB.jpg",
        306,
        39.065952f,
        107.75835f,
        "Pink",
        listOf("Metalworker", "Tinker"),
        listOf(),
        Gender.WOMAN
    ),
    Inhabitant(
        1,
        "Fizkin Voidbuster",
        "http://www.publicdomainpictures.net/pictures/10000/nahled/thinking-monkey-11282237747K8xB.jpg",
        305,
        35.065952f,
        112.75835f,
        "Green",
        listOf("Tinker"),
        listOf(),
        Gender.MAN
    ),
    Inhabitant(
        2,
        "Malbin Chromebuster",
        "http://www.publicdomainpictures.net/pictures/10000/nahled/thinking-monkey-11282237747K8xB.jpg",
        102,
        49.065952f,
        122.11835f,
        "Black",
        listOf("Metalworker"),
        listOf("Fizkin Voidbuster"),
        Gender.MAN
    )
)