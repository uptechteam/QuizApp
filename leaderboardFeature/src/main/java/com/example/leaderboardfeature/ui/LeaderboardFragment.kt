package com.example.leaderboardfeature.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.leaderboardfeature.R.string
import com.example.leaderboardfeature.databinding.FragmentLeaderboardBinding
import com.example.leaderboardfeature.model.DataProvider

class LeaderboardFragment : Fragment() {

  private var _binding: FragmentLeaderboardBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentLeaderboardBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.leaderboardFragment.setContent { CreateLeaderboardFragment() }
  }

  override fun onDestroyView() {
    _binding = null
    super.onDestroyView()
  }

  @Preview(showBackground = true)
  @Composable
  fun CreateLeaderboardFragment() {
    Column() {
      CreateLeaderboardTitle()
      CreateLazyColumn()
    }
  }

  @Composable
  fun CreateLeaderboardTitle() {
    Box(contentAlignment = Alignment.TopCenter) {
      Text(
        modifier = Modifier
          .border(BorderStroke(2.dp, Color.Blue))
          .padding(8.dp),
        text = stringResource(string.leaderboard),
        fontSize = 30.sp
      )
    }
  }

  @Composable
  fun CreateLazyColumn() {
    val leaderboards = remember { DataProvider.leaderboardList }

    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
      items(
        items = leaderboards,
        itemContent = { LeaderboardListItem(leaderboard = it) }
      )
    }
  }
}