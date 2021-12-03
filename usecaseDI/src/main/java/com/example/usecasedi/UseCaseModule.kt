package com.example.usecasedi

import com.panhuk.repository.QuestionRepoReader
import com.panhuk.useCase.GetQuestionsUseCase
import com.panhuk.usecaseImpl.GetQuestionsUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
  @Provides
  fun provideGetQuestionsUseCase(
    questionRepoReader: QuestionRepoReader
  ): GetQuestionsUseCase = GetQuestionsUseCaseImpl(
    questionRepoReader
  )
}