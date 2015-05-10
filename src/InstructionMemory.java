import java.util.ArrayList;

public class InstructionMemory {
    ArrayList<boolean[]> instructions;
    public InstructionMemory(){
        instructions = new ArrayList<boolean[]>();
    }
    public void setInstruction(boolean[] instruction) {
        this.instructions.add(instruction);
        //instruction.split(" ") 
    }
    public boolean[] getInstruction(int index) {
        return instructions.get(index);
    }
}