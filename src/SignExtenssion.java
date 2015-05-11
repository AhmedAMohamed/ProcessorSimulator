public class SignExtenssion {

	boolean[] input;
	boolean[] output;

	public SignExtenssion() {
		input = new boolean[16];
		output = new boolean[32];
	}

	public void extend() {
		for (int i = 0; i < 16; i++) {
			output[i] = input[15];
		}
		for (int i = 16, j = 0; i < 32; i++, j++) {
			output[i] = input[j];
		}
	}
}
