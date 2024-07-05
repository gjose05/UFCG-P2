package br.edu.ufcg.computacao.complementaccc;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestesAtvdComplementares {

private ComplementaCCCFacade fachada;
	
	@BeforeEach
	void preparaFachada(){
		this.fachada = new ComplementaCCCFacade();
		fachada.criarEstudante("Guilherme", "09050622488", 12345678, "123110787");
	}
	
	@Test
	void TesteMonitoria() {
		assertEquals("09050622488_1",fachada.criarAtividadeMonitoriaEmEstudante("09050622488", 12345678, "MONITORIA", 3, "LP2"));
		assertEquals(true, fachada.alterarDescricaoAtividade("09050622488", 12345678, "09050622488_1", "Atividade Monitoria LP2 2024"));
		assertEquals(false, fachada.alterarDescricaoAtividade("09050622488", 12345678, "09050622488_6", "Atividade Monitoria LP2 2024"));
		assertEquals(true, fachada.alterarComprovacaoAtividade("09050622488", 12345678, "09050622488_1", "12345678"));
		assertEquals(false, fachada.alterarComprovacaoAtividade("09050622488", 12345678, "09050622488_6", "12345678"));
		assertEquals(12.0, fachada.creditosAtividade("09050622488", 12345678, "09050622488_1"),0);
	}
	
	@Test
	void TestePesquisaExtesao() {
		assertEquals("09050622488_1",fachada.criarAtividadePesquisaExtensaoEmEstudante("09050622488", 12345678, "PESQUISA_EXTENSAO", 6, "LP2"));
		assertEquals(true, fachada.alterarDescricaoAtividade("09050622488", 12345678, "09050622488_1", "PESQUISA_EXTENSAO LP2 2024"));
		assertEquals(false, fachada.alterarDescricaoAtividade("09050622488", 12345678, "09050622488_6", "PESQUISA_EXTENSAO LP2 2024"));
		assertEquals(true, fachada.alterarComprovacaoAtividade("09050622488", 12345678, "09050622488_1", "12345678"));
		assertEquals(false, fachada.alterarComprovacaoAtividade("09050622488", 12345678, "09050622488_6", "12345678"));
		assertEquals(5, fachada.creditosAtividade("09050622488", 12345678, "09050622488_1"),0);
	}
	
	@Test
	void TesteEstagio() {
		assertEquals("09050622488_1",fachada.criarAtividadeEstagioEmEstudante("09050622488", 12345678, "ESTAGIO", 240, "LP2"));
		assertEquals(true, fachada.alterarDescricaoAtividade("09050622488", 12345678, "09050622488_1", "ESTAGIO LP2 2024"));
		assertEquals(false, fachada.alterarDescricaoAtividade("09050622488", 12345678, "09050622488_6", "ESTAGIO LP2 2024"));
		assertEquals(true, fachada.alterarComprovacaoAtividade("09050622488", 12345678, "09050622488_1", "12345678"));
		assertEquals(false, fachada.alterarComprovacaoAtividade("09050622488", 12345678, "09050622488_6", "12345678"));
		assertEquals(4, fachada.creditosAtividade("09050622488", 12345678, "09050622488_1"),0);
	}
	
	@Test
	void TestePublicacao() {
		assertEquals("09050622488_1",fachada.criarAtividadePublicacaoEmEstudante("09050622488", 12345678, "PERIÓDICO", "publicacao pesquisa", "periodico", "A2"));
		assertEquals(true, fachada.alterarDescricaoAtividade("09050622488", 12345678, "09050622488_1", "PUBLICACAO LP2 2024"));
		assertEquals(false, fachada.alterarDescricaoAtividade("09050622488", 12345678, "09050622488_6", "PUBLICACAO LP2 2024"));
		assertEquals(true, fachada.alterarComprovacaoAtividade("09050622488", 12345678, "09050622488_1", "12345678"));
		assertEquals(false, fachada.alterarComprovacaoAtividade("09050622488", 12345678, "09050622488_6", "12345678"));
		assertEquals(4, fachada.creditosAtividade("09050622488", 12345678, "09050622488_1"),0);
	}
	
}
