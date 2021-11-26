package model

data class BaseResponse(
    val response_code: Int,
    val results: List<Question>
)