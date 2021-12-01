package com.panhuk.datasourceimpl

import com.panhuk.api.api.QuestionApi
import com.panhuk.dataSourceimpl.mapToDomain
import com.panhuk.datasource.QuestionDSReader
import com.panhuk.domain.model.Question
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuestionApiDataSource(private val api: QuestionApi) : QuestionDSReader {
  override val questions: Flow<List<Question>?>
    get() = api.getQuestions().map {
      it.results.map { questionDTO ->
        questionDTO.mapToDomain()
      }
    }
}