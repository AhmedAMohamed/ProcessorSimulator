public class Control {
	boolean[] opcode;
	boolean regDest;
	boolean branch;
	boolean memRead;
	boolean memToReg;
	boolean[] aluOp;
	boolean memWrite;
	boolean aluSrc;
	boolean regWrite;
	
	public boolean[] getOpcode() {
		return opcode;
	}
	public void setOpcode(boolean[] opcode) {
		this.opcode = opcode;
	}
	public boolean isRegDest() {
		return regDest;
	}
	public void setRegDest(boolean regDest) {
		this.regDest = regDest;
	}
	public boolean isBranch() {
		return branch;
	}
	public void setBranch(boolean branch) {
		this.branch = branch;
	}
	public boolean isMemRead() {
		return memRead;
	}
	public void setMemRead(boolean memRead) {
		this.memRead = memRead;
	}
	public boolean isMemToReg() {
		return memToReg;
	}
	public void setMemToReg(boolean memToReg) {
		this.memToReg = memToReg;
	}
	public boolean[] getAluOp() {
		return aluOp;
	}
	public void setAluOp(boolean[] aluOp) {
		this.aluOp = aluOp;
	}
	public boolean isMemWrite() {
		return memWrite;
	}
	public void setMemWrite(boolean memWrite) {
		this.memWrite = memWrite;
	}
	public boolean isAluSrc() {
		return aluSrc;
	}
	public void setAluSrc(boolean aluSrc) {
		this.aluSrc = aluSrc;
	}
	public boolean isRegWrite() {
		return regWrite;
	}
	public void setRegWrite(boolean regWrite) {
		this.regWrite = regWrite;
	}
	
	Control() {
		opcode = new boolean[6];
		aluOp = new boolean[3];
	}
	
	public void operate() {
		if(!opcode[0] && !opcode[1] && !opcode[2] && !opcode[3] && !opcode[4] && !opcode[5]) { // R formate
			regDest = true;
			branch = false;
			memRead = false;
			memToReg = false;
			memWrite = false;
			aluSrc = false;
			regWrite = true;
			aluOp[0] = false;
			aluOp[1] = true;
			aluOp[2] = false;
		}
		else if(opcode[0] && !opcode[1] && !opcode[2] && !opcode[3] && opcode[4] && opcode[5]) { // lw
			aluOp[0] = false;
			aluOp[1] = false;
			aluOp[2] = false;
			setRegDest(false);
			setBranch(false);
			setMemRead(true);
			setMemToReg(true);
			setMemWrite(false);
			setAluSrc(true);
			setRegWrite(true);
		}
		else if(opcode[0] && !opcode[1] && opcode[2] && !opcode[3] && opcode[4] && opcode[5]) { // sw
			aluOp[0] = false;
			aluOp[1] = false;
			aluOp[2] = false;
			setRegDest(false);
			setBranch(false);
			setMemRead(false);
			setMemToReg(false);
			setMemWrite(true);
			setAluSrc(true);
			setRegWrite(false);
		}
		else if(!opcode[0] && !opcode[1] && opcode[2] && !opcode[3] && opcode[4] && !opcode[5]) { // beq
			aluOp[0] = false;
			aluOp[1] = false;
			aluOp[2] = true;
			setRegDest(false);
			setBranch(true);
			setMemRead(false);
			setMemToReg(false);
			setMemWrite(false);
			setAluSrc(false);
			setRegWrite(false);
		}
		else if(!opcode[0] && !opcode[1] && opcode[2] && !opcode[3] && !opcode[4] && !opcode[5]) { // addi
			aluOp[0] = true;
			aluOp[1] = false;
			aluOp[2] = false;
			setRegDest(false);
			setBranch(false);
			setMemRead(false);
			setMemToReg(false);
			setMemWrite(false);
			setAluSrc(true);
			setRegWrite(true);
		}
		else if(!opcode[0] && !opcode[1] && !opcode[2] && opcode[3] && !opcode[4] && opcode[5]) { // bne
			aluOp[0] = true;
			aluOp[1] = true;
			aluOp[2] = false;
			setRegDest(false);
			setBranch(true);
			setMemRead(false);
			setMemToReg(false);
			setMemWrite(false);
			setAluSrc(false);
			setRegWrite(false);
		}
		else if(!opcode[0] && !opcode[1] && opcode[2] && !opcode[3] && opcode[4] && !opcode[5]) { // slti
			aluOp[0] = true;
			aluOp[1] = true;
			aluOp[2] = true;
			setRegDest(false);
			setBranch(false);
			setMemRead(false);
			setMemToReg(false);
			setMemWrite(false);
			setAluSrc(true);
			setRegWrite(true);
		}
	}
}