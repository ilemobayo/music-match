name := "music-match"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "postgresql" % "postgresql" % "9.1-901.jdbc4",
  "com.github.nscala-time" %% "nscala-time" % "0.6.0",
  "com.nulab-inc" %% "play2-oauth2-provider" % "0.3.0"
)     

resolvers += Resolver.url("SBT Plugin Releases", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)

play.Project.playScalaSettings
