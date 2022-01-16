package br.com.gabriel.service;

import br.com.gabriel.ValidacaoException;
import br.com.gabriel.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteService {

    public void reajustarSalarioDoFuncionaro(Funcionario funcionario, BigDecimal aumento) {
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);

        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }

        BigDecimal salarioReajustado = salarioAtual.add(aumento);

        funcionario.atualizarSalario(salarioReajustado);
    }
}
