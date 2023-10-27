package section2;

import section2.Term3;

public class Term3 {
	public int coef;
	public int expo;
	
	public Term3(int c, int e) {
		coef = c;
		expo = e;
	}
	
	public void printTerm() {
		System.out.print(coef + "x^" + expo );
	}
	
	public int calcTerm(int x) {
		return (int) (coef * Math.pow(x, expo));
	}
}
