package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;

/*
    O sistema deve permitir que os funcionários recebam reajuste salarial
    anual baseado em seu desempenho, obedecendo às seguintes regras:
        - Se o desempenho foi "A desejar", reajuste será apenas 3% do salário;
        - Se o desempenho foi "Bom", reajuste será de 15% do salário;
        - Se o desempenho foi "Ótimo", reajuste será de 20% do salário;
*/
public class ReajusteServiceTest {
    
    @Test
    void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {

        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Fernando", LocalDate.now(), new BigDecimal("1000.00"));

        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForADesejar() {

        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Fernando", LocalDate.now(), new BigDecimal("1000.00"));

        reajusteService.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForADesejar() {

        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Fernando", LocalDate.now(), new BigDecimal("1000.00"));

        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
