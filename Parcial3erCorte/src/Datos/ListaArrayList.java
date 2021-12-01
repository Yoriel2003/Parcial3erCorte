package Datos;

import Entidades.ReporteTiendas;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaArrayList implements IArchivo, Serializable {

    private List<ReporteTiendas> lista;

    public ListaArrayList() {
        this.lista = new ArrayList();
    }

    @Override
    public List<ReporteTiendas> leer() throws IOException {
        return this.getLista();
    }

    @Override
    public ReporteTiendas buscar(String codigoTienda) throws IOException {
        for (ReporteTiendas f : this.getLista()) {
            if (f.getCTienda().equals(codigoTienda)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public ReporteTiendas eliminar(String codigoTienda) throws IOException {
        Iterator<ReporteTiendas> i = this.getLista().iterator();
        while (i.hasNext()) {
            ReporteTiendas f = i.next();
            if (f.getCTienda().equals(codigoTienda)) {
                i.remove();
                return f;
            }
        }
        return null;

    }

    @Override
    public boolean escribir(ReporteTiendas f) throws IOException {
        return this.getLista().add(f);
    }

    public List<ReporteTiendas> getLista() {
        return lista;
    }

    public void setLista(List<ReporteTiendas> lista) {
        this.lista = lista;
    }

}
