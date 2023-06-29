/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.batalhanaval;

/**
 *
 * @author Bruno
 */
public class Tabuleiro {
    private char[][] tabuleiro=new char[11][11];
    private char[][] jogada=new char[11][11];
    private int colunaBarco;
    private int linhaBarco;
    private int colunaJogada;
    private int linhaJogada;
   

    public void gerarTabuleiro() {
        int ltr=65;
        int num=48;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(tabuleiro[i][j]==tabuleiro[0][0]){
                    tabuleiro[i][j] = ' ';              
                }
                else if(tabuleiro[i][j]==tabuleiro[0][j]){
                    tabuleiro[i][j] = (char) ltr;
                    ltr++;
                }
                else if(tabuleiro[i][j]==tabuleiro[i][0]){
                    tabuleiro[i][j] = (char) num;
                    num++;
                }
                else{
                    tabuleiro[i][j] = ' ';
                }
                
            }
        }
    }

    public void imprimirTabuleiro() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(tabuleiro[i][j] + "|");
            }
            System.out.println();
        }
    }
    
    public void gerarTabuleiroOculto(){
        int ltr=65;
        int num=48;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(jogada[i][j]==jogada[0][0]){
                    jogada[i][j] = ' ';              
                }
                else if(jogada[i][j]==jogada[0][j]){
                    jogada[i][j] = (char) ltr;
                    ltr++;
                }
                else if(jogada[i][j]==jogada[i][0]){
                    jogada[i][j] = (char) num;
                    num++;
                }
                else{
                    jogada[i][j] = ' ';
                }
                
            }
        }
    }
    
    public void imprimirTabuleiroJogo() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(jogada[i][j] + "|");
            }
            System.out.println();
        }
    }

    public char verfTabuleiro(int colunaBarco, int linhaBarco) {
        return tabuleiro[colunaBarco][linhaBarco];
    }
    
    public char verfTabuleiroJogo(int colunaBarco, int linhaBarco){
        return jogada[colunaBarco][linhaBarco];
    }
    
    public void addBarcoTabuleiro(){
        tabuleiro[linhaBarco][colunaBarco] = 'B';
    }
    
    public void jogarTabuleiro(boolean acerto){
        if(acerto){
            jogada[linhaJogada][colunaJogada] = 'B';
        }else{
            jogada[linhaJogada][colunaJogada] = '~';
        }
        
    }
    public int getColunaBarco() {
        return colunaBarco;
    }

    public void setColunaBarco(int colunaBarco) {
        this.colunaBarco = colunaBarco;
    }

    public int getLinhaBarco() {
        return linhaBarco;
    }

    public void setLinhaBarco(int linhaBarco) {
        this.linhaBarco = linhaBarco;
    }

    public int getColunaJogada() {
        return colunaJogada;
    }

    public void setColunaJogada(int colunaJogada) {
        this.colunaJogada = colunaJogada;
    }

    public int getLinhaJogada() {
        return linhaJogada;
    }

    public void setLinhaJogada(int linhaJogada) {
        this.linhaJogada = linhaJogada;
    }
    
    
    
}
