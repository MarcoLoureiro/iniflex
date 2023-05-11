package entidades;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario() {

    }

    public String getSalario() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        return decimalFormat.format(salario);
    }

    public BigDecimal getSalarioNaoFormatado() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }


    @Override
    public String toString() {
        return "| " + getNome() + " | " + getDataNascimento() + " | " + salario + " | " + funcao +
                " |\n";
    }

    public String getNomeAndIdade() {
        return "| " + getNome() + " | " + getDataNascimento() + " |";
    }
}
