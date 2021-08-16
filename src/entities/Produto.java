package entities;

import java.util.ArrayList;
import java.util.List;

public class Produto implements Comparable<Produto>{
    private String nome;
    private Double preco;

    private List<Produto>lista =  new ArrayList<>();

    public Produto() {
    }

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setLista(Produto p) {
        lista.add(p);
    }

    public List<Produto> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Produto x:lista){
            s.append(x.getNome());
            s.append(", ");
            s.append(x.getPreco());
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public int compareTo(Produto o) {
        return preco.compareTo(o.getPreco());
    }
}
