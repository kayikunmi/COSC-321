public class JerCube extends Ri {

    double[] White = {1.0,1.0,1.0};
    double[] Blue = {0.0,0.0,1.0};
    double[] Red = {1.0,0.0,0.0};
    double[] Grey = {0.3,0.3,0.3};

    public static double[] Unit[] = {
	{-1.0, -1.0, 0.0},
	{-1.0,  1.0, 0.0},
	{ 1.0,  1.0, 0.0},
	{ 1.0, -1.0, 0.0}};

    void scaledUnitSquare(double s) {
	RiTransformBegin();
	RiScale(s,s,s);
	RiPolygon(4, RI_P,  Unit, RI_NULL);
	RiTransformEnd();
    }


    void unitCube(double s, double explode) {

	double transAmount = s*explode;

	RiBxdf("PxrSurface","surface1","int diffuseDoubleSided",1,"color diffuseColor",White);

	RiTransformBegin();
	RiTranslate(0.0,0.0,transAmount);
	scaledUnitSquare(s);
	RiTransformEnd();

	RiTransformBegin();
	RiTranslate(0.0,0.0,-transAmount);
	scaledUnitSquare(s);
	RiTransformEnd();


	RiBxdf("PxrSurface","surface1","int diffuseDoubleSided",1,"color diffuseColor",Blue);

	RiTransformBegin();
	RiTranslate(transAmount,0.0,0.0);
	RiRotate(90.0,0.0,1.0,0.0);
	scaledUnitSquare(s);
	RiTransformEnd();

	RiTransformBegin();
	RiTranslate(-transAmount,0.0,0.0);
	RiRotate(90.0,0.0,1.0,0.0);
	scaledUnitSquare(s);
	RiTransformEnd();

	RiBxdf("PxrSurface","surface1","int diffuseDoubleSided",1,"color diffuseColor",Red);

	RiTransformBegin();
	RiTranslate(0.0,-transAmount,0.0);
	RiRotate(90.0,1.0,0.0,0.0);
	scaledUnitSquare(s);
	RiTransformEnd();

	RiTransformBegin();
	RiTranslate(0.0,transAmount,0.0);
	RiRotate(90.0,1.0,0.0,0.0);
	scaledUnitSquare(s);
	RiTransformEnd();
    }
}
