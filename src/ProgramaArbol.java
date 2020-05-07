
public class ProgramaArbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		//5.-Construyendo un arbol de busqueda con las siguintes claves
		ArbolAVL construirarbol = new ArbolAVL();
		
		//insertando nodos
		construirarbol.insertar(50);
		construirarbol.insertar(25);
		construirarbol.insertar(75);
		construirarbol.insertar(10);
		construirarbol.insertar(40);
		construirarbol.insertar(60);
		construirarbol.insertar(90);
		construirarbol.insertar(35);
		construirarbol.insertar(45);
		construirarbol.insertar(70);
		construirarbol.insertar(42);
		System.out.print("Preorden:  ");
		construirarbol.preOrden(construirarbol.obtenerRaiz());
		System.out.print("\nInorden:   ");
		construirarbol.inOrden(construirarbol.obtenerRaiz());
		System.out.print("\nPostorden: ");
		construirarbol.postOrden(construirarbol.obtenerRaiz());
		System.out.println ("\nCantidad de nodos en el árbol: "+ construirarbol.cantidad() );
		*/
		
		ArbolAVL arbolito = new ArbolAVL();
		//insertando nodos
        arbolito.insertar(100);
        arbolito.insertar(55);
        arbolito.insertar(22);
        arbolito.insertar(71);
        arbolito.insertar(150);
        arbolito.insertar(11);
        arbolito.insertar(5);
        arbolito.insertar(2);
        arbolito.insertar(7);
        arbolito.insertar(15);
        
        System.out.println ("\nCantidad de nodos en el árbol: " + arbolito.cantidad());
        System.out.print("Altura del arbol: ");
        System.out.println(arbolito.retornarAltura());  
    	
        System.out.print("\nRecorrido en Pre-orden:          ");
   		arbolito.preOrden(arbolito.obtenerRaiz());
   		System.out.print("\nRecorrido en Pre-orden Iterativo:" );
        arbolito.PreordenIterativo(arbolito.obtenerRaiz());
        
        System.out.print("\n\nRecorrido en In-orden:          ");
   		arbolito.inOrden(arbolito.obtenerRaiz());
   		System.out.print("\nRecorrido en In-orden Iterativo:" );
        arbolito.inordenIterativo(arbolito.obtenerRaiz());
   		  	
   		System.out.print("\n\nRecorrido en Post-orden:          ");
   		arbolito.postOrden(arbolito.obtenerRaiz());
   		System.out.print("\nRecorrido en Post-orden Iterativo:" );
        arbolito.PostordenIterativo(arbolito.obtenerRaiz());
   		
    
	}

}

