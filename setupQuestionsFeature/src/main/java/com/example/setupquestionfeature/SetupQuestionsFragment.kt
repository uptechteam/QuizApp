package com.example.setupquestionfeature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.setupquestionfeature.di.SetupQuestionsComponent
import javax.inject.Inject

class SetupQuestionsFragment : Fragment() {

  @Inject
  protected lateinit var viewModel: SetupQuestionsViewModel

  override fun onAttach(context: Context) {
    SetupQuestionsComponent.create().inject(this)
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
        QuestionsFragment()
      }
    }
  }

  @Preview(showBackground = true)
  @Composable
  fun QuestionsFragment() {
    Column(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Spinner(R.string.number_of_questions, listOf("5", "10", "20", "50"))
      Spinner(R.string.category, listOf("Any category", "Music", "Games", "Films")) // category
      Spinner(R.string.difficulty, listOf("Easy", "Medium", "Hard")) //difficulty
      Spinner(R.string.type, listOf("Some type 1", "Some type 2")) //difficulty
      Confirm()
    }
  }

  @Composable
  fun Spinner(title: Int, options: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    OutlinedButton(
      onClick = { expanded = true },
      Modifier
        .padding(bottom = 30.dp)
        .width(300.dp),
      border = BorderStroke(1.dp, MaterialTheme.colors.onSecondary)
    ) {
      Text(
        stringResource(R.string.name_of_button, stringResource(title), options[selectedIndex]),
        fontSize = 20.sp,
        modifier = Modifier
      )
      DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
      ) {
        options.forEachIndexed { index, item ->
          DropdownMenuItem(onClick = {
            selectedIndex = index
            expanded = false
          }) {
            Text(item, fontSize = 20.sp)
          }
        }
      }
    }
  }

  @Composable
  fun Confirm() {
    Button(
      onClick = { navigateToPlayFragment() },
      Modifier
        .width(200.dp)
        .height(50.dp)
    ) {
      Text(stringResource(R.string.confirm))
    }
  }

  private fun navigateToPlayFragment() {
    (requireActivity() as SetupQuestionsNavigator).navigateSetupQuestionsToPlayFragment()
  }
}