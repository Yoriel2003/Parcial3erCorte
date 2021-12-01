/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.ReporteTiendas;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class ArchivoTiendasTxT implements IArchivo{

    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoTiendasTxT() {
        this.archivo = new File("GoleadoresLiga1.dat");
    }
    
    public ArchivoTiendasTxT(String name){
        this.archivo = new File(name);
    }

    /**
     * @return the archivo
     */
    public File getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    /**
     * @return the aEscritura
     */
    public FileWriter getaEscritura() {
        return aEscritura;
    }

    /**
     * @param aEscritura the aEscritura to set
     */
    public void setaEscritura(FileWriter aEscritura) {
        this.aEscritura = aEscritura;
    }

    /**
     * @return the aLectura
     */
    public Scanner getaLectura() {
        return aLectura;
    }

    /**
     * @param aLectura the aLectura to set
     */
    public void setaLectura(Scanner aLectura) {
        this.aLectura = aLectura;
    }
    
    public ReporteTiendas leerTiendas(String linea[]){
        ReporteTiendas f = new ReporteTiendas();
        f.setCTienda(linea[0]);
        f.setNombre(linea[1]);
        f.setCiudad(linea[2]);
        f.setDpto(linea[3]);
        f.setNProducto(linea[4]);
        f.setSubtotal(Integer.valueOf(linea[5]));
        f.setDescuento(Integer.valueOf(linea[6]));
        f.setTotal(Integer.valueOf(linea[7]));
        return f;
    }
    
    @Override
    public List<ReporteTiendas> leer() throws IOException{
        
        List<ReporteTiendas> lista = null;
        
        try {
            this.aLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while(this.aLectura.hasNext()){
                String linea[] = this.aLectura.nextLine().split(";");
               ReporteTiendas f = this.leerTiendas(linea);
                lista.add(f);
            }
            return lista;
            
       
        } catch (FileNotFoundException ex) {
            throw new IOException("Error al leer el archivo");
        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
        
        
    }
    
    @Override
    public ReporteTiendas buscar(String Ctiendas) throws IOException{
        ReporteTiendas buscado = null;
        
        try{
            this.aLectura = new Scanner(this.archivo);
            while(this.aLectura.hasNext()){
                ReporteTiendas f = this.leerTiendas(this.aLectura.nextLine().split(";"));
                if(f.getCTienda().equals(Ctiendas)){
                    buscado = f;
                    break;
                }
            }
            return buscado;
        }catch(FileNotFoundException ex){
            throw new IOException("No fue posible abrir el archivo para leer");
        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
    }
    
    
    
    @Override
    public ReporteTiendas eliminar(String Ctiendas) throws IOException{ // 123
        
        ReporteTiendas eliminado = null;
        List<ReporteTiendas> listadoGoleadores = this.leer();
        ArchivoTiendasTxT archivoTmp = new ArchivoTiendasTxT("ListadoGoleadoresTmp.dat");
        for(ReporteTiendas f: listadoGoleadores){
            if(f.getCTienda().equals(Ctiendas)){
                eliminado = f;
            }
            else{
               archivoTmp.escribir(f);
            }
        }
        
               
        if(!archivoTmp.archivo.exists()){
            archivoTmp.archivo.createNewFile();
        }

        if(this.archivo.delete()){
            if(archivoTmp.archivo.renameTo(this.archivo)){
                return eliminado;
            }
            else{
                throw new IOException("El archivo temporal no fue renombrado");
            }

        }
        else{
            throw new IOException("El archivo original no fue eliminado");
        }
                        
            
        
    }
    
    
    
    @Override
    public boolean escribir (ReporteTiendas f) throws IOException{
        
        PrintWriter escritor=null;
        boolean exito = false;
        try{
            this.aEscritura = new FileWriter(this.archivo, true);
            escritor = new PrintWriter(this.aEscritura);
            escritor.println(f.getArchivoDatos());
            exito = true;
            return exito;
            
        }catch(IOException ioe){
            throw new IOException("Error al abrir el archvio en modo escritura");
        }
        finally{
            if(escritor!=null)
                escritor.close();
            
            if(this.aEscritura!=null){
                this.aEscritura.close();
            }    
        }
    }
    
    
}

