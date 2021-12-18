package com.panhuk.finishfeature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.panhuk.core.Screen
import com.panhuk.finishfeature.databinding.FinishFragmentBinding

class FinishFragment : Fragment() {
  private var _binding: FinishFragmentBinding? = null
  private val binding get() = _binding!!

  override fun onAttach(context: Context) {
    //add component
    super.onAttach(context)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FinishFragmentBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.finishFragment.setContent { CreateFinishFragment() }
  }

  override fun onDestroyView() {
    _binding = null
    super.onDestroyView()
  }

  @Preview(showBackground = true)
  @Composable
  fun CreateFinishFragment() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      CreateButton(R.string.retry, Screen.PLAY)
      CreateButton(R.string.go_main_menu, Screen.MENU)
    }
  }

  @Composable
  fun CreateButton(textId: Int, navigateScreen: Screen) {
    Button(onClick = { navigateToScreen(navigateScreen) }) {
      Text(stringResource(textId), Modifier.padding(bottom = 10.dp))
    }
  }

  private fun navigateToScreen(navigateScreen: Screen) {
    val navigator = (requireActivity() as FinishNavigator)
    when (navigateScreen) {
      Screen.PLAY -> navigator.navigateFinishToPlayFragment()
      Screen.MENU -> navigator.navigateFinishToMenuFragment()
    }
  }
}