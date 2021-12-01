package Vista;

import Entidades.ReporteTiendas;
import Modelo.RegistroTiendas;
import java.io.IOException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException{
        RegistroTiendas modelo = new RegistroTiendas();
        ReporteTiendas t1 = new ReporteTiendas("SDASD", "MAYALES PLAZA", "Valleupar", "Cesar", "Hp", 1234, 5950, 53234);
        ReporteTiendas t2 = new ReporteTiendas("SADFW", "LA 44", "Valleupar", "Cesar", "Linux", 4321, 42731, 432432);
        ReporteTiendas t3 = new ReporteTiendas("HGHRT", "GUATAPURI PLAZA", "Valleupar", "Cesar", "Azus", 3829, 43123, 65322);
        ReporteTiendas t4 = new ReporteTiendas("VSERG", "TODO EN UNO", "Valleupar", "Cesar", "Samsung", 4231, 43232, 952532);

            modelo.registrar(t1);
            modelo.registrar(t2);
            modelo.registrar(t3);
            modelo.registrar(t4);


            System.out.println("Futbolista en el archivo: ");
            List<ReporteTiendas> TiendasVentas = modelo.leer();
            imprimirLista(TiendasVentas);
        }

    

    public static void imprimirTiendas(ReporteTiendas f) {
        System.out.printf("%10s %20s %10s %10s %10s %10s %10.2s%n", f.getCTienda(), f.getNombre(), f.getCiudad(),
                f.getDpto(), f.getSubtotal(), f.getDescuento(), f.getTotal());
    }

    public static void imprimirLista(List<ReporteTiendas> lista) {

        System.out.println("----------------------------------------------------------------------------------------------------");
        for (ReporteTiendas t : lista) {
            imprimirTiendas(t);
}
    }
}
