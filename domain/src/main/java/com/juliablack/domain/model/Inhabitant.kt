package com.juliablack.domain.model

import com.juliablack.data.model.InhabitantResponse
import java.io.Serializable

class Inhabitant(
    val id: Int,
    val name: String,
    val thumbnail: String,
    val age: Int,
    val weight: Float,
    val height: Float,
    val hairColor: String,
    val professions: List<String>,
    val friends: List<String>,
    val gender: Gender
) : Serializable

fun InhabitantResponse.fromResponse() = Inhabitant(
    id,
    name,
    thumbnail,
    age,
    weight,
    height,
    hairColor,
    professions,
    friends,
    determinateGender()
)

//Just a guess on popular stereotypes :)
fun InhabitantResponse.determinateGender() =
    if (hairColor.lowercase() == "pink" || weight < 36)
        Gender.WOMAN
    else
        Gender.MAN

enum class Gender {
    WOMAN, MAN
}