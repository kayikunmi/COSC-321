
public class LsysExample extends Ri{


	public static void main(String[] args) {
		new LsysExample().go(args);
	}

	public void go(String[] args) {
		double scaleFactor= 0.5;
		int moveDown = 100;
		int which = 5;


		for (int pos = 0; pos< args.length; ) {
			switch (args[pos].toLowerCase()) {
			case "which" : 
				which = Integer.parseInt(args[pos+1]);
				pos = pos + 2;
				break;   
			case "scale" :
				scaleFactor = Double.parseDouble(args[pos+1]);
				pos = pos + 2;
				break;
			case "movedown":
				moveDown = Integer.parseInt(args[pos+1]);
				pos = pos + 2;
				break;
			default: 
				System.out.println("Unhandled option "+args[pos]);
				pos = pos +1;
				break;
			}
		}


		RiBegin(RI_NULL);

		RiDisplay("test.tiff","file","rgba",RI_NULL);
		RiProjection("perspective",RI_NULL);

		RiFormat(1024,1024,1);


		RiWorldBegin(0.5);

		RiTranslate(0.0,-moveDown,300);
		RiScale(scaleFactor,scaleFactor,scaleFactor);



		if (which == 1)
			example1();
		else if (which ==2)
			example2();
		else if (which == 3)
			example3();
		else if (which == 4)
			example4();
		else if (which == 5)
			example5();

		double[] back = {0.2,0.2,0.2};
		new DoColor().color(back[0],back[1],back[2]);
		RiTranslate(0,0,10);
		RiRotate(20.0,1.0,0.0,0.0);
		RiScale(1000.0,1000.0,1000.0);

		RiWorldEnd();

		RiEnd();


	}
	void example5() {
		example(new String[] {"A[+F]+S//[S-F]+A"},"A+F-S+A-S+F",7,30 ,1.0,20,45);

	}
	void example4() {
		example(new String [] {"F[+F]F[F-F]F"},"F+F",3,45,1.0,1,10);
	}
	void example2() {
		example(new String [] {"FF[+F]F[-F]F"},"F",5,25.7,1.0,1,5);
	}

	void example1() {
		example(new String [] {"FF-F++F-F"},"F++F++F",3,60,1.0,1,10);
	}

	void example3() {
		int depth = 4 + ((int)Math.random())*3;
		double degree = 15 + 9.0*Math.random();
		double percent = .7 + .2*Math.random();
		example(new String[] {"A"+"[+F[//L]A]ttttt[+F[//LA]]ttttttt[+F[//L]A]",
				"F"+"StttttF",
				"S"+"F[//L]"},"A",depth,degree ,percent,7.5,50);

	}

	/** generate a plant given a set of rules
	 @param rules The rules, the first character should be the left hand side.  Rules should 
	 be deterministic but see percent below
	 @param axiom the starting point of the derivation
	 @param depth the depth of the derivation (the number of substitution cycles)
	 @param angle the turning angle - this is the same for all directions
	 @param percent used in stochastic rules (note - very limited the ONE rule applies in the percent given )
	 */
	public  void example(String[] rules, String axiom, int depth, double angle, 
			double percent, double width, double length) {

		APlant pm = new APlant();
		pm.setAxiom(axiom);
		pm.setRules(rules);
		String sample = new PlantMaker().makePlant(pm,depth,percent);

		System.out.println(sample);

		PlantRenderer pr = new PlantRenderer(sample,
				new TurtleBuilder().length(length).width(width).angleX(angle).angleY(angle).angleZ(angle).buildK());

		pr.startPlantDrawing();
	}


}
