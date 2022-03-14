import _root_.io.gatling.core.scenario.Simulation
import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.slf4j.LoggerFactory

import scala.concurrent.duration._

/**
 * Performance test for the FAQs entity.
 */
class FAQsGatlingTest extends Simulation {

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

    val scn = scenario("Test the FAQs entity")
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
            exec(http("Get all fAQs")
            .get("/api/fa-qs")
            .headers(headers_http_authenticated)
            .check(status.is(200)))
            .pause(10 seconds, 20 seconds)
            .exec(http("Create new fAQs")
            .post("/api/fa-qs")
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
                , "titreAccordion1Fr":"SAMPLE_TEXT"
                , "titreAccordion1En":"SAMPLE_TEXT"
                , "titreAccordion1Gr":"SAMPLE_TEXT"
                , "titreAccordion1Sw":"SAMPLE_TEXT"
                , "titreAccordion2Fr":"SAMPLE_TEXT"
                , "titreAccordion2En":"SAMPLE_TEXT"
                , "titreAccordion2Ger":"SAMPLE_TEXT"
                , "titreAccordion2Sw":"SAMPLE_TEXT"
                , "titreAccordion3Fr":"SAMPLE_TEXT"
                , "titreAccordion3En":"SAMPLE_TEXT"
                , "titreAccordion3Ger":"SAMPLE_TEXT"
                , "titreAccordion3Sw":"SAMPLE_TEXT"
                , "titreAccordion4Fr":"SAMPLE_TEXT"
                , "titreAccordion4En":"SAMPLE_TEXT"
                , "titreAccordion4Ger":"SAMPLE_TEXT"
                , "titreAccordion4Sw":"SAMPLE_TEXT"
                , "titreAccordion5Fr":"SAMPLE_TEXT"
                , "titreAccordion5En":"SAMPLE_TEXT"
                , "titreAccordion5Ger":"SAMPLE_TEXT"
                , "titreAccordion5Sw":"SAMPLE_TEXT"
                , "titreAccordion6Fr":"SAMPLE_TEXT"
                , "titreAccordion6En":"SAMPLE_TEXT"
                , "titreAccordion6Ger":"SAMPLE_TEXT"
                , "titreAccordion6Sw":"SAMPLE_TEXT"
                , "titreAccordion7Fr":"SAMPLE_TEXT"
                , "titreAccordion7En":"SAMPLE_TEXT"
                , "titreAccordion7Ger":"SAMPLE_TEXT"
                , "titreAccordion7Sw":"SAMPLE_TEXT"
                , "titreAccordion8Fr":"SAMPLE_TEXT"
                , "titreAccordion8En":"SAMPLE_TEXT"
                , "titreAccordion8Ger":"SAMPLE_TEXT"
                , "titreAccordion8Sw":"SAMPLE_TEXT"
                , "titreAccordion9Fr":"SAMPLE_TEXT"
                , "titreAccordion9En":"SAMPLE_TEXT"
                , "titreAccordion9Ger":"SAMPLE_TEXT"
                , "titreAccordion9Sw":"SAMPLE_TEXT"
                , "titreAccordion10Fr":"SAMPLE_TEXT"
                , "titreAccordion10En":"SAMPLE_TEXT"
                , "titreAccordion10Ger":"SAMPLE_TEXT"
                , "titreAccordion10Sw":"SAMPLE_TEXT"
                , "textAccordion1Fr":"SAMPLE_TEXT"
                , "textAccordion1En":"SAMPLE_TEXT"
                , "textAccordion1Ger":"SAMPLE_TEXT"
                , "textAccordion1Sw":"SAMPLE_TEXT"
                , "textAccordion2Fr":"SAMPLE_TEXT"
                , "textAccordion2En":"SAMPLE_TEXT"
                , "textAccordion2Ger":"SAMPLE_TEXT"
                , "textAccordion2Sw":"SAMPLE_TEXT"
                , "textAccordion3Fr":"SAMPLE_TEXT"
                , "textAccordion3En":"SAMPLE_TEXT"
                , "textAccordion3Ger":"SAMPLE_TEXT"
                , "textAccordion3Sw":"SAMPLE_TEXT"
                , "textAccordion4Fr":"SAMPLE_TEXT"
                , "textAccordion4En":"SAMPLE_TEXT"
                , "textAccordion4Ger":"SAMPLE_TEXT"
                , "textAccordion4Sw":"SAMPLE_TEXT"
                , "textAccordion5Fr":"SAMPLE_TEXT"
                , "textAccordion5En":"SAMPLE_TEXT"
                , "textAccordion5Ger":"SAMPLE_TEXT"
                , "textAccordion5Sw":"SAMPLE_TEXT"
                , "textAccordion6Fr":"SAMPLE_TEXT"
                , "textAccordion6En":"SAMPLE_TEXT"
                , "textAccordion6Ger":"SAMPLE_TEXT"
                , "textAccordion6Sw":"SAMPLE_TEXT"
                , "textAccordion7Fr":"SAMPLE_TEXT"
                , "textAccordion7En":"SAMPLE_TEXT"
                , "textAccordion7Ger":"SAMPLE_TEXT"
                , "textAccordion7Sw":"SAMPLE_TEXT"
                , "textAccordion8Fr":"SAMPLE_TEXT"
                , "textAccordion8En":"SAMPLE_TEXT"
                , "textAccordion8Ger":"SAMPLE_TEXT"
                , "textAccordion8Sw":"SAMPLE_TEXT"
                , "textAccordion9Fr":"SAMPLE_TEXT"
                , "textAccordion9En":"SAMPLE_TEXT"
                , "textAccordion9Ger":"SAMPLE_TEXT"
                , "textAccordion9Sw":"SAMPLE_TEXT"
                , "textAccordion10Fr":"SAMPLE_TEXT"
                , "textAccordion10En":"SAMPLE_TEXT"
                , "textAccordion10Ger":"SAMPLE_TEXT"
                , "textAccordion10Sw":"SAMPLE_TEXT"
                }""")).asJson
            .check(status.is(201))
            .check(headerRegex("Location", "(.*)").saveAs("new_fAQs_url"))).exitHereIfFailed
            .pause(10)
            .repeat(5) {
                exec(http("Get created fAQs")
                .get("${new_fAQs_url}")
                .headers(headers_http_authenticated))
                .pause(10)
            }
            .exec(http("Delete created fAQs")
            .delete("${new_fAQs_url}")
            .headers(headers_http_authenticated))
            .pause(10)
        }

    val users = scenario("Users").exec(scn)

    setUp(
        users.inject(rampUsers(Integer.getInteger("users", 100)) during (Integer.getInteger("ramp", 1) minutes))
    ).protocols(httpConf)
}
