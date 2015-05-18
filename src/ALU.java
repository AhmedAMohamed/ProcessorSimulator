public class ALU {
	boolean[] data1;
	boolean[] data2;
	boolean[] aluControl;
	boolean[] result;
	boolean zero;

	ALU() {
		data1 = new boolean[32];
		data2 = new boolean[32];
		result = new boolean[32];
		aluControl = new boolean[4];
	}

	public void calculate(boolean[] shamt) {
		if(!aluControl[0] && !aluControl[1] && !aluControl[2] && !aluControl[3]) { // and
			and();
		}
		else if(!aluControl[0] && !aluControl[1] && !aluControl[2] && aluControl[3]) { // or
			or();
		}
		else if(!aluControl[0] && !aluControl[1] && aluControl[2] && !aluControl[3]) { // add
			add();
		}
		else if(!aluControl[0] && aluControl[1] && aluControl[2] && !aluControl[3]) { // sub
			sub();
		}
		else if(!aluControl[0] && aluControl[1] && aluControl[2] && aluControl[3]) { // slt
			slt();
		}
		else if(!aluControl[0] && aluControl[1] && !aluControl[2] && aluControl[3]) { // sll
			sll(shamt);
		}
		else if(aluControl[0] && aluControl[1] && !aluControl[2] && !aluControl[3]) { // nor
			nor();
		}
		else if(aluControl[0] && aluControl[1] && !aluControl[2] && !aluControl[3]) { // lw  && sw
			add();
		}
		else if(aluControl[0] && aluControl[1] && aluControl[2] && aluControl[3]) { // bne
			sub();
			zero = !zero;
		}
		else if(!aluControl[0] && aluControl[1] && aluControl[2] && !aluControl[3]) { // beq
			sub();
		}
	}
	
	private void sll(boolean[] shamt) {
		int in1 = binaryArrayToInt(data1);
		int in2 = binaryArrayToInt(shamt);
		int res = (int) (in1*Math.pow(2, in2));
		result = intToBooleanArray(res);
	}

	private void nor() {
		
	}

	private void slt() {
		int in1 = binaryArrayToInt(data1);
		int in2 = binaryArrayToInt(data2);
		if(in1 < in2) {
			for(int i = 0; i < 32; i++) {
				result[i] = true;
			}
		}
		else {
			for(int i = 0; i < 32; i++) {
				result[i] = false;
			}
		}
	}

	private void sub() {
		int in1 = binaryArrayToInt(data1);
		int in2 = binaryArrayToInt(data2);
		in1 = in1 - in2;
		if(in1 == 0)
			zero = true;
		else 
			zero = false;
		result =  intToBooleanArray(in1);
	}

	private void add() {
		int in1 = binaryArrayToInt(data1);
		int in2 = binaryArrayToInt(data2);
		in1 = in1 + in2;
		result =  intToBooleanArray(in1);
	}

	private void or() {
		boolean[] res = new boolean[32];
		for(int i = 0; i < 32; i++) {
			res[i] = data1[i] | data2[i];
		}
		result =  res;
	}

	private void and() {
		boolean[] res = new boolean[32];
		for(int i = 0; i < 32; i++) {
			res[i] = data1[i] & data2[i];
		}
		result =  res;
	}

	public boolean[] getData1() {
		return data1;
	}

	public void setData1(boolean[] data1) {
		this.data1 = data1;
	}

	public boolean[] getData2() {
		return data2;
	}

	public void setData2(boolean[] data2) {
		this.data2 = data2;
	}

	public boolean[] getAluControl() {
		return aluControl;
	}

	public void setAluControl(boolean[] aluControl) {
		this.aluControl = aluControl;
	}

	public boolean[] getResult() {
		return result;
	}

	public void setResult(boolean[] result) {
		this.result = result;
	}

	public boolean isZero() {
		return zero;
	}

	public void setZero(boolean zero) {
		this.zero = zero;
	}
	
	public static int binaryArrayToInt(boolean[] in) {
		int n = 0, l = in.length;
		for (int i = 0; i < l; ++i) {
		    n = (n << 1) + (in[i] ? 1 : 0);
		}
		return n;
	}
	
	public static boolean[] intToBooleanArray(int in) {
		String f = String.format("%32s", Integer.toBinaryString(in)).replace(' ', '0');
		boolean[] res = new boolean[32];
		for(int i = 0; i < 32 ; i++) {
			res[i] = f.charAt(i)=='1' ? true : false;  
		}
		return res;
	}
	
}