package org.musicmatch.repositories

import anorm._
import play.api.db.DB
import play.api.Play.current
import com.github.nscala_time.time.Imports._
import org.musicmatch.repositories.AnormExtensions._

object RecommendationsRepository {
  lazy val findByUserIdQuery = SQL("SELECT * FROM recommendations INNER JOIN songs ON recommendations.song_id = songs.id INNER JOIN artists ON songs.artist_id = artists.id WHERE recommendations.user_id = {userId} ORDER BY created_at DESC")

  def findByUserId(userId: Long) = DB.withConnection { implicit c =>
    findByUserIdQuery.on("userId" -> userId)().map { row =>
      new RecommendationMapper(row).get
    }.toList
  }
}