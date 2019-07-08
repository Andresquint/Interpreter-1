package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    int lit = 0;
    String code = "";

    public void init(ArrayList<String> args) {
        lit = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            code = args.get(args.size() - 1);
        }
    }

    public void execute(VirtualMachine vm) {
        vm.push(lit);
    }

    public String toString() {
        String printLitCode = "LIT " + lit + " " + code;
        if (lit == 0) {
            printLitCode +=  "   int " + code;
        }
        return printLitCode;
    }
}
