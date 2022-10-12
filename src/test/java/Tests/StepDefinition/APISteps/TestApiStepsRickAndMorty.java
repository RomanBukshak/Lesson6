package Tests.StepDefinition.APISteps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static utils.Configuration.getConfigurationValue;

public class TestApiStepsRickAndMorty {
    public static String mortySmithID;
    public static String mortySmithLocation;
    public static int mortySmithLastEpisode;
    public static String mortySmithSpecies;
    public static int lastEpisodeID;
    public static String lastEpisodeName;
    public static int lastCharacterInLastEpisodeID;
    public static String lastCharacterInLastEpisodeName;
    public static String lastCharacterInLastEpisodeSpecies;
    public static String lastCharacterInLastEpisodeLocation;

    @Дано("Получить информацию о Морти Смит")
    public static void получитьИнформациюОМортиСмит() {
        Response findInfoAboutMortySmith = given()
                .baseUri(getConfigurationValue("baseUriRickAndMorty"))
                .contentType(ContentType.JSON)
                .when().get("character/?name=Morty Smith&status=alive")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .extract().response();
        JSONObject mortySmith = (JSONObject) new JSONObject(findInfoAboutMortySmith.getBody().asString()).getJSONArray("results").get(0);
        mortySmithID = mortySmith.get("id").toString();
        System.out.println("Morty Smith ID: " + mortySmithID);
        mortySmithLocation = mortySmith.getJSONObject("location").get("name").toString();
        System.out.println("Morty Smith location: " + mortySmithLocation);
        mortySmithSpecies = mortySmith.get("species").toString();
        System.out.println("Morty Smith species: " + mortySmithSpecies);
        int mortySmithNumberLastEpisode = mortySmith.getJSONArray("episode").length()-1;
        mortySmithLastEpisode = Integer.parseInt(mortySmith.getJSONArray("episode").get(mortySmithNumberLastEpisode).toString().replaceAll("[^0-9]",""));
        System.out.println("Morty Smith last episode: " + mortySmithLastEpisode);
    }
    @Затем("Найти последний эпизод")
    public static void найтиПоследнийЭпизод() {
        Response findLastEpisode = given()
                .baseUri(getConfigurationValue("baseUriRickAndMorty"))
                .contentType(ContentType.JSON)
                .when().get("episode")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .extract().response();
        lastEpisodeID = (int) new JSONObject(findLastEpisode.getBody().asString()).getJSONObject("info").get("count");
    }
    @Затем("Найти последнего персонажа последнего эпизода")
    public static void найтиПоследнегоПерсонажаПоследнегоЭпизода() {
        Response findLastCharacterIDInLastEpisode = given()
                .baseUri(getConfigurationValue("baseUriRickAndMorty"))
                .contentType(ContentType.JSON)
                .when().get("episode/" + lastEpisodeID)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .extract().response();
        lastEpisodeName = new JSONObject(findLastCharacterIDInLastEpisode.getBody().asString()).get("name").toString();
        System.out.println("Last episode ID: " + lastEpisodeID);
        System.out.println("Name last episode: " + lastEpisodeName);
        JSONArray characterInLastEpisode = new JSONObject(findLastCharacterIDInLastEpisode.getBody().asString()).getJSONArray("characters");
        int lastCharacterInLastEpisodeNumber = characterInLastEpisode.length()-1;
        lastCharacterInLastEpisodeID = Integer.parseInt(characterInLastEpisode.get(lastCharacterInLastEpisodeNumber).toString().replaceAll("[^0-9]",""));
    }
    @Затем("Получить информацию о последнем персонаже")
    public static void получитьИнформациюОПоследнемПерсонаже() {
        Response infoLastCharacterInLastEpisode = given()
                .baseUri(getConfigurationValue("baseUriRickAndMorty"))
                .contentType(ContentType.JSON)
                .when().get("character/" + lastCharacterInLastEpisodeID)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .extract().response();
        lastCharacterInLastEpisodeName = new JSONObject(infoLastCharacterInLastEpisode.getBody().asString()).get("name").toString();
        System.out.println("Last character in last episode ID: " + lastCharacterInLastEpisodeID);
        System.out.println("Name last character in last episode: " + lastCharacterInLastEpisodeName);
        lastCharacterInLastEpisodeSpecies = new JSONObject(infoLastCharacterInLastEpisode.getBody().asString()).get("species").toString();
        System.out.println(lastCharacterInLastEpisodeName + " species: " + lastCharacterInLastEpisodeSpecies);
        lastCharacterInLastEpisodeLocation =  new JSONObject(infoLastCharacterInLastEpisode.getBody().asString()).getJSONObject("location").get("name").toString();
        System.out.println(lastCharacterInLastEpisodeName + " location: " + lastCharacterInLastEpisodeLocation);
    }
    @И("Проверить совпадения локации")
    public static void проверитьСовпаденияЛокации() {
        String assertSpecies = mortySmithSpecies.equals(lastCharacterInLastEpisodeSpecies) ? "Персонажи одной расы!" : "Персонажи разной расы!";
        System.out.println(assertSpecies);
    }
    @И("Проверить совпадения расы")
    public static void проверитьСовпаденияРасы() {
        String assertLocation = mortySmithLocation.equals(lastCharacterInLastEpisodeLocation) ? "Персонажи находятся в одном месте!" : "Персонажи находятся в разных местах!";
        System.out.println(assertLocation);
    }

}
