import java.util.Stack;

public class ArbolAVL {

	
    private int cantida;
    private int altura;
	private NodoArbolAVL raiz;

	public ArbolAVL(){
		raiz=null;

	}
	public NodoArbolAVL obtenerRaiz(){
		return raiz;
	}
	//Buscar 
	public NodoArbolAVL buscar(int d, NodoArbolAVL r){
		if(raiz==null){
			return null;
		}else if (r.dato==d){
			return r;
		}else if (r.dato<d){
			return buscar(d,r.hijoDerecho);

		}else{
			return buscar(d,r.hijoIzquierdo);
		} 
	}
	//Obtener el Factor de Equilibrio
	public int obtenerFE(NodoArbolAVL x){
		if (x==null){
			return -1;
		}else{
			return x.fe;		
		}
	}
	//Rotacion Simple Izquierda
	public NodoArbolAVL rotacionIzquierda(NodoArbolAVL c){
		NodoArbolAVL aux=c.hijoIzquierdo;
		c.hijoIzquierdo=aux.hijoDerecho;
		aux.hijoDerecho=c;
		c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;	
	    aux.fe=Math.max(obtenerFE(aux.hijoIzquierdo), obtenerFE(aux.hijoDerecho))+1;
		return aux;
	}
	//Rotacion Simple Derecha
	public NodoArbolAVL rotacionDerecha(NodoArbolAVL c){
		NodoArbolAVL aux=c.hijoDerecho;
		c.hijoDerecho=aux.hijoIzquierdo;
		aux.hijoIzquierdo=c;
		c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;	
	    aux.fe=Math.max(obtenerFE(aux.hijoIzquierdo), obtenerFE(aux.hijoDerecho))+1;
		return aux;
	}
		//Rotacion Doble a la Izquierda
		public NodoArbolAVL rotacionDobleIzquierda(NodoArbolAVL c){
			NodoArbolAVL temporal;
			c.hijoIzquierdo=rotacionDerecha(c.hijoIzquierdo);
			temporal=rotacionIzquierda(c);
			return temporal;
		}
		//Rotacion Doble a la Derecha
		public NodoArbolAVL rotacionDobleDerecha(NodoArbolAVL c){
			NodoArbolAVL temporal;
			c.hijoDerecho=rotacionIzquierda(c.hijoDerecho);
			temporal=rotacionDerecha(c);
			return temporal;
		}
		//metodo para insertar AVL
		public NodoArbolAVL insertarAVL(NodoArbolAVL nuevo, NodoArbolAVL subAr){
		 NodoArbolAVL nuevoPadre=subAr;
		 if (nuevo.dato<subAr.dato){
			 if (subAr.hijoIzquierdo==null){
				 subAr.hijoIzquierdo=nuevo;
			 }else{
				 subAr.hijoIzquierdo=insertarAVL(nuevo,subAr.hijoIzquierdo);
				 if(obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho)==2){
					 if (nuevo.dato<subAr.hijoIzquierdo.dato){
						 nuevoPadre=rotacionIzquierda(subAr);
					 }else{
						 nuevoPadre=rotacionDobleIzquierda(subAr);
					 }
				 }
			 }
		 }else if(nuevo.dato>subAr.dato){
			 if(subAr.hijoDerecho==null){
				 subAr.hijoDerecho=nuevo;
			 }else{
				 subAr.hijoDerecho=insertarAVL(nuevo,subAr.hijoDerecho);
				 if(obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2){
					 if(nuevo.dato>subAr.hijoDerecho.dato){
						 nuevoPadre=rotacionDerecha(subAr);						 
					 }else{
						 nuevoPadre=rotacionDobleDerecha(subAr);
					 }
				 }
			 }	 
		 }else{
			System.out.println("Nodo Duplicado"); 
		 }
		 //Actualizando la altura
		 if((subAr.hijoIzquierdo==null) && (subAr.hijoDerecho!=null)){
			 subAr.fe=subAr.hijoDerecho.fe+1;
		 }else if((subAr.hijoDerecho==null) && (subAr.hijoIzquierdo!=null)){
			 subAr.fe=subAr.hijoIzquierdo.fe+1;	 
		 }else{
			 subAr.fe=Math.max(obtenerFE(subAr.hijoIzquierdo),obtenerFE(subAr.hijoDerecho))+1;		 
		 }
		 return nuevoPadre;
	   }
		//metodo para insertar
		public void insertar(int d){
			NodoArbolAVL nuevo = new NodoArbolAVL(d);
			if (raiz==null){
				raiz=nuevo;
			}else{
				raiz=insertarAVL(nuevo,raiz);
			}
		}
		//Recorridos
		//Metodo para recorrer el arbol inOrden
		public void inOrden(NodoArbolAVL r){
			if (r!=null){
				inOrden(r.hijoIzquierdo);
				System.out.print(r.dato+", ");
				inOrden(r.hijoDerecho);		
			}
		}
		//Metodo para recorrer el arbol PreOrden
		public void preOrden(NodoArbolAVL r){
			if (r!=null){
				System.out.print(r.dato+", ");
				preOrden(r.hijoIzquierdo);	
				preOrden(r.hijoDerecho);		
			}
		}
		//Metodo para recorrer el arbol PostOrden
		public void postOrden(NodoArbolAVL r){
			if (r!=null){
				postOrden(r.hijoIzquierdo);	
				postOrden(r.hijoDerecho);
				System.out.print(r.dato+", ");
			}
		}
		//2.-Implementar una Funcion NO Recursiva para Recorrer un Arbol en Inorden
		public void inordenIterativo(NodoArbolAVL r){
			 
		    Stack<NodoArbolAVL> pila = new Stack<NodoArbolAVL>();
		    NodoArbolAVL aux = r;
		 
		    do{
		        if(!pila.empty() && aux == null){
		            System.out.print(pila.peek().dato+", ");
		        }
		 
		        if(aux != null){
		            pila.push(aux);
		            aux = aux.hijoIzquierdo;
		        }else if(!pila.empty()){
		            aux = pila.peek();
		            pila.pop();
		            aux = aux.hijoDerecho;
		        }
		        
		    }while(!pila.empty() || aux != null);
		}
		//3.-Metodo Usando una Funcion Recursiva que encuentra el numero de nodos de un arbol
		private void cantidad(NodoArbolAVL recorre) {
			if (recorre!=null) {
				cantida++;
				cantidad(recorre.hijoIzquierdo);
				cantidad(recorre.hijoDerecho);
			}
		}

		public int cantidad() {
			cantidad(raiz);
			return cantida;
		}
		//4.-Metodo Usando una Funcion Recursiva que encuentra la altura de un arbol binario 
		private void retornarAltura(NodoArbolAVL recorre,int nivel){
			if (recorre != null) {    
				retornarAltura (recorre.hijoIzquierdo,nivel+1);
				if (nivel>altura)
					altura=nivel;
				retornarAltura (recorre.hijoDerecho,nivel+1);
			}
		}

		public  int retornarAltura () {
			retornarAltura (raiz,1);
			return altura;
		}  
}




