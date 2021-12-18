package com.panhuk.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.panhuk.finishfeature.FinishNavigator
import com.panhuk.menufeature.MenuNavigator
import com.panhuk.playfeature.PlayNavigator
import com.panhuk.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MenuNavigator, FinishNavigator, PlayNavigator {
  private lateinit var binding: ActivityMainBinding
  private lateinit var navigator: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    navigator = findNavController(R.id.nav_fragment)
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
    navigator.navigate(R.id.finish_menu)
  }

  override fun navigateToPlayFragment() {
    navigator.navigate(R.id.finish_play)
  }

  override fun navigateToFinishFragment() {
    navigator.navigate(R.id.play_finish)
  }
}