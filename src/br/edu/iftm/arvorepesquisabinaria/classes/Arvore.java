package br.edu.iftm.arvorepesquisabinaria.classes;

public class Arvore {

    private No raiz;

    // construtor inicializar um arvore vazia
    public Arvore() {
        this.raiz = null;
    }

    // inserir um novo nó na árvore de pesquisa binária
    public void insereNo(int valorIsercao) {
        if (this.raiz == null) {
            // criar Nó raiz
            this.raiz = new No(valorIsercao);
        } else {
            // chama o metodo insere do Nó
            this.raiz.insereNo(valorIsercao);
        }
    }

    public No buscar(int valorBusca) {
        return buscar(this.raiz, valorBusca);
    }

    public No buscar(No raiz, int valorBusca) {
        No aux = raiz;
        if (aux == null) {
            return null;
        } else if (aux.valor != valorBusca) {
            if (valorBusca < aux.valor) {
                aux = aux.noEsquerdo;
                aux = buscar(aux, valorBusca);
            } else {
                aux = aux.noDireito;
                aux = buscar(aux, valorBusca);
            }
        }
        return aux;

    }

    public No remover(int valorRemocao) {
        if (this.raiz == null){
            return null; // se arvore vazia
        } 
        No atual = this.raiz;
        No pai = this.raiz;
        boolean filho_esq = true;

        // ****** Buscando o valor **********
        while (atual.valor != valorRemocao) { // enquanto nao encontrou
            pai = atual;
            if (valorRemocao < atual.valor) { // caminha para esquerda
                atual = atual.noEsquerdo;
                filho_esq = true; // é filho a esquerda? sim
            } else { // caminha para direita
                atual = atual.noDireito;
                filho_esq = false; // é filho a esquerda? NAO
            }
            if (atual == null)
                return null; // encontrou uma folha -> sai
        } // fim laço while de busca do valor

        // **************************************************************
        // se chegou aqui quer dizer que encontrou o valor (valorRemocao)
        // "atual": contem a referencia ao No a ser eliminado
        // "pai": contem a referencia para o pai do No a ser eliminado
        // "filho_esq": é verdadeiro se atual é filho a esquerda do pai
        // **************************************************************

        // Se nao possui nenhum filho (é uma folha), elimine-o
        if (atual.noEsquerdo == null && atual.noDireito == null) {
            if (atual == this.raiz)
                this.raiz = null; // se raiz
            else if (filho_esq)
                pai.noEsquerdo = null; // se for filho a esquerda do pai
            else
                pai.noDireito = null; // se for filho a direita do pai
        }

        // Se é pai e nao possui um filho a direita, substitui pela subarvore a direita
        else if (atual.noDireito == null) {
            if (atual == this.raiz)
                this.raiz = atual.noEsquerdo; // se raiz
            else if (filho_esq)
                pai.noEsquerdo = atual.noEsquerdo; // se for filho a esquerda do pai
            else
                pai.noDireito = atual.noDireito; // se for filho a direita do pai
        }

        // Se é pai e nao possui um filho a esquerda, substitui pela subarvore a
        // esquerda
        else if (atual.noEsquerdo == null) {
            if (atual == this.raiz)
                this.raiz = atual.noDireito; // se raiz
            else if (filho_esq)
                pai.noEsquerdo = atual.noDireito; // se for filho a esquerda do pai
            else
                pai.noDireito = atual.noDireito; // se for filho a direita do pai
        }

        // Se possui mais de um filho, se for um avô ou outro grau maior de parentesco
        else {
            No sucessor = no_sucessor(atual);
            // Usando sucessor que seria o Nó mais a esquerda da subarvore a direita do No
            // que deseja-se remover
            if (atual == this.raiz)
                this.raiz = sucessor; // se raiz
            else if (filho_esq)
                pai.noEsquerdo = sucessor; // se for filho a esquerda do pai
            else
                pai.noDireito = sucessor; // se for filho a direita do pai
            sucessor.noEsquerdo = atual.noEsquerdo; // acertando o ponteiro a esquerda do sucessor agora que ele assumiu
                                      // a posição correta na arvore
        }

        return atual;
    }

    // O sucessor é o Nó mais a esquerda da subarvore a direita do No que foi
    // passado como parametro do metodo
    public No no_sucessor(No apaga) { // O parametro é a referencia para o No que deseja-se apagar
        No paidosucessor = apaga;
        No sucessor = apaga;
        No atual = apaga.noDireito; // vai para a subarvore a direita

        while (atual != null) { // enquanto nao chegar no Nó mais a esquerda
            paidosucessor = sucessor;
            sucessor = atual;
            atual = atual.noEsquerdo; // caminha para a esquerda
        }
        // *********************************************************************************
        // quando sair do while "sucessor" será o Nó mais a esquerda da subarvore a
        // direita
        // "paidosucessor" será o o pai de sucessor e "apaga" o Nó que deverá ser
        // eliminado
        // *********************************************************************************
        if (sucessor != apaga.noDireito) { // se sucessor nao é o filho a direita do Nó que deverá ser eliminado
            paidosucessor.noEsquerdo = sucessor.noDireito; // pai herda os filhos do sucessor que sempre serão a direita
            // lembrando que o sucessor nunca poderá ter filhos a esquerda, pois, ele sempre
            // será o
            // Nó mais a esquerda da subarvore a direita do Nó apaga.
            // lembrando também que sucessor sempre será o filho a esquerda do pai

            sucessor.noDireito = apaga.noDireito; // guardando a referencia a direita do sucessor para
                                      // quando ele assumir a posição correta na arvore
        }
        return sucessor;
    }

    public void preOrdemTransversal() {
        preOrdemAuxiliar(this.raiz);
    }

    private void preOrdemAuxiliar(No no) {
        if (no == null) {
            return;
        }
        System.out.printf(" %d ", no.valor);// gera saída de dados do nó
        preOrdemAuxiliar(no.noEsquerdo);// precorre subárvore esquerda
        preOrdemAuxiliar(no.noDireito);// precorre subárvore a direita
    }

    public void inOrdemTransversal() {
        inOrdemAuxiliar(this.raiz);
    }

    private void inOrdemAuxiliar(No no) {
        if (no == null) {
            return;
        }
        inOrdemAuxiliar(no.noEsquerdo);// precorre subárvore esquerda
        System.out.printf(" %d ", no.valor);// gera saída de dados do nó
        inOrdemAuxiliar(no.noDireito);// precorre subárvore a direita
    }

    public void posOrdemTransversal() {
        posOrdemAuxiliar(this.raiz);
    }

    private void posOrdemAuxiliar(No no) {
        if (no == null) {
            return;
        }
        posOrdemAuxiliar(no.noEsquerdo);// precorre subárvore esquerda
        posOrdemAuxiliar(no.noDireito);// precorre subárvore a direita
        System.out.printf(" %d ", no.valor);// gera saída de dados do nó
    }
}
