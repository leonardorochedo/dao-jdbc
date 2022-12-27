package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department insert ===");
		Department dep1 = new Department(7, "Lazer");
//		departmentDao.insert(dep1);
		System.out.println("Inserted! New id= " + dep1.getId());
		System.out.println();
		
		System.out.println("=== TEST 2: department update ===");
		Department dep2 = new Department(6, "Robotica");
		departmentDao.update(dep2);
		System.out.println("Updated! New id= " + dep2.getId());
		System.out.println();
		
		System.out.println("=== TEST 3: department deleteById ===");
		departmentDao.deleteById(6);
		System.out.println("Deleted!");
		System.out.println();
		
		System.out.println("=== TEST 4: department findById ===");
		System.out.println(departmentDao.findById(5));
		System.out.println();
		
		System.out.println("=== TEST 5: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for(Department obj: list) {
			System.out.println(obj);
		}
		System.out.println();
	}

}
