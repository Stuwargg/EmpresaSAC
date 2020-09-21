package Control;

import Modelo.Producto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Procesos {
//    String ruta = "C:\\Users\\tottus\\Documents\\NetBeansProjects\\EjercicioLab03\\Files\\Empleado.txt";

    String ruta = "C:\\Users\\Stuwar Giron Garcia\\Documents\\NetBeansProjects\\Ejercicio6\\Files\\productos.txt";
    Producto objproducto = new Producto();
    FileReader fr;  //lector de archivos
    BufferedReader br;    //recepctor de memoria
    FileWriter fw;        //escribir
    File f;

 

    public ArrayList<Producto> lista = new ArrayList<>();

    //METODO PARA AGREGAR USUARIO EN LA TABLA 
    public void agregar(Producto p) throws FileNotFoundException, IOException {

        fw = new FileWriter(ruta, true);
        String cad = p.getCodigo() + "/" + p.getNombre() + "/" + p.getStock() + "/" + p.getPrecio();
        fw.write(cad);
        fw.write(13); //hace un salto de linea
        fw.close();
    }

    // LEER
    public void leer() throws FileNotFoundException, IOException {
        lista.clear();     //Limpiar arrayList 0 elementos
        fr = new FileReader(ruta);
        br = new BufferedReader(fr);
        String cad = br.readLine();
        String[] vec;
        while (cad != null) {
            vec = cad.split("/");  //separar la cadena en un vector
            objproducto = new Producto(vec[0], vec[1], Double.parseDouble(vec[2]), Double.parseDouble(vec[3]));
            lista.add(objproducto);   //agregar elementos al arrayList
            cad = br.readLine();
        }
        fr.close();
    }
   

    //METODO PARA ACTUALIZAR Y ELIMINAR DATOS
    public void actualizar(ArrayList<Producto> array) throws FileNotFoundException, IOException {
        f = new File(ruta);
        fw = new FileWriter(ruta, true);
        //BORRAR EL ARCHIVO
        fw.close();
        f.delete();

        //CREAR UN NUEVO ARCHIVO
        f = new File(ruta);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        fw = new FileWriter(f, true);

        for (Producto p : array) { //recorrer todo el arraylist 1 al ultimo          
            String cad = p.getCodigo() + "/" + p.getNombre() + "/" + p.getStock() + "/" + p.getPrecio();
            fw.write(cad);
            fw.write(13); //hace un salto de linea
        }

        fw.close();

    }
}
