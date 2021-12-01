
package Modelo;

import Datos.ArchivoTiendasBin;
import Datos.ArchivoTiendasTxT;
import Datos.IArchivo;
import Entidades.ReporteTiendas;
import java.io.IOException;
import java.util.List;


public class RegistroTiendas {

    private IArchivo Datos; //

    public RegistroTiendas() {
        this.Datos = new ArchivoTiendasTxT();
        //this.Datos = new ListaArrayList();
        //this.Datos = new ArchivoTiendasBin();
    }

    /**
     * @return the datos
     */
    public IArchivo getDatos() {
        return Datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(ArchivoTiendasTxT Datos) {
        this.Datos = Datos;
    }
    
    
    public boolean registrar(ReporteTiendas f) throws IOException{
        return this.Datos.escribir(f);
    }
    
    public List<ReporteTiendas> leer() throws IOException{
        return this.Datos.leer();
    }
    
    public ReporteTiendas eliminar(String cc) throws IOException{
        return this.Datos.eliminar(cc);
    }
    
    public ReporteTiendas buscar(String cc) throws IOException{
        return this.Datos.buscar(cc);
    }
}
