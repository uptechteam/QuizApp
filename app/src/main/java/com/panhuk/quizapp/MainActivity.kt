package com.panhuk.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.panhuk.firstTimeFeature.FirstTimeNavigator
import com.panhuk.menufeature.MenuNavigator
import com.panhuk.quizapp.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity() : AppCompatActivity(), MenuNavigator, FirstTimeNavigator {

  private lateinit var binding: ActivityMainBinding
  private lateinit var navigator: NavController

  @Inject
  protected lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    MainComponent.create(applicationContext)
    binding = ActivityMainBinding.inflate(layoutInflater)
    navigator = findNavController(R.id.nav_fragment)

    if (viewModel.isFirstTimeCheck()) {
      navigateToFirstScreen()
    }

    setContentView(binding.root)
  }

  private fun navigateToFirstScreen() {
    navigator.navigate(R.id.firstTime)
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
}