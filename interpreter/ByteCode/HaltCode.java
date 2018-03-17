/**
 *sub class of CodeTable
*/
package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {
	public void init(ArrayList<String> arr) { }	//has no arguments

	public void execute(VirtualMachine vm) {
		vm.endProgram();
	}

	@Override
	public String toString() {
		return "HALTCODE ";
	}
}