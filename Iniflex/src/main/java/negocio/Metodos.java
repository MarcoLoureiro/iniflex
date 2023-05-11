package negocio;

import entidades.Funcionario;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Metodos {


    public static void imprimirTituloColunas() {
        System.out.println("[| Nome | Data Nascimento | Salário | Cargo |]");
    }

    public static void imprimirDivisoria() {
        System.out.println("---------------------------------------------");
    }

    public List<Funcionario> criarListaDeFuncionarios() {
        List<Funcionario> funcionarioListaComDados = new ArrayList<>(List.of(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2283.38), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), BigDecimal.valueOf(9836.14), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), BigDecimal.valueOf(2234.68), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), BigDecimal.valueOf(4071.84), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(4071.84), "Gerente"),
                new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), BigDecimal.valueOf(1606.85), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 24), BigDecimal.valueOf(2799.33), "Eletricista")
        ));
        return funcionarioListaComDados;
    }

    public void removerFuncionarioPorNome(String nome, List<Funcionario> funcionarioList) {
        for (int i = 0; i < funcionarioList.size(); i++) {
            if (funcionarioList.get(i).getNome().equals(nome))
                funcionarioList.remove(i);
        }
        imprimirTituloColunas();
        System.out.println(funcionarioList);
        imprimirDivisoria();
    }

    public void aumentarSalarioDeTodosOsFuncionarios(List<Funcionario> funcionarioList) {
        Metodos metodos = new Metodos();

        for (int i = 0; i < funcionarioList.size(); i++) {
            funcionarioList.get(i).setSalario((funcionarioList.get(i).getSalarioNaoFormatado()
                    .multiply(BigDecimal.valueOf(0.1)))
                    .add(funcionarioList.get(i).getSalarioNaoFormatado()).setScale(2, RoundingMode.HALF_UP)
            );
        }
        imprimirTituloColunas();
        System.out.println(funcionarioList);
        imprimirDivisoria();
    }

    public void agruparFuncionarios(List<Funcionario> funcionarioList) {
        Map<String, List<Funcionario>> funcionariosPeloCargo = funcionarioList.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("Funcionários agrupados pelo cargo: ");
        imprimirTituloColunas();
        System.out.println();
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPeloCargo.entrySet()) {
            System.out.println(entry.getValue());
        }
        imprimirDivisoria();
    }

    public void imprimirAniversariosMesDezAndDoze(List<Funcionario> funcionarioList) {

        for (Funcionario funcionario : funcionarioList) {
            if (funcionario.getDataNascimento().substring(3, 5).equals("12") || funcionario.getDataNascimento().substring(3, 5).equals("10")) {
                System.out.println(funcionario);
            }
        }
        imprimirDivisoria();
    }

    public String imprimirFuncionarioComMaiorIdade(List<Funcionario> funcionarioList) {

        String funcionarioDeMaiorIdade = "";
        Integer maiorIdade = 0;
        final LocalDate dataAtual = LocalDate.now();

        for (Funcionario funcionario : funcionarioList) {
            Integer idadeConvertida = Period.between(funcionario.getDataNascimentoNaoFormatada(), dataAtual).getYears();
            if (idadeConvertida > maiorIdade) {
                maiorIdade = idadeConvertida;
                funcionarioDeMaiorIdade = "[ | " + funcionario.getNome() + " | " + idadeConvertida + " | ]";
            }
        }
        funcionarioDeMaiorIdade = "[ | Nome | Idade | ]\n" + funcionarioDeMaiorIdade;
        return funcionarioDeMaiorIdade;
    }

    public List<Funcionario> ordenarListaAlfabeticamente(List<Funcionario> funcionarioList) {
        Collections.sort(funcionarioList, Comparator.comparing(Funcionario::getNome));
        return funcionarioList;
    }

    public BigDecimal calcularSomaTodosSalarios(List<Funcionario> funcionarioList) {

        BigDecimal totalSalarios = BigDecimal.ZERO;

        for (Funcionario funcionario : funcionarioList) {
            totalSalarios = totalSalarios.add(funcionario.getSalarioNaoFormatado());
        }
        return totalSalarios;
    }

    public void calcularQuantidadeDeSalariosMinimos(List<Funcionario> funcionarioList) {
        for (Funcionario funcionario : funcionarioList) {
            funcionario.setSalario(funcionario.getSalarioNaoFormatado().divide(BigDecimal.valueOf(1212), 0, RoundingMode.HALF_UP));
        }
        System.out.println("[| Nome | Data Nasc. | Sals. | Cargo |]");
        System.out.println(funcionarioList);
    }

}
