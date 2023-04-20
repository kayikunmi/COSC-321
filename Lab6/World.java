import java.util.ArrayList;

import javax.imageio.event.IIOWriteWarningListener;
import javax.swing.text.Position;

public class World {

	// The list of Traceable Objects

	ArrayList<Traceable> objects = new ArrayList<Traceable>();
	ArrayList<LightSource> lights = new ArrayList<LightSource>();
	Point np = new Point(3, 3, 0);
	MyColor c = new MyColor(1,1,1);
	PointLight pl = new PointLight(c, np);

	public World() {}

	public void add(Traceable t) {
		objects.add(t);
	}
	
	public void KSphere() {
		lights.add(pl);
		Sphere ksph = new Sphere();
		
		ksph.transform = Transformations.getScale(3,4,1.0);
		ksph.transform = Transformations.getTranslate(2, 4, 0);

		ksph.material = new Material();
		ksph.material.diffuse = 1.7;
		ksph.material.specular = 0.0;
		ksph.material.ambient = 0.4;
		MyColor scol =  new MyColor (0.93, 0.24, 0.72);
		ksph.material.color = scol;

		//ksph.local_normal_at(np, null);
		objects.add(ksph);
	}

	public void KCube() {
		lights.add(pl);
		Cube k1 = new Cube();
		k1.transform = Transformations.getTranslate(3, 1, 0);
		k1.transform = Transformations.getScale(2, 1, 1);
		Material material1 = new Material();
		material1.specular = 0.763;
		material1.color = new MyColor (0.77, 0.85, 0.25);
		k1.material = material1;
		objects.add(k1);
	}

	public void setDefault() {
		Cube s1 = new Cube();
		Material material = new Material();
		material.color = new MyColor (0.8, 1.0, 0.6);
		material.diffuse = 0.7;
		material.specular = 0.2;
		s1.material = material;
		Cube s2 = new Cube();
		//System.out.println(s2);
		s2.transform = Transformations.getTranslate(0,-8,-4);
		s2.transform = Transformations.getScale(0.5, 0.5, 0.5);	
		//System.out.println(s2);

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
		for(int i = 0; i < hsize; i++){
			for(int j = 0; j < vsize; j++){
				Vector direction = new Vector(2*(size*i/hsize) - size, 2*(size*j/vsize) - size, -1);
				Ray ray = new Ray(origin,direction);
				ArrayList<Intersection> raylist = new ArrayList<Intersection>();
				raylist = intersectWorld(ray);
				MyColor red = new MyColor(0.94, 0.76, 0.75); 

				Intersection ishit = Traceable.hit(raylist);
				
				if(ishit==null){ 
					cav.writeP(i,j,red);
				}
				else{
					Point p = ray.position(ishit.t);
					Vector v1 = ishit.object.local_normal_at(p, ishit);
					Vector v2 = ishit.object.normal_to_world(v1);
					Point p2 = null;
					if(ishit.object.includes(ishit.object)){//cube
						p2 = new Point(v2.t[0], v2.t[1], v2.t[2]);
					}
					else{	
						p2 = new Point(v2.t[0] + 0.1, v2.t[1] + 0.1, v2.t[2] + 0.1);
					}
					MyColor c = new MyColor(Tuple.mult(ishit.object.material.color, pl.intensityAt(p2, this)));
					MyColor ge = new MyColor(c.t[0] * 0.2, c.t[1] * 0.2, c.t[2] * 0.2);
					double nls = Tuple.dot(v2, pl.intensityAt(p2, this));
					nls *= ishit.object.material.diffuse;
					Tuple lcoc = Tuple.mult(pl.getIntensity(), ishit.object.material.color);
					MyColor diff = new MyColor(lcoc);
					MyColor ce  = new MyColor(diff.t[0] * ge.t[0] * nls, diff.t[1] * ge.t[1] * nls, diff.t[2] * ge.t[2] * nls);

					cav.writeP(i,j,ce);
				}
			}
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
		w.KSphere();
		w.KCube();
		// w.triple();
		// w.setDefault();
		w.render("test99.ppm", 1000, 1000,5);

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