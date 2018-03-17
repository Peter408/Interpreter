/**
 *sub class of CodeTable
*/
package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
	private int value;
	private String id;
	private int topStack;
	public void init(ArrayList<String> arr) {
		value = Integer.parseInt(arr.get(0));
		id = arr.get(1);
	}

	public void execute(VirtualMachine vm) {
		vm.storeRunStack(value);
		topStack = vm.peekRunStack();
	}

	@Override
	public String toString() {
		return "STORE " + value + " " + id + "    " + id + " = " + topStack;
	}
}