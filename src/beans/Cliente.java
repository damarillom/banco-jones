/**
 * 
 */
package beans;
/**
 * @author iaw26509397
 *
 */
public class Cliente {
	private String dni;
	private String nombre;
	private boolean isValid;
	
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
}
