


surface jerShader (float Ka = 1, float Kd = 1,output color Cout = 0)
{
	

  point shadeP = transform("shader",P);
  point objectP = transform("object",P);
  point worldP = transform("world",P);
  point cameraP = transform("camera",P);
  point defineP = transform("shaderDefine",P);


  printf("%f %f %f P (common) \n %f %f %f (worldP) \n %f %f %f (shadeP) \n %f %f %f (objectP) \n %f %f %f (cameraP)\n %f %f %f (shader define point)",
	 P[0],P[1],P[2],
	 worldP[0],worldP[1],worldP[2],
	 shadeP[0],shadeP[1],shadeP[2],
	 objectP[0],objectP[1],objectP[2],
	 cameraP[0],cameraP[1],cameraP[2],
	 defineP[0],defineP[1],defineP[2]
	 );

  Cout = color(0.3,0.7,0.1);
	
}
