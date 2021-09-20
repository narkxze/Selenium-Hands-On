package week3.day2.assignments;

public class Desktop implements HardWare, SoftWare { //Multiple-Inheritance
	public void softwareResources() {
		System.out.println("Software Resources Method is succesfully called!");
	}

	public void hardwareResources() {
		System.out.println("Hardware Resources Method is succesfully called!");
	}

	public void desktopModel() {
		System.out.println("Desktop Model Method is successfully called!");
	}

	public static void main(String[] args) {
		Desktop desktop = new Desktop();
		desktop.softwareResources();
		desktop.hardwareResources();
		desktop.desktopModel();
	}
}
