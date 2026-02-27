/**
 * Clase UtilizacionCola, para desarrollar los ejercicios propuestos en el apartado 4
 * @author profesores ED
 * @version 1
 */
public class UtilizacionCola {

    /**
     * Metodo que recibe una lista de etiquetas html y un String conteniendo una pagina html.
     * Genera una cola que contiene las etiquetas de la lista contenidas en el texto
     *
     * @param lista lista que contiene las etiquetas que queremos comprobar
     * @param texto la pagina que vamos a analizar
     * @return la cola que contiene las etiquetas de la lista contenidas en el texto
     */
    public Cola leerTexto (ListaEtiquetas lista, String texto) {
        Cola resultado = new Cola();
        String [] dato= texto.replace("\n", " ").split(" ");
        for(int i=0; i<dato.length; i++){
            if (lista.esEtiqueta(dato[i])){
                resultado.encolar(dato[i]);
            }
        }
        return resultado;
    }

    /**
     * Metodo que recibe una cola y una lista de etiquetas. Comprueba si todas las etiquetas
     * de la cola estan balanceadas (cada etiqueta de apertura se corresponde con una de cierre)
     *
     * @param cola que contiene las etiquetas extraidas de una pagina html
     * @param lista contiene las etiquetas que queremos analizar.
     * @return verdadero si las etiquetas estan balanceadas, falso en caso contrario
     */
    public boolean comprobarHtml (Cola cola, ListaEtiquetas lista) {
        boolean resultado = true;
        Pila pilaAux = new Pila();
        for (int i = 0; i < cola.getNumElementos(); i++) {
            String etiqueta = cola.desencolar();
            if (resultado) {
                if (lista.esApertura(etiqueta)) {
                    pilaAux.apilar(etiqueta);
                } else if (lista.esCierre(etiqueta)) {
                    if (!pilaAux.vacia()) {
                        String apertura = pilaAux.desapilar();
                        if (!lista.emparejados(apertura, etiqueta)) {
                            pilaAux.apilar(apertura);
                            resultado = false;
                        }
                    } else {
                        pilaAux.apilar(etiqueta);
                        resultado = false;
                    }
                }
            }
            cola.encolar(etiqueta);
        }

        if (!pilaAux.vacia()) {
            System.out.println("En la pila quedan elementos:");
            pilaAux.mostrar();
            resultado = false;
        }

        return resultado;
    }
}
