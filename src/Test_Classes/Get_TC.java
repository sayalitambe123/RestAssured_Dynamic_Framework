package Test_Classes;

import Common_Methods.Common_API_Methods_Get;
import Request_Repository.Get_Req_Repository;

public class Get_TC {
	public static void extractor() {
		int statusCode = Common_API_Methods_Get.ResponseStatusCode(Get_Req_Repository.BaseURI(),
				Get_Req_Repository.Resource());
		System.out.println("Status Code : " + statusCode);

		String responseBody = Common_API_Methods_Get.ResponseBody(Get_Req_Repository.BaseURI(),
				Get_Req_Repository.Resource());
		System.out.println("Response Body is : \n" + responseBody);

	}
}
