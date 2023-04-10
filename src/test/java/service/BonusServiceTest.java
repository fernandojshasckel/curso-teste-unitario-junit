package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {

        BonusService bonusService = new BonusService();

        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Fernando", LocalDate.now(), new BigDecimal(10001)));

        assertEquals(new BigDecimal("0.00"), bonus);

    }

    @Test
    void bonusDeveriaSerDezPorCentDoSalario() {

        BonusService bonusService = new BonusService();

        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Fernando", LocalDate.now(), new BigDecimal(2500)));

        assertEquals(new BigDecimal("250.00"), bonus);

    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDezMil() {

        BonusService bonusService = new BonusService();

        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Fernando", LocalDate.now(), new BigDecimal(10000)));

        assertEquals(new BigDecimal("1000.00"), bonus);

    }

}
