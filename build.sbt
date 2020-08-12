import sbt._
import sbt.Keys._
import Dependencies._

organization in ThisBuild := "com.lightbend"

name := "akka-sample-cluster-kubernetes"

scalaVersion := "2.12.10"

// make version compatible with docker for publishing
ThisBuild / dynverSeparator := "-"

scalacOptions := Seq("-feature", "-unchecked", "-deprecation", "-encoding", "utf8")
classLoaderLayeringStrategy := ClassLoaderLayeringStrategy.AllLibraryJars
fork in run := true
Compile / run / fork := true

mainClass in (Compile, run) := Some("akka.sample.cluster.kubernetes.DemoApp")

enablePlugins(JavaServerAppPackaging, DockerPlugin)

dockerExposedPorts := Seq(8080, 8558, 2552)
dockerUpdateLatest := true
dockerRepository := Some("lightbend")
dockerBaseImage := "adoptopenjdk:11-jre-hotspot"

libraryDependencies ++= Seq(akkaHTTP, akkaSpray, akkaCluster, akkaSharding, akkaStreams, akkaDiscovery,
  akkaDiscoveryK8, akkaBootstrap, akkaManagement, logback)

