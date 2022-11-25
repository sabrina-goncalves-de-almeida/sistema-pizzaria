package dcx.ufpb.br;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collection;

public class PizzariaSaveController implements ActionListener {
    private SistemaPizzaria pizzaria;

    private GravadorDeClientes gravador;

    private JFrame janelaPrincipal;

    public PizzariaSaveController(SistemaPizzaria pizzaria, JFrame janela, GravadorDeClientes gravador){
        this.pizzaria = pizzaria;
        this.janelaPrincipal = janela;
        this.gravador = gravador;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try{
            gravador.gravaClientes(pizzaria.getClientes());
            JOptionPane.showMessageDialog(janelaPrincipal, "Clientes salvos com sucesso");
        }catch (IOException ioException){
            JOptionPane.showMessageDialog(janelaPrincipal, "Não foi possivel salvar os novos cadastros");
            ioException.printStackTrace();
        }
    }
}
