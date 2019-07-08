package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    String operation = "";

    public void init(ArrayList<String> args) {
        operation = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        int op1 = 0, op2 = 0;
        if (operation.equals("+") || operation.equals("-") || operation.equals("/") || operation.equals("*")
                || operation.equals("==") || operation.equals("!=") || operation.equals("<=")
                || operation.equals(">") || operation.equals(">=") || operation.equals("<")
                || operation.equals("|") || operation.equals("&")) {
            op1 = vm.pop();
            op2 = vm.pop();
        }

        if (operation.equals("+")) {
            vm.push(op1+op2);
        } else if (operation.equals("-")) {
            int result = op2 - op1;
            vm.push(result);
        } else if (operation.equals("*")) {
            int result = op2 * op1;
            vm.push(result);
        } else if (operation.equals("/")) {
            int result = op2 / op1;
            vm.push(result);
        } else if (operation.equals("==")) {
            int result = 0;
            if (op2 == op1) {
                result = 1;
            }
            vm.push(result);
        } else if (operation.equals("!=")) {
            int result = 0;
            if (op2 != op1) {
                result = 1;
            }
            vm.push(result);
        } else if (operation.equals("<")) {
            int result = 0;
            if (op2 < op1) {
                result = 1;
            }
            vm.push(result);
        } else if (operation.equals("<=")) {
            int result = 0;
            if (op2 <= op1) {
                result = 1;
            }
            vm.push(result);
        } else if (operation.equals(">")) {
            int result = 0;
            if (op2 > op1) {
                result = 1;
            }
            vm.push(result);
        } else if (operation.equals(">=")) {
            int result = 0;
            if (op2 >= op1) {
                result = 1;
            }
            vm.push(result);
        } else if (operation.equals("|")) {
            int result = 0;
            if (op2 == 1 || op1 == 1) {
                result = 1;
            }
            vm.push(result);
        } else if (operation.equals("&")) {
            int result = 0;
            if (op2 == 1 && op1 == 1) {
                result = 1;
            }
            vm.push(result);
        }
    }

    public String toString() {
        return "BOP " + operation;
    }
}
