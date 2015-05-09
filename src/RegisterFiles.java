import java.util.ArrayList;

/**
 *
 * @author AhmedA
 */
public class RegisterFiles {

	public ArrayList<String> getA() {
		return a;
	}

	public void setA(ArrayList<String> a) {
		this.a = a;
	}

	public ArrayList<String> getV() {
		return v;
	}

	public void setV(ArrayList<String> v) {
		this.v = v;
	}

	public ArrayList<String> getT() {
		return t;
	}

	public void setT(ArrayList<String> t) {
		this.t = t;
	}

	public ArrayList<String> getS() {
		return s;
	}

	public void setS(ArrayList<String> s) {
		this.s = s;
	}

	public ArrayList<String> getK() {
		return k;
	}

	public void setK(ArrayList<String> k) {
		this.k = k;
	}

	public String getZero() {
		return zero;
	}

	public void setZero(String zero) {
		this.zero = zero;
	}

	public String getAt() {
		return at;
	}

	public void setAt(String at) {
		this.at = at;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getFp() {
		return fp;
	}

	public void setFp(String fp) {
		this.fp = fp;
	}

	public String getSp() {
		return sp;
	}

	public void setSp(String sp) {
		this.sp = sp;
	}

	public String getGp() {
		return gp;
	}

	public void setGp(String gp) {
		this.gp = gp;
	}

	public String getReadD1() {
		return readD1;
	}

	public void setReadD1(String readD1) {
		this.readD1 = readD1;
	}

	public String getReadD2() {
		return readD2;
	}

	public void setReadD2(String readD2) {
		this.readD2 = readD2;
	}

	public String getWriteReg() {
		return writeReg;
	}

	public void setWriteReg(String writeReg) {
		this.writeReg = writeReg;
	}

	public String getWriteData() {
		return writeData;
	}

	public void setWriteData(String writeData) {
		this.writeData = writeData;
	}

	public String getReadD1Out() {
		return readD1Out;
	}

	public void setReadD1Out(String readD1Out) {
		this.readD1Out = readD1Out;
	}

	public String getReadD2Out() {
		return readD2Out;
	}

	public void setReadD2Out(String readD2Out) {
		this.readD2Out = readD2Out;
	}

	public boolean isRegWrite() {
		return regWrite;
	}

	public void setRegWrite(boolean regWrite) {
		this.regWrite = regWrite;
	}

	private ArrayList<String> a;
	private ArrayList<String> v;
	private ArrayList<String> t;
	private ArrayList<String> s;
	private ArrayList<String> k;
	private String zero, at, ra, fp, sp, gp;
	
	String readD1, readD2,writeReg,writeData,readD1Out,readD2Out;
	boolean regWrite;

	public RegisterFiles() {
		a = new ArrayList<String>();
		v = new ArrayList<String>();
		t = new ArrayList<String>();
		s = new ArrayList<String>();
		k = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			a.add(new String());
		}
		for (int i = 0; i < 2; i++) {
			v.add(new String());
		}
		for (int i = 0; i < 10; i++) {
			t.add(new String());
		}
		for (int i = 0; i < 8; i++) {
			s.add(new String());
		}
		for (int i = 0; i < 2; i++) {
			k.add(new String());
		}
		zero = new String();
		at = new String();
		ra = new String();
		fp = new String();
		sp = new String();
		gp = new String();
	}

	private void storeReg(String regName, String regVal) {
		if (regName.charAt(0) == 'a') {
			char indexChar = regName.charAt(1);
			int index = (int) indexChar;
			a.add(index, regVal);
		}
		if (regName.charAt(0) == 'v') {
			char indexChar = regName.charAt(1);
			int index = (int) indexChar;
			v.add(index, regVal);
		}
		if (regName.charAt(0) == 't') {
			char indexChar = regName.charAt(1);
			int index = (int) indexChar;
			t.add(index, regVal);
		}
		if (regName.charAt(0) == 's') {
			char indexChar = regName.charAt(1);
			int index = (int) indexChar;
			s.add(index, regVal);
		}
		if (regName.charAt(0) == 'k') {
			char indexChar = regName.charAt(1);
			int index = (int) indexChar;
			k.add(index, regVal);
		}
		if (regName.equalsIgnoreCase("at")) {
			at = regVal;
		}
		if (regName.equalsIgnoreCase("zero")) {
			zero = regVal;
			System.out.println("bad usage!");
		}
		if (regName.equalsIgnoreCase("gp")) {
			gp = regVal;
		}
		if (regName.equalsIgnoreCase("sp")) {
			sp = regVal;
		}
		if (regName.equalsIgnoreCase("fp")) {
			fp = regVal;
		}
		if (regName.equalsIgnoreCase("ra")) {
			ra = regVal;
		} else {
			System.out.print("error !");
		}
	}

	public ArrayList<String> getValues(String reg1, String reg2) {
		ArrayList<String> result = new ArrayList<>();
		String val1 = new String();
		if (reg1.charAt(0) == 'a') {
			char indexChar = reg1.charAt(1);
			int index = (int) indexChar;
			val1 = a.get(index);
		} else if (reg1.charAt(0) == 's') {
			char indexChar = reg1.charAt(1);
			int index = (int) indexChar;
			val1 = s.get(index);
		} else if (reg1.charAt(0) == 'v') {
			char indexChar = reg1.charAt(1);
			int index = (int) indexChar;
			val1 = v.get(index);
		} else if (reg1.charAt(0) == 't') {
			char indexChar = reg1.charAt(1);
			int index = (int) indexChar;
			val1 = t.get(index);
		} else if (reg1.charAt(0) == 'k') {
			char indexChar = reg1.charAt(1);
			int index = (int) indexChar;
			val1 = k.get(index);
		} else if (reg1.equalsIgnoreCase("zero")) {
			val1 = zero;
		} else if (reg1.equalsIgnoreCase("at")) {
			val1 = at;
		} else if (reg1.equalsIgnoreCase("gp")) {
			val1 = gp;
		} else if (reg1.equalsIgnoreCase("sp")) {
			val1 = sp;
		} else if (reg1.equalsIgnoreCase("fp")) {
			val1 = fp;
		} else if (reg1.equalsIgnoreCase("ra")) {
			val1 = ra;
		} else {
			System.out.println("error");
		}
		String val2 = new String();
		if (reg2.charAt(0) == 'a') {
			char indexChar = reg2.charAt(1);
			int index = (int) indexChar;
			val2 = a.get(index);
		} else if (reg2.charAt(0) == 's') {
			char indexChar = reg2.charAt(1);
			int index = (int) indexChar;
			val2 = s.get(index);
		} else if (reg2.charAt(0) == 'v') {
			char indexChar = reg2.charAt(1);
			int index = (int) indexChar;
			val2 = v.get(index);
		} else if (reg2.charAt(0) == 't') {
			char indexChar = reg2.charAt(1);
			int index = (int) indexChar;
			val2 = t.get(index);
		} else if (reg2.charAt(0) == 'k') {
			char indexChar = reg2.charAt(1);
			int index = (int) indexChar;
			val2 = k.get(index);
		} else if (reg2.equalsIgnoreCase("zero")) {
			val2 = zero;
		} else if (reg2.equalsIgnoreCase("at")) {
			val2 = at;
		} else if (reg2.equalsIgnoreCase("gp")) {
			val2 = gp;
		} else if (reg2.equalsIgnoreCase("sp")) {
			val2 = sp;
		} else if (reg2.equalsIgnoreCase("fp")) {
			val2 = fp;
		} else if (reg2.equalsIgnoreCase("ra")) {
			val2 = ra;
		} else {
			System.out.println("error");
		}
		result.add(val1);
		result.add(val2);
		return result;
	}
	
	void getResult() {
		ArrayList<String> q = getValues(readD1,readD2);
		readD1Out=q.get(0);
		readD2Out=q.get(1);	
	}
}