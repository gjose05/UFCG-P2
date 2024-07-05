package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestesUsuario {

	private ComplementaCCCFacade fachada;
	
	@BeforeEach
	void preparaFachada(){
		this.fachada = new ComplementaCCCFacade();
	}
	
	@Test
	void testUsuario() {
		assertEquals(true, fachada.criarEstudante("Guilherme", "09050622488", 12345678, "123110787"));
		assertEquals(false, fachada.criarEstudante("Maria Luiza", "09050622488", 12345678, "123110777"));
		assertEquals(true, fachada.criarEstudante("Arthur", "09050962488", 12345678, "123110787"));
		assertEquals(true, fachada.criarEstudante("Maria Luiza", "09050662488", 12345678, "123110797"));
		assertEquals(true, fachada.criarAdm("Ze Rennan", "02050622488", 12345678));
		assertEquals(null, fachada.exibirEstudantes("01050622488", 12345678));
		assertEquals(true, fachada.alterarEstudante("09050622488", 12345678, "senha", "12345679"));
		assertEquals(false, fachada.alterarEstudante("09040622488", 12345678, "senha", "12345679"));
		assertEquals(true, fachada.configurarSenhaADMIN("02050622488", 12345678, 12345679));
		assertEquals(false, fachada.configurarSenhaADMIN("02050622488", 12345678, 12345675));
		assertEquals(true, fachada.configurarNovoADMIN("02050622488", 12345679, "Maria Luiza", "09050632488", 12345678));
		assertEquals(false, fachada.configurarNovoADMIN("09050632488", 12345677, "Guilherme", "09050624488", 12345678));
		String expected = "Arthur 09050962488 123110787" ;
		String expected1 = "Guilherme 09050622488 123110787";
		String expected2 = "Maria Luiza 09050662488 123110797";
		assertEquals(expected,fachada.exibirEstudantes("09050632488", 12345678)[0]);
		assertEquals(expected1,fachada.exibirEstudantes("09050632488", 12345678)[1]);
		assertEquals(expected2,fachada.exibirEstudantes("09050632488", 12345678)[2]);

	}
	
	

}
