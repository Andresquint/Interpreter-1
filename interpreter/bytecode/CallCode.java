package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {
    String label = "";
    int finalAddr = 0;

    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        vm.pushReturnAddrs(vm.getPc());
        vm.setPc(finalAddr);
    }

    public String toString() {
        String callPrint = "CALL " + label;
        if (label != null) {
            callPrint += "   f(3)";
        }
        return callPrint;
    }

    public String getLabel() {
        return label;
    }

    public void setFinalAddress(int finalAddr) {
        this.finalAddr = finalAddr;
    }
}
