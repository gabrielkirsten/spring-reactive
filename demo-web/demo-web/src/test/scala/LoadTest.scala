import io.gatling.core.Predef._
import io.gatling.http.Predef._

class LoadTest extends Simulation {
  val httpProtocol = http
    .baseUrl("http://localhost:8180")
    .acceptHeader("*/*")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val requestBody = StringBody("""{"name": "Customer name"}""")

  val scn = scenario("100 requests - customer")
    .exec(
      http("Post Customers")
        .post("/customers")
        .header("Content-Type", "application/json")
        .body(requestBody).asJson
    ).pause(1)
    .exec(
      http("Post Customers")
        .post("/customers")
        .header("Content-Type", "application/json")
        .body(requestBody).asJson
    ).pause(1)
    .exec(
      http("Post Customers")
        .post("/customers")
        .header("Content-Type", "application/json")
        .body(requestBody).asJson
    ).pause(1)
    .exec(
      http("Post Customers")
        .post("/customers")
        .header("Content-Type", "application/json")
        .body(requestBody).asJson
    ).pause(1)
    .exec(
      http("Post Customers")
        .post("/customers")
        .header("Content-Type", "application/json")
        .body(requestBody).asJson
    )

  setUp(scn.inject(atOnceUsers(10000)).protocols(httpProtocol))
}