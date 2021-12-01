package com.example.leaderboardfeature.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.leaderboardfeature.date.DateType
import com.example.leaderboardfeature.date.DateType.DAYS
import com.example.leaderboardfeature.date.DateType.HOURS
import com.example.leaderboardfeature.date.DateType.MINUTES
import com.example.leaderboardfeature.date.DateType.MONTHS
import com.example.leaderboardfeature.date.DateType.YEARS
import com.example.leaderboardfeature.R.string
import com.example.leaderboardfeature.date.getDateAgo
import com.example.leaderboardfeature.model.Leaderboard

@Composable
fun LeaderboardListItem(leaderboard: Leaderboard) {
  Card(
    modifier = Modifier
      .padding(horizontal = 8.dp, vertical = 8.dp)
      .fillMaxWidth(),
    elevation = 2.dp,
    backgroundColor = Color.White,
    shape = RoundedCornerShape(corner = CornerSize(16.dp))
  ) {
    Row {
      LeaderboardImage(leaderboard)
      Column(
        modifier = Modifier
          .padding(16.dp)
          .align(Alignment.CenterVertically)
      ) {
        LeaderboardUsernameAndScore(leaderboard)
      }
    }

    val date = getDateAgo(leaderboard.date)
    val dateFormatted = formatDate(date)
    LeaderBoardSetTimeAgo(dateFormatted)
  }
}

@Composable
private fun LeaderboardImage(leaderboard: Leaderboard) {
  Image(
    painter = painterResource(id = leaderboard.imageId),
    contentDescription = null,
    contentScale = ContentScale.Crop,
    modifier = Modifier
      .padding(8.dp)
      .size(84.dp)
      .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
  )
}

@Composable
private fun LeaderboardUsernameAndScore(leaderboard: Leaderboard) {
  Text(text = leaderboard.username, style = typography.h6)
  Text(
    text = stringResource(id = string.Score) + leaderboard.score,
    style = typography.caption
  )
}

@Composable
private fun formatDate(date: Pair<DateType, Long>): String {
  return when (date.first) {
    MINUTES -> stringResource(id = string.minutes_ago, date.second)
    HOURS -> stringResource(id = string.hours_ago, date.second)
    DAYS -> stringResource(id = string.days_ago, date.second)
    MONTHS -> stringResource(id = string.months_ago, date.second)
    YEARS -> stringResource(id = string.years_ago, date.second)
  }
}

@Composable
private fun LeaderBoardSetTimeAgo(date: String) {
  Box {
    Text(
      text = date,
      modifier = Modifier
        .align(Alignment.BottomEnd)
        .padding(top = 10.dp, end = 20.dp),
      style = typography.subtitle1
    )
  }
}
