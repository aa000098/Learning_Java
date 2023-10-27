package section1;

public class Computer {
	
	protected String manufacturer;
	protected String processor;
	private int ramSize;
	private int diskSize;
	private double processorSpeed;
	
	public Computer(String man, String proc, int ram, int disk, double speed) {
		manufacturer = man;
		processor = proc;
		ramSize = ram;
		diskSize = disk;
		processorSpeed = speed;
	}
	public double computePower() {
		return ramSize * processorSpeed;
	}
	
	public double getRamSize() {
		return ramSize;
	}
	
	public double getProcessorSpeed() {
		return processorSpeed;
	}
	
	public int getDiskSize() {
		return diskSize;
	}
	
	public String toString() {
		String result = "Manufactuerer :" + manufacturer +
						"\nCPU : " + processor +
						"\nDisk : " + diskSize + " gigabytes" +
						"\nProcessor speed : " + processorSpeed + "gigabytes";
		return result;
	}
	
}
