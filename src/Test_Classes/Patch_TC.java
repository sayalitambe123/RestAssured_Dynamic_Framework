package Test_Classes;
import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import Common_Methods.Common_API_Methods_Patch;
import Common_Methods.Common_Utility_Method;
import Request_Repository.Patch_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Patch_TC {
	
	public static void extractor() throws IOException {
		int statusCode = Common_API_Methods_Patch.ResponseStatusCode(Patch_Req_Repository.BaseURI(), Patch_Req_Repository.Resource()
				, Patch_Req_Repository.RequestBody() );
		System.out.println("Status Code : "+statusCode);
		
		
		String responseBody = Common_API_Methods_Patch.ResponseBody(Patch_Req_Repository.BaseURI(), Patch_Req_Repository.Resource()
				, Patch_Req_Repository.RequestBody() );
		System.out.println("Response Body is : \n"+responseBody);
		
		String RequestBody = Patch_Req_Repository.RequestBody();
		validator(RequestBody, responseBody);
		Common_Utility_Method.EvidenceFileCreator("PatchTC", RequestBody, responseBody, statusCode);
		
	}
	
	public static void validator(String RequestBody, String ResponseBody) {
		JsonPath jspRequest = new JsonPath(RequestBody);
		String req_name = jspRequest.getString("name");
		String req_job = jspRequest.getString("job");
		LocalDateTime current = LocalDateTime.now();
		String currenttime = current.toString().substring(0,10);
		
		JsonPath jspResponse = new JsonPath(ResponseBody);
		String res_name = jspResponse.getString("name");
		String res_job = jspResponse.getString("job");
		String res_updatedAt = jspResponse.getString("updatedAt");
		res_updatedAt = res_updatedAt.substring(0,10);
		
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertEquals(res_updatedAt, currenttime);
		
		
	}

}
