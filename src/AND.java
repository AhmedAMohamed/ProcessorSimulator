public class AND {
	boolean in1;
	boolean in2;
	boolean result;

	public boolean isIn1() {
		return in1;
	}

	public void setIn1(boolean in1) {
		this.in1 = in1;
	}

	public boolean isIn2() {
		return in2;
	}

	public void setIn2(boolean in2) {
		this.in2 = in2;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public void operate() {
		result = in1 & in2;
	}
}
