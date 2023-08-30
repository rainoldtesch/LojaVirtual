package validadores;

import models.PedidoVenda;

import java.util.ArrayList;
import java.util.List;

public class ValidadorPedidoVenda extends Validador {
    private PedidoVenda pedidoVenda;

    public List<IValidadorPedidoVenda> validadorPedidoVenda = new ArrayList<>();

    public ValidadorPedidoVenda(PedidoVenda pedidoVenda) {
        this.pedidoVenda = pedidoVenda;

        this.validadorPedidoVenda.add(new ValidadorDataValidade());
        this.validadorPedidoVenda.add(new ValidadorQuantidade());
    }

    @Override
    public boolean ehValido() {

    }
}
