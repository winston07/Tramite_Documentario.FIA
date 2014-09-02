/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Kelvin Thony
 */
public class hola {

    public String periodo() {
        String respuesta = null;
        Date dat = new Date();
        String fechanow;
        int diain = 1;
        int mesin = 6;
        int mesout = 12;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fechanow = sdf.format(dat);
        String cortadodia = fechanow.substring(0, 2);
        String cortadomes = fechanow.substring(3, 5);
        String cortanio = fechanow.substring(6, 10);
        int diain2 = Integer.parseInt(cortadodia);
        int mesin2 = Integer.parseInt(cortadomes);
        int anio = Integer.parseInt(cortanio);
        //System.out.println("dia:"+diain2+"-Mes:"+mesout2);
        if (diain2 >= diain && mesin2 <= mesin) {
            respuesta = anio + "-1";
        }

        if (diain2 >= diain && mesin2 <= mesout) {
            respuesta = anio + "-2";

        }
        return respuesta;
    }

    public String hora() {
        Date dat = new Date();
        String fechanow;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        fechanow = sdf.format(dat);

        return fechanow;
    }

}
