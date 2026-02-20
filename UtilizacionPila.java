/**
 * Clase UtilizacionPila, para desarrollar los ejercicios propuestos en el apartado 2
 * @author profesores ED
 * @version 1
 */
public class UtilizacionPila {

    /**
     * Metodo que recibe un texto y una lista de etiquetas. Comprueba si todas las etiquetas
     * del texto estan balanceadas (cada etiqueta de apertura se corresponde con una de cierre)
     *
     * @param lista contiene las etiquetas que queremos analizar.
     * @param texto que contiene el contenido de una pagina html
     * @return verdadero si las etiquetas estan balanceadas, falso en caso contrario
     */
    public boolean comprobarLinea(final ListaEtiquetas lista, final String texto) {
        Pila pilaEtiquetas = new Pila();
        String[] datos = texto.split(" ");

        for (int i = 0; i < datos.length; i++) {
            String etiquetaActual = datos[i];

            if (lista.esApertura(etiquetaActual)) {
                pilaEtiquetas.apilar(etiquetaActual);
            }
            else if (lista.esCierre(etiquetaActual)) {
                if (pilaEtiquetas.vacia()) {
                    return false;
                }

                String cima = pilaEtiquetas.desapilar();

                if (!lista.emparejados(cima, etiquetaActual)) {
                    return false;
                }
            }
        }
        if (!pilaEtiquetas.vacia()) {
            System.out.println("En la pila quedan elementos:");
            mostrarInverso(pilaEtiquetas);
            return false;
        }
        return true;
    }

    /**
     * Metodo que muestra el contenido de la pila invertido (el fondo arriba y la cima abajo)
     * @param pila la pila que deseamos mostrar
     */
    public void mostrarInverso(Pila pila) {
        String elemento;
        while (!pila.vacia()){
            elemento = pila.desapilar();
            mostrarInverso(pila);
            System.out.println(elemento);
            pila.apilar(elemento);

        }
     }
}

