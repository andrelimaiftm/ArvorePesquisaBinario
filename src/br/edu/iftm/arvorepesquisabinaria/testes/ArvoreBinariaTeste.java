package br.edu.iftm.arvorepesquisabinaria.testes;

import java.util.Random;

import br.edu.iftm.arvorepesquisabinaria.classes.Arvore;
import br.edu.iftm.arvorepesquisabinaria.classes.No;

public class ArvoreBinariaTeste {
 
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        int valor;
        Random rand = new Random();
        int valorBusca = 0;

        System.out.println("Os valores da nossa Arvore Binária são:");
        for (int i = 0; i < 10; i++) {
            valor = rand.nextInt(100);
            System.out.print(valor + " ");
            arvore.insereNo(valor);
            if (i == 5) {
                valorBusca = valor;
            }
        }

        No aux = arvore.buscar(valorBusca);
        if(aux != null){
            System.out.printf("\nO valor %d está na arvore binária\n", aux.valor);
        }else{
            System.out.println("\nO valor não está na arvore binária\n");
        }

        System.out.println("\n\nPreOrdem Transversal");
        arvore.preOrdemTransversal();

        System.out.println("\n\nInOrdem Transversal");
        arvore.inOrdemTransversal();

        System.out.println("\n\nPosOrdem Transversal");
        arvore.posOrdemTransversal();

        aux = arvore.remover(aux.valor);        

        aux = arvore.buscar(valorBusca);        
        if(aux != null){
            System.out.printf("\nO valor %d está na arvore binária\n", aux.valor);
        }else{
            System.out.println("\nO valor não está na arvore binária\n");
        }

        System.out.println("\n\nPreOrdem Transversal");
        arvore.preOrdemTransversal();
        
    }

    

   


}
