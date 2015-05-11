import java.util.ArrayList;

/**
 *
 * @author AhmedA
 */
public class RegisterFiles {
	boolean[][] registers;
	boolean[] readRegister1;
	boolean[] readRegister2;
	boolean[] writeRegister;
	boolean[] writeData;
	boolean[] readData1;
	boolean[] readData2;
	boolean regWrite;
	
	public RegisterFiles() {
		registers = new boolean [32][32];
		readRegister1 = new boolean [5];
		readRegister2 = new boolean [5];
		writeRegister = new boolean [5];
		writeData = new boolean [32];
		readData1 = new boolean [32];
		readData2 = new boolean [32];
	}
	
	public void operate() {
		int index1 = ALU.binaryArrayToInt(readRegister1);
		int index2 = ALU.binaryArrayToInt(readRegister2);
		readData1 = registers[index1];
		readData2 = registers[index2];
	}
	
	public void updateWriteOperation() {
		int index = ALU.binaryArrayToInt(writeRegister);
		if(regWrite) {
			registers[index] = writeData;
		}
	}
	
	public boolean[][] getRegisters() {
		return registers;
	}
	public void setRegisters(boolean[][] registers) {
		this.registers = registers;
	}
	public boolean[] getReadRegister1() {
		return readRegister1;
	}
	public void setReadRegister1(boolean[] readRegister1) {
		this.readRegister1 = readRegister1;
	}
	public boolean[] getReadRegister2() {
		return readRegister2;
	}
	public void setReadRegister2(boolean[] readRegister2) {
		this.readRegister2 = readRegister2;
	}
	public boolean[] getWriteRegister() {
		return writeRegister;
	}
	public void setWriteRegister(boolean[] writeRegister) {
		this.writeRegister = writeRegister;
	}
	public boolean[] getWriteData() {
		return writeData;
	}
	public void setWriteData(boolean[] writeData) {
		this.writeData = writeData;
	}
	public boolean[] getReadData1() {
		return readData1;
	}
	public void setReadData1(boolean[] readData1) {
		this.readData1 = readData1;
	}
	public boolean[] getReadData2() {
		return readData2;
	}
	public void setReadData2(boolean[] readData2) {
		this.readData2 = readData2;
	}
	public boolean isRegWrite() {
		return regWrite;
	}
	public void setRegWrite(boolean regWrite) {
		this.regWrite = regWrite;
	}
}