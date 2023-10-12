package de.tschuehly.fullstackdemo.core.scene

import java.time.LocalDate


class Scene(
    var id: Int?,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val birthDate: LocalDate
) {

    fun getSceneAsList() = listOf(id.toString(),firstName, lastName, phoneNumber, email, birthDate.toString())
}

