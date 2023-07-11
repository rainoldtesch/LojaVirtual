import db.EstoquesDB;
import db.PedidosVendaDB;
import db.ProdutoDB;
import db.UsuariosDB;
import models.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ProdutoDB produtoDB = new ProdutoDB();
    static UsuariosDB usuariosDB = new UsuariosDB();
    static EstoquesDB estoquesDB = new EstoquesDB();
    static PedidosVendaDB pedidosVendaDB = new PedidosVendaDB();

    public static void main(String[] args) throws Exception {
        System.out.println(" --- PEDIDO DE VENDAS --- ");
        int option;
        do {
            System.out.println(" ");
            System.out.println(" 1 - Cadastrar novo produto");
            System.out.println(" 2 - Listar produtos cadastrados");
            System.out.println(" 3 - Cadastrar usuário ADMINISTRADOR");
            System.out.println(" 4 - Cadastrar usuário CLIENTE");
            System.out.println(" 5 - Listar todos os usuários");
            System.out.println(" 6 - Cadastrar novo estoque de produtos");
            System.out.println(" 7 - Listar todos os estoques");
            System.out.println(" 8 - Criar Pedido de Venda");
            System.out.println(" 9 - Listar Pedidos de Venda");
            System.out.println(" 0 - Sair do sistema");
            Scanner scanner = new Scanner(System.in);
            System.out.println(" ");
            System.out.print("->> Qual operação deseja realizar? ");
            option = scanner.nextInt();
            process(option);
        } while (option != 0);
    }
    public static void process(int option) throws Exception {
        switch (option) {
            case 1 : {
                Scanner scanner = new Scanner(System.in);
                System.out.print("->> Qual a descrição deseja dar ao novo produto? ");
                String descricao = scanner.nextLine();
                System.out.print("->> Qual ID deseja dar ao novo produto? ");
                int id = scanner.nextInt();
                System.out.print("->> Qual o preço do novo produto? [1111,11]: ");
                double preco = scanner.nextDouble();
                System.out.print("->> Qual a data de validade do novo produto? ");
                String dataString = scanner.next();
                Date dataValidade = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);

                Produto novoProduto = new Produto(id, descricao, preco, dataValidade);

                produtoDB.addNovoProduto(novoProduto);

                break;
            }
            case 2: {
                List<Produto> listaDeProdutos = produtoDB.getProdutosList();

                for(Produto produto : listaDeProdutos) {
                    System.out.println(" _______________ ID: " + produto.getId());
                    System.out.println("_________ Descrição: " + produto.getDescricao());
                    System.out.println("_____________ Preço: " + produto.getPreco());
                    System.out.println("__ Data de validade: " + produto.getDataValidade());
                    System.out.println(" ----------------------------------------------- ");
                }
                break;
            }

            case 3: {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Digite o nome do usuário ADMINISTRADOR: ");
                String nome = scanner.nextLine();

                Admin novoAdmin = new Admin(nome);
                usuariosDB.addNovoUsuario(novoAdmin);
                break;
            }

            case 4: {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Digite o nome do usuário CLIENTE: ");
                String nome = scanner.nextLine();

                Cliente novoCliente = new Cliente(nome);
                usuariosDB.addNovoUsuario(novoCliente);
                break;
            }

            case 5: {
                System.out.println(" ----------------------------------------- ");
                System.out.println(" ----- LISTANDO USUÁRIOS CADASTRADOS ----- ");
                System.out.println(" ----------------------------------------- ");
                for(Usuario usuario : usuariosDB.getUsuarioList()) {
                    System.out.println("ID: " + usuario.getId());
                    System.out.println("NOME: " + usuario.getNome());
                    System.out.println("TIPO: " + usuario.getTipoUsuario());
                    System.out.println(" ----------------------------------------- ");
                }
                break;
            }

            case 6: {
                Scanner scanner = new Scanner(System.in);
                System.out.println(" ------------------------------------------ ");
                System.out.println(" ----- CADASTRANDO ESTOQUE DE PRODUTO ----- ");
                System.out.println(" ------------------------------------------ ");

                System.out.print("Qual o identificador do estoque - exemplo: Celular = CEL ->  ");
                String id = scanner.next();

                System.out.print("Qual o produto que será adicionado ao estoque? [Informe o ID]: ");
                int produtoId = scanner.nextInt();

                Produto produto = produtoDB.getProdutoPorID(produtoId);
                System.out.println("ID PRODUTO: " + produto.getId());
                System.out.println("DESCRIÇÃO PRODUTO: " + produto.getDescricao());
                System.out.println("VALIDADE PRODUTO: " + produto.getDataValidade());

                //informações de quantidade para novo valor de estoque:
                System.out.print("Qual a quantidade de produto a ser adicionada em estoque: ");
                int quantidade = scanner.nextInt();

                //criação do novo estoque:
                Estoque novoEstoque = new Estoque(id, produto, quantidade);

                //chamamos nosso atributo de estoqueDB:
                estoquesDB.addNovoEstoque(novoEstoque);
                break;
            }
            case 7: {
                System.out.println(" ----------------------------------------- ");
                System.out.println(" ----- LISTANDO ESTOQUES CADASTRADOS ----- ");
                System.out.println(" ----------------------------------------- ");
                for(Estoque estoque : estoquesDB.getEstoques()) {
                    System.out.println("________ID: " + estoque.getId());
                    System.out.println("___PRODUTO: " + estoque.getProduto().getDescricao());
                    System.out.println("_____PREÇO: " + estoque.getProduto().getPreco());
                    System.out.println("QUANTIDADE: " + estoque.getQuantidade());
                    System.out.println(" ----------------------------------------- ");
                }
                break;
            }
            case 8: {
                Scanner scanner = new Scanner(System.in);

                break;
            }
            case 9: {
                break;
            }
        }
    }
}
