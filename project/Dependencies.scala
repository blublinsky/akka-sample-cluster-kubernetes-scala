import Versions._
import sbt._

object Dependencies {

  val akkaHTTP            = "com.typesafe.akka"             %% "akka-http"                            % akkaHttpVersion
  val akkaSpray           = "com.typesafe.akka"             %% "akka-http-spray-json"                 % akkaHttpVersion
  val akkaCluster         = "com.typesafe.akka"             %% "akka-cluster-typed"                   % akkaVersion
  val akkaSharding        = "com.typesafe.akka"             %% "akka-cluster-sharding-typed"          % akkaVersion
  val akkaStreams         = "com.typesafe.akka"             %% "akka-stream-typed"                    % akkaVersion
  val akkaDiscovery       = "com.typesafe.akka"             %% "akka-discovery"                       % akkaVersion
  val akkaDiscoveryK8     = "com.lightbend.akka.discovery"  %% "akka-discovery-kubernetes-api"        % akkaManagementVersion
  val akkaBootstrap       = "com.lightbend.akka.management" %% "akka-management-cluster-bootstrap"    % akkaManagementVersion
  val akkaManagement      = "com.lightbend.akka.management" %% "akka-management-cluster-http"         % akkaManagementVersion

  val logback             = "ch.qos.logback"                % "logback-classic"                       % logbackVersion

//  val akkaTestkit         = "com.typesafe.akka"             %% "akka-testkit"                         % akkaVersion       % Test
//  val akkaActorTestkit    = "com.typesafe.akka"             %% "akka-actor-testkit-typed"             % akkaVersion       % Test
//  val akkaHTTPTestkit     = "com.typesafe.akka"             %% "akka-http-testkit"                    % akkaHttpVersion   % Test
//  val akkaStreamTestkit   = "com.typesafe.akka"             %% "akka-stream-testkit"                  % akkaVersion       % Test
}
