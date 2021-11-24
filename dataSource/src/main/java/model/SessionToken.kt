package model

data class SessionToken(
    val response_code: Int,
    val response_message: String,
    val token: String
)