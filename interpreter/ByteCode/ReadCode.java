/**
 *sub class of CodeTable
*/
package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
	public void init(ArrayList<String> arr) { }

	public void execute(VirtualMachine vm) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an Integer: ");
		vm.pushRunStack(scanner.nextInt());
	}

	@Override
	public String toString() {
		return "READ";
	}
}