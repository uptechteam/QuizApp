package com.panhuk.settingsfeature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.panhuk.settingsfeature.di.SettingsComponent
import javax.inject.Inject

class SettingsFragment : Fragment() {

  @Inject
  protected lateinit var viewModel: SettingsViewModel

  override fun onAttach(context: Context) {
    SettingsComponent.create(requireActivity().applicationContext).inject(this)
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
        Settings()
      }
    }
  }

  override fun onDestroy() {
    viewModel.saveUsername()
    super.onDestroy()
  }

  @Preview(showBackground = true)
  @Composable
  fun Settings() {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
    ) {
      UsernameTextField(
        username = viewModel.username.value,
        onUsernameChanged = { viewModel.username.value = it })
      TextWithSwitchInRow()
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

  @Composable
  fun TextWithSwitchInRow() {
    Row() {
      Text(stringResource(R.string.use_your_data_to_improve_our_service))
      Switch()
    }
  }

  @Composable
  fun Switch() {
    val checkedState = remember { mutableStateOf(true) }
    Switch(
      checked = checkedState.value,
      onCheckedChange = { checkedState.value = it }
    )
  }
}