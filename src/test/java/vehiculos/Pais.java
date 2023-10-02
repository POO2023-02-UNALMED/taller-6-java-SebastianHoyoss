package vehiculos;

import java.util.ArrayList;

public class Pais {
	private String nombre;
	
	public Pais(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public static Pais paisMasVendedor() {
		ArrayList<Pais> paises=new ArrayList<Pais>();
		for (int i=0;i<Vehiculo.getVehiculos().size();i++) {
			Pais pais=Vehiculo.getVehiculos().get(i).getFabricante().getPais();
			if (paises.contains(pais)==false) {
				paises.add(pais);
			}
		}
		int lista[];
		lista=new int[paises.size()];
		for (Vehiculo vehiculo:Vehiculo.getVehiculos()) {
			int indice=paises.indexOf(vehiculo.getFabricante().getPais());
			lista[indice]++;
		}
		int cont=0;
		for (int i=1;i<lista.length;i++) {
			if(lista[i]>lista[cont]) {
				cont=i;
			}
		}
		return paises.get(cont);
	}
	
	
}
