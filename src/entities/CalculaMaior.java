package entities;

import java.util.List;

public class CalculaMaior {
    public static <T extends Comparable <T>> T maximo(List<T> lista){

        if(lista.isEmpty()){
            throw new IllegalStateException("Lista está vazia");
        }
        T max = lista.get(0);

        for(T x: lista){
            if(x.compareTo(max) > 0){
                max = x;
            }

        }
        return max;
    }

}
