public class Mux {
	boolean[] a;
	boolean[] b;
	boolean[] result;
	boolean s;

	Mux() {
		a = new boolean[32];
		b = new boolean[32];
		result = new boolean[32];
	}

	public boolean[] getA() {
		return a;
	}

	public void setA(boolean[] a) {
		this.a = a;
	}

	public boolean[] getB() {
		return b;
	}

	public void setB(boolean[] b) {
		this.b = b;
	}

	public boolean[] getResult() {
		return result;
	}

	public void setResult(boolean[] result) {
		this.result = result;
	}

	public boolean isS() {
		return s;
	}

	public void setS(boolean s) {
		this.s = s;
	}
	
	public void operateMux() {
		result = s ? b : a;
	}
}