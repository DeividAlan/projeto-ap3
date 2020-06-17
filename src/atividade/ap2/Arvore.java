/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade.ap2;

/**
 *
 * @author Deivid
 */
public class Arvore {
    
    int valor;
    Arvore ArvoreEsquerda, ArvoreDireita;
    int maisAlto;
    static int contador = 0;
    static String retOrdem = "";
    static String retPre = "";
    static String retPos = "";
    static String retProf = "";

    public Arvore(int valor) {
        this.valor = valor;
    }
    public static Arvore raiz;

    public static String preordem(Arvore Arvorede) {
        if (Arvorede != null) {
            System.out.print(Arvorede.valor + ", ");
            retPre += (Arvorede.valor + ", ");
            preordem(Arvorede.ArvoreEsquerda);
            preordem(Arvorede.ArvoreDireita);
        }
        return retPre;
    }

    public static String posordem(Arvore Arvorede) {
        if (Arvorede != null) {

            posordem(Arvorede.ArvoreEsquerda);
            posordem(Arvorede.ArvoreDireita);
            System.out.print(Arvorede.valor + ", ");
            retPos += (Arvorede.valor + ", ");

        }
        return retPos;
    }

    public static String ordem(Arvore Arvorede) {
        if (Arvorede != null) {
            ordem(Arvorede.ArvoreEsquerda);
            System.out.print(Arvorede.valor + ", ");
            retOrdem += (Arvorede.valor + ", ");
            ordem(Arvorede.ArvoreDireita);
        }
        return retOrdem;
    }

    public static void inserir(int valor) {
        inserir(raiz, valor);
    }

    public static void inserir(Arvore Arvorede, int valor) {
        if (Arvorede == null) {
            System.out.println("Root " + valor);
            raiz = new Arvore(valor);
        } else {
            if (valor < Arvorede.valor) {
                if (Arvorede.ArvoreEsquerda != null) {
                    inserir(Arvorede.ArvoreEsquerda, valor);
                } else {
                    System.out.println("insert " + valor + " to the left " + Arvorede.valor);
                    Arvorede.ArvoreEsquerda = new Arvore(valor);                    
                }

            } else {
                if (Arvorede.ArvoreDireita != null) {
                    inserir(Arvorede.ArvoreDireita, valor);
                } else {
                    System.out.println("insert " + valor + " to the right " + Arvorede.valor);
                    Arvorede.ArvoreDireita = new Arvore(valor);
                }
            }
        }
    }
    
    public static String buscarProfundidade(int valor) {
        buscar(raiz, valor);
        return retProf;
    }
    
    public static void buscar(Arvore Arvorede, int valor) {
        if (Arvorede.valor == valor) {
        	System.out.println("Encontrado, Percorreu: " + contador + " Vezes" );
                retProf = ("Encontrado, Percorreu: " + contador + " Vezes" );
        } else {
            if (valor < Arvorede.valor) {
            	contador ++;
                if (Arvorede.ArvoreEsquerda != null) {
                	buscar(Arvorede.ArvoreEsquerda, valor);
                } else {
                    System.out.println("Não encontrado");
                    retProf = ("Não encontrado");
                }

            } else {
            	contador ++;
                if (Arvorede.ArvoreDireita != null) {
                    buscar(Arvorede.ArvoreDireita, valor);
                } else {
                	System.out.println("Não encontrado");
                        retProf = ("Não encontrado");
                }
            }
        }
    } 
    
}
