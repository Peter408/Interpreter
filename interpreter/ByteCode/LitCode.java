/**
 *sub class of CodeTable
*/
package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
	private int value;
	private String str;
	public void init(ArrayList<String> arr) {	//check this
		value = Integer.parseInt(arr.get(0));
		if(arr.size() == 2)	//if has another value
			str = arr.get(1);
	}

	public void execute(VirtualMachine vm) {
		vm.pushRunStack(value);
	}

	@Override
	public String toString() {
		String str2 = "Lit " + value;
		if(!str.isEmpty())
			str2 += "int " + str;
		return str2;
	}
}