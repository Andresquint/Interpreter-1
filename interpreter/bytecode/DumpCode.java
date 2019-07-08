package interpreter.bytecode;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    String label = "";

    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        if (label.equals("ON")) {
            vm.dumpOn();
        } else {
            vm.dumpOff();
        }
    }

    public String toString() {
        return "DUMP " + label;
    }
}
