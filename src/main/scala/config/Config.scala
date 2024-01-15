package dev.khusanjon
package config

import cats.effect.IO
import io.circe.config.parser
import io.circe.generic.auto._


case class ServerConfig(port: Int, host: String)

case class DbConfig(url: String, username: String, password: String, poolSize: Int)

case class Config(serverConfig: ServerConfig, dbConfig: DbConfig)

object Config {
  /*
   * use this appliation.conf file
    server {
      host = "0.0.0.0"
      port = 8761
    }
    db {
      url = "jdbc:mysql://localhost:3306/mystiko"
      username = "root"
      password = "root"
      poolSize = 10
    }
   */

  def load(): IO[Config] = {
    for {
      dbConf <- parser.decodePathF[IO, DbConfig]("db")
      serverConf <- parser.decodePathF[IO, ServerConfig]("server")
    } yield Config(serverConf, dbConf)
  }
}
