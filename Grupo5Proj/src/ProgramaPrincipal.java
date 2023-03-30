import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProgramaPrincipal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Partido> listaPartidos = new ArrayList<Partido>();
		
		ArrayList<Pronostico> listaPronostico2 = new ArrayList<Pronostico>();

		
		Partido unPartido;
		Equipo unEquipo1;
		Equipo unEquipo2;
		
		String resultado = "archivos\\resultados.txt";
		String pronostico = "archivos\\pronosticos.txt";
		
		Pronostico unPronostico;
		
		int puntaje = 0;
		
		
		for (String linea : Files.readAllLines(Paths.get(resultado))) {
			String lineas[] = linea.split(" ");
			
			unPartido = new Partido();
			unEquipo1 = new Equipo();
			unEquipo2 = new Equipo();
			
			unEquipo1.setNombre(lineas[0]);
			unEquipo2.setNombre(lineas[3]);
			
			unPartido.setPartido(unEquipo1,unEquipo1,Integer.parseInt(lineas[1]),Integer.parseInt(lineas[2]));
			listaPartidos.add(unPartido);
			
		}
				
		// Array[1] = Gana equipo 1
		// Array[2] = Empate
		// Array[3] = Gana equipo2

		for (String linea : Files.readAllLines(Paths.get(pronostico))) {
			String lineas[] = linea.split(" ");
			
			unPronostico = new Pronostico();
			unEquipo1 = new Equipo();
			unEquipo2 = new Equipo();
			
			unEquipo1.setNombre(lineas[0]);
			unEquipo2.setNombre(lineas[4]);
			
			unPronostico.setPronostico(unEquipo1,unEquipo2,Integer.parseInt(lineas[1]),Integer.parseInt(lineas[2]),Integer.parseInt(lineas[3]));

			
			listaPronostico2.add(unPronostico);
		}
		
		for(int i = 0; i < listaPronostico2.size(); i++) {
			if(listaPronostico2.get(i).getGanaEquipo1() == 1) {
				if(listaPartidos.get(i).getGolesEquipo1() > listaPartidos.get(i).getGolesEquipo2()) {
					puntaje++;
				}
			}else if(listaPronostico2.get(i).getGanaEquipo2() == 1) {
				if(listaPartidos.get(i).getGolesEquipo1() < listaPartidos.get(i).getGolesEquipo2()) {
					puntaje++;				
				}
			
			}else if(listaPronostico2.get(i).getEmpate() == 1){
				if(listaPartidos.get(i).getGolesEquipo1() == listaPartidos.get(i).getGolesEquipo2()) {
					puntaje++;
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "El puntaje es " + puntaje);
	}

}
