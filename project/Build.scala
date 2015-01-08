import sbt._
import sbt.Keys._

object DispatcherBuild extends Build {
  val appName = "dispatcher-sample"
  val main = Project(appName, file("."))
    .settings(
      version := "1.0-SNAPSHOT",
      scalaVersion := "2.11.4",
      javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation"),
      scalacOptions ++= Seq("-Xlint", "-deprecation", "-unchecked", "-feature"),
      resolvers ++= Seq(
        "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
      ),
      libraryDependencies ++= Seq(
        "com.typesafe.akka" %% "akka-actor" % "2.3.8",
        "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
//        "ch.qos.logback" % "logback-classic" % "1.1.2"
        "org.slf4j" % "slf4j-simple" % "1.7.9"
      )
    )
}
