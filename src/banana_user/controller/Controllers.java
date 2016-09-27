package banana_user.controller;


public class Controllers {
	
	private static ProgramController programController;
	
	public Controllers() {
		
		programController = new ProgramController();
		
	}

	public static ProgramController getProgramController() {

		return programController;

	}


}
