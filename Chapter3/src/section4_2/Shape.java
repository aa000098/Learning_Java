package section4_2;

public abstract class Shape implements Comparable { // MyComparable
	public String shapeName;
	
	public Shape(String name) {
		shapeName = name;
	}
	
	public abstract double computeArea();		// 추상 메서드
	public abstract double computePerimeter();	// 추상 메서드

	public int compareTo(Object other) {
		double myArea = computeArea();
		double yourArea = ((Shape)other).computeArea();
		if (myArea < yourArea) return -1;
		else if (myArea == yourArea) return 0;
		else return 1;
	}
}
