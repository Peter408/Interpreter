/**
 *sub class of CodeTable
*/
package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {
	public void init(ArrayList<String> arr) { }

	public void execute(VirtualMachine vm) {
		System.out.println(vm.peekRunStack());
	}

	@Override
	public String toString() {
		return "WRITE";
	}
}