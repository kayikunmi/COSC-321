public class KCylinder extends Ri{
    void SolidCylinder(double radius, double zmin, double zmax){
	RiCylinder(radius, zmin, zmax, 360.0, RI_NULL);
	//RiDisk(zmin, radius, 360.0, RI_NULL);
    RiSphere(radius, zmin, zmax, 360.0, RI_NULL);
    RiSphere(radius, zmin, zmax, 360.0, RI_NULL);
	//RiDisk(zmax, radius, 360.0, RI_NULL);
    }

    void object(){
        RiCylinder(6, 1, 4, 360, RI_NULL);
        RiTranslate(0.0, 0.0, 2);
        RiScale(1, 0, 0);

    }
}