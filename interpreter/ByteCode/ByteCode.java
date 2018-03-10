/**
 *abstract class
*/
package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public abstract class ByteCode {
	public abstract void init(ArrayList<String> arr);

	public abstract void execute(VirtualMachine vm);
}