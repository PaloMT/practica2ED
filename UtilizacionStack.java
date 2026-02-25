import java.util.Stack;

/**
 * Clase UtilizacionStack, para desarrollar los ejercicios propuestos en el apartado 3
 * @author profesores ED
 * @version 1
 */
public class UtilizacionStack {

    /**
     * Metodo que recibe un texto y una lista de etiquetas. Comprueba si todas las etiquetas
     * del texto estan balanceadas (cada etiqueta de apertura se corresponde con una de cierre)
     *
     * @param lista contiene las etiquetas que queremos analizar.
     * @param texto que contiene el contenido de una pagina html
     * @return verdadero si las etiquetas estan balanceadas, falso en caso contrario
     */
    public boolean comprobarLineaStack (ListaEtiquetas lista, String texto) {
        Stack<String> stack = new Stack();
        String [] dato= texto.replace("\n", " ").split(" ");
        for(int i=0; i<dato.length; i++){
            if(lista.esApertura(dato[i])){
                stack.push(dato[i]);
            }
            else if(lista.esCierre(dato[i])){
                if(!stack.isEmpty()){
                    String apertura = stack.pop();
                    if(!lista.emparejados(apertura, dato[i])){
                        stack.push(apertura);
                        break;
                    }
                } else {
                    stack.push(dato[i]);
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("En la pila quedan elementos:");
            mostrarInverso(stack);
        }
         return stack.isEmpty();
    }
    /**
     * Metodo que muestra el contenido de la pila
     * @param pila la pila que deseamos mostrar
     */
    public void mostrar (Stack<String> pila)  {
        if (!pila.isEmpty()) {
            String elemento = pila.pop();
            System.out.println(elemento);
            mostrar(pila);
            pila.push(elemento);
        }
    }

    /**
     * Metodo que muestra el contenido de la pila invertido (el fondo arriba y la cima abajo)
     * @param pila la pila que deseamos mostrar
     */
    public void mostrarInverso (Stack <String> pila) {
        if (!pila.isEmpty()) {
            String elemento = pila.pop();
            mostrarInverso(pila);
            System.out.println(elemento);
            pila.push(elemento);
        }
    }
}
