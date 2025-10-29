package submissions.alicya_mikaelle.src;

import java.util.*;

public class ArrayListApp {
    public static void main(String[] args) {
        // Create and Print ArrayList
        System.out.println("=== Create and Print ArrayList ===");
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);

        // Iterate ArrayList Elements
        System.out.println("\n=== Iterate ArrayList Elements ===");
        for (String cor : cores) {
            System.out.println(cor);
        }

        // Insert at First Position
        System.out.println("\n=== Insert at First Position ===");
        cores.add(0, "Vermelho");
        System.out.println(cores);

        // Retrieve Element by Index
        System.out.println("\n=== Retrieve Element by Index ===");
        int index = 2;
        if (index >= 0 && index < cores.size()) {
            System.out.println("Elemento no índice " + index + ": " + cores.get(index));
        } else {
            System.out.println("Índice inválido!");
        }

        // Update ArrayList Element
        System.out.println("\n=== Update ArrayList Element ===");
        if (!cores.isEmpty()) {
            cores.set(1, "Laranja");
            System.out.println("Lista atualizada: " + cores);
        }

        // Remove Third Element
        System.out.println("\n=== Remove Third Element ===");
        if (cores.size() > 2) {
            cores.remove(2);
        }
        System.out.println(cores);

        // Search Element in ArrayList
        System.out.println("\n=== Search Element in ArrayList ===");
        System.out.println("Contém 'Azul'? " + cores.contains("Azul"));

        // Sort ArrayList
        System.out.println("\n=== Sort ArrayList ===");
        Collections.sort(cores);
        System.out.println(cores);

        // Copy ArrayList
        System.out.println("\n=== Copy ArrayList ===");
        ArrayList<String> copia = new ArrayList<>(cores);
        System.out.println(copia);

        // Shuffle ArrayList
        System.out.println("\n=== Shuffle ArrayList ===");
        Collections.shuffle(cores);
        System.out.println(cores);

        // Reverse ArrayList
        System.out.println("\n=== Reverse ArrayList ===");
        Collections.reverse(cores);
        System.out.println(cores);

        // Extract Sublist from ArrayList
        System.out.println("\n=== Extract Sublist from ArrayList ===");
        if (cores.size() >= 2) {
            List<String> sublista = cores.subList(0, 2);
            System.out.println(sublista);
        }

        // Compare Two ArrayLists
        System.out.println("\n=== Compare Two ArrayLists ===");
        System.out.println("Listas iguais? " + cores.equals(copia));

        // Swap ArrayList Elements
        System.out.println("\n=== Swap ArrayList Elements ===");
        if (cores.size() > 2) {
            Collections.swap(cores, 0, 2);
        }
        System.out.println(cores);

        // Join Two ArrayLists
        System.out.println("\n=== Join Two ArrayLists ===");
        ArrayList<String> unida = new ArrayList<>(cores);
        unida.addAll(copia);
        System.out.println(unida);

        // Clone ArrayList
        System.out.println("\n=== Clone ArrayList ===");
        ArrayList<String> clone = (ArrayList<String>) cores.clone();
        System.out.println(clone);

        // Clear ArrayList
        System.out.println("\n=== Clear ArrayList ===");
        cores.clear();
        System.out.println(cores);

        // Check if ArrayList is Empty
        System.out.println("\n=== Check if ArrayList is Empty ===");
        System.out.println("Está vazia? " + cores.isEmpty());

        // Trim ArrayList Capacity
        System.out.println("\n=== Trim ArrayList Capacity ===");
        copia.trimToSize();
        System.out.println("Capacidade ajustada com trimToSize()");

        // Increase ArrayList Capacity
        System.out.println("\n=== Increase ArrayList Capacity ===");
        copia.ensureCapacity(10);
        System.out.println("Capacidade mínima garantida (10)");

        // Replace Second Element
        System.out.println("\n=== Replace Second Element ===");
        if (copia.size() > 1) {
            copia.set(1, "Preto");
        }
        System.out.println(copia);

        // Print Elements by Position
        System.out.println("\n=== Print Elements by Position ===");
        for (int i = 0; i < copia.size(); i++) {
            System.out.println(i + " -> " + copia.get(i));
        }
    }
}
