package com.saico.victor.poketinder.data.model

import java.io.Serializable

data class User(
    val id: String,
    val name: String,
    val email: String,
    val password: String
): Serializable {
    fun getImage() = "https://graph.facebook.com/$id/picture?type=large&width=720&height=720"
}
