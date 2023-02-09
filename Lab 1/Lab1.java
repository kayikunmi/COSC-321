public class Lab1 extends Ri {

    public static void main 
	(String args[]) { 
 
	new Lab1().main();
    }

    double[] White = {1.0,1.0,1.0};
    double[] Blue = {0.0,0.0,1.0};
    double[] Red = {1.0,0.0,0.0};
    double[] Grey = {0.3,0.3,0.3};

    void main (){

	int frameCount = 1;

	RiBegin(RI_NULL);
 
	// here we set options that will hold for all frames

	RiFormat(400,400,1.0);
	RiPixelVariance(0.1);

	RiProjection("perspective",RI_NULL);


	for (int frameNo=1; frameNo<frameCount+1; frameNo++) {

	    String fileName;

	    // writes the name of the file for the frame into 
	    // fileName (String)

	    if (frameNo<10)
		fileName = "frame00"+frameNo+".tiff";
	    else if (frameNo<100) fileName = "frame0"+frameNo+".tiff";
	    else fileName = "frame"+frameNo+".tiff";


	    // set the display as a file for the frame

	    RiDisplay(fileName,"file","rgba",RI_NULL);
    
	    // start the frame

	    RiFrameBegin(frameNo-1);
    
	    // If you give RiWorldBegin a parameter, it is used to set the intensity of the default
	    // light source.  Without a parameter, it is set to 0.1 (Note: the default light source
	    // is something I built in to the Amherst system
    
	    RiWorldBegin(1.0);

     
	    // move all whole world away from the origin

	    RiTranslate(0.0,0.0,1.0);

    
	    // RiAttributeBegin();
      
	    // //RiTranslate(-0.3*frameNo,0.4*frameNo,10.0-1.5*frameNo);
	    // //RiScale(5.0,5.0,5.0);

	    // double[] darkOrange = {1.0,0.549,0};
	    // RiBxdf("PxrSurface","surface1","int diffuseDoubleSided",1,"color diffuseColor", darkOrange);

		// RiTranslate(1, 3,4);
		// new KCylinder().object();
	    // RiAttributeEnd();
		
		//add objects here

		RiAttributeBegin();
		double[] darkOrange = {1.0,0.549,0};
	    RiBxdf("PxrSurface","surface1","int diffuseDoubleSided",1,"color diffuseColor", darkOrange);
		
		//RiRotate(45.0+5.0*frameNo,1.0,1.0,1.0);
		RiTranslate(2.0,2.0,8.0);
		new KCylinder().object();
		RiAttributeEnd();

		RiAttributeBegin();
		RiTranslate(2.0,3.0,5.0);
		//RiRotate(0.0, 4.2, 5.0);
	    RiScale(5.0,5.0,5.0);
		new KCube().object();
		RiAttributeEnd();

		RiAttributeBegin();
		double[] rand = {103.0,0.205,0};
	    RiBxdf("PxrSurface","surface1","int diffuseDoubleSided",1,"color diffuseColor", rand);
		
		//RiRotate(45.0+5.0*frameNo,1.0,1.0,1.0);
		RiTranslate(2.0,2.0,8.0);
		new KCylinder().SolidCylinder(2,0,7);
		RiAttributeEnd();

       
	    // RiAttributeBegin();
	    // double[] Color2 = {0.0,0.749,1.0};
	    // RiBxdf("PxrSurface","surface1","int diffuseDoubleSided",1,"color diffuseColor",Color2);

    
	    // RiTranslate(2.0,3.0,5.0);
	    // RiScale(5.0,5.0,5.0);

	
	    // RiRotate(45.0+5.0*frameNo,1.0,1.0,1.0);
	    // //new JerObject2().object();

	    // RiAttributeEnd();

	    // RiAttributeBegin();
    
	    // RiTranslate(-frameNo*0.4,frameNo*0.2,frameNo*frameNo*0.1);
    
	    // //RiRotate(8.0*frameNo,4.0,2.0,8.0);
	    // //new JerCube().unitCube(0.2,1.0);
		// RiTranslate(2.0,2.0,8.0);
	    // //RiScale(100.0,100.0,1.0);
		// // RiSphere (3, 2, 5, 360.0, RI_NULL);
		// // RiCylinder(6, 1, 12, 360, RI_NULL);
    
	    // RiAttributeEnd();


	    // a backdrop

	    double[] Grey = {0.5,0.5,0.5};
	    RiBxdf("PxrSurface","surface1","int diffuseDoubleSided",1,"color diffuseColor", Grey);

	    RiTranslate(2.0,2.0,8.0);
	    //RiScale(100.0,100.0,1.0);
	    //RiPolygon(4, RI_P,  JerCube.Unit, RI_NULL);
		


	    // render frame, destroy lighting, objects and state created in the world,
	    // restore start to that before the world begin

	    RiWorldEnd();


	    RiFrameEnd();

	}  


	RiEnd();


    }




}

