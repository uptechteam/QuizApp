package com.panhuk.dataSourceimpl

import com.panhuk.api.api.QuestionApi
import com.panhuk.datasource.QuestionDSReader
import com.panhuk.domain.model.Question
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class QuestionApiDataSource(private val api: QuestionApi) : QuestionDSReader {
  override val questions: Flow<List<Question>?>
    get() = flow {
      api.getQuestions().results.map { questionDTO ->
        questionDTO.mapToDomain()
      }
    }
}