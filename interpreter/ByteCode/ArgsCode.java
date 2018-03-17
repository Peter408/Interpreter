/**
 *sub class of CodeTable
*/
package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
	private String num;
	public void init(ArrayList<String> arr) {
		num = arr.get(0);
	}

	public void execute(VirtualMachine vm) {
		vm.newFrameAt(Integer.parseInt(num));
	}

	public String toString() {
		return "ARGS " + num;
	}
}