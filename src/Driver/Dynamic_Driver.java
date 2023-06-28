package Driver;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import Common_Methods.Common_Utility_Method;

public class Dynamic_Driver {

	public static void main(String[] args)
			throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// Read the test class names from excel
		ArrayList<String> TestCaseToRun = Common_Utility_Method.readDataExcel("TestCase", "TestCaseToExecute");

		// find size of array list
		int count = TestCaseToRun.size();
		for (int i = 1; i < count; i++) {
			String TestCaseName = TestCaseToRun.get(i);
			System.out.println("\n\n"+TestCaseName);
			// Call test class at runtime using lava.lang.reflect
			Class<?> testclassname = Class.forName("Test_Classes." + TestCaseName);

			// Call executor method belonging to test class
			Method executeMethod = testclassname.getDeclaredMethod("extractor");

			// set accessibility to true(accessible)
			executeMethod.setAccessible(true);

			// Create an instance of test class capture in testclassname
			Object instanceofClass = testclassname.getDeclaredConstructor().newInstance();

			// execute test class captured in variable name testclassname
			executeMethod.invoke(instanceofClass);
		}

	}
}
