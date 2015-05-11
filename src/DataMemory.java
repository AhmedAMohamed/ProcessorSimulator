import java.util.ArrayList;

public class DataMemory {
	boolean memRead;
	boolean memWrite;
	boolean[] address;
	boolean[] writeData;
	boolean[] readData;
	boolean[][] data;

	DataMemory() {
		data = new boolean[(int) Math.pow(32, 2)][32];
		address = new boolean[32];
		writeData = new boolean[32];
		readData = new boolean[32];
	}

	private void getData() {
		int index = ALU.binaryArrayToInt(address);
		readData = data[index];
	}

	private void setData() {
		int index = ALU.binaryArrayToInt(address);
		data[index] = writeData;
	}

	public void memoryAccess() {
		if (memRead && !memWrite) {
			getData();
		} else if (memWrite && !memRead) {
			setData();
		}
	}
}