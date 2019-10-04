import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.google.gson.Gson;

public class Lectura {

public static void main(String[] args) throws IOException {
    String json = FileUtils.readFileToString(new File("cuboresuelto.json"));
    Gson gson = new Gson();
    Cubo cubo = gson.fromJson(json, Cubo.class);
    
    //impresion del cubo para comprobar
    
    for(int i=0; i< cubo.BACK.length; i++) {
    	for(int j=0; j< cubo.BACK[0].length; j++) {
    	System.out.print(cubo.BACK[i][j]);
    	}
    	System.out.println(" ");
    }
    for(int i=0; i< cubo.DOWN.length; i++) {
    	for(int j=0; j< cubo.DOWN[0].length; j++) {
    	System.out.print(cubo.DOWN[i][j]);
    	}
    	System.out.println(" ");
    }
    for(int i=0; i< cubo.FRONT.length; i++) {
    	for(int j=0; j< cubo.FRONT[0].length; j++) {
    	System.out.print(cubo.FRONT[i][j]);
    	}
    	System.out.println(" ");
    }
    for(int i=0; i< cubo.LEFT.length; i++) {
    	for(int j=0; j< cubo.LEFT[0].length; j++) {
    	System.out.print(cubo.LEFT[i][j]);
    	}
    	System.out.println(" ");
    }
    for(int i=0; i< cubo.RIGHT.length; i++) {
    	for(int j=0; j< cubo.RIGHT[0].length; j++) {
    	System.out.print(cubo.RIGHT[i][j]);
    	}
    	System.out.println(" ");
    }
    for(int i=0; i< cubo.UP.length; i++) {
    	for(int j=0; j< cubo.UP[0].length; j++) {
    	System.out.print(cubo.UP[i][j]);
    	}
    	System.out.println(" ");
    }
    
    }
}