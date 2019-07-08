package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    Scanner scanner = new Scanner(System.in);

    public void init(ArrayList<String> args) {}

    public void execute(VirtualMachine vm) {
        System.out.print("Please enter a number: ");
        int userInput = scanner.nextInt();
        vm.push(userInput);
    }

    public String toString() {
        return "READ ";
    }
}
