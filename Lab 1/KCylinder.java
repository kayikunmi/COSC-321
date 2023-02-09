public class KCylinder extends Ri{
    void SolidCylinder(double radius, double zmin, double zmax){
	RiCylinder(radius, zmin, zmax, 360.0, RI_NULL);
	//RiSphere(zmin, radius, 360.0, RI_NULL);
   // RiSphere(4.0, 1.0, 8.0, 360.0, RI_NULL);
	//RiDisk(zmax, radius, 360.0, RI_NULL);
    }

    void object(){
        RiCylinder(6, 1, 12, 360, RI_NULL);
        //RiSphere(4.0, 1.0, 8.0, 360.0, RI_NULL);
        RiTranslate(0.0, 2, 4);
    
    }
}
