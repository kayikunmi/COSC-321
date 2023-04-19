import java.util.ArrayList;

public class PointLight extends LightSource{

	public String toString() {
		return "Point light at "+this.position+" with intensity "+this.intensity;
	}
	
	@Override
	public MyColor intensityAt(Point point, World w) {
		//fill
		//if point is not shadowed, ret false
		//if had return int/2

		if(this.isShadowed(point, w)){
			MyColor intcol = new MyColor(this.intensity.t[0]/2, this.intensity.t[1]/2,this.intensity.t[2]/2);
			return intcol;
		}
		else{
			return this.intensity;
		}
		//return MyColor.White;
						
	}

	
	public MyColor getIntensity() {
		return intensity;
	}



	public void setIntensity(MyColor intensity) {
		this.intensity = intensity;
	}



	public Point getPosition() {
		return position;
	}



	public void setPosition(Point position) {
		this.position = position;
	}



	public PointLight(MyColor intensity, Point position) {
		super();
		this.intensity = intensity;
		this.position = position;
	}
	
	
	public PointLight(double r, double g, double b, double x, double y, double z) {
		super();
		this.intensity = new MyColor(r,g,b);;
		this.position = new Point(x,y,z);
	}




	public static void main(String[] args) {

	}

}