package com.panhuk.repositorydi.firstTime

import com.panhuk.datasource.DatastorePreferences
import com.panhuk.repository.FirstTimeRepo
import com.panhuk.repository_impl.firstTime.FirstTimeRepoImpl
import dagger.Module
import dagger.Provides

@Module
class FirstTimeRepoModule {
  @Provides
  fun provideFirstTimeRepo(
    dataStorePreferences: DatastorePreferences
  ): FirstTimeRepo = FirstTimeRepoImpl(
    dataStorePreferences
  )
}