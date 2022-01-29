package com.panhuk.dataSourceimpl.question

import com.panhuk.api.api.QuestionApi
import com.panhuk.datasource.QuestionDSReader
import com.panhuk.domain.model.Category
import com.panhuk.domain.model.Question
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class QuestionApiDataSource(private val api: QuestionApi) : QuestionDSReader {

  private val categoriesDTO = mapOf(
    "Geography" to "geography",
    "Sport and leisure" to "sport_and_leisure",
    "Food and drink" to "food_and_drink",
    "General Knowledge" to "general_knowledge",
    "History" to "history",
    "Movies" to "movies",
    "Music" to "music",
    "Science" to "science",
    "Society and culture" to "society_and_culture"
  )

  override fun getQuestions(
    limit: Int,
    category: String?
  ): Flow<List<Question>?> = flow {
    emit(
      api.getQuestions(limit, category).map { questionDTO ->
        questionDTO.mapToDomain()
      }
    )
  }

  override val categories: Flow<List<Category>>
    get() = flow {
      emit(
        categoriesDTO.map { categoryDTO ->
          categoryDTO.mapToDomain()
        }
      )
    }
}