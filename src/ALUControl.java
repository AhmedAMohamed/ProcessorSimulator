
public class ALUControl {
	boolean[] funct;
	boolean[] AluOp;
	boolean[] result;
	
	public ALUControl() {
		funct=new boolean[6];
		AluOp=new boolean[3];
		result=new boolean[4];
	}
	
	public boolean[] getFunct() {
		return funct;
	}

	public void setFunct(boolean[] funct) {
		this.funct = funct;
	}

	public boolean[] getAluOp() {
		return AluOp;
	}

	public void setAluOp(boolean[] aluOp) {
		AluOp = aluOp;
	}

	public boolean[] getResult() {
		return result;
	}

	public void operate() {
		if(!AluOp[0] && AluOp[1] && !AluOp[2]) { // R formate
			if(!funct[0] && funct[1] && !funct[2] && !funct[3] && !funct[4] && !funct[5]) { //add
				result[0]=false;
				result[1]=false;
				result[2]=true;
				result[3]=false;
			}
			if(!funct[0] && funct[1] && !funct[2] && !funct[3] && funct[4] && !funct[5]) { //and
				result[0]=false;
				result[1]=false;
				result[2]=false;
				result[3]=false;
			}
			if(funct[0] && !funct[1] && !funct[2] && funct[3] && funct[4] && funct[5]) { //nor
				result[0]=true;
				result[1]=true;
				result[2]=false;
				result[3]=false;
			}
			if(funct[0] && !funct[1] && funct[2] && !funct[3] && funct[4] && !funct[5]) { //slt
				result[0]=false;
				result[1]=true;
				result[2]=true;
				result[3]=true;
			}
			if(funct[0] && !funct[1] && !funct[2] && !funct[3] && funct[4] && !funct[5]) { //sub
				result[0]=false;
				result[1]=true;
				result[2]=true;
				result[3]=false;
			}
			if(!funct[0] && !funct[1] && !funct[2] && !funct[3] && !funct[4] && !funct[5]) { //sll
				result[0]=false;
				result[1]=true;
				result[2]=false;
				result[3]=true;
			}
			if(funct[0] && !funct[1] && !funct[2] && funct[3] && !funct[4] && funct[5]) { //or
				result[0]=false;
				result[1]=false;
				result[2]=false;
				result[3]=true;
			}
		}
			
	}
	
}
