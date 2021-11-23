package com.panhuk.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MakeOutlinedButtonWithText(text = stringResource(id = R.string.play))
            MakeOutlinedButtonWithText(text = stringResource(id = R.string.settings))
            MakeOutlinedButtonWithText(text = stringResource(id = R.string.leaderboard))
        }
    }


    @Composable
    fun MakeOutlinedButtonWithText(text: String) {
        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .padding(bottom = 30.dp)
                .width(300.dp)
        ) {
            Text(text, fontSize = 24.sp)
        }
    }
}