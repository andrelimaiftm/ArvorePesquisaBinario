package br.edu.iftm.arvorepesquisabinaria.testes;

import java.util.Random;

import br.edu.iftm.arvorepesquisabinaria.classes.Arvore;

public class ArvoreBinariaTeste {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        int valor;
        Random rand = new Random();

        System.out.println("Os valores da nossa Arvore Binária são:");
        for (int i = 0; i < 10; i++) {
            valor = rand.nextInt(100);
            System.out.print(valor+" ");
            arvore.insereNo(valor);
        }

        System.out.println("\n\nPreOrdem Transversal");
        arvore.preOrdemTransversal();

        System.out.println("\n\nInOrdem Transversal");
        arvore.inOrdemTransversal();

        System.out.println("\n\nPosOrdem Transversal");
        arvore.posOrdemTransversal();
    }
}
