public class Control {
	String aluOp;
	boolean regDes;
	boolean branch;
	boolean memRead;
	boolean memToReg;
	boolean memWrite;
	boolean aluSrc;
	boolean regwrite;

	public void setAluOp(String aluOp) {
		this.aluOp = aluOp;
	}

	public void setRegDes(boolean regDes) {
		this.regDes = regDes;
	}

	public void setBranch(boolean branch) {
		this.branch = branch;
	}

	public void setMemRead(boolean memRead) {
		this.memRead = memRead;
	}

	public void setMemToReg(boolean memToReg) {
		this.memToReg = memToReg;
	}

	public void setMemWrite(boolean memWrite) {
		this.memWrite = memWrite;
	}

	public void setAluSrc(boolean aluSrc) {
		this.aluSrc = aluSrc;
	}

	public void setRegWrite(boolean regWrite) {
		this.regwrite = regWrite;
	}

	public void select(String s) {
		if (s.equalsIgnoreCase("add") || s.equalsIgnoreCase("sub")
				|| s.equalsIgnoreCase("and") || s.equalsIgnoreCase("or")
				|| s.equalsIgnoreCase("slt") || s.equalsIgnoreCase("nor")) {
			setRegDes(true);
			setBranch(false);
			setMemRead(false);
			setMemToReg(false);
			setMemWrite(false);
			setAluSrc(false);
			setRegWrite(true);
			if (aluOp.equalsIgnoreCase("sub"))
				this.aluOp = "sub";
			else if (aluOp.equalsIgnoreCase("add"))
				this.aluOp = "add";
			else if (aluOp.equalsIgnoreCase("and"))
				this.aluOp = "and";
			else if (aluOp.equalsIgnoreCase("or"))
				this.aluOp = "or";
			else if (aluOp.equalsIgnoreCase("slt"))
				this.aluOp = "slt";
			else if (aluOp.equalsIgnoreCase("nor"))
				this.aluOp = "nor";
		}
		if (s.equalsIgnoreCase("addi")) {
			setRegDes(false);
			setBranch(false);
			setMemRead(false);
			setMemToReg(false);
			setMemWrite(false);
			setAluSrc(true);
			setRegWrite(true);
			this.aluOp = "add";
		}
		if (s.equalsIgnoreCase("lw")) {
			setRegDes(false);
			setBranch(false);
			setMemRead(true);
			setMemToReg(true);
			setMemWrite(false);
			setAluSrc(true);
			setRegWrite(true);
			this.aluOp = "add";
		}
		if (s.equalsIgnoreCase("sw")) {
			setRegDes(false);
			setBranch(false);
			setMemRead(false);
			setMemToReg(false);
			setMemWrite(true);
			setAluSrc(true);
			setRegWrite(false);
			this.aluOp = "add";
		}
		if (s.equalsIgnoreCase("beq")) {
			setRegDes(false);
			setBranch(true);
			setMemRead(false);
			setMemToReg(false);
			setMemWrite(false);
			setAluSrc(false);
			setRegWrite(false);
			this.aluOp = "sub";
		}

	}
}