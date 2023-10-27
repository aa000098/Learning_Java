package section2;

import section2.Term2;

public class Term2 {
	public int coef;
	public int expo;
	
	public void printTerm() {
		System.out.print(coef + "x^" + expo );
	}
	
	public int calcTerm(int x) {
		return (int) (coef * Math.pow(x, expo));
	}
}
