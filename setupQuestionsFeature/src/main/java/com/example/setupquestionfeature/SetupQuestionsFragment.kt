package com.example.setupquestionfeature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
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
    NumberOfQuestions()
    Spinner(listOf("Any category", "Music", "Games", "Films")) // category
    Spinner(listOf("Easy", "Medium", "Hard")) //difficulty
    Spinner(listOf("Some type 2", "Some type 2")) //difficulty
    Confirm()
  }

  @Composable
  fun NumberOfQuestions() {
    Text("10 questions")
  }

  @Composable
  fun Spinner(options: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    OutlinedButton(onClick = { expanded = true }) {
      Text(
        options[selectedIndex],
        fontSize = 12.sp,
        modifier = Modifier
          .width(75.dp)
          .align(Alignment.CenterVertically)
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
            Text(item)
          }
        }
      }
    }
  }

  @Composable
  fun Confirm() {
    Button(
      onClick = {
        (requireActivity() as SetupQuestionsNavigator).navigateSetupQuestionsToPlayFragment()
      }
    ) {
      Text("Confirm")
    }
  }
}