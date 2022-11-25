package dcx.ufpb.br;

public interface InterfaceSistemaPizzaria {

    boolean cadastraCliente(String nome, String cpf, int conta, String favorito) throws CPFJaExistenteException ;

    String pesquisaCliente(String cpf) throws CPFInesistenteException;

    boolean removeCliente(String cpf);

    boolean cadastraFavorito(String cpf, String favorito);
}
