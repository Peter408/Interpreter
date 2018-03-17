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
        if(!runTimeStack.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            for (Integer aFramePointer : framePointer) {
                int frame = aFramePointer;
                if (frame > 0)
                    list.add(frame);
            }
            System.out.print("[");
            boolean comma = true;
            for(int i = 0; i < runTimeStack.size(); i++) {
                if(!list.isEmpty() && list.size() > 0)
                    if(list.get(0) == i)
                        System.out.print("] [");
                if(!list.isEmpty())
                    if(list.get(0) == i+1)
                        comma = false;
                System.out.print(runTimeStack.get(0));
                if( (runTimeStack.size() != 1) && ((runTimeStack.size()-1) != i) && comma)
                    System.out.print(",");
                if(!comma)
                    comma = true;
            }
            System.out.println("]");
        }
    }

    public int peek() {
        return runTimeStack.get(runTimeStack.size() - 1);
    }

    public int pop() {
        if(!runTimeStack.isEmpty())   //check out of bound
            return runTimeStack.remove(runTimeStack.size() - 1);
        return 0;
    }

    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size()-offset);
    }

    public void popFrame() {
        int value = runTimeStack.remove(runTimeStack.size()-1);
        while(runTimeStack.size() > framePointer.peek())
            runTimeStack.remove(runTimeStack.size()-1);
        framePointer.pop();
        runTimeStack.add(value);
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
