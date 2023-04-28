public class BSplineDisplay extends Ri {
	public static void main (String args[]) throws java.io.FileNotFoundException { 
	    
	    double x = 0;
	    double y = 0;
	    double z = 0;
	    double rotY = 0;
	    String filename = "test1";
	    boolean closed = false;
	    double intensity = 0.1;
	    
	    for (int i = 0; i < args.length ;) {
		System.out.println(args[i]);
		if (args[i].toLowerCase().equals("translate")) {
		    x = Double.valueOf(args[i+1]);
		    y = Double.valueOf(args[i+2]);
		    z = Double.valueOf(args[i+3]);
		    i = i+4;
		}
		else if (args[i].toLowerCase().equals("rotatey")) {
		    rotY = Double.valueOf(args[i+1]);
		    i = i+2;
		}  
		else if (args[i].toLowerCase().equals("filename")) {
		    System.out.println("FileName "+args[i+1]);
		    filename = args[i+1];
		    i = i+2;
		}
		else if (args[i].toLowerCase().equals("closed")) {
		    closed = true;
		    i = i + 1;
		}
		else if (args[i].toLowerCase().equals("intensity")) {
		    intensity = Double.valueOf(args[i+1]);
		    i = i + 2;
		}
		else {
		    System.out.println("Skipping unknown option "+args[i]);
		    i = i + 1;
		}
	    }

 
	    new BSplineDisplay().main(x,y,z,rotY,closed,filename,intensity);
	}



    void main(double x , double y, double z , double rotY, boolean closed,
	      String filename, double intensity) 
	throws java.io.FileNotFoundException

	{



		RiBegin(RI_NULL);
		RiDisplay("test.tiff","framebuffer","rgba",RI_NULL);

		RiProjection("perspective",RI_NULL);
		
		RiTranslate(x,y,z);




		RiWorldBegin(intensity);


		RiTransformBegin();
		double[] red = {1.0,0.0,0.0};
	     
		RiBxdf("PxrSurface","shader","color diffuseColor",red,"int diffuseDoubleSided",1);
		double[] green = {0.0,1.0,0.0};
		RiRotate(rotY,0,1,0);
		if (closed)
		    new BSplineSurfaceDrawer().PatchDrawClosed(filename);
		else 
		    new BSplineSurfaceDrawer().PatchDraw(filename);
		//		RiColor(green);
	
		RiTransformEnd();


		RiWorldEnd();
		RiEnd();
	}

}
