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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
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
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.setupquestionfeature.di.SetupQuestionsComponent
import com.panhuk.core.CATEGORY_ID
import com.panhuk.core.DIFFICULTY
import com.panhuk.core.QUESTIONS_NUMBER
import com.panhuk.core.TYPE
import com.panhuk.domain.model.Category
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
      if (viewModel.isLoading) {
        CircularProgress()
      } else {
        Spinner(
          R.string.number_of_questions,
          stringArrayResource(viewModel.questions).toMutableList()
        )
        Spinner(R.string.category, viewModel.categories.map { it.title } as MutableList<String>)
        Spinner(R.string.difficulty, stringArrayResource(viewModel.difficulties).toMutableList())
        Spinner(R.string.type, stringArrayResource(viewModel.types).toMutableList())
        Confirm()
      }
    }
  }

  @Composable
  fun CircularProgress() {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      CircularProgressIndicator(modifier = Modifier.size(200.dp))
    }
  }

  @Composable
  fun Spinner(title: Int, options: MutableList<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    if(title != R.string.number_of_questions){
      options.add(0, ADD_ANY_TYPE)
    }

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

      when (title) {
        R.string.number_of_questions -> viewModel.question = options[selectedIndex]
        R.string.category -> {
          val searchCategory = viewModel.categories.find { options[selectedIndex] == it.title }
          if (searchCategory == null) {
            viewModel.category = Category(ADD_ANY_TYPE, -1)
          } else {
            viewModel.category = searchCategory
          }
        }
        R.string.difficulty -> viewModel.difficulty = options[selectedIndex]
        R.string.type -> viewModel.type = options[selectedIndex]
      }

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
    val bundle = Bundle().apply {
      if (viewModel.category.id != -1) {
        putInt(CATEGORY_ID, viewModel.category.id)
      } else {
        putInt(CATEGORY_ID, -1)
      }
      if (viewModel.difficulty != ADD_ANY_TYPE) {
        putString(DIFFICULTY, viewModel.difficulty.lowercase())
      } else {
        putString(DIFFICULTY, null)
      }

      putString(QUESTIONS_NUMBER, viewModel.question)
      when (viewModel.type) {
        ADD_ANY_TYPE -> putString(TYPE, null)
        TYPE_MULTIPLE -> putString(TYPE, MULTIPLE)
        TYPE_BOOLEAN -> putString(TYPE, BOOLEAN)
      }
    }
    (requireActivity() as SetupQuestionsNavigator).navigateSetupQuestionsToPlayFragment(bundle)
  }
}