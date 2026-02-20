/**
 * Clase para gestionar una pila
 * Esta clase se entrega desarrollada, pero se tiene que modificar para que la cola tenga String como
 * elementos en vez de int
 *
 * @author profesores ED
 * @version 1.0
 */
public class Pila {
    /**
     * Referencia al primer nodo de la pila
     */
    private Nodo cima;
    /**
     * Numero de elementos que contiene la pila
     */
    private int numElementos;

    /**
     * Constructor de la clase, prepara la pila para su uso
     */
    public Pila() {
        cima = null;
        numElementos = 0;
    }

    /**
     * Metodo que verifica si la pila tiene algun elemento
     * @return true si esta vacia, false si tiene elementos
     */
    public boolean vacia() {
        return cima == null;
    }

    /**
     * Metodo que inserta un nuevo elemento en la cima de la pila
     * @param dato el elemento a insertar
     */
    public void apilar(String dato) {
        Nodo nuevo = new Nodo(dato, cima);
        cima = nuevo;
        numElementos++;
    }

    /**
     * Metodo que extrae de la pila el elemento que aparece en la cima
     * @return el primer elemento de la pila. Devuelve una cadena vacia si la cola esta vacia
     */
    public String desapilar() {
        String valor = " ";
        if (this.vacia()) {
            System.out.println("Error, la pila esta vacia");
        } else {
            valor = cima.getDato();
            cima = cima.getSiguiente();
            numElementos--;
        }
        return valor;
    }

    /**
     * Metodo para comprobar el numero de elementos que contiene la pila
     * @return el numero de elementos que contiene la pila
     */
    public int getNumElementos() {
        return numElementos;
    }

    /**
     * Metodo que muestra por pantalla el contenido de la pila
     */
    public void mostrar() {
        Nodo auxiliar = cima;
        System.out.println("Contenido de la pila:");
        while (auxiliar != null) {
            System.out.println(auxiliar.getDato());
            auxiliar = auxiliar.getSiguiente();
        }
        System.out.println("FIN");
    }
}
