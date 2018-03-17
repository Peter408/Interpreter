/**
 *sub class of CodeTable
*/
package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
	private int value;
	private String str;
	public void init(ArrayList<String> arr) {
		value = Integer.parseInt(arr.get(0));
		str = arr.get(1);
	}

	public void execute(VirtualMachine vm) {
		vm.loadRunStack(value);
	}

	@Override
	public String toString() {
		String str2 = "Load " + value;
		if(str != null)
			str2 += " " + str + "   <load " + str + ">";
		return str2;
	}
}