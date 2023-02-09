public class KCube extends Ri{
    // void SolidCylinder(double radius, double zmin, double zmax){
    //     RiCylinder(radius, zmin, zmax, 360.0, RI_NULL);
    //     //RiDisk(zmin, radius, 360.0, RI_NULL);
    //     RiSphere(radius, zmin, zmax, 360.0, RI_NULL);
    //     RiSphere(radius, zmin, zmax, 360.0, RI_NULL);
    //     //RiDisk(zmax, radius, 360.0, RI_NULL);
    // }

    void object(){
        RiCone(6,3, 4, RI_NULL);
        RiTranslate(8, 2.0, 5);
        RiScale(0, 0, 3);
        
    }
}