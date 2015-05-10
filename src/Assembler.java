import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Assembler {
	boolean[] instruction;
	Map<String,Integer> registerMaper;
	ArrayList<boolean[]> instructions;
	ArrayList<String> instructionsText;
	
	Assembler() {
		instructionsText = new ArrayList<String>();
		registerMaper = new HashMap<>(32);
		registerMaper.put("$zero", 0);
		registerMaper.put("$at", 1);
		registerMaper.put("$v0", 2);
		registerMaper.put("$v1", 3);
		registerMaper.put("$a0", 4);
		registerMaper.put("$a1", 5);
		registerMaper.put("$a2", 6);
		registerMaper.put("$a3", 7);
		registerMaper.put("$t0", 8);
		registerMaper.put("$t1", 9);
		registerMaper.put("$t2", 10);
		registerMaper.put("$t3", 11);
		registerMaper.put("$t4", 12);
		registerMaper.put("$t5", 13);
		registerMaper.put("$t6", 14);
		registerMaper.put("$t7", 15);
		registerMaper.put("$s0", 16);
		registerMaper.put("$s1", 17);
		registerMaper.put("$s2", 18);
		registerMaper.put("$s3", 19);
		registerMaper.put("$s4", 20);
		registerMaper.put("$s5", 21);
		registerMaper.put("$s6", 22);
		registerMaper.put("$s7", 23);
		registerMaper.put("$t8", 24);
		registerMaper.put("$t9", 25);
		registerMaper.put("$k0", 26);
		registerMaper.put("$k1", 27);
		registerMaper.put("$gp", 28);
		registerMaper.put("$sp", 29);
		registerMaper.put("$fp", 30);
		registerMaper.put("$ra", 31);
		instruction = new boolean[32];
	}
	public void addInstructions(String instruction) {
		instructionsText.add(instruction);
	}
	
	public void assemblyGenerator () {
		for(String ins : instructionsText) {
			String[] parts = ins.split(" ");
			if(parts[0].equalsIgnoreCase("and")) {
				String rs, rt, rd, shamt, funct, opcode;
				rd = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[1])).replace(' ', '1'));
				rs = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[2])).replace(' ', '1'));
				rt = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[3])).replace(' ', '1'));
				shamt = String.format("%5s", Integer.toBinaryString(0).replace(' ', '0'));
				funct = String.format("%6s", Integer.toBinaryString(36).replace(' ', '0'));
				opcode = String.format("%6s", Integer.toBinaryString(0)).replace(' ', '0');
				for(int i = 0; i < 6; i++) {
					instruction[i] = opcode.charAt(i) == '1' ? true : false;
				}
				for(int i = 6, j = 0; i < 11; i++,j++) {
					instruction[i] = rs.charAt(j) == '1' ? true : false;
				}
				for(int i = 11, j = 0; i < 16; i++,j++) {
					instruction[i] = rt.charAt(j) == '1' ? true : false;
				}
				for(int i = 16, j = 0; i < 21; i++,j++) {
					instruction[i] = rd.charAt(j) == '1' ? true : false;
				}
				for(int i = 21, j = 0; i < 26; i++,j++) {
					instruction[i] = shamt.charAt(j) == '1' ? true : false;
				}
				for(int i = 26, j = 0; i < 32; i++,j++) {
					instruction[i] = funct.charAt(j) == '1' ? true : false;
				}
			}
			else if(parts[0].equalsIgnoreCase("add")) {
				String rs, rt, rd, shamt, funct, opcode;
				rd = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[1]))).replace(' ', '0');
				rs = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[2]))).replace(' ', '0');
				rt = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[3]))).replace(' ', '0');
				shamt = String.format("%5s", Integer.toBinaryString(0).replace(' ', '0'));
				funct = String.format("%6s", Integer.toBinaryString(32).replace(' ', '0'));
				opcode = String.format("%6s", Integer.toBinaryString(0)).replace(' ', '0');
				for(int i = 0; i < 6; i++) {
					instruction[i] = opcode.charAt(i) == '1' ? true : false;
				}
				for(int i = 6, j = 0; i < 11; i++,j++) {
					instruction[i] = rs.charAt(j) == '1' ? true : false;
				}
				for(int i = 11, j = 0; i < 16; i++,j++) {
					instruction[i] = rt.charAt(j) == '1' ? true : false;
				}
				for(int i = 16, j = 0; i < 21; i++,j++) {
					instruction[i] = rd.charAt(j) == '1' ? true : false;
				}
				for(int i = 21, j = 0; i < 26; i++,j++) {
					instruction[i] = shamt.charAt(j) == '1' ? true : false;
				}
				for(int i = 26, j = 0; i < 32; i++,j++) {
					instruction[i] = funct.charAt(j) == '1' ? true : false;
				}
			}
			else if(parts[0].equalsIgnoreCase("nor")) {
				String rs, rt, rd, shamt, funct, opcode;
				rd = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[1]))).replace(' ', '0');
				rs = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[2]))).replace(' ', '0');
				rt = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[3]))).replace(' ', '0');
				shamt = String.format("%5s", Integer.toBinaryString(0).replace(' ', '0'));
				funct = String.format("%6s", Integer.toBinaryString(39).replace(' ', '0'));
				opcode = String.format("%6s", Integer.toBinaryString(0)).replace(' ', '0');
				for(int i = 0; i < 6; i++) {
					instruction[i] = opcode.charAt(i) == '1' ? true : false;
				}
				for(int i = 6, j = 0; i < 11; i++,j++) {
					instruction[i] = rs.charAt(j) == '1' ? true : false;
				}
				for(int i = 11, j = 0; i < 16; i++,j++) {
					instruction[i] = rt.charAt(j) == '1' ? true : false;
				}
				for(int i = 16, j = 0; i < 21; i++,j++) {
					instruction[i] = rd.charAt(j) == '1' ? true : false;
				}
				for(int i = 21, j = 0; i < 26; i++,j++) {
					instruction[i] = shamt.charAt(j) == '1' ? true : false;
				}
				for(int i = 26, j = 0; i < 32; i++,j++) {
					instruction[i] = funct.charAt(j) == '1' ? true : false;
				}
			}
			else if(parts[0].equalsIgnoreCase("or")) {
				String rs, rt, rd, shamt, funct, opcode;
				rd = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[1])).replace(' ', '1'));
				rs = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[2])).replace(' ', '1'));
				rt = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[3])).replace(' ', '1'));
				shamt = String.format("%5s", Integer.toBinaryString(0).replace(' ', '0'));
				funct = String.format("%6s", Integer.toBinaryString(37).replace(' ', '0'));
				opcode = String.format("%6s", Integer.toBinaryString(0)).replace(' ', '0');
				for(int i = 0; i < 6; i++) {
					instruction[i] = opcode.charAt(i) == '1' ? true : false;
				}
				for(int i = 6, j = 0; i < 11; i++,j++) {
					instruction[i] = rs.charAt(j) == '1' ? true : false;
				}
				for(int i = 11, j = 0; i < 16; i++,j++) {
					instruction[i] = rt.charAt(j) == '1' ? true : false;
				}
				for(int i = 16, j = 0; i < 21; i++,j++) {
					instruction[i] = rd.charAt(j) == '1' ? true : false;
				}
				for(int i = 21, j = 0; i < 26; i++,j++) {
					instruction[i] = shamt.charAt(j) == '1' ? true : false;
				}
				for(int i = 26, j = 0; i < 32; i++,j++) {
					instruction[i] = funct.charAt(j) == '1' ? true : false;
				}
			}
			else if(parts[0].equalsIgnoreCase("sll")) {
				String rs, rt, rd, shamt, funct, opcode;
				rd = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[1])).replace(' ', '1'));
				rt = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[2])).replace(' ', '1'));
				shamt = String.format("%5s", Integer.toBinaryString(Integer.parseInt(parts[3])).replace(' ', '1'));
				rs = String.format("%5s", Integer.toBinaryString(0).replace(' ', '0'));
				funct = String.format("%6s", Integer.toBinaryString(0).replace(' ', '0'));
				opcode = String.format("%6s", Integer.toBinaryString(0)).replace(' ', '0');
				for(int i = 0; i < 6; i++) {
					instruction[i] = opcode.charAt(i) == '1' ? true : false;
				}
				for(int i = 6, j = 0; i < 11; i++,j++) {
					instruction[i] = rs.charAt(j) == '1' ? true : false;
				}
				for(int i = 11, j = 0; i < 16; i++,j++) {
					instruction[i] = rt.charAt(j) == '1' ? true : false;
				}
				for(int i = 16, j = 0; i < 21; i++,j++) {
					instruction[i] = rd.charAt(j) == '1' ? true : false;
				}
				for(int i = 21, j = 0; i < 26; i++,j++) {
					instruction[i] = shamt.charAt(j) == '1' ? true : false;
				}
				for(int i = 26, j = 0; i < 32; i++,j++) {
					instruction[i] = funct.charAt(j) == '1' ? true : false;
				}
			}
			else if(parts[0].equalsIgnoreCase("sub")) {
				String rs, rt, rd, shamt, funct, opcode;
				rd = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[1])).replace(' ', '1'));
				rs = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[2])).replace(' ', '1'));
				rt = String.format("%5s", Integer.toBinaryString(registerMaper.get(parts[3])).replace(' ', '1'));
				shamt = String.format("%5s", Integer.toBinaryString(0).replace(' ', '0'));
				funct = String.format("%6s", Integer.toBinaryString(34).replace(' ', '0'));
				opcode = String.format("%6s", Integer.toBinaryString(0)).replace(' ', '0');
				for(int i = 0; i < 6; i++) {
					instruction[i] = opcode.charAt(i) == '1' ? true : false;
				}
				for(int i = 6, j = 0; i < 11; i++,j++) {
					instruction[i] = rs.charAt(j) == '1' ? true : false;
				}
				for(int i = 11, j = 0; i < 16; i++,j++) {
					instruction[i] = rt.charAt(j) == '1' ? true : false;
				}
				for(int i = 16, j = 0; i < 21; i++,j++) {
					instruction[i] = rd.charAt(j) == '1' ? true : false;
				}
				for(int i = 21, j = 0; i < 26; i++,j++) {
					instruction[i] = shamt.charAt(j) == '1' ? true : false;
				}
				for(int i = 26, j = 0; i < 32; i++,j++) {
					instruction[i] = funct.charAt(j) == '1' ? true : false;
				}
			}
			else if(parts[0].equalsIgnoreCase("addi")) { // I formate
				// addi t1 t2 value
				String rs, rt, address, opcode;
				rs = Integer.toBinaryString(registerMaper.get(parts[0]));
				rt = Integer.toBinaryString(registerMaper.get(parts[1]));
			}
		}
	}
	public static void main(String[] args) {
		Assembler s = new Assembler();
	}
}
