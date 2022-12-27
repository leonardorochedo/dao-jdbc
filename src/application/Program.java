package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller1 = sellerDao.findById(3);
		System.out.println(seller1);
		System.out.println();
		
		System.out.println("=== TEST 2: seller findByDepartment ===");
		Department dep1 = new Department(2, null);
		List<Seller> list1 = sellerDao.findByDepartment(dep1);
		for(Seller obj: list1) {
			System.out.println(obj);
		}
		System.out.println();
		
		System.out.println("=== TEST 3: seller findAll ===");
		List<Seller> list2 = sellerDao.findAll();
		for(Seller obj: list2) {
			System.out.println(obj);
		}
		System.out.println();
		
		System.out.println("=== TEST 4: seller insert ===");
		Seller seller2 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep1);
		sellerDao.insert(seller2);
		System.out.println("Inserted! New id= " + seller2.getId());
		System.out.println();
		
		System.out.println("=== TEST 5: seller update ===");
		Seller sellerUp = sellerDao.findById(4);
		sellerUp.setName("Leonardo");
		sellerDao.update(sellerUp);
		System.out.println("Updated complete!");
		System.out.println();
	}

}
