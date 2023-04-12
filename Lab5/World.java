import java.util.ArrayList;

import javax.imageio.event.IIOWriteWarningListener;
import javax.swing.text.Position;

public class World {

	// The list of Traceable Objects

	ArrayList<Traceable> objects = new ArrayList<Traceable>();
	ArrayList<LightSource> lights = new ArrayList<LightSource>();
	Point np = new Point(4,4,0);
	MyColor c = new MyColor(0,0,1);
	PointLight pl = new PointLight(c, np);

	public World() {}

	public void add(Traceable t) {
		objects.add(t);
	}
	
	public void KSphere() {
		lights.add(pl);
		Sphere ks1 = new Sphere();
		//ks1.transform = Transformations.getTranslate(4, 3, 0);
		ks1.material = new Material();
		ks1.material.specular = 0;
		ks1.material.diffuse = 1.7;
		ks1.material.ambient = 0;
		objects.add(ks1);
	}

	public void KCube() {
		Cube k1 = new Cube();
		k1.transform = Transformations.getTranslate(0.8, 0.8, 0.5);
		k1.transform = Transformations.getScale(0.5, 0.5, 0.9);
		Material material1 = new Material();
		material1.specular = 0.763;
		material1.color = new MyColor (0.9, 0.24, 0.6);
		k1.material = material1;
		Cube k2 = new Cube();
		k2.transform = Transformations.getRotY(0.3);
		k2.transform = Transformations.getScale(0.8, 0.2, 0.5);
		Material material2 = new Material();
		material2.color = new MyColor (0.8, 0.6, 0.37);
		material2.ambient = 0.75;
		k2.material = material2;
		objects.add(k1);
		objects.add(k2);
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
		int counter = 0;
		
		for(int i = 0; i < hsize; i++){
			for(int j = 0; j < vsize; j++){
				Vector direction = new Vector(2*(size*i/hsize) - size, 2*(size*j/vsize) - size, -1);
				Ray ray = new Ray(origin,direction);
				ArrayList<Intersection> raylist = new ArrayList<Intersection>();
				raylist = intersectWorld(ray);
				double b = j/255;
				MyColor col1 = new MyColor(1, 0.5, b);
				MyColor col2 = new MyColor(0.75,b,0.4); 
				MyColor col3 = new MyColor(b,b,0.9); 
				MyColor col4 = new MyColor(0.5,b,0.67);
				MyColor col5 = new MyColor(1,0,0); 
				MyColor red = new MyColor(1,0,0); 
				MyColor blue = new MyColor(0,0,1); 
				counter++;

				Intersection ishit = Traceable.hit(raylist);
				
				if(Traceable.hit(raylist)==null){ //is null
					// if(counter%3 ==0){
					// 	cav.writeP(i,j,col1);
					// 	cav.writeP(j,i,col5);
					// }
					// else{
						cav.writeP(i,j,red);
					// }
					//cav.writeP(i,j,col1);
					//cav.writeP(j,i,col2);
				}
				else{ //not null
					//System.out.println("hit works");
					// if(counter%3 ==0){
					// 	cav.writeP(i,j,col4);
					// 	cav.writeP(j,i,col3);
					// }
					// else{
					// 	cav.writeP(i,j,col2);
					Point p = ray.position(ishit.t);
					MyColor ce = new MyColor(Tuple.mult(ishit.object.material.color, pl.intensityAt(p, this)));
		
					//MyColor plc = pl.intensityAt(p, this);
					cav.writeP(i,j,ce);
					// }
					//cav.writeP(i,j,col3);
					// cav.writeP(j,i,col4);
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
		//w.KCube();
		w.KSphere();
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