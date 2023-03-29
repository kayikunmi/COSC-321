public class Squares extends Ri {

	public static void main (String args[]) { 
		new Squares().go();
	}

	double[] quad[] = { 
			{1.0,1.00,1.0}, 
			{-1.0,1.0,1.0}, 
			{-1.0,-1.0,1.0}, 
			{1.0,-1.0,1.0} 
	};


	void go()

	{

		RiBegin(RI_NULL);
		
		RiDisplay("test.tiff","file","rgba",RI_NULL);

		RiFormat(800,600,1);
		RiProjection("perspective",RI_NULL);

		RiTranslate(0.0,0.0,2.0);

		RiWorldBegin(0.5);

		RiScale(0.4,0.4,0.4);

		RiCoordinateSystem("shaderDefine");

		RiPattern("jerShader","jerShader");
		RiBxdf("PxrSurface","surface1",
		       "reference color diffuseColor", "jerShader:Cout", RI_NULL);		
		
		stack();

		RiTranslate(2.0,0.0,0.0);
		stack();

		RiTranslate(-6.0,0.0,0.0);
		stack();

		RiWorldEnd();
		RiEnd();
	}

	void stack() {

      		double[] Color2 = {1.0,0.0,0.0};

		RiTransformBegin();
		
		RiTranslate(0.0,0.0,0.5);
		RiRotate(180,0,1,0);
		RiPolygon(4, RI_P, quad, RI_NULL);
		RiTransformEnd();

		RiTransformBegin();
		RiTranslate(0.0,3.0,0.5);

		RiRotate(45.0,0.0,0.0,1.0);
		RiRotate(180,0,1,0);
		RiPolygon(4, RI_P, quad, RI_NULL);
		RiTransformEnd();

		RiTransformBegin();

		RiTranslate(0.0,-3.0,0.5);
		RiRotate(10.0,0.0,1.0,0.0);
		RiRotate(180,0,1,0);
		RiPolygon(4, RI_P, quad, RI_NULL);
		RiTransformEnd();



	}
}
