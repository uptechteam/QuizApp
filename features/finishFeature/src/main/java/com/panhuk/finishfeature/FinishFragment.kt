package com.panhuk.finishfeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.panhuk.core.CORRECT_ANSWERS
import com.panhuk.core.Screen
import com.panhuk.core.TOTAL_ANSWERS

class FinishFragment : Fragment() {
  private var correctAnswers: Int = 0
  private var totalAnswers: Int = 0

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return ComposeView(requireContext()).apply {
      setViewCompositionStrategy(DisposeOnViewTreeLifecycleDestroyed)
      setContent {
        FinishFragment()
      }
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    arguments?.run {
      correctAnswers = getInt(CORRECT_ANSWERS)
      totalAnswers = getInt(TOTAL_ANSWERS)
    }
  }

  @Preview(showBackground = true)
  @Composable
  fun FinishFragment() {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
      modifier = Modifier.fillMaxSize()
    ) {
      CircularProgress()
      TotalScore()
      ActionButton(R.string.action_retry, Screen.PLAY)
      ActionButton(R.string.action_go_main_menu, Screen.MENU)
    }
  }

  @Composable
  fun CircularProgress() {
    val totalScore = correctAnswers.toFloat() / totalAnswers.toFloat()
    CircularProgressIndicator(
      progress = totalScore,
      modifier = Modifier
        .padding(bottom = 15.dp)
        .size(200.dp),
      color = Color.Green,
      strokeWidth = 5.dp
    )
  }

  @Composable
  fun TotalScore() {
    Text(
      stringResource(R.string.finish_quiz_total_score, correctAnswers, totalAnswers),
      fontSize = 20.sp
    )
  }

  @Composable
  fun ActionButton(textId: Int, navigateScreen: Screen) {
    Button(
      onClick = { navigateToScreen(navigateScreen) },
      Modifier.padding(top = 10.dp, bottom = 10.dp)
    ) {
      Text(stringResource(textId), fontSize = 24.sp)
    }
  }

  private fun navigateToScreen(navigateScreen: Screen) {
    val navigator = (requireActivity() as FinishNavigator)
    when (navigateScreen) {
      Screen.PLAY -> navigator.navigateFinishToPlayFragment()
      Screen.MENU -> navigator.navigateFinishToMenuFragment()
      else -> navigator.navigateFinishToMenuFragment()
    }
  }
}