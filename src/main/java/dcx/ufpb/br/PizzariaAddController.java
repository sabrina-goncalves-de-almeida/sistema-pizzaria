package dcx.ufpb.br;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzariaAddController implements ActionListener {

    private SistemaPizzaria pizzaria;
    private JFrame janelaPrincipal;

    public PizzariaAddController(SistemaPizzaria pizzaria, JFrame janela){
        this.pizzaria = pizzaria;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do cliente?");
        String cpf = JOptionPane.showInputDialog(janelaPrincipal, "Qual o cpf do cliente? ex.: 111.111.111-11");
        int conta = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Nº da conta do cliente"));
        String favorito = JOptionPane.showInputDialog(janelaPrincipal, "Digite aqui o pedido favorito do cliente:");
        try {
            boolean cadastrou = pizzaria.cadastraCliente(nome, cpf, conta, favorito);
            if (cadastrou) {
                JOptionPane.showMessageDialog(janelaPrincipal, "Cliente cadastrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(janelaPrincipal, "Cliente não foi cadastrado.");
            }
        } catch (CPFJaExistenteException ex) {
            System.out.println(ex);
        }
    }
}

