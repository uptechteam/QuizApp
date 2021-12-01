package com.example.settingsfeature

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.settingsfeature.R.string
import com.example.settingsfeature.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
  private var _binding: FragmentSettingsBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentSettingsBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.settingsFragment.setContent { CreateSettingsFragment() }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  @Preview(showBackground = true)
  @Composable
  fun CreateSettingsFragment() {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
    ) {
      ChangeUsernameTextField()
      CreateTextWithSwitchInRow()
    }
  }

  @Composable
  fun ChangeUsernameTextField() {
    val tempText = "John Smith"
    var text by remember { mutableStateOf(tempText) }

    OutlinedTextField(
      value = text,
      onValueChange = { text = it },
      label = { Text(stringResource(R.string.your_username)) },
      modifier = Modifier.padding(bottom = 10.dp, start = 5.dp, end = 5.dp)
    )
  }

  @Composable
  fun CreateTextWithSwitchInRow() {
    Row() {
      Text(stringResource(string.use_your_data_to_improve_our_service))
      CreateSwitch()
    }
  }

  @Composable
  fun CreateSwitch() {
    val checkedState = remember { mutableStateOf(true) }
    Switch(
      checked = checkedState.value,
      onCheckedChange = { checkedState.value = it }
    )
  }
}