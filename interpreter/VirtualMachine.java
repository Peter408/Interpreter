package interpreter;

import interpreter.ByteCode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dumping = false;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<>();
        isRunning = true;
        while(isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if(dumping) {
                System.out.println(code);
                runStack.dump();
            }
            pc++;
        }
    }

    public int peekRunStack() {
        return runStack.peek();
    }

    public int popRunStack() {
        return runStack.pop();
    }
    public void popRunStackFrame(int offset) {
        for(int i = 0; i < offset; i++) {
            runStack.pop();
        }
    }

    public void pushRunStack(int i) {
        runStack.push(i);
    }

    public void newFrameAt(int offset) {
        runStack.newFrameAt(offset);
    }

    public void popFrame() {
        runStack.popFrame();
    }

    public void storeRunStack(int offset) {
        runStack.store(offset);
    }

    public void loadRunStack(int offset) {
        runStack.load(offset);
    }

    public void pushReturnAddrsPC() {
        returnAddrs.push(pc);
    }

    public int popReturnAddrs() {
        return returnAddrs.pop();
    }

    public void endProgram() {
        isRunning = false;
    }

    public void setPC(int i) {
        pc = i;
    }

    public void setDumping(boolean bool) {
        dumping = bool;
    }

}
