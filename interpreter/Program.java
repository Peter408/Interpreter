package interpreter;

import interpreter.ByteCode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    public void add(ByteCode bc) {
        this.program.add(bc);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 1; i < program.getSize(); i++) {
            ByteCode code = program.getCode(i);
            if(code instanceof LabelCode) {
                map.put( ((LabelCode)code).getLabel(), i);
            }
        }
        for(int i = 0; i < program.getSize(); i++) {   //efficient change, make instance of
            ByteCode code = program.getCode(i);
            if(code instanceof FalseBranchCode) {
                    ((FalseBranchCode) code).setAddress(map.get(((FalseBranchCode) code).getAddress()));
            }
            if(code instanceof GotoCode) {
                ((GotoCode) code).setAddress(map.get(((GotoCode) code).getAddress()));
            }
            if(code instanceof CallCode) {
                ((CallCode) code).setAddress(map.get(((CallCode) code).getAddress()));
            }
        }
    }




}
