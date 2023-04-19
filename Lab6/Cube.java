import java.util.ArrayList;

public class Cube extends Traceable {

	/* A Cube is cube centered at the origin, extending from -1 to +1 on
	 * each axis
	 * 
	 * Note:  there is a bug in local_intersect so it sometimes does not work
	 * correctly, but this should not give you a problem.
	 */

	public String toString() {
		return "Cube \n"+this.transform;
	}


	
	@Override
	public ArrayList<Intersection> local_intersect(Ray gray) {
			
		
		var ray = gray.transform(transform.invert());

		double[] rets = 
				check_axis(ray.origin.t[0], ray.direction.t[0]);
		double xtmin = rets[0];
		double xtmax = rets[1];

		rets = check_axis(ray.origin.t[1], ray.direction.t[1]);
		if (rets[0] > xtmin)
			xtmin = rets[0];
		if (rets[1] < xtmax)
			xtmax = rets[1];

		rets = check_axis(ray.origin.t[2], ray.direction.t[2]);
		if (rets[0] > xtmin)
			xtmin = rets[0];
		if (rets[1] < xtmax)
			xtmax = rets[1];

		ArrayList<Intersection> ans = new ArrayList<Intersection>();



		if (xtmin >= xtmax || xtmax == Double.POSITIVE_INFINITY) 
			return ans;

		ans.add(new Intersection(this, xtmin));
		ans.add(new	Intersection(this, xtmax));	

		return ans;
	}



	private double[] check_axis(double origin, double direction) {
		double tmin_numerator = (-1 - origin);
		double tmax_numerator = (1 - origin);
		double tmin;
		double tmax;
		if (Math.abs(direction) >= Aux.EPSILON) {
			tmin = tmin_numerator / direction;
			tmax = tmax_numerator / direction;
		}
		else {
				if (tmin_numerator >= 0)
				tmin =  Double.POSITIVE_INFINITY;
				else if (tmin_numerator <=0)
					tmin = Double.NEGATIVE_INFINITY;
				else tmin = 0;
				
				if (tmax_numerator >= 0)
					tmax =  Double.POSITIVE_INFINITY;
					else if (tmax_numerator <=0)
						tmax = Double.NEGATIVE_INFINITY;
					else tmax = 0;

		}

		if (tmin > tmax) {
			double temp = tmin;
			tmin = tmax;
			tmax = temp;
		}

		return new double[] {tmin, tmax};

	}



	@Override
	public Vector local_normal_at(Point point, Intersection dontUse) {
		double x = point.t[0];
		double y = point.t[1];
		double z = point.t[2];
		//System.out.println(x + " " + y + " " + z);
		if(x>=y && x>=z){//x is greatest
			Point px = new Point(x, 0, 0);
			Vector vx = new Vector(px);
			//System.out.println("vx: " + vx);
			return vx;
		}
		else if(y>=x && y>=z){//y is greatest
			Point py = new Point(0, y , 0);
			Vector vy = new Vector(py);
			//System.out.println("vy: " + vy);
			return vy;
		}
		else if(z>=x && z>=y){//z is greatest
			Point pz = new Point(0,0, z);
			Vector vz = new Vector(pz);
			//System.out.println("vz: " + vz);
			return vz;
		}
		else{
			return null;
		}
	}

	public static void main(String[] args) {


	}



	@Override
	public boolean includes(Traceable object) {

		return this == object;
	}

}
