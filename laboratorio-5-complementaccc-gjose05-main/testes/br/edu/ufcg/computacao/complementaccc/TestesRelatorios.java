package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestesRelatorios {

	private ComplementaCCCFacade fachada;
	
	@BeforeEach
	void preparaFachada(){
		this.fachada = new ComplementaCCCFacade();
		fachada.criarEstudante("Guilherme", "09050622488", 12345678, "123110787");
		fachada.criarAtividadePesquisaExtensaoEmEstudante("09050622488", 12345678, "PESQUISA_EXTENSAO", 6, "LP2");
		fachada.criarAtividadeMonitoriaEmEstudante("09050622488", 12345678, "MONITORIA", 3, "LP2");
		fachada.criarAtividadeMonitoriaEmEstudante("09050622488", 12345678, "MONITORIA", 1, "P2");
		fachada.criarAtividadePublicacaoEmEstudante("09050622488", 12345678, "PERIÓDICO", "publicacao pesquisa", "periodico", "A2");
		fachada.alterarDescricaoAtividade("09050622488", 12345678, "09050622488_2", "Atividade Monitoria LP2 2024");
		fachada.alterarDescricaoAtividade("09050622488", 12345678, "09050622488_3", "Atividade Monitoria P2 2024");
		fachada.alterarDescricaoAtividade("09050622488", 12345678, "09050622488_1", "Atividade PESQUISA_EXTENSAO LP2 2024");
	}
	
	@Test
	void TesteRelatorioCompleto() {
		try {
			fachada.criarRelatorioCompleto("09050622478", "12345678");
			fail();
		}catch(Exception e) {
		}
		assertEquals(0,fachada.criarRelatorioCompleto("09050622488", "12345678"));
		String expected = "Guilherme 09050622488 123110787\nMONITORIA Atividade Monitoria LP2 2024 12.0\nMONITORIA Atividade Monitoria P2 2024 4.0\nPESQUISA_EXTENSAO Atividade PESQUISA_EXTENSAO LP2 2024 5.0\nPUBLICAÇÃO 4.0\n";
		assertEquals(expected, fachada.exibirRelatorio("09050622488", "12345678",0));
	}
	
	@Test
	void TesteRelatorioResumido() {
		try {
			fachada.criarRelatorioResumido("09050622478", "12345678");
			fail();
		}catch(Exception e) {
		}
		assertEquals(0,fachada.criarRelatorioResumido("09050622488", "12345678"));
		String expected = "Guilherme 09050622488 123110787\nMONITORIA 16 16\nPESQUISA_EXTENSAO 5.0 18\nPUBLICACAO 4.0 16\n";
		assertEquals(expected, fachada.exibirRelatorio("09050622488", "12345678",0));
	}
	
	@Test
	void TesteRelatorioResumidoAtv() {
		try {
			fachada.criarRelatorioResumido("09050622478", "12345678");
			fail();
		}catch(Exception e) {
		}
		assertEquals(0,fachada.criarRelatorioPorATV("09050622488", "12345678", "MONITORIA"));
		String expected = "Guilherme 09050622488 123110787\nMONITORIA 16 16";
		assertEquals(expected, fachada.exibirRelatorio("09050622488", "12345678",0));
	}
	
	
}
