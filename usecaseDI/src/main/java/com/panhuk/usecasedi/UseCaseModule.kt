package com.panhuk.usecasedi

import com.panhuk.datasource.DatastorePreferences
import com.panhuk.repository.QuestionRepoReader
import com.panhuk.useCase.GetQuestionsUseCase
import com.panhuk.useCase.GetUsernameUseCase
import com.panhuk.usecaseImpl.GetQuestionsUseCaseImpl
import com.panhuk.usecaseImpl.GetUsernameUseCaseImpl
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

  @Provides
  fun provideGetUsernameUseCase(
    dataStorePreferences: DatastorePreferences
  ): GetUsernameUseCase = GetUsernameUseCaseImpl(
    dataStorePreferences
  )
}