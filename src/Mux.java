public class Mux {
	boolean[] a;
	boolean[] b;
	boolean[] result;
	boolean s;
	int size;

	Mux(int size) {
		a = new boolean[size];
		b = new boolean[size];
		result = new boolean[size];
		this.size = size;
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