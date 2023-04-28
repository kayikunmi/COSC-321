public class Mockup extends Ri {
	public static void main (String args[]) throws java.io.FileNotFoundException { 
	    
	    
	    new Mockup().main();
	}



    void main() 
	throws java.io.FileNotFoundException

	{

    	RiBegin(RI_NULL);
		RiDisplay("test.tiff","file","rgba",RI_NULL);

		RiProjection("perspective",RI_NULL);
		
		RiTranslate(0,0,10);




		RiWorldBegin(1.0);


		RiAttributeBegin();
		double[] red = {1.0,0.0,0.0};
	    double[] green = {0.0,1.0,0.0};
		RiBxdf("PxrSurface","shader","color diffuseColor",
				red,"int diffuseDoubleSided",1);
		
	

		new BSplineSurfaceDrawer().PatchDrawClosed("testBB");
		RiBxdf("PxrSurface","shader","color diffuseColor",green,"int diffuseDoubleSided",1);

		RiTranslate(4,4,0);

		new BSplineSurfaceDrawer().PatchDraw("testAA");
		
		
		RiAttributeEnd();

		
		RiAttributeBegin();
		
		RiTranslate(-200,-100,300);
		RiScale(0.3,0.3,0.3);


		LsysExample lsys = new LsysExample();
		lsys.example3();
		
		
		RiTranslate(1200,0,0);

		lsys.example3();
		
		RiAttributeEnd();
		
		RiAttributeBegin();
		
		Points p = new Points();
		p.stars();
		
		
		RiAttributeEnd();
		
		RiAttributeBegin();
		double[] Color1 = {0.2, 0.4, 0.6};
		RiBxdf("PxrSurface","test1","color diffuseColor",Color1);
		
		RiTranslate(-1,0.5,-9);

		RiScale(0.003,0.003,0.003);		
		RiRotate(45,1,0,0);	
		Phone p1 = new Phone();
		p1.PhoneMesh();
		
		RiAttributeEnd();
		
		RiAttributeBegin();
	
		
		RiTranslate(1,-4.5,-2);
		RiRotate(45,0,1,0);	
		RiScale(0.4,0.4,0.2);
		JerCube cube = new JerCube();
		cube.unitCube(2.0,1.0);
		
		RiAttributeEnd();

		RiWorldEnd();
		RiEnd();
	}

}
