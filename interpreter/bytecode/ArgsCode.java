package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode{
    int argsCode = 0;

    public void init(ArrayList<String> args) {
        argsCode = Integer.parseInt(args.get(0));
    }

    public void execute(VirtualMachine vm) {
        vm.newFrameAt(argsCode);
    }

    public String toString() {
        return "ARGS " + argsCode;
    }
}
