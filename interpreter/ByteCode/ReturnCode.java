/**
 *sub class of CodeTable
*/
package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
	private String funcName;
	private int value;

	public void init(ArrayList<String> arr) {
		if(!arr.isEmpty())
			funcName = arr.get(0);
	}

	public void execute(VirtualMachine vm) {
		vm.popFrame();
		value = vm.popReturnAddrs();
		vm.setPC(value);
	}

	@Override
	public String toString() {
		return "RETURN " + funcName + " exit: " + value;
	}
}