package section4_2;

public class RtTriangle extends Shape {
	public int width;
	public int height;
	
	public RtTriangle (int w, int h) {
		super("RtTriangle");
		width = w;
		height = h;
	}
	
	public double computeArea() {
		return 0.5 * width * height; 
	}
	
	public double computePerimeter() {
		return width + height + Math.sqrt(height*height + width*width);
	}
	
	public String toString() {
		return  "RtTriangle : width is " + width + ", height is " + height;
	}
}
