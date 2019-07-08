package interpreter;

import interpreter.bytecode.*;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dump;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    protected void executeProgram() {
        pc = 0;
        dump = false;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<>();
        isRunning = true;
        while(isRunning) {
            ByteCode newCode = program.getCode(pc);
            newCode.execute(this);
            if (dump && !(newCode instanceof DumpCode)) {
                System.out.println(newCode.toString());
                runStack.dump();
            }
            pc++;
        }
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public int peek() {
        return runStack.peek();
    }

    public int pop() {
        return runStack.pop();
    }

    public void newFrameAt(int offset) {
        runStack.newFrameAt(offset);
    }

    public void popFrame() {
        runStack.popFrame();
    }

    public int store(int offset) {
        return runStack.store(offset);
    }

    public int load(int offset) {
        return runStack.load(offset);
    }

    public void push(int result) {
        runStack.push(result);
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getPc() {
        return pc;
    }

    public int popReturnAddrs() {
        return (int) returnAddrs.pop();
    }

    public void pushReturnAddrs(int address) {
        returnAddrs.push(address);
    }

    public void dumpOn() {
        dump = true;
    }

    public void dumpOff() {
        dump = false;
    }

}
