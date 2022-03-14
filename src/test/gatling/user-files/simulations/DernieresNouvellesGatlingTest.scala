import _root_.io.gatling.core.scenario.Simulation
import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.slf4j.LoggerFactory

import scala.concurrent.duration._

/**
 * Performance test for the DernieresNouvelles entity.
 */
class DernieresNouvellesGatlingTest extends Simulation {

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

    val scn = scenario("Test the DernieresNouvelles entity")
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
            exec(http("Get all dernieresNouvelles")
            .get("/api/dernieres-nouvelles")
            .headers(headers_http_authenticated)
            .check(status.is(200)))
            .pause(10 seconds, 20 seconds)
            .exec(http("Create new dernieresNouvelles")
            .post("/api/dernieres-nouvelles")
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
                , "titreSlide1Fr":"SAMPLE_TEXT"
                , "titreSlide1En":"SAMPLE_TEXT"
                , "titreSlide1Ger":"SAMPLE_TEXT"
                , "titreSlide1Sw":"SAMPLE_TEXT"
                , "titreSlide2Fr":"SAMPLE_TEXT"
                , "titreSlide2En":"SAMPLE_TEXT"
                , "titreSlide2Ger":"SAMPLE_TEXT"
                , "titreSlide2Sw":"SAMPLE_TEXT"
                , "titreSlide3Fr":"SAMPLE_TEXT"
                , "titreSlide3En":"SAMPLE_TEXT"
                , "titreSlide3Ger":"SAMPLE_TEXT"
                , "titreSlide3Sw":"SAMPLE_TEXT"
                , "titreSlide4Fr":"SAMPLE_TEXT"
                , "titreSlide4En":"SAMPLE_TEXT"
                , "titreSlide4Ger":"SAMPLE_TEXT"
                , "titreSlide4Sw":"SAMPLE_TEXT"
                , "titreSlide5Fr":"SAMPLE_TEXT"
                , "titreSlide5En":"SAMPLE_TEXT"
                , "titreSlide5Ger":"SAMPLE_TEXT"
                , "titreSlide5Sw":"SAMPLE_TEXT"
                , "titreSlide6Fr":"SAMPLE_TEXT"
                , "titreSlide6En":"SAMPLE_TEXT"
                , "titreSlide6Ger":"SAMPLE_TEXT"
                , "titreSlide6Sw":"SAMPLE_TEXT"
                , "titreSlide7Fr":"SAMPLE_TEXT"
                , "titreSlide7En":"SAMPLE_TEXT"
                , "titreSlide7Ger":"SAMPLE_TEXT"
                , "titreSlide7Sw":"SAMPLE_TEXT"
                , "titreSlide8Fr":"SAMPLE_TEXT"
                , "titreSlide8En":"SAMPLE_TEXT"
                , "titreSlide8Ger":"SAMPLE_TEXT"
                , "titreSlide8Sw":"SAMPLE_TEXT"
                , "titreSlide9Fr":"SAMPLE_TEXT"
                , "titreSlide9En":"SAMPLE_TEXT"
                , "titreSlide9Ger":"SAMPLE_TEXT"
                , "titreSlide9Sw":"SAMPLE_TEXT"
                , "titreSlide1OFr":"SAMPLE_TEXT"
                , "titreSlide1OEn":"SAMPLE_TEXT"
                , "titreSlide1OGer":"SAMPLE_TEXT"
                , "titreSlide1OSw":"SAMPLE_TEXT"
                , "textSlide1Fr":"SAMPLE_TEXT"
                , "textSlide1En":"SAMPLE_TEXT"
                , "textSlide1Ger":"SAMPLE_TEXT"
                , "textSlide1Sw":"SAMPLE_TEXT"
                , "textSlide2Fr":"SAMPLE_TEXT"
                , "textSlide2En":"SAMPLE_TEXT"
                , "textSlide2Ger":"SAMPLE_TEXT"
                , "textSlide2Sw":"SAMPLE_TEXT"
                , "textSlide3Fr":"SAMPLE_TEXT"
                , "textSlide3En":"SAMPLE_TEXT"
                , "textSlide3Ger":"SAMPLE_TEXT"
                , "textSlide3Sw":"SAMPLE_TEXT"
                , "textSlide4Fr":"SAMPLE_TEXT"
                , "textSlide4En":"SAMPLE_TEXT"
                , "textSlide4Ger":"SAMPLE_TEXT"
                , "textSlide4Sw":"SAMPLE_TEXT"
                , "textSlide5Fr":"SAMPLE_TEXT"
                , "textSlide5En":"SAMPLE_TEXT"
                , "textSlide5Ger":"SAMPLE_TEXT"
                , "textSlide5Sw":"SAMPLE_TEXT"
                , "textSlide6Fr":"SAMPLE_TEXT"
                , "textSlide6En":"SAMPLE_TEXT"
                , "textSlide6Ger":"SAMPLE_TEXT"
                , "textSlide6Sw":"SAMPLE_TEXT"
                , "textSlide7Fr":"SAMPLE_TEXT"
                , "textSlide7En":"SAMPLE_TEXT"
                , "textSlide7Ger":"SAMPLE_TEXT"
                , "textSlide7Sw":"SAMPLE_TEXT"
                , "textSlide8Fr":"SAMPLE_TEXT"
                , "textSlide8En":"SAMPLE_TEXT"
                , "textSlide8Ger":"SAMPLE_TEXT"
                , "textSlide8Sw":"SAMPLE_TEXT"
                , "textSlide9Fr":"SAMPLE_TEXT"
                , "textSlide9En":"SAMPLE_TEXT"
                }""")).asJson
            .check(status.is(201))
            .check(headerRegex("Location", "(.*)").saveAs("new_dernieresNouvelles_url"))).exitHereIfFailed
            .pause(10)
            .repeat(5) {
                exec(http("Get created dernieresNouvelles")
                .get("${new_dernieresNouvelles_url}")
                .headers(headers_http_authenticated))
                .pause(10)
            }
            .exec(http("Delete created dernieresNouvelles")
            .delete("${new_dernieresNouvelles_url}")
            .headers(headers_http_authenticated))
            .pause(10)
        }

    val users = scenario("Users").exec(scn)

    setUp(
        users.inject(rampUsers(Integer.getInteger("users", 100)) during (Integer.getInteger("ramp", 1) minutes))
    ).protocols(httpConf)
}
