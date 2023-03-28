import java.util.ArrayList;

import javax.imageio.event.IIOWriteWarningListener;

public class World {

	// The list of Traceable Objects

	ArrayList<Traceable> objects = new ArrayList<Traceable>();

	public World() {

	}

	public void add(Traceable t) {
		objects.add(t);
	}

	public void setDefault() {


		Cube s1 = new Cube();
		Material material = new Material();
		material.color = new MyColor (0.8, 1.0, 0.6);
		material.diffuse = 0.7;
		material.specular = 0.2;
		s1.material = material;
		Cube s2 = new Cube();
		System.out.println(s2);
		s2.transform = Transformations.getTranslate(0,-8,-4);
		//s2.transform = Transformations.getScale(0.5, 0.5, 0.5);	
		System.out.println(s2);

		objects.add(s1);
		objects.add(s2);


	}

	/*
	 * NOTE:  RIGHT HAND COORDINATE SYSTEM
	 * Using 0,0,2 as the center of projection, casting rays toward the z = -1
	 * plane, with the "film" covering size by size centered at the origin
	 * 
	 * generate an image hsize by vsize pixels  and store it in fileName
	 Use one of my world setup routines to start, then make your own.
	 Once this is working, do somethhing ionteresting with the color = 
	 use something to vary the color on your objects.
	 * 
	 */

	public Canvas render(String fileName, int hsize, int vsize, double size) {
	
		Canvas cav = new Canvas(hsize,vsize);
		Point origin = new Point(0,0,2);
		Vector direction = new  Vector(-0.5,0,-1);
		Ray ray = new Ray(origin,direction);
		//System.out.println("ray: " + ray);
		ArrayList<Intersection> raylist = new ArrayList<Intersection>();
		raylist = intersectWorld(ray);
		System.out.println("arraylist: " + raylist);
		MyColor col = new MyColor(1,0,0);

	
		if(Traceable.hit(raylist)==null){
			System.out.println("null here");
		}
		else{
			System.out.println("hit works");
		}
		
		cav.toPPM(fileName);
		System.out.println("Tracer world done");

		return cav;
	}



	public ArrayList<Intersection> intersectWorld(Ray r) {
		ArrayList<Intersection> result = new ArrayList<Intersection>();
		for (Traceable o : objects) {
			ArrayList<Intersection> inters = o.intersections(r);
			result = Traceable.mergeInters(inters, result);
		}
		return result;
	}

	public static void main(String[] args) {

		World w = new World();
		w.triple();
		//w.setDefault();
		w.render("test99.ppm", 1000, 1000,10);

	}


	public void triple() {

		Cube middle = new Cube();
		middle.transform = Matrices.mult(
				Transformations.getTranslate(-0.5, 1,0),
				Transformations.getScale(0.5,0.5,0.7));
		middle.material = new Material();
		middle.material.color = new MyColor(1,0,1);
		middle.material.diffuse = 0.7;
		middle.material.specular = 0.3;
		middle.material.ambient = 0.9;

		add(middle);

		Cube right = new Cube();
		right.transform = Matrices.mult(
				Transformations.getTranslate(1.5, 0.5,0),
				Transformations.getScale(0.5,0.5,0.5));
		right.material = new Material();
		right.material.color = new MyColor(0,1,0);
		right.material.diffuse = 0.7;
		right.material.specular = 0.0;
		right.material.ambient = 0.9;
		add(right);

		Cube left = new Cube();
		left.transform = Matrices.mult(
				Transformations.getTranslate(-2.75, 0.73,-0.75),
				Transformations.getScale(1.33,1.33,1.33));
		left.material = new Material();
		left.material.color = new MyColor(1,0,0);
		left.material.diffuse = 0.0;
		left.material.specular = 0.3;
		left.material.ambient = 0.9;
		add(left);


		Cube fourth = new Cube();
		fourth.transform = Matrices.mult(
				Transformations.getTranslate(1.5, 2.0,-0.5),
				Transformations.getScale(0.5,0.5,0.5));
		fourth.material = new Material();
		fourth.material.color = new MyColor(1,1,1);
		fourth.material.diffuse = 1.7;
		fourth.material.specular = 0.0;
		fourth.material.ambient = 0.0;

		add(fourth);
	}

}