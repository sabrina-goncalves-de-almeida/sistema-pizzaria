package dcx.ufpb.br;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class PizzariaSearchController implements ActionListener{
    private SistemaPizzaria pizzaria;
    private JFrame janelaPrincipal;

    public PizzariaSearchController(SistemaPizzaria pizzaria, JFrame janela){
        this.pizzaria = pizzaria;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String cpf = JOptionPane.showInputDialog(janelaPrincipal, "Qual o cpf do cliente? ex.: 111.111.111-11");
        try {
            String clienteAchado = pizzaria.pesquisaCliente(cpf);
            if (clienteAchado != ""){
                JOptionPane.showMessageDialog(janelaPrincipal, "Encontrado: " + clienteAchado);
            }else {
                JOptionPane.showMessageDialog(janelaPrincipal, "Não foi encontrado nenhum cliente com cpf: "+ cpf);
            }
        } catch (CPFInesistenteException x) {
            System.out.println(x.getMessage());
        }
    }
}
