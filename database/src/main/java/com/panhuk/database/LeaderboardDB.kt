package com.panhuk.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LeaderboardDB(
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo val imageId: Int,
  @ColumnInfo val username: String,
  @ColumnInfo val score: Int,
  @ColumnInfo val scoreLocalDate: String
)