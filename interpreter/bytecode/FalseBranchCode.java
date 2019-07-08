package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {
    String label = "";
    int finalAddress = 0;

    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        int temp = vm.pop();
        if (temp == 0) {
            vm.setPc(finalAddress);
        }
    }

    public String toString() {
        return "FALSEBRANCH " + label;
    }

    public String getLabel() {
        return label;
    }

    public void setFinalAddress(int finalAddress) {
        this.finalAddress = finalAddress;
    }
}
