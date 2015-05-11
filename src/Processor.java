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
	ALUControl alucontrol;
	SignExtenssion signextenssion;
	Mux addermux;
	Adder adder;
	AND and;
	Adder pcadder;

	boolean[] opcode;
	boolean[] rs;
	boolean[] rt;
	boolean[] rd;
	boolean[] funct;
	boolean[] shamt;
	boolean[] address;

	public Processor() {
		controlUnit = new Control();
		alu = new ALU();
		datamemory = new DataMemory();
		instructionmemory = new InstructionMemory();
		alumux = new Mux(32);
		registerfiles = new RegisterFiles();
		branchadder = new ALU();
		registerfilemux = new Mux(5);
		datamemorymux = new Mux(32);
		alucontrol = new ALUControl();
		signextenssion = new SignExtenssion();
		addermux = new Mux(32);
		adder = new Adder();
		and = new AND();
		pcadder = new Adder();

		opcode = new boolean[6];
		rs = new boolean[5];
		rt = new boolean[5];
		rd = new boolean[5];
		funct = new boolean[6];
		shamt = new boolean[5];
		address = new boolean[16];
	}

	void cycle() {
		boolean[] instruction = fetch();
		decode(instruction);
		execute();
		memoryaccess();
		writeback();
	}

	private void writeback() {
		pcadder.i1 = ALU.intToBooleanArray(pcCounter);
		pcadder.i2 = ALU.intToBooleanArray(1);
		pcadder.operate();

		adder.i1 = pcadder.result;
		adder.i2 = signextenssion.output;
		adder.operate();

		and.in1 = controlUnit.branch;
		and.in2 = alu.zero;
		and.operate();

		addermux.a = pcadder.result;
		addermux.b = adder.result;
		addermux.s = and.result;
		addermux.operateMux();

		pcCounter = ALU.binaryArrayToInt(addermux.result);
	}

	private void memoryaccess() {
		datamemory.address = alu.result;
		datamemory.writeData = registerfiles.readData2;
		datamemory.memWrite = controlUnit.memWrite;
		datamemory.memRead = controlUnit.memRead;
		datamemory.memoryAccess();

		datamemorymux.setB(datamemory.readData);
		datamemorymux.setA(alu.result);
		datamemorymux.operateMux();

		registerfiles.writeData = datamemorymux.result;
		registerfiles.updateWriteOperation();
	}

	private void execute() {
		controlUnit.setAluOp(opcode);
		controlUnit.operate();

		registerfilemux.setA(rt);
		registerfilemux.setB(rd);
		registerfilemux.setS(controlUnit.regDest);
		registerfilemux.operateMux();

		registerfiles.setReadData1(rs);
		registerfiles.setReadData2(rt);
		registerfiles.setWriteRegister(registerfilemux.getResult());
		registerfiles.setRegWrite(controlUnit.regWrite);
		registerfiles.operate();

		signextenssion.input = address;
		signextenssion.extend();

		alumux.setA(registerfiles.readData2);
		alumux.setB(signextenssion.output);
		alumux.setS(controlUnit.aluSrc);
		alumux.operateMux();

		alucontrol.setAluOp(controlUnit.aluOp);
		alucontrol.setFunct(funct);
		alucontrol.operate();

		alu.setData1(registerfiles.readData1);
		alu.setData2(alumux.result);
		alu.setAluControl(alucontrol.getResult());
		alu.calculate();
	}

	private void decode(boolean[] instruction) {
		for (int i = 0; i < 6; i++) { // opcode
			opcode[i] = instruction[i];
		}
		for (int i = 6, j = 0; i < 11; i++, j++) { // rs
			rs[j] = instruction[i];
		}
		for (int i = 11, j = 0; i < 16; i++, j++) { // rt
			rt[j] = instruction[i];
		}
		for (int i = 16, j = 0; i < 21; i++, j++) { // rd
			rd[j] = instruction[i];
		}
		for (int i = 16, j = 0; i < 32; i++, j++) { // address
			address[j] = instruction[i];
		}
		for (int i = 26, j = 0; i < 32; i++) { // funct
			funct[j] = instruction[i];
		}
		for (int i = 21, j = 0; i < 26; i++, j++) { // shamt
			shamt[j] = instruction[i];
		}
	}

	private boolean[] fetch() {
		return instructionmemory.getInstruction(pcCounter);
	}
	
	public void mipsoperator() {
		for(int i=0; i<instructionmemory.instructions.size(); i++) {
			cycle();
		}
	}

}