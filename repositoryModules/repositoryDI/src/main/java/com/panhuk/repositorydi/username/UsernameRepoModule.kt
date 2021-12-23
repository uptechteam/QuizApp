package com.panhuk.repositorydi.username

import com.panhuk.datasource.DatastorePreferences
import com.panhuk.repository.UsernameRepo
import com.panhuk.repository_impl.username.UsernameRepoImpl
import dagger.Module
import dagger.Provides

@Module
class UsernameRepoModule {
  @Provides
  fun provideUsernameRepo(
    dataStorePreferences: DatastorePreferences
  ): UsernameRepo = UsernameRepoImpl(
    dataStorePreferences
  )
}