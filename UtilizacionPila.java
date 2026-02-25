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
        Pila pila=new Pila ();
        String [] dato= texto.replace("\n", " ").split(" ");
        for(int i=0; i<dato.length; i++){
            if(lista.esApertura(dato[i])){
                pila.apilar(dato[i]);
            }
            else if(lista.esCierre(dato[i])){
                if(!pila.vacia()){
                    String apertura = pila.desapilar();
                    if(!lista.emparejados(apertura, dato[i])){
                        pila.apilar(apertura);
                    }
                } else {
                    pila.apilar(dato[i]);
                }
            }
        }

        if (!pila.vacia()) {
            System.out.println("En la pila quedan elementos:");
            mostrarInverso(pila);
        }
        return pila.vacia();
    }

    /**
     * Metodo que muestra el contenido de la pila invertido (el fondo arriba y la cima abajo)
     * @param pila la pila que deseamos mostrar
     */
    public void mostrarInverso(Pila pila) {
        String elemento;
        if (!pila.vacia()){
            elemento = pila.desapilar();
            mostrarInverso(pila);
            System.out.println(elemento);
            pila.apilar(elemento);

        }
     }
}

