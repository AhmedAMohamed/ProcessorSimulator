public class Mux {
	String s1;
	String s2;
	String result;

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public String getResult(Boolean select) {
		if (select) {
			result = s2;
		} else {
			result = s1;
		}
		return result;
	}

}