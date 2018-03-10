package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() 
    {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {
        //nothing atm
    }

    public int peek() {
        return runTimeStack.get(runTimeStack.size() - 1);
    }

    public int pop() {
        return runTimeStack.remove(runTimeStack.size() - 1);
    }

    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size()-offset);
    }

    public void popFrame() {
        Integer value = framePointer.peek();
        framePointer.pop();
        framePointer.push(value);
    }

    public int store(int offset) {
        int value = runTimeStack.remove(runTimeStack.size() - 1);
        runTimeStack.set(framePointer.peek() + offset, value);
        return value;
    }

    public int load(int offset) {
        int value = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(value);
        return value;
    }

    public Integer push(Integer i) {
        runTimeStack.add(i);
        return i;
    }
    
}
