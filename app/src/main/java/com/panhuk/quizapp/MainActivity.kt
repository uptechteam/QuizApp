package com.panhuk.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.setupquestionfeature.SetupQuestionsNavigator
import com.panhuk.menufeature.MenuNavigator
import com.panhuk.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MenuNavigator, SetupQuestionsNavigator {
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

  override fun navigateSetupQuestionsToPlayFragment() {
    navigator.navigate(R.id.setup_questions_play)
  }
}