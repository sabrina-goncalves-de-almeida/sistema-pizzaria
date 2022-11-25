package dcx.ufpb.br;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzariaRemoveController implements ActionListener{
    private SistemaPizzaria pizzaria;
    private JFrame janelaPrincipal;
    public PizzariaRemoveController(SistemaPizzaria pizzaria, JFrame janela){
        this.pizzaria = pizzaria;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String cpf = JOptionPane.showInputDialog(janelaPrincipal, "Qual o cpf do cliente a remover?");
        boolean removeu = pizzaria.removeCliente(cpf);
        if (removeu){
            JOptionPane.showMessageDialog(janelaPrincipal, "Cliente removido com sucesso");
        }else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Cliente não foi encontrado.");
        }
    }
}
