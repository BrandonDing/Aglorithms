package ag.basic;

import ag.utils.AglorithmsException;

import java.util.Stack;

public class Evaluate {

	public static void main(String[] args) {
		System.out.println(eval("( 1 + ( ( 2 * 4 ) + ( 7 * ( 9 - 4 ) ) ) )"));
		System.out.println(eval("1 + 2 * 4 + 7 * ( 9 - 4 )"));
	}

	public static double eval(String expression) {
		if (expression.length() < 1) {
			throw new AglorithmsException("Expression is empty.");
		}
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		//用split的限制，符号和数字必须用space分开
		for (String s : expression.split(" ")) {
			if (s.equals("("))
				;
			else if (s.equals("+"))
				ops.push(s);
			else if (s.equals("-"))
				ops.push(s);
			else if (s.equals("*"))
				ops.push(s);
			else if (s.equals("/"))
				ops.push(s);
			//用右括号的限制，每个符号必须对应一次右括号，否则不予计算
			else if (s.equals(")")) {
				String op = ops.pop();
				Double val = vals.pop();
				if (op.equals("+"))
					val = vals.pop() + val;
				else if (op.equals("-"))
					val = vals.pop() - val;
				else if (op.equals("*"))
					val = vals.pop() * val;
				else if (op.equals("/"))
					val = vals.pop() / val;
				vals.push(val);
			} else if (s.equals(" "))
				;
			else
				vals.push(Double.valueOf(s));
		}
		return vals.pop();
	}

}
