
public class Point {

	public double originalWidth;
	public double originalLength;
	public double width = 10.0;
	public double length = 16.0;
	public Point() {

	}

	public String toString() {
		return "Point w/l"+width+"  "+length;
	}

	public Point copy() {
		Point back = new Point();

		back.width = width;
		back.length = length;
		back.originalLength = this.originalLength;
		back.originalWidth = this.originalWidth;
		return back;
	}
}
