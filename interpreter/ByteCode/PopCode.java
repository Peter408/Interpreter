/**
 *sub class of CodeTable
*/
package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
	private String str;
	public void init(ArrayList<String> arr) {
		str = arr.get(0);
	}

	public void execute(VirtualMachine vm) {
		vm.popRunStackFrame(Integer.parseInt(str));
	}

	@Override
	public String toString() {
		return "POP";
	}
}