/** Project **/
name := "bowling-kata"

organization := "com.chriswk"

version := "1.0-SNAPSHOT"

scalaVersion := "2.9.1"

shellPrompt := { state => System.getProperty("user.name") +"> " }

resolvers ++= Seq("snapshots-repo" at "http://scala-tools.org/repo-snapshots",
				  "snapshots releases" at "http://scala-tools.org/repo-releases",
				 "sbt-idea-repo" at "http://mpeltonen.github.com/maven/")
				
libraryDependencies ++= Seq("org.specs2" %% "specs2" % "1.6.1",
							"org.specs2" %% "specs2-scalaz-core" % "6.0.1" % "test",
							"com.github.mpeltonen" %% "sbt-idea" % "0.10.0")
				