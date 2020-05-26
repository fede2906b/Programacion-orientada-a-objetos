package aplicacion;

public class Fortaleza {
	private int fortaleza;
	private int reduccion;
	public Fortaleza() {
		this.fortaleza=1000;
		this.reduccion=2;
	}
	
	public void reducir() {
		this.fortaleza=this.fortaleza-this.reduccion;
	}
	
	public void recuperar() {
		this.fortaleza=(int)this.fortaleza+(1000-this.fortaleza)/2;
	}
	
	public void setReduccion(int reduccion) {
		this.reduccion=reduccion;
	}
	
	public int getFortaleza() {
		return this.fortaleza;
	}
	
	public void perder() {
		this.fortaleza=(int)this.fortaleza-100;
	}
	
	public void noPerder() {
		this.fortaleza=this.fortaleza+0;
	}
}
