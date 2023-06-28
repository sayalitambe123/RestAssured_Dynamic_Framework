package Common_Methods;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Common_API_Methods_Get {
	public static int ResponseStatusCode(String BaseURI, String Resource) {
		RestAssured.baseURI = BaseURI;
		int ResponseCode = given().header("Content-Type", "application/json").when().get(Resource)
				.then().extract().statusCode();

		return ResponseCode;
	}

	public static String ResponseBody(String BaseURI, String Resource) {
		RestAssured.baseURI = BaseURI;
		String Response = given().header("Content-Type", "application/json").when().get(Resource)
				.then().extract().response().asPrettyString();

		return Response;
	}

}
