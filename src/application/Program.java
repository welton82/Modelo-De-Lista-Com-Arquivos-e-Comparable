package application;

import entities.CalculaMaior;
import entities.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        while(continuar){
            operacao(sc);
            System.out.print("Deseja Criar nova Lista? ");
            char nova = sc.next().toLowerCase().charAt(0);
            continuar = (nova =='s') ? true:false;

        }

        

    }

    public static int menu(Scanner sc){
        System.out.println();
        System.out.println("0 - Gerar Nova Lista");
        System.out.println("1 - Inserir Produto na Lista");
        System.out.println("2 - Listar");
        System.out.println("3 - Criar Arquivo da Lista Gerada");
        System.out.println("4 - Ler Arquivo File A Partir de Lista pronta");
        System.out.println("5 - Mostrar ìtem Mais Caro da Lista");
        System.out.print("operação: ");
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }
    public static void operacao(Scanner sc){
        Produto produto = new Produto();

        int op = 1;
        while (op != 0){
            op = menu (sc);
            switch (op){
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço do produto: ");
                    Double preco = sc.nextDouble();
                    produto.setLista(new Produto(nome, preco));
                    break;
                case 2:
                    System.out.println(produto.toString());
                    break;
                case 3:
                    System.out.print("Informe o Caminho para gerar Arquivo: ");
                    String caminho = sc.next();
                    caminho += ".txt";

                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho,true))) {
                        String []lines = {produto.toString()};

                        FileReader fr = new FileReader(caminho);
                        BufferedReader br = new BufferedReader(fr);
                        String line = br.readLine();
                        if(line == null){
                            System.out.println("Entrou em Null");
                            for(String l: lines){
                                bw.write(l);
                                bw.newLine();
                            }
                            System.out.println("Gravado Com Sucesso Em: " + caminho);

                        }else{
                            System.out.println("Arquivo deve ser Nulo!!!");
                        }




                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                    break;
                case 4:
                    System.out.print("Informe o Caminho Do Qual deseja ler: ");
                    caminho = sc.next();
                    caminho += ".txt";
                    try {
                        FileReader fr = new FileReader(caminho);
                        BufferedReader br = new BufferedReader(fr);

                        String line = br.readLine();
                        while(line != null){
                            System.out.println(line);
                            line = br.readLine();

                        }

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    Produto maior = CalculaMaior.maximo(produto.getLista());
                    System.out.println("Maior Produto: " + maior.getNome() + " R$: " + maior.getPreco());
                    break;
            }


        }

    }

}
