package dev.khusanjon

import cats.effect.IO
import io.circe.generic.auto._
import org.http4s._
import org.http4s.circe.CirceEntityCodec._
import org.http4s.dsl.Http4sDsl

object AccountRoutes {
  /**
   * define following APIS
   *   1. create account — POST api/v1/accounts
   *   2. update account — PUT api/v1/accounts/{id}
   *   3. get account — GET api/v1/accounts/{id}
   *   4. search accounts — GET api/v1/accounts
   */
  def routes(documentRepo: AccountRepo): HttpRoutes[IO] = {
    val dsl = new Http4sDsl[IO] {}
    import dsl._

    HttpRoutes.of[IO] {
      case req@POST -> Root / "accounts" =>
        req.decode[Account] { acc =>
          documentRepo.createAccount(acc).flatMap(id => Created(id))
        }.handleErrorWith(e => BadRequest(e.getMessage))
      case req@PUT -> Root / "accounts" / id =>
        req.decode[Account] { acc =>
          documentRepo.updateAccount(id, acc).flatMap(_ => Accepted())
        }.handleErrorWith(e => BadRequest(e.getMessage))
      case _@GET -> Root / "accounts" =>
        documentRepo.getAccounts().flatMap(accs => Ok(accs))
      case _@GET -> Root / "accounts" / id =>
        documentRepo.getAccount(id) flatMap {
          case None => NotFound()
          case Some(acc) => Ok(acc)
        }
    }
  }
}