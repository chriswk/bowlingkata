/** Project **/
name := "bowling-kata"

organization := "com.chriswk"

version := "1.0-SNAPSHOT"

scalaVersion := "2.9.1"

shellPrompt := { state => System.getProperty("user.name") +"> " }

resolvers ++= Seq("snapshots-repo" at "http://scala-tools.org/repo-snapshots",
				  "snapshots releases" at "http://scala-tools.org/repo-releases")
				