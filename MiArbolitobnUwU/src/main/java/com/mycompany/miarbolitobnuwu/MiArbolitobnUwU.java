package com.mycompany.miarbolitobnuwu;

import java.util.Iterator;

/**
 *
 * @author luisa
 */
public class MiArbolitobnUwU {

    public static void main(String[] args) {
     Familiar abueloPat = new Familiar("Alfonso Benitez", 62, "Mecanico", false, "Navojoa, Sonora");
        Familiar abuelaPat = new Familiar("Maria Guadalupe Rodriguez", 60, "Ama de casa", false, "Navojoa, Sonora");
        BinaryTree<Familiar> ramaPaterna = new BinaryTree<>(
                new Familiar("Alfonso Benitez Rodriguez", 38, "Sabritero", false, "Navojoa, Sonora"),
                new BinaryTree<>(abueloPat),
                new BinaryTree<>(abuelaPat)
        );

        Familiar abuelaMat = new Familiar("Elvira Pacheco", 65, "Cocinera", false, "Bacobampo, Sonora");
        Familiar abueloMat = new Familiar("Jose Miranda", 66, "Ingeniero mecatronica", true, "Navojoa, Sonora");
        BinaryTree<Familiar> ramaMaterna = new BinaryTree<>(
                new Familiar("Maria Jose Miranda", 38, "Maquillista", false, "Navojoa, Sonora"),
                new BinaryTree<>(abuelaMat),
                new BinaryTree<>(abueloMat)
        );

        Familiar personaRaiz = new Familiar("Luisita Benitez Miranda", 19, "Estudiante en ingenieria en software", false, "Navojoa, Sonora");
        BinaryTree<Familiar> arbolGenealogico = new BinaryTree<>(personaRaiz, ramaPaterna, ramaMaterna);

        System.out.println("Altura: " + arbolGenealogico.getHeight());
        System.out.println("Total de nodos: " + arbolGenealogico.getNumberNodes());
        System.out.println("Vacio?: " + arbolGenealogico.empty());

        System.out.println("\n--- Recorrido Preorden ---");
        mostrarRecorrido(arbolGenealogico.getPreorderIterator());

        System.out.println("\n--- Recorrido Inorden ---");
        mostrarRecorrido(arbolGenealogico.getInorderIterator());

        System.out.println("\n--- Recorrido Postorden ---");
        mostrarRecorrido(arbolGenealogico.getPostorderIterator());
    }

    private static void mostrarRecorrido(Iterator<Familiar> it) {
        while (it.hasNext()) {
            System.out.println("-> " + it.next());
        }   
    }
}
