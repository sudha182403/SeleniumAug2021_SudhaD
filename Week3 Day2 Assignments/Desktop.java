package week3.day2;

public class Desktop implements HardWare, Software{
	
	public void desktopModel() {
		System.out.println("Desktop model is Dell 13 inches");
	}
	
	@Override
	public void hardwareResources(){
		System.out.println("Inside hardware interface's method");
	}
	
	@Override
	public void softwareResources() {
		System.out.println("Inside software interface's method");
	}	
	
}
