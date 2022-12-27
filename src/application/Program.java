package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Scanner sc = new Scanner(System.in);

		int x = 0;
		while (x == 0) {
			System.out.println();
			System.out.println("O que deseja fazer");
			System.out.println("1 - Inserir um Vendedor");
			System.out.println("2 - Inserir um Departamento");
			System.out.println("3 - Procurar um Vendedor (ID)");
			System.out.println("4 - Procurar um Departamento (NOME)");
			System.out.println("5 - Ver todos os vendedores por ordem alfabetica");
			System.out.println("6 - Ver todos os departamentos por ordem alfabetica");
			System.out.println("7 - Deletar um Vendedor (ID)");
			System.out.println("8 - Deletar um Departamento (ID)");
			System.out.println("9 - Ver todos os vendedores de acordo com o departamento (NOME)");
			System.out.println("10 - Sair");
			System.out.println();
			System.out.print("Opcao: ");
			int menu = sc.nextInt();
			System.out.println();

			if (menu == 1) {
				System.out.print("Nome: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Email: ");
				String email = sc.nextLine();
				System.out.println("Data de Nascimento: ");
				Date birthDate = new Date();
				System.out.print("Salario: ");
				Double baseSalary = sc.nextDouble();
				System.out.print("Departamento: ");
				sc.nextLine();
				String departmentName = sc.nextLine();

				Seller newSeller = new Seller(999, name, email, birthDate, baseSalary,
						departmentDao.findByName(departmentName));
				sellerDao.insert(newSeller);
				System.out.println();
				System.out.println(newSeller);
			} else if (menu == 2) {
				System.out.print("Nome: ");
				sc.nextLine();
				String name = sc.nextLine();

				Department newDep = new Department(999, name);
				departmentDao.insert(newDep);
				System.out.println();
				System.out.println(newDep);
			} else if (menu == 3) {
				System.out.print("ID: ");
				int id = sc.nextInt();

				System.out.println();
				System.out.println(sellerDao.findById(id));
			} else if (menu == 4) {
				System.out.print("Departamento: ");
				sc.nextLine();
				String name = sc.nextLine();

				System.out.println();
				System.out.println(departmentDao.findByName(name));
			} else if (menu == 5) {
				List<Seller> list = sellerDao.findAll();

				for (Seller seller : list) {
					System.out.println(seller);
				}
			} else if (menu == 6) {
				List<Department> list = departmentDao.findAll();

				for (Department department : list) {
					System.out.println(department);
				}
			} else if (menu == 7) {
				System.out.print("ID: ");
				int id = sc.nextInt();
				
				sellerDao.deleteById(id);
				System.out.println("Vendedor ID = " + id + " deletado!");
			} else if (menu == 8) {
				System.out.print("ID: ");
				int id = sc.nextInt();
				
				departmentDao.deleteById(id);
				System.out.println("Departamento ID = " + id + " deletado!");
			} else if (menu == 9) {
				System.out.print("Departamento: ");
				sc.nextLine();
				String name = sc.nextLine();
				
				Department dep = departmentDao.findByName(name);
				List<Seller> list = sellerDao.findByDepartment(dep);
				
				for(Seller seller: list) {
					System.out.println(seller);
				}
			} else if (menu == 10) {
				System.out.println("Obrigado por utilizar nosso sistema!");
				x = 1;
			} else {
				System.out.println("Opcao incorreta, tente novamente!");
			}
		}

	}

}
