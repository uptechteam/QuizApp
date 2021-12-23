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
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.panhuk.core.CATEGORY_ID
import com.panhuk.core.CATEGORY_TITLE
import com.panhuk.core.CORRECT_ANSWERS
import com.panhuk.core.DIFFICULTY
import com.panhuk.core.QUESTIONS_NUMBER
import com.panhuk.core.TOTAL_ANSWERS
import com.panhuk.core.TYPE
import com.panhuk.domain.model.Category
import com.panhuk.playfeature.di.PlayComponent
import com.panhuk.playfeature.di.PlayFactory
import javax.inject.Inject

class PlayFragment : Fragment() {

  @Inject
  lateinit var viewModelAssistedFactory: PlayFactory.Factory

  private val viewModel: PlayViewModel by viewModels {
    val results = arguments
    val category = Category(results!!.getString(CATEGORY_TITLE)!!,results.getInt(CATEGORY_ID) )
    val difficulty = results.getString(DIFFICULTY)
    val question = results.getString(QUESTIONS_NUMBER)
    val type = results.getString(TYPE)

    PlayFactory.provideFactory(
      viewModelAssistedFactory,
      category,
      difficulty!!,
      question!!,
      type!!
    )
  }

  override fun onAttach(context: Context) {
    PlayComponent.create(requireContext().applicationContext).inject(this)
    super.onAttach(context)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    return ComposeView(requireContext()).apply {
      setViewCompositionStrategy(DisposeOnViewTreeLifecycleDestroyed)
      setContent {
        PlayFragment()
      }
    }
  }

  @Preview(showBackground = true)
  @Composable
  fun PlayFragment() {
    if (viewModel.isLoading) {
      CircularProgress()
    } else {
      QuestionTitleAndNumeration()
      QuestionsAndScore()
      QuitButton()

      checkIfLastQuestionAndGoToFinishFragment()
    }
  }

  private fun checkIfLastQuestionAndGoToFinishFragment() {
    if (viewModel.isLastQuestion) {
      val bundle = Bundle().apply {
        putInt(CORRECT_ANSWERS, viewModel.totalScore)
        putInt(TOTAL_ANSWERS, viewModel.totalNumberOfQuestions)
      }
      (requireActivity() as PlayNavigator).navigatePlayToFinishFragment(bundle)
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
  fun QuestionTitleAndNumeration() {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp, start = 40.dp, end = 30.dp),
      contentAlignment = Alignment.TopCenter
    ) {
      Column() {
        Row() {
          NumerationOfQuestion()
          Timer()
        }

        val text = Html.fromHtml(viewModel.title).toString()
        Text(text, fontSize = 24.sp)
      }
    }
  }

  @Composable
  fun Timer() {
    Text(stringResource(R.string.timer, viewModel.timer), fontSize = 24.sp, color = Color.LightGray)

    if (!viewModel.timerIsActive) {
      val (messageId, colorId) = Pair(R.string.out_of_time, android.graphics.Color.MAGENTA)
      showSnackbar(messageId, colorId)
    }
  }

  @Composable
  fun NumerationOfQuestion() {
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
  fun QuestionsAndScore() {
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      viewModel.questionAnswers.forEach { answer ->
        val text = Html.fromHtml(answer).toString()
        QuestionButton(text)
      }
      Score()
    }
  }

  @Composable
  fun QuestionButton(text: String) {
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
  fun Score() {
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