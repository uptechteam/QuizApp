package com.panhuk.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.panhuk.finishfeature.FinishNavigator
import com.panhuk.firstTimeFeature.FirstTimeNavigator
import com.panhuk.menufeature.MenuNavigator
import com.panhuk.playfeature.PlayNavigator
import com.panhuk.quizapp.databinding.ActivityMainBinding
import com.panhuk.quizapp.di.MainActivityComponent
import kotlinx.coroutines.flow.first
import timber.log.Timber
import javax.inject.Inject

class MainActivity() : AppCompatActivity(), MenuNavigator, FirstTimeNavigator, FinishNavigator,
  PlayNavigator {

  private lateinit var binding: ActivityMainBinding
  private lateinit var navigator: NavController

  @Inject
  protected lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    MainActivityComponent.create(applicationContext).inject(this)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    subscribeStateFlow()
    setupNavigation()
    setupTimber()
  }

  private fun setupNavigation(){
    navigator = findNavController(R.id.nav_fragment)
  }

  private fun setupTimber(){
    Timber.plant(Timber.DebugTree())
  }

  private fun subscribeStateFlow() {
    lifecycleScope.launchWhenStarted {
      if (viewModel.isFirstTime.first()) {
        navigateToFirstScreen()
      }
    }
  }

  private fun navigateToFirstScreen() {
    navigator.navigate(R.id.firstTimeFragment)
  }

  override fun navigateMenuToPlayFragment() {
    navigator.navigate(R.id.menu_play)
  }

  override fun navigateMenuToSettingsFragment() {
    navigator.navigate(R.id.menu_settings)
  }

  override fun navigateMenuToLeaderboardFragment() {
    navigator.navigate(R.id.menu_leaderboard)
  }

  override fun navigateToMenuFragment() {
    navigator.navigate(R.id.firstTime_menu)
  }

  override fun navigateFinishToMenuFragment() {
    navigator.navigate(R.id.finish_menu)
  }

  override fun navigateFinishToPlayFragment() {
    navigator.navigate(R.id.finish_play)
  }

  override fun navigatePlayToFinishFragment(bundle: Bundle) {
    navigator.navigate(R.id.play_finish, bundle)
  }
}