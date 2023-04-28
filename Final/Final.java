public class Final extends Ri {
        public static void main (String args[]) throws java.io.FileNotFoundException { 
                new Final().main();
	}

        void main() throws java.io.FileNotFoundException {

                RiBegin(RI_NULL);
                RiDisplay("file.tiff", "file", "rgba", RI_NULL);
                RiProjection("perspective", RI_NULL);
                RiTranslate(0, 0, 10);
                RiWorldBegin(1.0);
            
                //bspline
                RiAttributeBegin();
                // double[] red = {1.0,0.0,0.0};
                double[] silver = {1,1,0.8};
                // RiBxdf("PxrSurface","shader","color diffuseColor",red,"int diffuseDoubleSided",1);
                // new BSplineSurfaceDrawer().PatchDrawClosed("testBB");
                RiBxdf("PxrSurface","shader","color diffuseColor",silver,"int diffuseDoubleSided",1);
                RiTranslate(7,7,0);
                RiScale(0.3,0.3,0.3);
                new BSplineSurfaceDrawer().PatchDraw("testAA");
                RiAttributeEnd();
            
                //lsys
                RiAttributeBegin();
                RiTranslate(-200,-150,300);
                RiScale(0.3,0.3,0.3);
                LsysExample lsys = new LsysExample();
                lsys.example2();
                RiTranslate(1200,0,0);
                lsys.example2();
                RiAttributeEnd();
            
                //stars
                RiAttributeBegin();
                Points p = new Points();
                p.stars();
                RiAttributeEnd();
            
                // //phone
                // RiAttributeBegin();
                // double[] Color1 = {0.2, 0.4, 0.6};
                // RiBxdf("PxrSurface","test1","color diffuseColor",Color1);
                // RiTranslate(-1,0.5,-9);
                // RiScale(0.003,0.003,0.003);
                // RiRotate(45,1,0,0);
                // Phone p1 = new Phone();
                // p1.PhoneMesh();
                // RiAttributeEnd();
            
                //car
                RiAttributeBegin();
                RiTranslate(1,-4.5,-2);
                RiRotate(45,0,1,0);
                RiScale(0.5,0.5,0.5);
                KObject car = new KObject();
                car.car();
                RiAttributeEnd();
            
                //snowman
                RiAttributeBegin();
                RiTranslate(0, -2, 4);
                RiScale(0.5,0.5,0.5);
                KObject snowman = new KObject();
                snowman.snowman();
                RiAttributeEnd();
            
                RiWorldEnd();
                RiEnd();
        }
            
}
