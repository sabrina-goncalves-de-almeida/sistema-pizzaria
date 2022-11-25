package dcx.ufpb.br;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SistemaPizzariaTest {
    @Test
    public void TestaCadastraCliente(){
        SistemaPizzaria sistema = new SistemaPizzaria();
        try{
            sistema.cadastraCliente("Ana", "111.111.111-11", 0001, "Pizza quatro queijos");
        }catch (CPFJaExistenteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void TestaPesquisaCliente(){
        SistemaPizzaria sistema = new SistemaPizzaria();
        try{
            sistema.cadastraCliente("Maria", "111.111.111-22", 0002, "Pizza quatro queijos");
        }catch (CPFJaExistenteException e){
            System.out.println(e.getMessage());
        }

        try {
            assertEquals("Maria", sistema.pesquisaCliente("111.111.111-22"));
        } catch (CPFInesistenteException e) {
            System.out.println(e);
        }
    }

    @Test
    public void TestaRemoveCliente(){
        SistemaPizzaria sistema = new SistemaPizzaria();
        try{
            sistema.cadastraCliente("Maria", "111.111.111-22", 0002, "Pizza quatro queijos");
        }catch (CPFJaExistenteException e){
            System.out.println(e.getMessage());
        }

        sistema.removeCliente("111.111.111-22");

        try {
            assertEquals("", sistema.pesquisaCliente("111.111.111-22"));
        } catch (CPFInesistenteException e) {
            System.out.println(e);
        }
    }
}
