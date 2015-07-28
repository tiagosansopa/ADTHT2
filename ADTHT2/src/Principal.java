import java.io.*;
public class Principal 
{
	public static void main(String[] args) 
	{
		String archivo, linea = null; 
		int contadorOperadores = 0;
		
		//Leer el archivo
		try
		{ 
			archivo = "C:/Users/Tiago/Desktop/HT2.txt";
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo))); 
		
			linea = br.readLine();
			
		//Llenar el Stack
			
		Pila miPila = new Pila();
		
		for(int i = (linea.length()-1); i>=0; i--)
		{
			if(linea.charAt(i) != ' ') 
			{
				miPila.push(Character.toString(linea.charAt(i)));
				contadorOperadores++;
			}
		}
		
		br.close(); 
		
		//Sacar el Stack y operar
		String temporal1, temporal2, temporal3, envio;
		int resultado = 0;
		for(int i = 0; i <= ((contadorOperadores-1)/2); i++)
		{
			temporal1 = miPila.pop(); //Resultado anterior
			temporal2 = miPila.pop(); //nuevo numero
			temporal3 = miPila.pop(); //operador
			
			if( temporal3.equals("+"))
			{
				resultado = Math.addExact(Integer.parseInt(temporal1), Integer.parseInt(temporal2));
				//System.out.println("La suma de los numeros es " + resultado);
				envio = Integer.toString(resultado);
				miPila.push(envio);
			}
			
			if( temporal3.equals("/"))
			{
				resultado = Math.floorDiv(Integer.parseInt(temporal1), Integer.parseInt(temporal2));
				//System.out.println("La division de los numeros es " + resultado);
				envio = Integer.toString(resultado);
				miPila.push(envio);
			}

			if( temporal3.equals("*"))
			{
				resultado = Math.multiplyExact(Integer.parseInt(temporal1), Integer.parseInt(temporal2));
				//System.out.println("La multiplicacion de los numeros es " + resultado);
				envio = Integer.toString(resultado);
				miPila.push(envio);
			}
			
			if( temporal3.equals("-"))
			{
				resultado = Math.subtractExact(Integer.parseInt(temporal1), Integer.parseInt(temporal2));
				//System.out.println("La division de los numeros es " + resultado);
				envio = Integer.toString(resultado);
				miPila.push(envio);
			}
			
			if (i == ((contadorOperadores-1)/2))
			{
				System.out.println("El resultado es " + resultado);
			}
		}

		}
		catch(FileNotFoundException ex)
		{ 
			System.out.println("Error: "+ex.getMessage()); 
		}
		catch(IOException ex)
		{ 
			System.out.println("Error: "+ex.getMessage()); 
		}
	
		
	}

}
