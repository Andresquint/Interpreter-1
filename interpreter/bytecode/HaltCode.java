package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {

    public void init(ArrayList<String> args) {}

    public void execute(VirtualMachine vm) {
        vm.setRunning(false);
    }

    public String toString() {
        return "HALT ";
    }
}
