package com.panhuk.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.panhuk.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    binding.mainActivity.setContent { CreateMainActivity() }
  }

  @Preview(showBackground = true)
  @Composable
  fun CreateMainActivity() {
    CreateIconAndTitle()
    CreateButtons()
    CreateDeveloperInfo()
  }

  @Composable
  fun CreateIconAndTitle() {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 210.dp)
    ) {
      CreateIcon()
      CreateTitle()
    }
  }

  @Composable
  fun CreateIcon() {
    Image(
      painterResource(R.drawable.ic_launcher_foreground),
      contentDescription = null,
      modifier = Modifier.border(1.5.dp, MaterialTheme.colors.primary, CircleShape)
    )
  }

  @Composable
  fun CreateTitle() {
    Text(stringResource(R.string.app_name), fontSize = 30.sp)
  }

  @Composable
  fun CreateButtons() {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(top = 200.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      CreateButton(stringResource(R.string.play))
      CreateButton(stringResource(R.string.settings))
      CreateButton(stringResource(R.string.leaderboard))
    }
  }

  @Composable
  fun CreateButton(text: String) {
    OutlinedButton(
      onClick = {},
      modifier = Modifier
        .padding(bottom = 30.dp)
        .width(300.dp),
      border = BorderStroke(1.dp, MaterialTheme.colors.primary)
    ) {
      Text(text, fontSize = 24.sp)
    }
  }

  @Composable
  fun CreateDeveloperInfo() {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
      contentAlignment = Alignment.BottomCenter
    ) {
      Text(
        stringResource(R.string.developer_info),
        fontSize = 16.sp,
      )
    }
  }
}
