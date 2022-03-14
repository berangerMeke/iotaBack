import _root_.io.gatling.core.scenario.Simulation
import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.slf4j.LoggerFactory

import scala.concurrent.duration._

/**
 * Performance test for the APropos entity.
 */
class AProposGatlingTest extends Simulation {

    val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
    // Log all HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("TRACE"))
    // Log failed HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("DEBUG"))

    val baseURL = Option(System.getProperty("baseURL")) getOrElse """http://localhost:8080"""

    val httpConf = http
        .baseUrl(baseURL)
        .inferHtmlResources()
        .acceptHeader("*/*")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
        .connectionHeader("keep-alive")
        .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:33.0) Gecko/20100101 Firefox/33.0")
        .silentResources // Silence all resources like css or css so they don't clutter the results

    val headers_http = Map(
        "Accept" -> """application/json"""
    )

    val headers_http_authentication = Map(
        "Content-Type" -> """application/json""",
        "Accept" -> """application/json"""
    )

    val headers_http_authenticated = Map(
        "Accept" -> """application/json""",
        "Authorization" -> "${access_token}"
    )

    val scn = scenario("Test the APropos entity")
        .exec(http("First unauthenticated request")
        .get("/api/account")
        .headers(headers_http)
        .check(status.is(401))
        ).exitHereIfFailed
        .pause(10)
        .exec(http("Authentication")
        .post("/api/authenticate")
        .headers(headers_http_authentication)
        .body(StringBody("""{"username":"admin", "password":"admin"}""")).asJson
        .check(header("Authorization").saveAs("access_token"))).exitHereIfFailed
        .pause(2)
        .exec(http("Authenticated request")
        .get("/api/account")
        .headers(headers_http_authenticated)
        .check(status.is(200)))
        .pause(10)
        .repeat(2) {
            exec(http("Get all aPropos")
            .get("/api/a-propos")
            .headers(headers_http_authenticated)
            .check(status.is(200)))
            .pause(10 seconds, 20 seconds)
            .exec(http("Create new aPropos")
            .post("/api/a-propos")
            .headers(headers_http_authenticated)
            .body(StringBody("""{
                "id":null
                , "titreFr":"SAMPLE_TEXT"
                , "titreEn":"SAMPLE_TEXT"
                , "titreGer":"SAMPLE_TEXT"
                , "titreSw":"SAMPLE_TEXT"
                , "sousTitreFr":"SAMPLE_TEXT"
                , "sousTitreEn":"SAMPLE_TEXT"
                , "sousTitreGer":"SAMPLE_TEXT"
                , "sousTitreSw":"SAMPLE_TEXT"
                , "textParagraphe1Fr":"SAMPLE_TEXT"
                , "textParagraphe1En":"SAMPLE_TEXT"
                , "textParagraphe1Ger":"SAMPLE_TEXT"
                , "textParagraphe1Sw":"SAMPLE_TEXT"
                , "textParagraphe2Fr":"SAMPLE_TEXT"
                , "textParagraphe2En":"SAMPLE_TEXT"
                , "textParagraphe2Ger":"SAMPLE_TEXT"
                , "textParagraphe2Sw":"SAMPLE_TEXT"
                , "textParagraphe3Fr":"SAMPLE_TEXT"
                , "textParagraphe3En":"SAMPLE_TEXT"
                , "textParagraphe3Ger":"SAMPLE_TEXT"
                , "textParagraphe3Sw":"SAMPLE_TEXT"
                , "textParagraphe4Fr":"SAMPLE_TEXT"
                , "textParagraphe4En":"SAMPLE_TEXT"
                , "textParagraphe4Ger":"SAMPLE_TEXT"
                , "textParagraphe4Sw":"SAMPLE_TEXT"
                , "textParagraphe5Fr":"SAMPLE_TEXT"
                , "textParagraphe5En":"SAMPLE_TEXT"
                , "textParagraphe5Ger":"SAMPLE_TEXT"
                , "textParagraphe5Sw":"SAMPLE_TEXT"
                , "image":null
                }""")).asJson
            .check(status.is(201))
            .check(headerRegex("Location", "(.*)").saveAs("new_aPropos_url"))).exitHereIfFailed
            .pause(10)
            .repeat(5) {
                exec(http("Get created aPropos")
                .get("${new_aPropos_url}")
                .headers(headers_http_authenticated))
                .pause(10)
            }
            .exec(http("Delete created aPropos")
            .delete("${new_aPropos_url}")
            .headers(headers_http_authenticated))
            .pause(10)
        }

    val users = scenario("Users").exec(scn)

    setUp(
        users.inject(rampUsers(Integer.getInteger("users", 100)) during (Integer.getInteger("ramp", 1) minutes))
    ).protocols(httpConf)
}
