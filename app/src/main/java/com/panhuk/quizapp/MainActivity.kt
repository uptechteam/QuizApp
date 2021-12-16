package com.panhuk.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.panhuk.menufeature.MenuNavigator
import com.panhuk.quizapp.databinding.ActivityMainBinding
import com.panhuk.repository.FirstTimeRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity @Inject constructor(
  private val firstTimeRepo: FirstTimeRepo,
  private val dispatcher: CoroutineDispatcher
) : AppCompatActivity(), MenuNavigator {

  private lateinit var binding: ActivityMainBinding
  private lateinit var navigator: NavController
  private var isFirstTime: Boolean = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    navigator = findNavController(R.id.nav_fragment)

    CoroutineScope(dispatcher).launch {
      firstTimeRepo.isFirstTime().collect { value ->
        isFirstTime = value
      }
    }

    if (isFirstTime) {
      navigateToFirstScreen()
    }

    setContentView(binding.root)
  }

  private fun navigateToFirstScreen() {
    //navigator.navigate(R.id.first_screen)
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
}