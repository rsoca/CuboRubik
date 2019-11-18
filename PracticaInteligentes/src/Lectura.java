import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import org.json.*;

public class Lectura {
	private String estado = "";
	private int cubo[][][];

	public int[][][] leerArchivo() throws IOException {
		try {
			//String ob = FileUtils.readFileToString(new File("cuboresuelto3por3.json"));
			String ob = FileUtils.readFileToString(new File("cubo2por2.json"));
			JSONObject json = new JSONObject(ob);
			// importante mantener el orden de los arrays igual que en el json.
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

			// hacemos un vector de string separando el de estado
			String[] lista = estado.split("");

			// creamos el vector donde guardaremos los numeros con la longitud de la lista
			// anterior
			int[] numeros = new int[lista.length];
			// int limite = 6 * dimension * dimension;

			// recorremos el string numeros y guardamos en cada posicion el estado
			// correspondiente
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