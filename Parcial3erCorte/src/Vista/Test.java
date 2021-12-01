package vista;

import Entidades.ReporteTiendas;
import Modelo.RegistroTiendas;
import java.io.IOException;
import java.util.List;


public class Test {

    public static void main(String[] args) throws IOException{
        RegistroTiendas modelo = new RegistroTiendas();
        ReporteTiendas f1 = new ReporteTiendas("Abvc1", "Vpar-Guatapuri", "Valleupar", "Cesar", "Lg", 10, 49, 20);
        ReporteTiendas f2 = new ReporteTiendas("Abhc1", "Vpar-MALLALES", "Valleupar", "Cesar", "Lg", 10, 49, 40);
        ReporteTiendas f3 = new ReporteTiendas("Abjc1", "Vpar-Guatapuri", "Valleupar", "Cesar", "Lg", 10, 49, 60);
        ReporteTiendas f4 = new ReporteTiendas("Abuc1", "Vpar-Guatapuri", "Valleupar", "Cesar", "Lg", 10, 49, 80);

            modelo.registrar(f1);
            modelo.registrar(f2);
            modelo.registrar(f3);
            modelo.registrar(f4);


            System.out.println("Futbolista en el archivo: ");
            List<ReporteTiendas> TiendasVenta = modelo.leer();
            imprimirLista(TiendasVenta);
        }

    

    public static void imprimirTiendas(ReporteTiendas f) {
        System.out.printf("%10s %20s %10s %10s %10s %10s %10s%n", f.getCTienda(), f.getNombre(), f.getCiudad(),
                f.getDpto(), f.getSubtotal(), f.getDescuento(), f.getTotal());
    }

    public static void imprimirLista(List<ReporteTiendas> lista) {
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (ReporteTiendas t : lista) {
            imprimirTiendas(t);
}
    }
}