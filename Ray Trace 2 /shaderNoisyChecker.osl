//This is a surface shader - it determines color




surface

jerShader ( float Ka = 1, float Kd = 1, float frequency = .1,
	    color darkcolor = color (0,0,1),
	    output color Cout = color (0,0,0)
)
{
  
  float count;

  color Cs = color (1,0,0);

  float xp,yp,zp,smod,tmod;
	
  point P1 = transform("camera",P);

  xp = P1[0];
  yp = P1[1];
  zp = P1[2];


  smod = mod(xp+0.7*noise(P1),frequency);
  tmod = mod(yp+0.7*noise(P1),frequency);


  if (smod < 0.5*frequency) {
    if (tmod < 0.5*frequency) 
      Cout = Cs;
    else
      Cout = darkcolor;
  }
  else {
    if (tmod < 0.5*frequency)
      Cout = darkcolor;
    else
      Cout = Cs;
  }

	
	
}








