public class Phone extends Ri {
public static void main 
               (String args[]) { 
 
new Phone().main();
}
//Subdivision Mesh Construction
//originally by Tom Wexler, Yan Karklin

 
void PhoneMesh()
{
 int nfaces = 20; 
 int nvertices[] = {3,4,4,3,4,3,4,4,3,4,4,4,4,4,4,4,4,4,4,4};
 int vertices[] = {0,5,16,
			   16,5,6,7,  
			   0, 1, 4, 5, 
			   1,17,4,
			   4,17,2,3,
			   8,18,13,
			   18,15,14,13,
			   8,13,12,9,
			   9,12,19,
			   12,11,10,19,
			   0,8,9,1,
			   1,9,19,17,
			   17,19,10,2,
			   2,10,11,3,
			   3,11,12,4,
			   4,12,13,5,
			   5,13,14,6,
			   6,14,15,7,
			   8,0,16,18,
			   16,7,15,18
};

  double[] sdmpoints[] = { {-20,15,0},
				  {20,15,0},
				  {30,-15,-5},
				  {15,-10,0},
				  {15,0,0},
				  {-15,0,0},
				  {-15,-10,0},
				  {-30,-15,-5},
				  {-20,15,20},
				  {20,15,20},
				  {30,-15,25},
				  {15,-10,20},
				  {15,0,20},
				  {-15,0,20},
				  {-15,-10,20},
				  {-30,-15,25},
				  {-40,-5,-10},
				  {40,-5,-10},
				  {-40,-5,30},
				  {40,-5,30}
};

 int ntags = 6;
 String tags[] = {"crease", "crease","crease","crease","crease","crease"};
 int nargs[] = {5,1,5,1,2,1,2,1,4,1,4,1};
 int intargs[] = {7,6,14,15,7,
			  3,2,10,11,3,
			  0,1,
			  9,8,
			  16,5,13,18,
			  19,12,4,17
};
 double fargs[] = {2.0,2.0,2.0,2.0,2.0,2.0};

RiSubdivisionMesh("catmull-clark", nfaces, nvertices, vertices,ntags,tags,nargs,intargs,fargs,"P",  sdmpoints, RI_NULL);
}

void main ()

{
  RiBegin(RI_NULL);


  RiProjection("perspective", RI_NULL);
  RiTranslate(0.0, 0.0, 1.0);
  RiDisplay("Phone.tiff","file","rgba",RI_NULL);

  RiWorldBegin(1.0);
  double[] Color1 = {0.2, 0.4, 0.6};
    RiBxdf("PxrSurface","test1","color diffuseColor",Color1);
    RiScale(0.03,0.03,0.03);
    RiRotate(45,1,0,0);
    PhoneMesh();

  RiWorldEnd();

  RiEnd();
}







}
