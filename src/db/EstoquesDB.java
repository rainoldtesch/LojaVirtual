package db;
import models.Estoque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstoquesDB {
    //criação HashMap + importe das classes:
    private Map<String, Estoque> estoquesDBMap = new HashMap<>();

    //adicionamos o método Getter:
    public Map<String, Estoque> getEstoquesDBMap() { return estoquesDBMap; }

    //implementação da Lista de estoque - Menu: case 7
    public List<Estoque> getEstoques() {
        List<Estoque> estoques = new ArrayList<>();
        for (Map.Entry<String, Estoque> estoque : estoquesDBMap.entrySet()) {
            estoques.add(estoque.getValue());
        }
        return estoques;
    }
    //criamos novo método para adicionar novo estoque (recebendo "estoque" como argumento):
    public void addNovoEstoque (Estoque estoque) {
        //fazemos "put()" sendo a chave o "id" do estoque:
        estoquesDBMap.put(estoque.getId(), estoque);
    }
}
