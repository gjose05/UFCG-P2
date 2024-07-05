package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filmnow.FilmNow;

class DetalhaFilmeTest {
    
	private FilmNow fn;

	@BeforeEach
		void preparaFilmes() {
			this.fn = new FilmNow();
	    }
	
	@Test
	void test1() {
    	assertEquals("FILME ADICIONADO", fn.cadastraFilme(1, "Avatar", "2009", "Disney+"));
    	assertEquals("Avatar, 2009\nDisney+", fn.getFilme(1));
    	assertEquals("FILME ADICIONADO", fn.cadastraFilme(1, "20 dias em Mariupol", "2023", "Cinema"));
    	assertEquals("20 dias em Mariupol, 2023\nCinema", fn.getFilme(1));
	}
	
	void test2() {
    	assertEquals("", fn.getFilme(1));
    	assertEquals("POSIÇÃO INVÁLIDA", fn.getFilme(0));
    	assertEquals("POSIÇÃO INVÁLIDA", fn.getFilme(101));
	}
	
	void test3() {
    	assertEquals("FILME ADICIONADO", fn.cadastraFilme(1, "Avatar", "2009", "Disney+"));
    	fn.criaHotlist(1, 1);
    	assertEquals("🔥 Avatar,2009\nDisney+", fn.getFilme(1));
	}

}
