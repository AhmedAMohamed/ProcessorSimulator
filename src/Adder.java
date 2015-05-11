public class Adder {
	boolean[] i1;
	boolean[] i2;
	boolean[] result;

	public Adder() {
		i1 = new boolean[32];
		i2 = new boolean[32];
	}

	public void operate() {
		result = ALU.intToBooleanArray(ALU.binaryArrayToInt(i1)
				+ ALU.binaryArrayToInt(i2));
	}
}
