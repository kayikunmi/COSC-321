
public class Intersection implements Comparable<Intersection>{

	protected Traceable object;
	protected double t;

	public Intersection(Traceable object, double t) {
		this.object = object;
		this.t = t;
	}

	public String toString() {
		return ""+object+"  "+t;
	}

	@Override
	public int compareTo(Intersection o) {
		if (t < o.t)
			return -1;
		else if (t > o.t)
			return 1;
		else return 0;

	}
}
