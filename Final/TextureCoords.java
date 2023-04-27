public class TextureCoords extends Ri {

    public static void main 
	(String args[]) { 
 
	new TextureCoords().main();
    }

    static double[] quad[] = { 
	{1.0,1.00,1.0}, 
	{-1.0,1.0,1.0}, 
	{-1.0,-1.0,1.0}, 
	{1.0,-1.0,1.0} 
    };


    void main ()

    {

	RiBegin(RI_NULL);

	RiDisplay("test.tiff","file","rgba",RI_NULL);
	RiFormat(10,10,1.0);

	RiProjection("perspective",RI_NULL);
  
	RiTranslate(0.0,0.0,5.0);


	RiWorldBegin();

	RiTranslate(0.0,0.0,5.0);

	// new code for step a
	RiScale(1,1,2);
	RiRotate(15,0,0,1);
	// end of new code


	RiCoordinateSystem("shaderDefine");
	RiPattern("jerShader","jerShader");
	
	RiBxdf("PxrSurface","surface1","reference color diffuseColor", "jerShader:Cout", RI_NULL);
	RiTransformBegin();
	RiTranslate(0.0,0.0,5.0);
	RiPolygon(4, RI_P, quad, RI_NULL);
	RiTransformEnd();
	
	RiWorldEnd();

	RiEnd();
    }

}
