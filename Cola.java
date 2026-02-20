/**
 * Clase para gestionar una cola
 * Esta clase se entrega desarrollada, pero se tiene que modificar para que la cola tenga String como
 * elementos en vez de int
 *
 * @author profesores ED
 * @version 1.0
 */
public class Cola {
    /**
     * Referencias al principio y al final de la lista
     */
    private Nodo principio, fin;
    /**
     * numero de elementos que contiene la lista
     */
    private int numElementos;

    /**
     * Constructor de la clase, prepara la cola para su utilización
     */
    public Cola() {
        principio = null;
        fin = null;
        numElementos = 0;
    }

    /**
     * Metodo que verifica si la cola tiene algun elemento
     * @return true si esta vacia, false si tiene elementos
     */
    public boolean vacia() {
        return principio == null;
    }


    /**
     * Metodo que inserta un nuevo elemento al final de la cola
     * @param dato el elemento a insertar
     */
    public void encolar(String dato) {
        Nodo nuevo;
        nuevo = new Nodo(dato, null);
        if (principio != null)
            fin.setSiguiente(nuevo);
        else principio = nuevo;
        fin = nuevo;
        numElementos++;
    }

    /**
     * Metodo que extrae de la cola el elemento que aparece al principio
     * @return el primer elemento de la cola. Devuelve una cadena vacia si la cola esta vacia
     */
    public String desencolar() {
        Nodo nodo;
        String resultado = " ";

        if (principio == null)
            System.out.println("Error, la cola esta vacia");
        else {
            nodo = principio;
            principio = nodo.getSiguiente();
            resultado = nodo.getDato();
            if (principio == null)
                fin = null;

            numElementos--;
        }
        return resultado;
    }

    /**
     * Metodo que muestra por pantalla el contenido de la cola
     */
    public void mostrar() {     // Muestra por pantalla el contenido de la cola
        Nodo auxiliar;
        System.out.println("Contenido de la cola: ");
        auxiliar = principio;
        while (auxiliar != null) {
            System.out.print(auxiliar.getDato() + "  ");
            auxiliar = auxiliar.getSiguiente();
        }
        System.out.println("FIN");
    }

    /**
     * Metodo para comprobar el numero de elementos que contiene la cola
     * @return el numero de elementos que contiene la cola
     */
    public int getNumElementos() {       // Devuelve el numero de elementos de la cola
        return numElementos;
    }
}
