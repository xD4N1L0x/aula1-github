package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Funcionario;

public class Programa {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> list = new ArrayList<>();
		
		System.out.print("Quantos funcionários quer registrar? ");
		int n = sc.nextInt();
		
		for(int i =0; i < n; i++) {
			
			System.out.println();
			System.out.println("Funcionário #"+(i+1)+":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while(existeId(list, id)) {
				System.out.print("Id já existe! Tente novamente: ");
				id = sc.nextInt();
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			Double salario = sc.nextDouble();
			
			Funcionario fun = new Funcionario(id, nome, salario);
			list.add(fun);
		}
		
			System.out.println();
			System.out.print("Entre com a id do funcionário que vai receber o acrécimo de salario: ");
			int idSalario = sc.nextInt();
			
			Funcionario fun = list.stream().filter(x -> x.getId() == idSalario).findFirst().orElse(null);
			
			if(fun == null) {
				
				System.out.println("Essa Id não existe!");
			}
			else {
				System.out.print("Digite a percentagem: ");
				Double percentagem = sc.nextDouble();
				fun.acressimoSalario(percentagem);
			}
			
			System.out.println();
			System.out.println("Lista de Funcionários:");
			for(Funcionario x : list) {
				System.out.println(x);
			}
		
		sc.close();
	}
	
	public static boolean existeId(List<Funcionario> list, int id) {
		
		Funcionario fun = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return fun != null;
	}

}
