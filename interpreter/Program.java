package interpreter;

import interpreter.bytecode.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Program extends Object{

    private ArrayList<ByteCode> program ;
    /*private*/ static HashMap<String, Integer> labelTable = new HashMap<>();

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) { return this.program.get(pc); }

    public int getSize() {
        return this.program.size();
    }

    protected void addCode(ByteCode byteCode){
        if (byteCode instanceof LabelCode) {
            LabelCode newBranch = (LabelCode) byteCode;
            addLabel(newBranch.getLabel(), program.size());
        }
        program.add(byteCode);
    }

    protected static void addLabel(String label, int size) {
        labelTable.put(label, size);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {
        for (int i = 0; i < program.getSize(); i++) {
            if (program.getCode(i) instanceof GotoCode) {
                GotoCode newCode = (GotoCode) program.getCode(i);
                newCode.setFinalAddress(labelTable.get(newCode.getLabel()));
            } else if (program.getCode(i) instanceof FalseBranchCode) {
                FalseBranchCode newCode = (FalseBranchCode) program.getCode(i);
                newCode.setFinalAddress(labelTable.get(newCode.getLabel()));
            } else if (program.getCode(i) instanceof CallCode) {
                CallCode newCode = (CallCode) program.getCode(i);
                newCode.setFinalAddress(labelTable.get(newCode.getLabel()));
            }
        }
    }
}
