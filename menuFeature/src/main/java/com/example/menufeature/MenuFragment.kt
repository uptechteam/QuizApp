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
import androidx.navigation.fragment.findNavController
import com.example.menufeature.R.string
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
      MakeOutlinedButtonWithText(text = stringResource(id = string.play), R.id.menu_play)
      MakeOutlinedButtonWithText(text = stringResource(id = string.settings), R.id.menu_settings)
      MakeOutlinedButtonWithText(
        text = stringResource(id = string.leaderboard),
        R.id.menu_leaderboard
      )
    }
  }

  @Composable
  fun MakeOutlinedButtonWithText(text: String, navigationId: Int) {
    OutlinedButton(
      onClick = { findNavController().navigate(navigationId) },
      modifier = Modifier
        .padding(bottom = 30.dp)
        .width(300.dp)
    ) {
      Text(text, fontSize = 24.sp)
    }
  }
}