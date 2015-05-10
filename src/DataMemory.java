import java.util.ArrayList;

public class DataMemory {
	private boolean memRead;
	private boolean memWrite;
	private boolean[] address;
	private boolean[] writeData;
	private boolean[] readData;
	private boolean[][] data;
	
	DataMemory() {
		data = new boolean[(int) Math.pow(32, 2)][32];
		address = new boolean[32];
		writeData = new boolean[32];
		readData = new boolean[32];
	}
	
	public void getData() {
		int index = ALU.binaryArrayToInt(address);
		readData = data[index];
	}
	
	public void setData() {
		int index = ALU.binaryArrayToInt(address);
		data[index] = writeData;
	}
	
	public void memoryAccess() {
		if(memRead && ! memWrite) {
			getData();
		}
		else if(memWrite && ! memRead) {
			setData();
		}
	}
}