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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.panhuk.core.RIGHT_ANSWERS
import com.panhuk.core.TOTAL_ANSWERS
import com.panhuk.core.Screen
import com.panhuk.finishfeature.databinding.FinishFragmentBinding

class FinishFragment : Fragment() {
  private var _binding: FinishFragmentBinding? = null
  private val binding get() = _binding!!
  private var rightAnswers: Int = 0
  private var totalAnswers: Int = 0

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
    arguments?.run {
      rightAnswers = getInt(RIGHT_ANSWERS)
      totalAnswers = getInt(TOTAL_ANSWERS)
    }
    binding.finishFragment.setContent { CreateFinishFragment() }
  }

  override fun onDestroyView() {
    _binding = null
    super.onDestroyView()
  }

  @Preview(showBackground = true)
  @Composable
  fun CreateFinishFragment() {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
      modifier = Modifier.fillMaxSize()
    ) {
      CreateCircularProgress()
      CreateTotalScore()
      CreateButton(R.string.retry, Screen.PLAY)
      CreateButton(R.string.go_main_menu, Screen.MENU)
    }
  }

  @Composable
  fun CreateCircularProgress() {
    val totalScore = rightAnswers.toFloat() / totalAnswers.toFloat()
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
  fun CreateTotalScore() {
    Text(stringResource(R.string.total_score, rightAnswers, totalAnswers), fontSize = 20.sp)
  }

  @Composable
  fun CreateButton(textId: Int, navigateScreen: Screen) {
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