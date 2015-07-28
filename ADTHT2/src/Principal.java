import java.io.*;
public class Principal 
{
    public static void main(String[] args) 
    {
        String archivo, linea = null; 
        Calculadora miCalculadora = new Calculadora();
        int resultado = 0;
        //Leer el archivo
        try
        { 
            archivo = "C:/Users/Tiago/Desktop/HT2.txt";
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo))); 
            linea = br.readLine();
            miCalculadora.recolectarOperadores(linea);
            br.close(); 
            resultado = miCalculadora.realizarCalculos();
            System.out.println("El resultado es " + resultado);
        }
        catch(FileNotFoundException ex)
        { 
                System.out.println("Error: " + ex.getMessage()); 
        }
        catch(IOException ex)
        { 
                System.out.println("Error: " + ex.getMessage()); 
        }
    }
}
