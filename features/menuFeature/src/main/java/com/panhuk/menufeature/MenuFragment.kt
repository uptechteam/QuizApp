package com.panhuk.menufeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.panhuk.core.Screen

class MenuFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    return ComposeView(requireContext()).apply {
      setViewCompositionStrategy(DisposeOnViewTreeLifecycleDestroyed)
      setContent {
        Menu()
      }
    }
  }

  @Preview(showBackground = true)
  @Composable
  fun Menu() {
    IconAndTitle()
    Buttons()
    DeveloperInfo()
  }

  @Composable
  fun IconAndTitle() {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 210.dp)
    ) {
      Icon()
      Title()
    }
  }

  @Composable
  fun Icon() {
    Image(
      painterResource(R.drawable.ic_launcher_foreground),
      contentDescription = null,
      modifier = Modifier.border(1.5.dp, MaterialTheme.colors.primary, CircleShape)
    )
  }

  @Composable
  fun Title() {
    Text(stringResource(R.string.app_name), fontSize = 30.sp)
  }

  @Composable
  fun Buttons() {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(top = 200.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Button(R.string.play, Screen.SETUP_QUESTIONS)
      Button(R.string.settings, Screen.SETTINGS)
      Button(R.string.leaderboard, Screen.LEADERBOARD)
    }
  }

  @Composable
  fun Button(textId: Int, fragment: Screen) {
    OutlinedButton(
      onClick = { navigateToFragment(fragment) },
      modifier = Modifier
        .padding(bottom = 30.dp)
        .width(300.dp),
      border = BorderStroke(1.dp, MaterialTheme.colors.primary)
    ) {
      Text(stringResource(textId), fontSize = 24.sp)
    }
  }

  private fun navigateToFragment(fragment: Screen) {
    val navigator = (requireActivity() as MenuNavigator)
    when (fragment) {
      Screen.SETUP_QUESTIONS -> navigator.navigateMenuToSetupQuestionsFragment()
      Screen.SETTINGS -> navigator.navigateMenuToSettingsFragment()
      Screen.LEADERBOARD -> navigator.navigateMenuToLeaderboardFragment()
    }
  }

  @Composable
  fun DeveloperInfo() {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
      contentAlignment = Alignment.BottomCenter
    ) {
      Text(
        stringResource(R.string.developer_info),
        fontSize = 16.sp,
      )
    }
  }
}

