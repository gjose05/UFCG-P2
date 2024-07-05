package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filmnow.FilmNow;

public class FilmeAdicionaTest {


    private FilmNow fn;


    @BeforeEach
    void preparaFilmes() {
        this.fn = new FilmNow();
    }

    @Test
    void testAdicionaFilme() {
    	assertEquals("FILME ADICIONADO", fn.cadastraFilme(1, "Avatar", "2009", "Disney+"));
    }
    
    @Test
    void test2() {
    	assertEquals("FILME ADICIONADO", fn.cadastraFilme(1, "20 dias em Mariupol", "2023", "Cinema"));
    	assertEquals("FILME ADICIONADO", fn.cadastraFilme(1, "Avatar", "2009", "Disney+"));
    }
    
    @Test
    void test3() {
    	assertEquals("FILME ADICIONADO", fn.cadastraFilme(1, "Avatar", "2009", "Disney+"));
    	assertEquals("FILME JÁ ADICIONADO", fn.cadastraFilme(3, "Avatar", "2009", "Disney+"));
    }
    
    @Test
    void test4() {
        assertEquals("FILME ADICIONADO", fn.cadastraFilme(1, "Avatar", "2009", "Disney+"));
        assertEquals("FILME JÁ ADICIONADO", fn.cadastraFilme(3, "Avatar", "2009", "Popcornflix"));
    }
    
    void test5() {
    	assertEquals("FILME ADICIONADO", fn.cadastraFilme(100, "Avatar", "2009", "Disney+"));
    }
    
    void test6() {
    	assertEquals("POSIÇÃO INVÁLIDA", fn.cadastraFilme(101, "Avatar", "2009", "Disney+"));
    	assertEquals("POSIÇÃO INVÁLIDA", fn.cadastraFilme(0, "Avatar", "2009", "Disney+"));
    }
    
    void test7() {
    	assertEquals("FILME INVALIDO", fn.cadastraFilme(1, "20 dias em Mariupol", "2023", ""));
    	assertEquals("FILME ADICIONADO", fn.cadastraFilme(1, "20 dias em Mariupol", "", "Cinema"));
    	assertEquals("FILME INVALIDO", fn.cadastraFilme(1, "", "2023", "Cinema"));
    }
}
