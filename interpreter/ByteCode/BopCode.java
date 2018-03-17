/**
 *sub class of CodeTable
*/
package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
	private String operator;
	public void init(ArrayList<String> arr) {
		operator = arr.get(0);
	}

	public void execute(VirtualMachine vm) {
		int op2 = vm.popRunStack();
		int op1 = vm.popRunStack();


		switch (operator) {
			case "+":
				vm.pushRunStack(op1 + op2);
				break;
			case "-":
				vm.pushRunStack(op1 - op2);
				break;
			case "*":
				vm.pushRunStack(op1 * op2);
				break;
			case "/":
				vm.pushRunStack(op1 / op2);
				break;
			case "==":
				if (op1 == op2)
					vm.pushRunStack(1);    //true
				else
					vm.pushRunStack(0);    //false
				break;
			case "!=":
				if (op1 != op2)
					vm.pushRunStack(1);
				else
					vm.pushRunStack(0);
				break;
			case "<=":
				if (op1 <= op2)
					vm.pushRunStack(1);
				else
					vm.pushRunStack(0);
				break;
			case ">":
				if (op1 > op2)
					vm.pushRunStack(1);
				else
					vm.pushRunStack(0);
				break;
			case ">=":
				if (op1 >= op2)
					vm.pushRunStack(1);
				else
					vm.pushRunStack(0);
				break;
			case "<":
				if (op1 < op2)
					vm.pushRunStack(1);
				else
					vm.pushRunStack(0);
				break;
			case "|":
				if (op1 == 1 || op2 == 1)
					vm.pushRunStack(1);
				else
					vm.pushRunStack(0);
				break;
			case "&":
				if (op1 == 1 && op2 == 1)
					vm.pushRunStack(1);
				else
					vm.pushRunStack(0);
				break;
		}
	}

	@Override
	public String toString() {
		return "BOP ";
	}
}