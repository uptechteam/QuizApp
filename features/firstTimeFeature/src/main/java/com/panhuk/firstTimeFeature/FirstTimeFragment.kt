package com.panhuk.firstTimeFeature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.panhuk.firstTimeFeature.di.FirstTimeComponent
import javax.inject.Inject

class FirstTimeFragment : Fragment() {
  @Inject
  protected lateinit var viewModel: FirstTimeViewModel

  override fun onAttach(context: Context) {
    FirstTimeComponent.create(requireActivity().applicationContext).inject(this)
    super.onAttach(context)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return ComposeView(requireContext()).apply {
      setViewCompositionStrategy(DisposeOnViewTreeLifecycleDestroyed)
      setContent {
        FirstTime()
      }
    }
  }

  @Composable
  @Preview
  fun FirstTime() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      UsernameTextField(
        username = viewModel.username.value,
        onUsernameChanged = { viewModel.username.value = it }
      )
      Button(onClick = {
        if (viewModel.username.value.isNotEmpty()) {
          viewModel.saveUsername()
          (requireActivity() as FirstTimeNavigator).navigateToMenuFragment()
        } else {
          viewModel.username.value = "Error"
        }
      }) {
        Text(stringResource(R.string.save_username))
      }
    }
  }

  @Composable
  fun UsernameTextField(username: String, onUsernameChanged: (String) -> Unit) {
    OutlinedTextField(
      value = username,
      onValueChange = onUsernameChanged,
      label = { Text(stringResource(R.string.your_username)) },
      modifier = Modifier.padding(bottom = 10.dp, start = 5.dp, end = 5.dp)
    )
  }
}