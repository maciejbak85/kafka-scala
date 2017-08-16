name := "kafka-scala"

version := "1.0"

scalaVersion := "2.12.1"

val akkaVer = "2.5.3"

val loggingDeps = Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.7.1",
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVer,
  "com.typesafe.akka" %% "akka-testkit" % akkaVer % Test,
  "com.typesafe.akka" %% "akka-stream" % akkaVer,
  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVer % Test,
  "com.typesafe.akka" %% "akka-stream-kafka" % "0.16",
  "com.typesafe.akka" %% "akka-slf4j" % akkaVer
) ++ loggingDeps
