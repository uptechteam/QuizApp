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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.panhuk.core.Fragments
import com.panhuk.menufeature.databinding.MenuFragmentBinding

class MenuFragment : Fragment() {
  private var _binding: MenuFragmentBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    _binding = MenuFragmentBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.menuFragment.setContent { CreateMainActivity() }
  }

  @Preview(showBackground = true)
  @Composable
  fun CreateMainActivity() {
    CreateIconAndTitle()
    CreateButtons()
    CreateDeveloperInfo()
  }

  @Composable
  fun CreateIconAndTitle() {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 210.dp)
    ) {
      CreateIcon()
      CreateTitle()
    }
  }

  @Composable
  fun CreateIcon() {
    Image(
      painterResource(R.drawable.ic_launcher_foreground),
      contentDescription = null,
      modifier = Modifier.border(1.5.dp, MaterialTheme.colors.primary, CircleShape)
    )
  }

  @Composable
  fun CreateTitle() {
    Text(stringResource(R.string.app_name), fontSize = 30.sp)
  }

  @Composable
  fun CreateButtons() {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(top = 200.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      CreateButton(R.string.play, Fragments.PLAY)
      CreateButton(R.string.settings, Fragments.SETTINGS)
      CreateButton(R.string.leaderboard, Fragments.LEADERBOARD)
    }
  }

  @Composable
  fun CreateButton(textId: Int, fragment: Fragments) {
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

  private fun navigateToFragment(fragment: Fragments) {
    val navigator = (requireActivity() as MenuNavigator)
    when (fragment) {
      Fragments.PLAY -> navigator.navigateMenuToPlayFragment()
      Fragments.SETTINGS -> navigator.navigateMenuToSettingsFragment()
      Fragments.LEADERBOARD -> navigator.navigateMenuToLeaderboardFragment()
    }
  }

  @Composable
  fun CreateDeveloperInfo() {
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

