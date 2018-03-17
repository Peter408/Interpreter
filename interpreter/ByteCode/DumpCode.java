/**
 *sub class of CodeTable
*/
package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
	private String toggle;

	public void init(ArrayList<String> arr) {
		toggle = arr.get(0);
	}

	public void execute(VirtualMachine vm) {
		if(toggle.toUpperCase().equals("ON"))
			vm.setDumping(true);
		else if(toggle.toUpperCase().equals("OFF"))
			vm.setDumping(false);
	}

	@Override
	public String toString() { return null; }
}