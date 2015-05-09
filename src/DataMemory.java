import java.util.ArrayList;

public class DataMemory {
	private boolean memRead;
	private boolean memWrite;
	private String address;
	private String writeData;
	private String result;
	private ArrayList<String> data;

	public void setAddress(String address) {
		this.address = address;
	}

	public void setWriteData(String writeData) {
		this.writeData = writeData;
	}

	public void setMemRead(boolean memRead) {
		this.memRead = memRead;
	}

	public void setMemWrite(boolean memWrite) {
		this.memWrite = memWrite;
	}

	void addDataToMemory() {
		if (!memRead && memWrite)
			data.add(Integer.parseInt(address), writeData);
	}

	String getDataFromMemory() {
		if (memRead && !memWrite)
			result = data.get(Integer.parseInt(address));
		return result;
	}

}