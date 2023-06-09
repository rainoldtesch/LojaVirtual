package db;

import models.Produto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProdutoDB {
    private Map<Integer, Produto> produtosMap = new HashMap<>();

    public List<Produto> getProdutosList() {
        List<Produto> produtos = new ArrayList<>();
        for (Map.Entry<Integer, Produto> produto : produtosMap.entrySet()) {
            produtos.add(produto.getValue());
        }
        return produtos;
    }

    public void addNovoProduto(Produto produto) {
        produtosMap.put(produto.getId(), produto);
    }

    public Produto getProdutoPorID(int id) {
        return produtosMap.get(id);
    }
}