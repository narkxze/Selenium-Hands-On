package org.system;

public class MainMethodClass {
	public static void main(String[] args) {
		Desktop pc =new Desktop();
		pc.computerModel("Dell");
		pc.desktopSize(22); 
		/* The Object reference "pc"  is created for "Desktop" class alone yet it can access
		 * the method of  "Computer" class because of Inheritance Concept.
		 * In this Case, Single Inheritance is followed.
		 */

	}

}
