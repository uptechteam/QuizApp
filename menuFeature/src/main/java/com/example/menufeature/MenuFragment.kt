package com.example.menufeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.menufeature.databinding.MenuFragmentBinding

class MenuFragment : Fragment() {

  private var _binding: MenuFragmentBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = MenuFragmentBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onDestroyView() {
    _binding = null
    super.onDestroyView()
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.menuFragment.setContent { CreateMenuFragment() }
  }

  @Preview(showBackground = true)
  @Composable
  fun CreateMenuFragment() {
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      MakeOutlinedButtonWithText(R.string.play)
      MakeOutlinedButtonWithText(R.string.settings)
      MakeOutlinedButtonWithText(R.string.leaderboard)
    }
  }

  @Composable
  fun MakeOutlinedButtonWithText(textId: Int) {
    OutlinedButton(
      onClick = { navigateToFragment(textId) },
      modifier = Modifier
        .padding(bottom = 30.dp)
        .width(300.dp)
    ) {
      Text(stringResource(textId), fontSize = 24.sp)
    }
  }

  private fun navigateToFragment(textId: Int) {
    val navigator = (requireActivity() as MenuNavigator)
    when (textId) {
      R.string.play -> navigator.navigateMenuToPlayFragment()
      R.string.settings -> navigator.navigateMenuToSettingsFragment()
      R.string.leaderboard -> navigator.navigateMenuToLeaderboardFragment()
    }
  }
}