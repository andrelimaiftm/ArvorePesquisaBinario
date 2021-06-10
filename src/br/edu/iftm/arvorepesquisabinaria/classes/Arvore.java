package br.edu.iftm.arvorepesquisabinaria.classes;

public class Arvore {

    private No raiz;

    //construtor inicializar um arvore vazia
    public Arvore(){
        this.raiz = null;
    }
    
    //inserir um novo nó na árvore de pesquisa binária
    public void insereNo(int valorIsercao){
        if(this.raiz == null){
            //criar Nó raiz
            this.raiz = new No(valorIsercao);
        }else{
            //chama o metodo insere do Nó
            this.raiz.insereNo(valorIsercao);
        }
    }

    public void preOrdemTransversal(){
        preOrdemAuxiliar(this.raiz);
    }

    private void preOrdemAuxiliar(No no) {
        if(no == null){
            return;
        }
        System.out.printf(" %d ",no.valor);//gera saída de dados do nó
        preOrdemAuxiliar(no.noEsquerdo);//precorre subárvore esquerda
        preOrdemAuxiliar(no.noDireito);//precorre subárvore a direita
    }

    public void inOrdemTransversal(){
        inOrdemAuxiliar(this.raiz);
    }

    private void inOrdemAuxiliar(No no) {
        if(no == null){
            return;
        }        
        inOrdemAuxiliar(no.noEsquerdo);//precorre subárvore esquerda
        System.out.printf(" %d ",no.valor);//gera saída de dados do nó
        inOrdemAuxiliar(no.noDireito);//precorre subárvore a direita
    }

    public void posOrdemTransversal(){
        posOrdemAuxiliar(this.raiz);
    }

    private void posOrdemAuxiliar(No no) {
        if(no == null){
            return;
        }        
        posOrdemAuxiliar(no.noEsquerdo);//precorre subárvore esquerda        
        posOrdemAuxiliar(no.noDireito);//precorre subárvore a direita
        System.out.printf(" %d ",no.valor);//gera saída de dados do nó
    }
}
