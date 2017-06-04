package Junit;

import org.junit.Before;

public class TestBase {
	
	public boolean isAbove50(double first, double second) {
		if (first + second > 50) {
			return false;
		}

		return true;
	}
	
}
