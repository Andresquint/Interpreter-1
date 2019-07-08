package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    private String functionName = "";
    private int value = 0;

    public void init(ArrayList<String> args) {
        if (!args.isEmpty()) {
            functionName = args.get(0);
        }
    }

    public void execute(VirtualMachine vm) {
        vm.popFrame();
        vm.setPc(vm.popReturnAddrs());
        value = vm.peek();
    }

    public String toString() {
        return "RETURN " + functionName;
    }
}

