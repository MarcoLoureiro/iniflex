import entidades.Funcionario;
import negocio.Metodos;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        Metodos metodos = new Metodos();

//      Tópicos comtemplados: 3, 3.1
        List<Funcionario> listaDeFuncionarios = metodos.criarListaDeFuncionarios();

        System.out.println("Tópicos comtemplados: 3.3");
        System.out.println("Imprimir todos os funcionários com todas suas informações, sendo que:\n" +
                "• informação de data deve ser exibido no formato dd/mm/aaaa;\n" +
                "• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.");
        Metodos.imprimirTituloColunas();
        System.out.println(listaDeFuncionarios);
        Metodos.imprimirDivisoria();

        System.out.println("Tópicos comtemplados: 3.2");
        System.out.println("Remover o funcionário “João” da lista.");
        metodos.removerFuncionarioPorNome("João", listaDeFuncionarios);

        System.out.println("Tópicos comtemplados: 3.4");
        System.out.println("Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.");
        metodos.aumentarSalarioDeTodosOsFuncionarios(listaDeFuncionarios);

        System.out.println("Tópicos comtemplados: 3.5, 3.6");
        System.out.println("Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.");
        System.out.println("Imprimir os funcionários, agrupados por função.");
        metodos.agruparFuncionarios(listaDeFuncionarios);

        System.out.println("Tópicos comtemplados: 3.8");
        System.out.println("Imprimir os funcionários que fazem aniversário no mês 10 e 12.");
        metodos.imprimirAniversariosMesDezAndDoze(listaDeFuncionarios);

        System.out.println("Tópicos comtemplados: 3.9");
        System.out.println("Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.");
        System.out.println(metodos.imprimirFuncionarioComMaiorIdade(listaDeFuncionarios));
        Metodos.imprimirDivisoria();

        System.out.println("Tópicos comtemplados: 3.10");
        System.out.println("Imprimir a lista de funcionários por ordem alfabética.");
        System.out.println(metodos.ordenarListaAlfabeticamente(listaDeFuncionarios));
        Metodos.imprimirDivisoria();

        System.out.println("Tópicos comtemplados: 3.11");
        System.out.println("Imprimir o total dos salários dos funcionários.");
        System.out.println("Soma total dos salários: " + metodos.calcularSomaTodosSalarios(listaDeFuncionarios) + " R$");
        Metodos.imprimirDivisoria();

        System.out.println("Tópicos comtemplados: 3.12");
        System.out.println("Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.");
        metodos.calcularQuantidadeDeSalariosMinimos(listaDeFuncionarios);
    }
}
