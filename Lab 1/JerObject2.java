
public class JerObject2 extends Ri{

    void SolidCylinder(double radius, double zmin, double zmax){

		  
	RiCylinder(radius, zmin, zmax, 360.0, RI_NULL);
	RiDisk(zmin, radius, 360.0, RI_NULL);
	RiDisk(zmax, radius, 360.0, RI_NULL);
		  

    }


    void object(){
	SolidCylinder(0.1, -0.5, 0.5);
	RiTranslate(0.0, 0.0, -0.3);
	SolidCylinder(0.15, -0.05, 0.05);
	RiTranslate(0.0, 0.0, 0.6);
	SolidCylinder(0.15, -0.05, 0.05);
	RiTransformBegin();
	RiRotate(90.0, 1.0, 0.0, 0.0);
	SolidCylinder(0.1, -0.5, 0.5);
	RiTranslate(0.0, 0.0, -0.3);
	SolidCylinder(0.15, -0.05, 0.05);
	RiTranslate(0.0, 0.0, 0.6);
	SolidCylinder(0.15, -0.05, 0.05);
	RiTransformEnd();
	RiTransformBegin();
	RiRotate(90.0, 0.0, 1.0, 0.0);
	SolidCylinder(0.1, -0.5, 0.5);
	RiTranslate(0.0, 0.0, -0.3);
	SolidCylinder(0.15, -0.05, 0.05);
	RiTranslate(0.0, 0.0, 0.6);
	SolidCylinder(0.15, -0.05, 0.05);
	RiTransformEnd();
    }

}
