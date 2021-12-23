package com.panhuk.repositorydi.username

import android.content.Context
import com.panhuk.datasourcedi.di.datastore.DatastoreComponent
import com.panhuk.repository.UsernameRepo
import dagger.Component

@Component(
  dependencies = [
    DatastoreComponent::class
  ],
  modules = [
    UsernameRepoModule::class
  ]
)
interface UsernameRepoComponent {

  fun getUsernameRepo(): UsernameRepo

  @Component.Builder
  interface Builder {
    fun datastoreComponent(component: DatastoreComponent): Builder
    fun usernameRepoModule(module: UsernameRepoModule): Builder
    fun build(): UsernameRepoComponent
  }

  companion object {
    fun create(context: Context): UsernameRepoComponent =
      DaggerUsernameRepoComponent.builder()
        .datastoreComponent(DatastoreComponent.create(context))
        .usernameRepoModule(UsernameRepoModule())
        .build()
  }
}