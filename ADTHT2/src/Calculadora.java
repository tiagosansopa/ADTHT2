
public class Calculadora 
{
    Pila miPila = new Pila();
    int contadorOperadores = 0;
    
    public Calculadora() 
    {

    }

    //Llenar el Stack
    public void recolectarOperadores(String linea)
    {
        for(int i = (linea.length()-1); i>=0; i--)
        {
                if(linea.charAt(i) != ' ') 
                {
                        miPila.push(Character.toString(linea.charAt(i)));
                        contadorOperadores++;
                }
        }
    }
    
    public int realizarCalculos()
    {
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
        }
        return resultado;
    }
}

