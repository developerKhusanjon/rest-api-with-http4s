name := "scala-rest-api-with-http4s-doobie"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.13.12"

idePackagePrefix := Some("dev.khusanjon")

libraryDependencies ++= {

  lazy val doobieVersion = "0.13.4"
  lazy val http4sVersion = "0.23.18"
  lazy val circeVersion = "0.14.5"

  Seq(
    "org.tpolecat" %% "doobie-core" % doobieVersion,
    "org.tpolecat" %% "doobie-h2" % doobieVersion,
    "org.tpolecat" %% "doobie-hikari" % doobieVersion,
    "org.tpolecat" %% "doobie-specs2" % doobieVersion,
    "org.http4s" %% "http4s-blaze-server" % http4sVersion,
    "org.http4s" %% "http4s-circe" % http4sVersion,
    "org.http4s" %% "http4s-dsl" % http4sVersion,
    "io.circe" %% "circe-core" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-config" % "0.10.0",
    "mysql" % "mysql-connector-java" % "8.0.33",
    "org.slf4j" % "slf4j-api" % "2.0.5",
    "ch.qos.logback" % "logback-classic" % "1.4.7"
  )

}

resolvers += Resolver.typesafeRepo("releases")
