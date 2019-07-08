package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    int i;
    String code = "";

    public void init(ArrayList<String> args) {
        if (args.size() == 1) {
            i = Integer.parseInt(args.get(0));
        } else {
            code = args.get(args.size() - 1);
            i = Integer.parseInt(args.get(0));
        }
    }

    public void execute(VirtualMachine vm) {
        vm.store(i);
    }

    public String toString() {
        return "STORE " + i + " " + code + "   m = " + i;
    }

}
