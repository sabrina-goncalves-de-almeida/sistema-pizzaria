package dcx.ufpb.br;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SistemaPizzaria implements InterfaceSistemaPizzaria{
    private Collection<Cliente> clientes;

    public SistemaPizzaria(){
        this.clientes = new ArrayList<>();
    }

    public boolean cadastraCliente(String nome, String cpf, int conta, String favorito) throws CPFJaExistenteException {
        boolean cadastrou = false;
        Cliente c = new Cliente(nome, cpf, conta, favorito);
        if (clientes.contains(c.getCpf())){
            throw new CPFJaExistenteException("Cliente de cpf " + cpf + " já foi registrado");
        } else if (!clientes.contains(c.getCpf())) {
            clientes.add(c);
            cadastrou = true;
        }
        System.out.println(cadastrou);
        return cadastrou;
    }

    public String pesquisaCliente(String cpf) throws CPFInesistenteException{
        String clienteAchado = "";
        for (Cliente c: clientes) {
            System.out.println(c.getCpf());
            System.out.println(c.getCpf().equals(cpf));
            if (c.getCpf().equals(cpf)){
                clienteAchado = c.getNome();
                return clienteAchado;
            }
        }
        throw new CPFInesistenteException("CPF "+cpf+" não existe no banco de dados");
    }

    public boolean removeCliente(String cpf) {
        boolean removeu = false;
        for (Cliente c: clientes) {
            if (c.getCpf().equals(cpf)){
                clientes.remove(c);
                removeu = true;
                return removeu;
            }
        }
        return removeu;
    }

    public boolean cadastraFavorito(String cpf, String favorito){
        boolean fav = false;
        for (Cliente c: clientes) {
            if (c.getCpf().equals(cpf)){
                c.setFavorito(favorito);
                fav = true;
            }
        }
        return fav;
    }

    public Collection<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }
}
