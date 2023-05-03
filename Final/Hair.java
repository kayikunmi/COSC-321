public class Hair extends Ri {


    public static void main( String args[ ])
    { Hair hr = new Hair( );
        hr.main();
    }


    int pts = 7;  //must be 4 plus a multiple of 3 

    void main( ) {
	
        double[] bkgd[ ] = {
                {  1,1,	0 } ,
                {-1,1,	0 },
                {-1,-1,	0 } ,
                {  1,-1,0}
        } ;



        RiBegin(100);

        RiDisplay( "hair.tiff",	"file", "rgba", RI_NULL);


        RiFormat( 800, 600, 1.0);
        RiProjection("perspective" , RI_NULL) ;
	RiWorldBegin(2 );


        // camera shift
        RiTranslate (0, -5, 5);

        RiTransformBegin();
        double[] hairColor = {0.54, 0.27, 0.074};
        double[] color1 = {0,0.3,0};
        RiBxdf("PxrSurface","hairShader","color diffuseColor",hairColor);
        RiTranslate(0, 0, 2);

            //hair
            int numCurves = 1000;

            // generation of numVertsArray
            int[] numVertsArray = new int[numCurves];

            for (int i = 0; i <  numVertsArray.length; i++) {
                numVertsArray[ i] = pts;

            }

            // getting the coordinate array
            double [][] hairParams	= getHair(numVertsArray);

            RiTranslate(0.0,-10.0,28.0);
            //RiRotate(-15.0, 1.0, 0.0, 0.0);


            double [] lightSpot = {0.0,5.0,1.5};
            //double intens = 5.0;

            double [] lightSourcel	= {0.0, 12.0, -10.0};
            double [] lightSource2	= {0.0,	8.0, 0.2};
            double [] lightSource3	= {0.0,	4.0, 0.2};

            double intens = 30.0;
            LightSource("pointlight","from",lightSource2,"intensity",100000.0,RI_NULL);


            RiCurves( "cubic", numCurves, numVertsArray,
		      "nonperiodic", "P", hairParams,
		      "constant float width", 0.01);

            RiTranslate(0.0,0.0,50.0);
            RiRotate(15.0, 1.0, 0.0, 0.0);
            RiScale(100.0,100.0,1.0);
            RiPolygon( 4, RI_P, bkgd, RI_NULL) ;

        RiTransformEnd( );
        RiWorldEnd();
        RiEnd();
    }

    private void LightSource(String string, String string2, double[] lightSourcel, String string3, double intens,
                             Object riNull) {

	RiTransformBegin();
	RiTranslate(0,30,0);
        RiLight("PxrSphereLight","light3","float intensity",intens,RI_NULL);
	RiTransformEnd();
    }


    double [][] getHair (int [] numVertsArray) {

        int c = pts*numVertsArray.length;
	//        for ( int i : numVertsArray )
	//  c += i;
        double[ ][] params = new double [c][3];


        for (int i = 0; i < params.length; i++) {
            double [] point = new double [3];

            if ( i % pts  == 0 ) {
                point[0] = Math.random( )*30-15;
                point[1] = 0;
                point[2] = Math. random()*30-15;
                params[i] = point;
            }
            else {
                point[0] = params[i-1] [0] + Math.random()*10 - 1; // switch to 10
                point[1] = params[i-1] [1] + Math.random()*4.5 + 1;
                point[2] = params[ i-1] [2] + Math.random()*2 - 1;
                params[ i] = point;
            }
        }
        return params;
    }

}