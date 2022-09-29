package practica1Clara;

import java.io.Serializable;

public class Cliente implements Serializable {
	private String nombre;
	private String email;
	private int codigo;
	private double importe;
	private String estado;
	
	public Cliente(String nombre, String email, int codigo, double importe, String estado) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.codigo = codigo;
		this.importe = importe;
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	} 
	
}
