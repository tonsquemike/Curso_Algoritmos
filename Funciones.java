package com.company;

import java.io.*;

public class Funciones {
    /**
     * Imprimir una cadena de texto en la consola
     * @param texto
     */
    public static void Escribir(String texto){
        System.out.println(texto);
    }

    /**
     * Función para leer datos en el teclado
     * @return contenido de un archivo de texto
     */
    public static String Leer(){
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = teclado.readLine();
        }catch(Exception e){}
        return input;
    }

    /**
     * Leer el contenido de un archivo de texto y devolver una sola cadena
     * @param nombreArchivo
     * @return cadena de texto
     */
    public static String LeerTXT(String nombreArchivo)
    {
        String contenido = "";
        //crear un buffer para abrir el archivo de texto
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            //mientras se encuentre una línea, continuar leyendo el archivo de texto
            while ((line = br.readLine()) != null) {
                line = line+"\r\n";//agregar un salto al leer cada línea
                contenido = contenido+line;//concatenar las líneas anteriores con la actual
            }
        } catch (IOException e) {//en caso de error...
            e.printStackTrace();//imprimir error
        }
        return contenido;//regresar la cada leída
    }

    /**
     * Función para cargar el contenido de un archivo de texto en una Dimensión
     * @param nombreArchivo ruta del archivo de texto a leer
     * @return Dimension con líneas de texto
     */
    public static String[] LeerTXTLineas(String nombreArchivo){
        String lineas[] = null;//crear una Dimensión de cadenas
        int lines = 0;//variable para contar el número de líneas en el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            while ((br.readLine()) != null) {//mientras la línea actual sea diferente de nulo
                lines++;//incrmentar el contador de líneas
            }
        } catch (IOException e) {//en caso de error
            e.printStackTrace();//imprimir el error
        }

        lineas = new String[lines];//asignar un tamaño a la dimensión creada
        int i = 0;//índice para recorrer la Dimensión lineas
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String lineaActual;
            while ((lineaActual = br.readLine()) != null) {
                lineas[i] = lineaActual;//guardar la línea actual en la casilla 'i' de la Dimension lineas
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }

    /**
     * Escribir sólo una línea de texto
     * @param rutaSalida ruta para guardar el archivo
     * @param cadena cadena de texto a guardar
     */
    public static void EscribeTXT(String rutaSalida, String cadena)
    {
        try {
            FileWriter writer = new FileWriter(rutaSalida, true);//crear un buffere de salida
            writer.write(cadena);//escribir la cadena actual en el archivo de texto
            writer.close();//cerrar el buffer de esccritura
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Función para escribir una Dimensión con cadenas en un archivo de texto
     * @param rutaSalida
     * @param cadenas
     */
    public static void EscribeTXT(String rutaSalida, String[]cadenas)
    {
        int i = 0;
        try {
            FileWriter writer = new FileWriter(rutaSalida, true);//crear un buffer de salida
            while (i<cadenas.length){//mientras el índice sea menor al tamaño de la Dimensión cadenas ...
                writer.write(cadenas[i]);//escribir la casilla 'i' de la Dimensión cadenas en el buffer de salida
                i += 1;//incrementar el índice
            }
            writer.close();//cerrar el buffer de escritura
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
