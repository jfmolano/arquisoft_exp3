package jose.adicionales;

import java.io.File;

public class FileManager {

	public static File findFile(File rutaInicial, String name) {
        System.out.println(rutaInicial.getAbsolutePath());
        if ( rutaInicial.getName().contains(name))
        {
            return rutaInicial;
        }
        else if ( rutaInicial.isDirectory())
        {
           File[] archivos = rutaInicial.listFiles();
           for (File archivo:archivos)
           {
               File fileN = findFile(archivo, name);
               if (fileN != null)
               {
                   return fileN;
               }
           }
        }
        return null;
    }
}
