package Gestores;

import Personas.Cliente;

public class GestorClientes extends Gestor<Cliente> {
    /* archivos json */
    public void cargarDesdeArchivo(String nombre_archivo) {
        super.cargarDesdeArchivo(nombre_archivo, Cliente.class);
    }


}
