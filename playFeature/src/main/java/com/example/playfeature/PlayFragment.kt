package com.example.playfeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import com.example.playfeature.databinding.PlayFragmentBinding
import com.example.playfeature.di.PlayComponent
import com.panhuk.datasourcedi.di.DaggerSessionTokenComponent
import com.panhuk.datasourcedi.di.QuestionComponent
import javax.inject.Inject

class PlayFragment : Fragment() {
  private var _binding: PlayFragmentBinding? = null
  private val binding get() = _binding!!

  @Inject
  protected lateinit var viewModel: PlayViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = PlayFragmentBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.playFragment.setContent { CreatePlayFragment() }
    PlayComponent.create(this)
    viewModel.temp()
  }

  override fun onDestroyView() {
    _binding = null
    super.onDestroyView()
  }

  @Preview(showBackground = true)
  @Composable
  fun CreatePlayFragment() {
    MakeQuestionTitle(text = "Question")
    MakeQuestionsAndScore()
    QuitButton()
  }

  @Composable
  fun MakeQuestionTitle(text: String) {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp),
      contentAlignment = Alignment.TopCenter
    ) {
      Text(text, fontSize = 24.sp)
    }
  }

  @Composable
  fun MakeQuestionsAndScore() {
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      val answer = "Answer"
      MakeOutlinedButtonWithText(text = answer)
      MakeOutlinedButtonWithText(text = answer)
      MakeOutlinedButtonWithText(text = answer)
      MakeOutlinedButtonWithText(text = answer)
      MakeScore()
    }
  }

  @Composable
  fun MakeOutlinedButtonWithText(text: String) {
    Button(
      onClick = {},
      modifier = Modifier
        .padding(bottom = 30.dp)
        .width(300.dp),
      shape = RoundedCornerShape(40.dp)
    ) {
      Text(text, fontSize = 24.sp)
    }
  }

  @Composable
  fun MakeScore() {
    Row() {
      Text(stringResource(id = R.string.score), modifier = Modifier.padding(end = 5.dp))
      Text("2")
    }
  }

  @Composable
  fun QuitButton() {
    Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.BottomCenter
    ) {
      OutlinedButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        shape = RoundedCornerShape(40.dp)
      ) {
        Text("Quit", color = Color.Red)
      }
    }
  }
}