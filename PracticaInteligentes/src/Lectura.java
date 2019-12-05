import java.io.*;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.json.*;

public class Lectura {
	private String estado = "";
	private int cubo[][][];
	static Scanner TECLADO = new Scanner(System.in);

	public int[][][] leerArchivo() throws IOException {
		try {
			File archivo;
			boolean existe = false;
			String archivoJson;
			do {
				System.out.println("Introduce el nombre del archivo json sin la extension (.json) :");
				archivoJson = "src/json/" + TECLADO.nextLine() + ".json";
				archivo = new File(archivoJson);
				if (archivo.exists())
					existe = true;
				else {
					existe = false;
					System.out.println("El archivo que has indicado no existe.\n");
				}
			}while(!existe);
			String ob = FileUtils.readFileToString(archivo);
			
			JSONObject json = new JSONObject(ob);
			JSONArray arrayback = json.getJSONArray("BACK");
			JSONArray arraydown = json.getJSONArray("DOWN");
			JSONArray arrayfront = json.getJSONArray("FRONT");
			JSONArray arrayleft = json.getJSONArray("LEFT");
			JSONArray arrayright = json.getJSONArray("RIGHT");
			JSONArray arrayup = json.getJSONArray("UP");

			int dimension = arrayup.length();
			cubo = new int[6][dimension][dimension];

			for (int i = 0; i < arrayback.length(); i++) {
				JSONArray f = arrayback.getJSONArray(i);
				for (int j = 0; j < f.length(); j++) {
					estado += f.get(j);
				}
			}
			for (int i = 0; i < arraydown.length(); i++) {
				JSONArray f = arraydown.getJSONArray(i);
				for (int j = 0; j < f.length(); j++) {
					estado += f.get(j);
				}
			}
			for (int i = 0; i < arrayfront.length(); i++) {
				JSONArray f = arrayfront.getJSONArray(i);
				for (int j = 0; j < f.length(); j++) {
					estado += f.get(j);
				}
			}

			for (int i = 0; i < arrayleft.length(); i++) {
				JSONArray f = arrayleft.getJSONArray(i);
				for (int j = 0; j < f.length(); j++) {
					estado += f.get(j);
				}
			}
			for (int i = 0; i < arrayright.length(); i++) {
				JSONArray f = arrayright.getJSONArray(i);
				for (int j = 0; j < f.length(); j++) {
					estado += f.get(j);
				}
			}
			for (int i = 0; i < arrayup.length(); i++) {
				JSONArray f = arrayup.getJSONArray(i);
				for (int j = 0; j < f.length(); j++) {
					estado += f.get(j);
				}
			}
			String[] lista = estado.split("");
			int[] numeros = new int[lista.length];
			for (int g = 0; g < numeros.length; g++) {
				numeros[g] = Integer.parseInt(lista[g]);
			}

			int contador = 0;
			int limite = 6 * dimension * dimension;

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < dimension; j++) {
					for (int k = 0; k < dimension; k++) {
						if (contador < limite) {
							cubo[i][j][k] = numeros[contador];
							contador++;
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cubo;
	}

}