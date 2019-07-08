package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    int i;
    String codeID;

    public void init(ArrayList<String> args) {
        if (args.size() == 1) {
            i = Integer.parseInt(args.get(0));
        } else {
            codeID = args.get(args.size() - 1);
            i = Integer.parseInt(args.get(0));
        }
    }

    public void execute(VirtualMachine vm) {
        vm.load(i);
    }

    public String toString() {
        return "LOAD " + i + " " + codeID + "   <load " + codeID + ">";
    }

}

