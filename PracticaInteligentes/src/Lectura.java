import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.google.gson.Gson;

public class Lectura {
public Cubo leerArchivo() throws IOException{
		Cubo cubo = null;
		try{
		String json = FileUtils.readFileToString(new File("cuboresuelto.json"));
    	Gson gson = new Gson();
    	cubo = gson.fromJson(json, Cubo.class); 
    	}catch(FileNotFoundException e){ e.printStackTrace();}
		catch(Exception e){ e.printStackTrace();}
		return cubo;
	}
}