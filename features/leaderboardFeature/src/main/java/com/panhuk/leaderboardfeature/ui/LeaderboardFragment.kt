package com.panhuk.leaderboardfeature.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.panhuk.analytic.Analytic
import com.panhuk.core.AnalyticTags.DATA
import com.panhuk.core.AnalyticTags.EMPTY_SCREEN
import com.panhuk.core.Screen
import com.panhuk.leaderboardfeature.R
import com.panhuk.leaderboardfeature.di.LeaderboardComponent
import javax.inject.Inject

class LeaderboardFragment : Fragment() {

  @Inject
  protected lateinit var viewModel: LeaderboardViewModel

  @Inject
  protected lateinit var analytic: Analytic

  override fun onAttach(context: Context) {
    LeaderboardComponent.create(requireActivity().applicationContext).inject(this)
    super.onAttach(context)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return ComposeView(requireContext()).apply {
      setViewCompositionStrategy(DisposeOnViewTreeLifecycleDestroyed)
      setContent {
        Leaderboard()
      }
    }
  }

  @Preview(showBackground = true)
  @Composable
  fun Leaderboard() {
    if (viewModel.isLeaderboardEmpty) {
      EmptyLeaderboardScreen()
      analytic.logEvent(Screen.LEADERBOARD.toString(), Bundle().apply {
        putString(EMPTY_SCREEN, getString(R.string.empty_leaderboard))
      })
    } else {
      Column() {
        LeaderboardTitleAndSort()
        LazyColumn()

        analytic.logEvent(Screen.LEADERBOARD.toString(), Bundle().apply {
          putString(DATA, viewModel.leaderboardSorted.toString())
        })
      }
    }
  }

  @Composable
  fun EmptyLeaderboardScreen() {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        stringResource(R.string.empty_leaderboard),
        fontSize = 24.sp,
        modifier = Modifier
          .width(300.dp)
          .padding(bottom = 20.dp)
      )
      Button(onClick = { navigateUp() }) {
        Text(stringResource(R.string.action_go_menu))
      }
    }
  }

  private fun navigateUp() {
    findNavController().popBackStack()
  }

  @Composable
  fun LeaderboardTitleAndSort() {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 5.dp),
      horizontalArrangement = Arrangement.Center
    ) {
      Text(
        modifier = Modifier
          .border(BorderStroke(2.dp, Color.Blue))
          .padding(start = 8.dp, end = 120.dp, bottom = 8.dp, top = 8.dp),
        text = stringResource(R.string.leaderboard),
        fontSize = 24.sp
      )
      Sort()
    }
  }

  @Composable
  fun Sort() {
    val options = viewModel.sortTypes
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    OutlinedButton(onClick = { expanded = true }) {
      Text(
        stringResource(options[selectedIndex]),
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
            viewModel.setSortType(item)
          }) {
            Text(stringResource(item))
          }
        }
      }
    }
  }

  @Composable
  fun LazyColumn() {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
      items(
        items = viewModel.leaderboardSorted,
        itemContent = { LeaderboardListItem(leaderboard = it) }
      )
    }
  }
}