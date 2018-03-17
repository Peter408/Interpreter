/*
 *sub class of CodeTable
*/
package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {

	private String address;

	public void init(ArrayList<String> arr) {
		address = arr.get(0);
	}

	public String getLabel() {
		return address;
	}

	public void execute(VirtualMachine vm) { }	//does not execute

	@Override
	public String toString() {
		return "LABEL ";
	}
}