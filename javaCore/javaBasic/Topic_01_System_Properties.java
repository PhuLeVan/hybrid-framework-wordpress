package javaBasic;

public class Topic_01_System_Properties {

	public static void main(String[] args) {
		String projectLocation = System.getProperty("user.dir");
		System.out.println(projectLocation);
	}

}
