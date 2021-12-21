package com.panhuk.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.panhuk.menufeature.MenuNavigator
import com.panhuk.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MenuNavigator, , FinishNavigator, PlayNavigator {
  private lateinit var binding: ActivityMainBinding
  private lateinit var navigator: NavController

  @Inject
  protected lateinit var firebaseAnalytics: FirebaseAnalytics

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    MainActivityComponent.create(applicationContext).inject(this)
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