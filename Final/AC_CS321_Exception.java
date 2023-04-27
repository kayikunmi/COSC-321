
public class AC_CS321_Exception extends RuntimeException {

	String name;
	
	public AC_CS321_Exception(String name) {
		this.name = name;
}

	public String toString() {
		return "RiShader called with shader "+name+" this is not supported in any way";
	}
}
