import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.json.*;

public class Lectura {
	private String estado = "";
	private int dimension;
	public String leerArchivo() throws IOException{
	//public static void main(String[] args) throws IOException{s
		
		try{
			String ob = FileUtils.readFileToString(new File("cuboresuelto.json"));
			JSONObject json = new JSONObject(ob);
			JSONArray arrayup = json.getJSONArray("UP");
			JSONArray arraydown = json.getJSONArray("DOWN");
			JSONArray arrayleft = json.getJSONArray("LEFT");
			JSONArray arrayright = json.getJSONArray("RIGHT");
			JSONArray arrayfront = json.getJSONArray("FRONT");
			JSONArray arrayback = json.getJSONArray("BACK");
			dimension=arrayup.length();
			System.out.println("La dimension es"+dimension);
			for(int i=0;i<arrayup.length();i++){
				JSONArray f = arrayup.getJSONArray(i);
				for(int j=0; j<f.length();j++){
					estado += f.get(j);
				}
			}
			for(int i=0;i<arraydown.length();i++){
				JSONArray f = arraydown.getJSONArray(i);
				for(int j=0; j<f.length();j++){
					estado += f.get(j);
				}
			}
			for(int i=0;i<arrayfront.length();i++){
				JSONArray f = arrayfront.getJSONArray(i);
				for(int j=0; j<f.length();j++){
					estado += f.get(j);
				}
			}
			for(int i=0;i<arrayback.length();i++){
				JSONArray f = arrayback.getJSONArray(i);
				for(int j=0; j<f.length();j++){
					estado += f.get(j);
				}
			}
			for(int i=0;i<arrayleft.length();i++){
				JSONArray f = arrayleft.getJSONArray(i);
				for(int j=0; j<f.length();j++){
					estado += f.get(j);
				}
			}
			for(int i=0;i<arrayright.length();i++){
				JSONArray f = arrayright.getJSONArray(i);
				for(int j=0; j<f.length();j++){
					estado += f.get(j);
				}
			}
			System.out.println(estado);
    	}catch(FileNotFoundException e){ e.printStackTrace();}
		catch(Exception e){ e.printStackTrace();}
		return estado;
	} public int getDimension(){
		return dimension;
	}
}