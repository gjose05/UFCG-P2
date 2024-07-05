package mrbet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MrBetSistemaTest {

	private MrBetSistema driver;
	
	@BeforeEach
	void preparaSistema() {
		this.driver = new MrBetSistema();
		driver.cadastraTime("250_PB", "Nacional de Patos", "Canario");
		driver.cadastraTime("252_PB", "Sport Lagoa Seca" , "Carneiro");
		driver.cadastraTime("002_RJ","Clube de Regatas do Flamengo", "Urubu");
		driver.cadastraTime("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
    }
	
	@Test
	void test1() {
		assertEquals("CAMPEONATO ADICIONADO!\n", driver.adicionaCampeonato("Brasileirão série A 2023", 30));
		assertEquals("CAMPEONATO JÁ EXISTE!\n", driver.adicionaCampeonato("Brasileirão série A 2023", 30));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!\n",driver.incluiNoCampeonato("250_PB", "Brasileirão série A 2023"));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!\n",driver.incluiNoCampeonato("252_PB", "Brasileirão série A 2023"));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!\n",driver.incluiNoCampeonato("252_PB", "Brasileirão série A 2023"));
		assertEquals("O TIME NÃO EXISTE!\n" ,driver.incluiNoCampeonato("005_PB", "Brasileirão série A 2023"));
		assertEquals("O CAMPEONATO NÃO EXISTE!\n" ,driver.incluiNoCampeonato("250_PB", "Brasileirão série D 2023"));
	}
	
	void test2() {
		assertEquals("CAMPEONATO ADICIONADO!\n", driver.adicionaCampeonato("Brasileirão série A 2023", 1));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!\n",driver.incluiNoCampeonato("252_PB", "Brasileirão série A 2023"));
		assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!\n",driver.incluiNoCampeonato("250_PB", "Brasileirão série A 2023"));
	}
	
	void test3() {
		assertEquals("CAMPEONATO ADICIONADO!\n", driver.adicionaCampeonato("Copa do Nordeste 2023", 30));
		assertEquals("O TIME ESTÁ NO CAMPEONATO!\n",driver.verificaCampeonato("252_PB", "Copa do Nordeste 2023"));
		assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO!\n",driver.verificaCampeonato("250_PB", "Copa do Nordeste 2023"));
		assertEquals("O CAMPEONATO NÃO EXISTE!\n",driver.verificaCampeonato("252_PB", "Copa do Nordeste 2023"));
		assertEquals("O TIME NÃO EXISTE!\n",driver.verificaCampeonato("005_PB", "Copa do Nordeste 2023"));
	}
}
