
public class Processor {

	public int pcCounter;
	Control controlUnit;
	ALU alu;
	DataMemory datamemory;
	InstructionMemory instructionmemory;
	Mux alumux;
	RegisterFiles registerfiles;
	ALU branchadder;
	Mux registerfilemux;
	Mux datamemorymux;
	int nextshift;
	String signextend;
	String aluresult;
	
	Processor() {
		controlUnit=new Control();
		alu=new ALU();
		datamemory=new DataMemory();
		instructionmemory=new InstructionMemory();
		alumux=new Mux();
		registerfiles= new RegisterFiles();
		branchadder=new ALU();
		registerfilemux=new Mux();
		datamemorymux=new Mux();
	}
	
	void cycle() {
		String instruction=fetch();
		decode(instruction); 
		
	}

	private void decode(String instruction) {
		String[] s = instruction.split(" ");
		//op + rd + rs + rt
		controlUnit.select(s[0]);
		registerfiles.setReadD1(s[2]);
		registerfiles.setReadD2(s[3]);
		registerfilemux.setS1(s[2]);
		registerfilemux.setS2(s[1]);
		registerfiles.setWriteReg(registerfilemux.getResult(controlUnit.regDes));
		
		nextshift=Integer.parseInt(s[3]);
		signextend=s[3];
	}
	
	private String fetch() {
		return instructionmemory.getInstruction(pcCounter);
	}
	
	@SuppressWarnings("unused")
	private void execute() {
		alumux.setS1(registerfiles.readD2Out);
		alumux.setS2(signextend);
		alu.setData1(registerfiles.readD1Out);
		alu.setData2(alumux.getResult(controlUnit.aluSrc));
		alu.setAluOp(controlUnit.aluOp);
		aluresult=alu.getResult();
	}
	
}
