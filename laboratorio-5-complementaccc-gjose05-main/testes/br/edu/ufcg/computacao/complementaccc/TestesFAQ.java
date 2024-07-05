package br.edu.ufcg.computacao.complementaccc;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestesFAQ {

	private ComplementaCCCFacade fachada;
	
	@BeforeEach
	void preparaFachada(){
		this.fachada = new ComplementaCCCFacade();
		fachada.criarAdm("Ze Rennan", "02050622488", 12345678);
		fachada.criarEstudante("Guilherme", "09050622488", 12345678, "123110787");
	}
	
	@Test
	void TestesFaqAdm() {
		assertEquals(true, fachada.adicionarItemFAQ("02050622488", 12345678, "O Flamengo é o maior time do Brasil?"));
		assertEquals(false, fachada.adicionarItemFAQ("02050642488", 12345678, "O Flamengo é o maior time do Brasil?"));
		assertEquals(true, fachada.adicionarItemFAQ("02050622488", 12345678, "O Flamengo é o maior time do Brasil?", "Não, é o São Paulo!"));
		assertEquals(false, fachada.adicionarItemFAQ("02050642488", 12345678, "O Flamengo é o maior time do Brasil?", "Não, é o São Paulo!"));
		assertEquals(true, fachada.alteraRespostaItem("02050622488", 12345678, 0, "Não, é o São Paulo!"));
		assertEquals(false, fachada.alteraRespostaItem("02050642488", 12345678, 0, "Não, é o São Paulo!"));
		String[] tag = new String[3];
		assertEquals(true ,fachada.atribuirTagsItemFAQ("02050622488", 12345678, 0, tag));
		assertEquals(false ,fachada.atribuirTagsItemFAQ("02050642488", 12345678, 0, tag));
	}
	
	@Test
	void TestesFaqOrdenação() {
		assertEquals(true, fachada.adicionarItemFAQ("02050622488", 12345678, "O Flamengo é o maior time do Brasil?", "Não, é o São Paulo!"));
		assertEquals(true, fachada.adicionarItemFAQ("02050622488", 12345678, "Guilherme Jose é lindo?", "Sim!!!!"));
		assertEquals(true, fachada.adicionarItemFAQ("02050622488", 12345678, "Vou pra final de LP2 e P2?", "Certamente!!!"));
		String[] expected = {"O Flamengo é o maior time do Brasil? Não, é o São Paulo! 0 ","Guilherme Jose é lindo? Sim!!!! 0 ","Vou pra final de LP2 e P2? Certamente!!! 0 "};
		assertArrayEquals(expected,fachada.listarFAQ());
		assertEquals(true, fachada.destacarItem(0));
		assertEquals(true, fachada.destacarItem(0));
		assertEquals(true, fachada.destacarItem(2));
		assertEquals(false, fachada.destacarItem(16));
		String[] esperado = {"O Flamengo é o maior time do Brasil? Não, é o São Paulo! 2 ","Guilherme Jose é lindo? Sim!!!! 0 ","Vou pra final de LP2 e P2? Certamente!!! 1 "};
		assertArrayEquals(esperado,fachada.listarFAQ());
		String[] ola = {"O Flamengo é o maior time do Brasil? Não, é o São Paulo! 2 ","Vou pra final de LP2 e P2? Certamente!!! 1 ","Guilherme Jose é lindo? Sim!!!! 0 "};
		assertArrayEquals(ola,fachada.listarFAQPorDestaque());
		}
	
	@Test
	void TestesFaqTags() {
		assertEquals(true, fachada.adicionarItemFAQ("02050622488", 12345678, "O Flamengo é o maior time do Brasil?", "Não, é o São Paulo!"));
		assertEquals(true, fachada.adicionarItemFAQ("02050622488", 12345678, "Guilherme Jose é lindo?", "Sim!!!!"));
		assertEquals(true, fachada.adicionarItemFAQ("02050622488", 12345678, "Vou pra final de LP2 e P2?", "Certamente!!!"));
		String [] tags = {"estagio", "carga horaria"};
		String[] tags2 = {"estagio"};
		assertEquals(true ,fachada.atribuirTagsItemFAQ("02050622488", 12345678, 0, tags));
		assertEquals(true ,fachada.atribuirTagsItemFAQ("02050622488", 12345678, 2, tags));
		assertEquals(true ,fachada.atribuirTagsItemFAQ("02050622488", 12345678, 1, tags2));
		String[] expected = {"O Flamengo é o maior time do Brasil? Não, é o São Paulo! 0 estagio carga horaria ", "Guilherme Jose é lindo? Sim!!!! 0 estagio ","Vou pra final de LP2 e P2? Certamente!!! 0 estagio carga horaria "};
		assertArrayEquals(expected, fachada.buscarItemFAQ(tags2));
	}

}
