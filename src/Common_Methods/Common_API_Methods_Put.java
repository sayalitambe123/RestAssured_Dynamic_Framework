package Common_Methods;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Common_API_Methods_Put {
	public static int ResponseStatusCode(String BaseURI, String Resource, String ResponseBody) {
		RestAssured.baseURI = BaseURI;
		int ResponseCode = given().header("Content-Type", "application/json").body(ResponseBody).when().put(Resource)
				.then().extract().statusCode();

		return ResponseCode;
	}
	
	public static String ResponseBody(String BaseURI, String Resource, String ResponseBody) {
		RestAssured.baseURI = BaseURI;
		String Response = given().header("Content-Type", "application/json").body(ResponseBody).when().put(Resource)
				.then().extract().response().asPrettyString();

		return Response;
	}

}
