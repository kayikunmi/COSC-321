public class Material {

	protected double ambient = 0.1;
	protected double diffuse = 0.9;
	protected double specular = 0.9;
	protected double shininess = 50.0;
	protected MyColor color = new MyColor(1,1,1);
	protected double reflective = 0.0;
	protected double transparency = 0.0;
	protected double refractiveIndex = 1.0;
	
	public MyColor getColor(double t) {
		return color;
	}
	
	public Material() {
	}
	
	public double getAmbient() {
		return ambient;
	}

	public void setAmbient(double ambient) {
		this.ambient = ambient;
	}

	public double getDiffuse() {
		return diffuse;
	}

	public void setDiffuse(double diffuse) {
		this.diffuse = diffuse;
	}

	public double getSpecular() {
		return specular;
	}

	public void setSpecular(double specular) {
		this.specular = specular;
	}

	public double getShininess() {
		return shininess;
	}

	public void setShininess(double shininess) {
		this.shininess = shininess;
	}

	
	
}


