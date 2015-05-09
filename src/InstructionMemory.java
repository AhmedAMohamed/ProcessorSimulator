import java.util.ArrayList;

public class InstructionMemory {
    ArrayList<String> instructions;
    public InstructionMemory(){
        instructions = new ArrayList<String>();
        for(int i = 0; i < 512; i++) {
            instructions.add(new String());
        }
    }
    public void setInstruction(String instruction) {
        this.instructions.add(instruction);
        //instruction.split(" ") 
    }
    public String getInstruction(int index) {
        return instructions.get(index);
    }
}