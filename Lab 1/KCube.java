/* 
public class KCube extends Ri {

    int[] red = {235, 64, 52};
    int[] green = {9, 107, 35};
    int[] gold = {235, 178, 7};
    int[] violet = {117, 48, 166};

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
    
        RiBxdf("PxrSurface","surface1","int diffuseDoubleSided",1,"color diffuseColor",red);
    
        RiTransformBegin();
        RiTranslate(0.0,0.0,transAmount);
        scaledUnitSquare(s);
        RiTransformEnd();
    
        RiTransformBegin();
        RiTranslate(0.0,0.0,-transAmount);
        scaledUnitSquare(s);
        RiTransformEnd();
    
    
        RiBxdf("PxrSurface","surface1","int diffuseDoubleSided",1,"color diffuseColor",gold);
    
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
    
        RiBxdf("PxrSurface","surface1","int diffuseDoubleSided",1,"color diffuseColor",violet);
    
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
*/
public class KCube extends Ri{
    // void SolidCylinder(double radius, double zmin, double zmax){
    //     RiCylinder(radius, zmin, zmax, 360.0, RI_NULL);
    //     //RiDisk(zmin, radius, 360.0, RI_NULL);
    //     RiSphere(radius, zmin, zmax, 360.0, RI_NULL);
    //     RiSphere(radius, zmin, zmax, 360.0, RI_NULL);
    //     //RiDisk(zmax, radius, 360.0, RI_NULL);
    // }

    void object(){
        RiCylinder(6, 1, 4, 360, RI_NULL);
        RiTranslate(0.0, 0.0, 2);
        RiScale(1, 0, 0);

    }
}