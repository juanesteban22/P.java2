package we;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

public class PaiseCiudad {
	HashMap<String, ArrayList<String>> paises = new HashMap<String, ArrayList<String>>();
	public void iniciar() {
		menu();
	}
	public void menu () {
		String menu = "MENU DE PAISES \n";
		
		menu+= "1.ingrasar pais \n";
		menu+= "2.consultar pais con sus ciudades elegidas \n";
		menu+= "3.consultar ciudad con su repscitivo pais \n";
		menu+= "4.imprimir listado\n";
		menu+= "5.salir \n";
		pedir(menu);
	}
	
	public void pedir(String menu) {
		  boolean casoUnoIngresado = false;
		  int menuInt = 0;
	        do {
	        	menuInt = Integer.parseInt(JOptionPane.showInputDialog(menu));

	            if (menuInt == 1) {
	                casoUnoIngresado = true;
	                Pais();
	            } else if (!casoUnoIngresado) {
	                JOptionPane.showMessageDialog(null, "Debe ingresar el valor 1 primero.");
	            } else {
	                switch (menuInt) {
	                    case 2:
	                        consultaP();
	                        break;
	                    case 3:
	                        consultarCiudad();
	                        break;
	                    case 4:
	                        imprimir();
	                        break;
	                    case 5:
	                        JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
	                        break;
	                    default:
	                        break;
	                }
	            }
	        } while (menuInt != 5);
	}
	public void Pais() {
		int n = Integer.parseInt(JOptionPane.showInputDialog("ah cuantos paises quieres ir ingrese numero"));
		for (int i = 0; i < n; i++) {
			String pais = JOptionPane.showInputDialog("Ingresa el pais a el que quieres ir");
			ArrayList<String>ciudades= new ArrayList<String>();
			int canC = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ciudades a el que quieres ir"));
			for (int j = 0; j < canC; j++) {
				ciudades.add(JOptionPane.showInputDialog("Ingrese la ciudad de "+pais));
			}
			paises.put(pais, ciudades);
		}

	}
	public void consultaP () {
		String paisCiudades = JOptionPane.showInputDialog("Ingrese el país para consultar las ciudades");
        if (paises.containsKey(paisCiudades)) {
            ArrayList<String> ciudades = paises.get(paisCiudades);
            String mensaje = "Ciudades de " + paisCiudades + ":\n";
            for (String ciudad : ciudades) {
                mensaje += ciudad + "\n";
            }
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "El país ingresado no existe en la lista.");
        }
	}
	public void consultarCiudad () {
		  String ciudadConsulta = JOptionPane.showInputDialog("Ingrese la ciudad a consultar");
	        boolean ciudadEncontrada = false;
	        for (Map.Entry<String, ArrayList<String>> entry : paises.entrySet()) {
	            ArrayList<String> ciudades = entry.getValue();
	            if (ciudades.contains(ciudadConsulta)) {
	                JOptionPane.showMessageDialog(null, "La ciudad " + ciudadConsulta + " pertenece a " + entry.getKey());
	                ciudadEncontrada = true;
	                break;
	            }
	        }
	        if (!ciudadEncontrada) {
	            JOptionPane.showMessageDialog(null, "La ciudad " + ciudadConsulta + " no fue encontrada en ningún país.");
	        }
	}
	public void imprimir () {
		Iterator<String> imprimir = paises.keySet().iterator();
		while (imprimir.hasNext()) {
			String llave = (String) imprimir.next();
			System.out.println(llave+" - "+paises.get(llave));
		}
	}

}
