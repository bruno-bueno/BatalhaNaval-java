/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.batalhanaval;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Bruno
 */
public class jogo {
    
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        Tabuleiro jogo1 = new Tabuleiro();
        Tabuleiro jogo2 = new Tabuleiro();
        
        Tabuleiro[] tabuleiros = new Tabuleiro[2];
        tabuleiros[0] = jogo1;
        tabuleiros[1] = jogo2;
        
        System.out.println("Bem-vindo à Batalha Naval!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Jogar contra o computador");
        System.out.println("2 - Jogar contra outro jogador");

        int opcao = ler.nextInt();

        if (opcao == 1) {
            tabuleiros[0].gerarTabuleiro();
            tabuleiros[1].gerarTabuleiro();
            jogarContraComputador(tabuleiros);
        } else if (opcao == 2) {
            tabuleiros[0].gerarTabuleiro();
            tabuleiros[1].gerarTabuleiro();
            jogarContraJogador(tabuleiros);
        } else {
            System.out.println("Opção inválida. Encerrando o jogo.");
        }
        
        
    }
    public static void jogarContraComputador(Tabuleiro[] tabuleiros){
        
        Random aleatorio=new Random();
        Scanner ler = new Scanner(System.in);
        System.out.println("Você escolheu Jogar contra o computador");
        System.out.println("Você deseja:");
        System.out.println("1 - Posicionar Manualmente");
        System.out.println("2 - Posicionar Automaticamente");
        int opcao = ler.nextInt();

        if (opcao == 1) {
            posicionarManualmente(tabuleiros, 0);
            posicionarAutomaticamente(tabuleiros, 1);
        } else if (opcao == 2) {
            posicionarAutomaticamente(tabuleiros, 0);
            posicionarAutomaticamente(tabuleiros, 1);
            tabuleiros[0].imprimirTabuleiro();
            tabuleiros[1].imprimirTabuleiro();
        } else {
            System.out.println("Opção inválida");
        }
        boolean jogo=true;
        tabuleiros[0].gerarTabuleiroOculto();
        tabuleiros[1].gerarTabuleiroOculto();
        int jogada=1;
        int jog;
        do{
            int barcosAcertados[]=new int[2];
            
            if(jogada%2==0){
                jog=0;
                System.out.println("Sua vez");
                tabuleiros[jog].imprimirTabuleiroJogo();
                System.out.print("digite a coluna que voce quer jogar");
                int coluna=lerLetra();
                System.out.print("digite a linha que voce quer jogar");
                int linha=lerNumero();
                if(verificaJogada(linha,coluna,tabuleiros,jog)){
                    tabuleiros[jog].setColunaJogada(coluna);
                    tabuleiros[jog].setLinhaJogada(linha);
                    if(tabuleiros[jog].verfTabuleiro(coluna, linha)=='B'){
                        tabuleiros[jog].jogarTabuleiro(true);
                    }else{
                        tabuleiros[jog].jogarTabuleiro(false);
                        jogada++;
                    }
                    tabuleiros[jog].imprimirTabuleiroJogo();
                    barcosAcertados[jog]++;
                }
                else{
                    System.out.println("valor invalido jogue novamente");
                }
            }
            else{
                jog=1;
                System.out.println("vez do computador");
                
                int linha=aleatorio.nextInt(1,10);
                int coluna=aleatorio.nextInt(1,10);
                if(verificaJogada(linha,coluna,tabuleiros,jog)){
                    tabuleiros[jog].setColunaJogada(coluna);
                    tabuleiros[jog].setLinhaJogada(linha);
                    if(tabuleiros[jog].verfTabuleiro(coluna, linha)=='B'){
                        tabuleiros[jog].jogarTabuleiro(true);
                    }else{
                        tabuleiros[jog].jogarTabuleiro(false);
                        jogada++;
                    }
                    tabuleiros[jog].imprimirTabuleiroJogo();
                    barcosAcertados[jog]++;
                }
                else{
                    
                }
            }
            if(barcosAcertados[jog]==20){
                jogo=false;
            }
        }while(jogo);
        
    }
    public static void jogarContraJogador(Tabuleiro[] tabuleiros){
        Scanner ler = new Scanner(System.in);
        System.out.println("Você escolheu Jogar contra outro jogador");
        System.out.println("Jogador 1 você deseja:");
        System.out.println("1 - Posicionar Manualmente");
        System.out.println("2 - Posicionar Automaticamente");
        int opcao = ler.nextInt();
        if (opcao == 1) {
            posicionarManualmente(tabuleiros, 0);
        } else if (opcao == 2) {
            posicionarAutomaticamente(tabuleiros, 0);
        } else {
            System.out.println("Opção inválida");
        }
        System.out.println("Jogador 2 você deseja:");
        System.out.println("1 - Posicionar Manualmente");
        System.out.println("2 - Posicionar Automaticamente");
        opcao = ler.nextInt();
        if (opcao == 1) {
            posicionarManualmente(tabuleiros, 0);
        } else if (opcao == 2) {
            posicionarAutomaticamente(tabuleiros, 0);
        } else {
            System.out.println("Opção inválida");
        }
        boolean jogo=true;
        tabuleiros[0].gerarTabuleiroOculto();
        tabuleiros[1].gerarTabuleiroOculto();
        int jogada=1;
        int jog;
        do{
            int barcosAcertados[]=new int[2];
            
            if(jogada%2==0){
                jog=0;
            }
            else{
                jog=1;
            }
            System.out.println("vez do jogador:"+jog);
            tabuleiros[jog].imprimirTabuleiroJogo();
            System.out.print("digite a coluna que voce quer jogar");
            int coluna=lerLetra();
            System.out.print("digite a linha que voce quer jogar");
            int linha=lerNumero();
            if(verificaJogada(linha,coluna,tabuleiros,jog)){
                tabuleiros[jog].setColunaJogada(coluna);
                tabuleiros[jog].setLinhaJogada(linha);
                if(tabuleiros[jog].verfTabuleiro(coluna, linha)=='B'){
                    tabuleiros[jog].jogarTabuleiro(true);
                    
                }else{
                    tabuleiros[jog].jogarTabuleiro(false);
                    jogada++;
                }
                tabuleiros[jog].imprimirTabuleiroJogo();
                barcosAcertados[jog]++;
            }
            else{
                System.out.println("valor invalido jogue novamente");
            }
            
            if(barcosAcertados[jog]==20){
                jogo=false;
            }
        }while(jogo);
        
    }
    public static void posicionarAutomaticamente(Tabuleiro[] tabuleiros, int jog){
        int[] tamanhoNavio={4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
        Random aleatorio= new Random();
        
        for(int i=0;i<tamanhoNavio.length;i++){
            int leitura=aleatorio.nextInt(1,10);
            tabuleiros[jog].setLinhaBarco(leitura);
            leitura=aleatorio.nextInt(1,10);
            tabuleiros[jog].setColunaBarco(leitura);
            int opcao = aleatorio.nextInt(1,2);
            int linha=tabuleiros[jog].getLinhaBarco();
            int col=tabuleiros[jog].getColunaBarco();
            if(verificaAlocacao(tamanhoNavio[i],jog,tabuleiros,opcao)){
                if (opcao == 1) {
                    for(int j=0;j<tamanhoNavio[i];j++){
                        tabuleiros[jog].setLinhaBarco(linha);
                        tabuleiros[jog].addBarcoTabuleiro();
                        linha++;
                    }
                } else if (opcao == 2) {
                    for(int j=0;j<tamanhoNavio[i];j++){
                        tabuleiros[jog].setColunaBarco(col);
                        tabuleiros[jog].addBarcoTabuleiro();
                        col++;
                    }
                }
            } else{
                i--;
            }                         
        }
        
    }
    public static void posicionarManualmente(Tabuleiro[] tabuleiros, int jog){
        int[] tamanhoNavio={4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
        Scanner ler= new Scanner(System.in);
        
        
        for(int i=0;i<tamanhoNavio.length;i++){
            tabuleiros[jog].imprimirTabuleiro();
            System.out.println("Digite a coluna do navio de "+tamanhoNavio[i]+" posições");
            int leitura=lerLetra();
            tabuleiros[jog].setColunaBarco(leitura);
            System.out.println("Digite a linha do navio de "+tamanhoNavio[i]+" posições");
            leitura=lerNumero();
            tabuleiros[jog].setLinhaBarco(leitura);
            System.out.println("o navio esta na horizontal e vertical");
            System.out.println("1 - vertical");
            System.out.println("2 - horizontal");
            int opcao = ler.nextInt();
            int linha=tabuleiros[jog].getLinhaBarco();
            int col=tabuleiros[jog].getColunaBarco();
            if(verificaAlocacao(tamanhoNavio[i],jog,tabuleiros,opcao)){
                if (opcao == 1) {
                    for(int j=0;j<tamanhoNavio[i];j++){
                        tabuleiros[jog].setLinhaBarco(linha);
                        tabuleiros[jog].addBarcoTabuleiro();
                        linha++;
                    }
                } else if (opcao == 2) {
                    for(int j=0;j<tamanhoNavio[i];j++){
                        tabuleiros[jog].setColunaBarco(col);
                        tabuleiros[jog].addBarcoTabuleiro();
                        col++;
                    }
                }
            } else{
                System.out.println("posição invalida aloque em outro lugar:");
                i--;
            }                         
        }
    }
    
    public static int lerNumero(){
        Scanner ler= new Scanner(System.in);
        int leitura=ler.nextInt();
        return leitura+1;
        
    }
    public static int lerLetra(){
        String alfabeto="ABCDEFGHIJ";
        Scanner ler= new Scanner(System.in);
        String letra=ler.next().toUpperCase();
        return alfabeto.indexOf(letra)+1;
    }
    
    public static boolean verificaAlocacao(int tamanhoNavio,int jog,Tabuleiro[] tabuleiros,int opcao){    
          
        if (opcao == 1) {
            int linha = tabuleiros[jog].getLinhaBarco();
            int col = tabuleiros[jog].getColunaBarco();
            if(linha<0 || linha>11 || linha + tamanhoNavio > 11){
                return false;
            }
            for(int j=0;j<tamanhoNavio;j++){
                if(tabuleiros[jog].verfTabuleiro(linha,col)=='B'){
                    return false;
                }
                linha++;
            }
        } else if (opcao == 2) {
            int linha = tabuleiros[jog].getLinhaBarco();
            int col = tabuleiros[jog].getColunaBarco();
            if(col<0 || col>11 || col + tamanhoNavio > 11){
                return false;
            }
            for(int j=0;j<tamanhoNavio;j++){
                if(tabuleiros[jog].verfTabuleiro(linha,col)=='B'){
                    return false;
                }
                col++;
            }
        }
        return true;
    }
    public static boolean verificaJogada(int linha,int coluna,Tabuleiro[] tabuleiros,int jog){
        if(tabuleiros[jog].verfTabuleiroJogo(coluna,linha)=='B'){
            return false;
        }else if(tabuleiros[jog].verfTabuleiroJogo(coluna,linha)=='~'){
            return false;
        }
        return true;
    }
}
