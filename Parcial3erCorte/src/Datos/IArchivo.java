
package Datos;

import Entidades.ReporteTiendas;
import java.io.IOException;
import java.util.List;


public interface IArchivo {
     public List<ReporteTiendas> leer() throws IOException;
     public ReporteTiendas buscar(String Ctiendas) throws IOException ;
     public ReporteTiendas eliminar(String Ctiendas) throws IOException;
     public boolean escribir (ReporteTiendas f) throws IOException;
}
