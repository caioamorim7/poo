import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListApp {
    public static void main(String[] args) {
        ArrayList<String> cores = new ArrayList<>();

        //1. ___________________________________
        System.out.println("\n1.");

        //2. ___________________________________
        System.out.println("\n2. ");

        //3. ___________________________________
        System.out.println("\n3. ");

        //4. ___________________________________
        System.out.println("\n4.");

        //5. ___________________________________
        System.out.println("\n5.");

        //6. ___________________________________
        System.out.println("\n6.");

        //7. ___________________________________
        System.out.println("\n7.");

        //8. ___________________________________
        System.out.println("\n8.");

        //9. ___________________________________
        System.out.println("\n9.");

        //10. ___________________________________
        System.out.println("\n10.");

        //11. ___________________________________
        System.out.println("\n11.");

        //12. ___________________________________
        System.out.println("\n12.");

        //13. ___________________________________
        System.out.println("\n13.");

        //14. ___________________________________
        System.out.println("\n14.");

        //15. ___________________________________
        System.out.println("\n15.");

        //16. ___________________________________
        System.out.println("\n16.");


         //17. ___________________________________
        out.println("\n17.");

        out.println("Criando linked List com conteudo de cores e cores2:");
        
        LinkedList<String> listalinked = new LinkedList<String>();

        listalinked.addAll(cores);
        listalinked.addAll(cores2);

        out.println("LinkedList: " + listalinked);


        //18. ___________________________________
        out.println("\n18.");

        LinkedList<String> listalinked_copia = listalinked;

        out.println("cópia da LinkedList: " + listalinked_copia);


        //19. ___________________________________
        out.println("\n19.");

        listalinked.pollFirst();
        out.println("LinkedList sem o primeiro elemento (poll): " + listalinked);


        //20. ___________________________________
        out.println("\n20.");

        out.println("LinkedList olhando primeiro elemento (peekfirst): " + listalinked.peekFirst());


        //21. ___________________________________
        out.println("\n21.");

        out.println("LinkedList olhando último elemento (peeklast): " + listalinked.peekLast());


        //22. ___________________________________
        out.println("\n22.");

        out.println("LinkedList verificando se o elemento 'Felipe' está presente: " + listalinked.contains("Felipe"));

        //23. ___________________________________
        out.println("\n23.");

        out.println("Convertendo a LinkedList para ArrayList: ");



        //24. ___________________________________
        out.println("\n24.");



        //25. ___________________________________
        out.println("\n25.");

        out.println("LinkedList verificando se a lista está vazia: " + listalinked.isEmpty());


        //26. ___________________________________
        out.println("\n26.");

        out.println("LinkedList atual: " + listalinked);
        listalinked.set(6, "Fabricio");
        out.println("LinkedList modificando a posição 6 para 'Fabricio': " + listalinked);

    }
}
