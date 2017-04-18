package parafeel.pageone;

import java.util.Stack;

/**
 * 
 * @author wh-pc
 * @date 2017年4月17日
 * @keywords
 * 
 * 
 * 			Evaluate the value of an arithmetic expression in Reverse Polish
 *           Notation.Valid operators are+,-,*,/. Each operand may be an integer
 *           or another expression. Some examples: ["2", "1", "+", "3", "*"] ->
 *           ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) ->
 *           6
 * 
 *           这个题就是在处理这个反向波兰表示法的字符串。
 * 
 * 
 */

public class Solution2 {
	public int evalRPN(String[] tokens) {
		int length = tokens.length;
		Stack<Integer> stack = new Stack<>();
		int a, b, c;
		for (int i = 0; i < length; i++) {
			if (!isOperator(tokens[i])) {
				stack.push(Integer.parseInt(tokens[i]));
			} else {
				b = stack.pop();
				a = stack.pop();
				c = this.getRS(a, b, tokens[i]);
				stack.push(c);
			}
		}

		return stack.peek();
	}

	public boolean isOperator(String string) {
		if ("+".equals(string) || "-".equals(string) || "*".equals(string) || "/".equals(string)) {
			return true;
		} else
			return false;
	}

	public int getRS(int a, int b, String operator) {
		if ("+".equals(operator)) {
			return a + b;
		} else if ("-".equals(operator)) {
			return a - b;
		} else if ("*".equals(operator)) {
			return a * b;
		} else if ("/".equals(operator)) {
			return a / b;
		}
		return 0;
	}

}
