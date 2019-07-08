package interpreter.bytecode;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode {
    String label = "";
    int finalAddress = 0;

    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        vm.setPc(finalAddress);
    }

    public String toString() {
        return "GOTO " + label;
    }

    public String getLabel() {
        return label;
    }

    public void setFinalAddress(int finalAddress) {
        this.finalAddress = finalAddress;
    }
}
