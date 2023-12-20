package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnlyzer implements IRetryAnalyzer {

	//counter to keep track of retry attempts

		int counterForRetryAttempts = 0;

		//create a variable how many times  to retry failed test
		int setMaxLimitForRetry =1;



		//in iRetryAnalyzer a method retry it is unimplemented method
		//so we will implemented in our code .
		@Override
		public boolean retry(ITestResult result) {
			if(!result.isSuccess())
			{
				if(counterForRetryAttempts< setMaxLimitForRetry)
				{
					counterForRetryAttempts++;
					return true;
				}
			}
			return false;
		}

}
