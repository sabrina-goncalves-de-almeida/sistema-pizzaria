package dcx.ufpb.br;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class PizzariaGUI extends JFrame {
    JLabel linha1, linha2;
    private Collection<Cliente> clientes1 = new ArrayList<Cliente>();
    SistemaPizzaria pizzaria = new SistemaPizzaria();

    ImageIcon imagem = new ImageIcon("."+File.separator+"src"+File.separator+"images"+File.separator+"pizza.png");
    JMenuBar barraDeMenu = new JMenuBar();
    GravadorDeClientes gravador = new GravadorDeClientes();
    public PizzariaGUI() throws IOException {

        File f = new File("src"+File.separator+"main"+File.separator+"java"+File.separator+"dcx"+File.separator+"ufpb"+File.separator+"br");
        System.out.println(f.getAbsolutePath());

        setTitle("Pizzaria nova esperança");
        setSize(800, 600);
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.white);

        Collection<Cliente> clientes = null;

        try{
            clientes = gravador.recuperaClientes();
            for (Cliente c: clientes) {
                this.pizzaria.cadastraCliente(c.getNome(), c.getCpf(), c.getConta(), c.getFavorito());
            }
            JOptionPane.showMessageDialog(null, "Clientes recuperados com sucesso");
        } catch (IOException| ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Clientes não recuperados, erro: "+ e.getMessage());
            e.printStackTrace();
        } catch (CPFJaExistenteException e) {
            throw new RuntimeException(e);
        }

        linha1 = new JLabel("Pizzas, salgados e bebidas", JLabel.CENTER);
        linha1.setForeground(Color.blue);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        linha2 = new JLabel(imagem, JLabel.CENTER);
        setLayout(new GridLayout(3, 1));
        add(linha1);
        add(linha2);
        add(new JLabel());
        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarCliente = new JMenuItem("Cadastrar cliente");
        menuCadastrar.add(menuCadastrarCliente);

        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarCliente = new JMenuItem("Pesquisar cliente");
        menuPesquisar.add(menuPesquisarCliente);

        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverCliente = new JMenuItem("Remover cliente");
        menuRemover.add(menuRemoverCliente);

        JMenu menuSalvar = new JMenu("Salvar");
        JMenuItem menuSalvarClientes = new JMenuItem("Salvar clientes");
        menuSalvar.add(menuSalvarClientes);

        menuPesquisarCliente.addActionListener(new PizzariaSearchController(pizzaria, this));
        menuRemoverCliente.addActionListener(new PizzariaRemoveController(pizzaria, this));
        menuCadastrarCliente.addActionListener((ae) -> {
            String nome = JOptionPane.showInputDialog(this, "Qual o nome do cliente?");
            String cpf = JOptionPane.showInputDialog(this, "Qual o cpf do cliente? ex.: 111.111.111-11");
            int conta = Integer.parseInt(JOptionPane.showInputDialog(this, "Nº da conta do cliente"));
            String favorito = JOptionPane.showInputDialog(this, "Digite aqui o pedido favorito do cliente:");
            boolean cadastrou = false;
            try {
                cadastrou = pizzaria.cadastraCliente(nome, cpf, conta, favorito);
                clientes1.add(new Cliente(nome,cpf,conta,favorito));
            } catch (CPFJaExistenteException e) {
                System.out.println(e);
            }
            if (cadastrou) {
                JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não foi cadastrado.");
            }
        });
        menuSalvarClientes.addActionListener(new PizzariaSaveController(pizzaria, this, gravador));

        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        barraDeMenu.add(menuSalvar);
        setJMenuBar(barraDeMenu);

    }

    public static void main(String[] args) throws IOException {
        JFrame janela = new PizzariaGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

