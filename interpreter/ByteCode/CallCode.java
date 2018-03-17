/**
 *sub class of CodeTable
*/
package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {
	private String address;

	public void init(ArrayList<String> arr) {
		address = arr.get(0);
	}

	public void setAddress(int num) {
		address = Integer.toString(num);
	}

	public String getAddress() {
		return address;
	}

	public void execute(VirtualMachine vm) {
		vm.pushReturnAddrsPC();
		vm.setPC(Integer.parseInt(address));
	}

	@Override
	public String toString() {
		return "CALL " + address;
	}
}