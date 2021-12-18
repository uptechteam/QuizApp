package com.panhuk.playfeature

import android.content.Context
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedButton
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
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.panhuk.core.RIGHT_ANSWERS
import com.panhuk.core.TOTAL_ANSWERS
import com.panhuk.playfeature.databinding.PlayFragmentBinding
import com.panhuk.playfeature.di.PlayComponent
import javax.inject.Inject

class PlayFragment : Fragment() {
  private var _binding: PlayFragmentBinding? = null
  private val binding get() = _binding!!

  @Inject
  protected lateinit var viewModel: PlayViewModel

  override fun onAttach(context: Context) {
    PlayComponent.create(requireContext().applicationContext).inject(this)
    super.onAttach(context)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    _binding = PlayFragmentBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.playFragment.setContent { CreatePlayFragment() }
  }

  override fun onDestroyView() {
    _binding = null
    super.onDestroyView()
  }

  @Preview(showBackground = true)
  @Composable
  fun CreatePlayFragment() {
    if (viewModel.isLoading) {
      MakeCircularProgress()
    } else {
      MakeQuestionTitleAndNumeration()
      MakeQuestionsAndScore()
      QuitButton()

      if (viewModel.isLastQuestion) {
        val bundle = Bundle().apply {
          putInt(RIGHT_ANSWERS, viewModel.totalScore)
          putInt(TOTAL_ANSWERS, viewModel.totalNumberOfQuestions)
        }
        (requireActivity() as PlayNavigator).navigatePlayToFinishFragment(bundle)
      }
    }
  }

  @Composable
  fun MakeCircularProgress() {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      CircularProgressIndicator(modifier = Modifier.size(200.dp))
    }
  }

  @Composable
  fun MakeQuestionTitleAndNumeration() {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp, start = 40.dp, end = 30.dp),
      contentAlignment = Alignment.TopCenter
    ) {
      Column() {
        Row() {
          MakeNumerationOfQuestion()
          MakeTimer()
        }

        val text = Html.fromHtml(viewModel.title).toString()
        Text(text, fontSize = 24.sp)
      }
    }
  }

  @Composable
  fun MakeTimer() {
    Text(stringResource(R.string.timer, viewModel.timer), fontSize = 24.sp, color = Color.LightGray)

    if (!viewModel.timerIsActive) {
      val (messageId, colorId) = Pair(R.string.out_of_time, android.graphics.Color.MAGENTA)
      showSnackbar(messageId, colorId)
    }
  }

  @Composable
  fun MakeNumerationOfQuestion() {
    Text(
      stringResource(
        R.string.number_of_question,
        viewModel.currentQuestionNumber,
        viewModel.totalNumberOfQuestions
      ),
      modifier = Modifier.padding(end = 10.dp),
      color = Color.LightGray,
      fontSize = 24.sp
    )
  }

  @Composable
  fun MakeQuestionsAndScore() {
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      viewModel.questionAnswers.forEach { answer ->
        val text = Html.fromHtml(answer).toString()
        MakeQuestion(text)
      }
      MakeScore()
    }
  }

  @Composable
  fun MakeQuestion(text: String) {
    Button(
      onClick = { checkAnswerAndShowToast(text) },
      modifier = Modifier
        .padding(bottom = 30.dp)
        .width(300.dp),
      shape = RoundedCornerShape(40.dp)
    ) {
      Text(text, fontSize = 18.sp)
    }
  }

  private fun checkAnswerAndShowToast(text: String) {
    val (messageId, colorId) = when (viewModel.checkAnswer(text)) {
      true -> Pair(R.string.right_answer, android.graphics.Color.GREEN)
      false -> Pair(R.string.wrong_answer, android.graphics.Color.RED)
    }
    showSnackbar(messageId, colorId)
  }

  private fun showSnackbar(messageId: Int, colorId: Int) {
    Snackbar.make(requireView(), getString(messageId), Snackbar.LENGTH_SHORT).apply {
      view.setBackgroundColor(colorId)
      show()
    }
  }

  @Composable
  fun MakeScore() {
    Row() {
      Text(stringResource(id = R.string.score), modifier = Modifier.padding(end = 5.dp))
      Text(viewModel.totalScore.toString())
    }
  }

  @Composable
  fun QuitButton() {
    Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.BottomCenter
    ) {
      OutlinedButton(
        onClick = { findNavController().popBackStack() },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        shape = RoundedCornerShape(40.dp)
      ) {
        Text(stringResource(id = R.string.quit), color = Color.Red)
      }
    }
  }
}