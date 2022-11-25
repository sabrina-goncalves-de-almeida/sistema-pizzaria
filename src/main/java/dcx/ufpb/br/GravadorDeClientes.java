package dcx.ufpb.br;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class GravadorDeClientes {
    private String fileName = "clientes.txt";

    public void gravaClientes( Collection<Cliente> clientes) throws IOException {
        ObjectOutputStream gravador = null;
        try {
            gravador = new ObjectOutputStream(new FileOutputStream(fileName));
            ArrayList<Cliente> clientesASalvar = new ArrayList<>(clientes);
            gravador.writeObject(clientesASalvar);
        } finally {
            if (gravador != null){
                gravador.close();
            }
        }
    }

    public Collection<Cliente> recuperaClientes() throws IOException, ClassNotFoundException{
        ObjectInputStream leitor = null;
        try {
            leitor = new ObjectInputStream( new FileInputStream(fileName) );
            Collection<Cliente> clientesLidos = (Collection<Cliente>) leitor.readObject();
            return clientesLidos;
        } finally {
            if (leitor != null){
                leitor.close();
            }
        }
    }
}
