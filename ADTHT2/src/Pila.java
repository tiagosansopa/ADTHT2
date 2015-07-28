
public class Pila 
{		
	Nodo inicio; 
	
	public Pila () 
	{
	    inicio = null;
	}
	
	public void push(String entrada) 
	{
		Nodo nuevoNodo;
	    nuevoNodo = new Nodo();
	    nuevoNodo.caracterIndex = entrada;
	    if (inicio == null)
	    {
	        nuevoNodo.siguiente = null;
	        inicio = nuevoNodo;
	    }
	    else
	    {
	        nuevoNodo.siguiente = inicio;
	        inicio = nuevoNodo;
	    }
	}
	
	public String pop ()
	{
		String actualCaracter;
		
		if (inicio!=null)
	    {
	        actualCaracter = inicio.caracterIndex;
	        inicio = inicio.siguiente;
	        return actualCaracter;
	    }
	    else
	    {
	    	actualCaracter = " ";
	    	return actualCaracter;
	    }
	}
}
