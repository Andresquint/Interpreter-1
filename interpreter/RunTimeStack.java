package interpreter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {
        Iterator newIterator = framePointer.iterator();
        int counter = (Integer) newIterator.next();
        if (newIterator.hasNext()) {
            counter = (Integer) newIterator.next();
        }
        System.out.printf("[");
        if (!runTimeStack.isEmpty()) {
            System.out.print(runTimeStack.get(0));
        }
        for (int i = 1; i < runTimeStack.size(); i++) {
            if (i == counter) {
                System.out.print("][" + runTimeStack.get(i));
                if (newIterator.hasNext()) {
                    counter = (Integer) newIterator.next();
                }
            } else {
                System.out.print("," + runTimeStack.get(i));
            }
        }
        System.out.println("]");
    }

    public int peek() {
        return runTimeStack.get(runTimeStack.size() - 1);
    }

    protected int pop() {
        int i= runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        return i;
    }

    /**
     * This method is used to start a new frame
     * @param offset the offset from the start of the frame
     */
    public void newFrameAt(int offset) {
        framePointer.push(this.runTimeStack.size() - offset);
    }

    /**
     * This method is used to pop the frame
     */
    public void popFrame() {
        int return_val = runTimeStack.get(runTimeStack.size() - 1);
        while (runTimeStack.size() != framePointer.peek()) {
            runTimeStack.remove(runTimeStack.size() - 1);
        }
        framePointer.pop();
        runTimeStack.add(return_val);
    }

    /**
     * This method is used to value into variabels
     * @param offset the offset from the start of the frame
     */
    public int store(int offset) {
        int storeVal = runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        runTimeStack.set(offset + framePointer.peek(), storeVal);

        return storeVal;
    }

    public int load(int offset) {
        int temp = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(temp);
        return temp;
    }

    public Integer push(Integer i) {
        runTimeStack.add(i);
        return i;
    }
}
