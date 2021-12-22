package com.panhuk.repository_impl

import com.panhuk.database.LeaderboardDB
import com.panhuk.domain.model.Leaderboard
import java.time.LocalDateTime

fun Leaderboard.mapToDB(): LeaderboardDB {
  return LeaderboardDB(imageId, username, score, scoreLocalDate.toString())
}

fun LeaderboardDB.mapToDomain(): Leaderboard {
  return Leaderboard(imageId, username, score, LocalDateTime.parse(scoreLocalDate))
}