package br.edu.iftm.arvorepesquisabinaria.classes;

public class No {
    No noEsquerdo;
    int valor;// valor que arvore vai armazenar
    No noDireito;

    // metodo construtor da classe Nó
    public No(int valor) {
        this.valor = valor;
        noEsquerdo = null;
        noDireito = null;
    }

    // localiza o ponto de inserção e insere o novo nó;
    // ignorar valores duplicados;
    public void insereNo(int valorIsercao) {
        // insere na subárvore esquerda
        if (valorIsercao < this.valor) {
            // insere um novo Nó
            if (this.noEsquerdo == null) {
                this.noEsquerdo = new No(valorIsercao);
            } else {// contiua percorrendo subárvore esquerda
                this.noEsquerdo.insereNo(valorIsercao);
            }
            //insere na subárvore direita
        } else if (valorIsercao > this.valor) {
            //insere um novo Nó
            if(this.noDireito == null){
                this.noDireito = new No(valorIsercao);
            }else{// contiua percorrendo subárvore direita
                this.noDireito.insereNo(valorIsercao);
            }
        }
    }
}
