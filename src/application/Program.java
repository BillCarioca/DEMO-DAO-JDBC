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
		
		System.out.println("=== teste 01: seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("=== teste 02: seller findByDepartment ====");
		Department department = new Department(2,null);
		List<Seller> list= sellerDao.findByDepartament(department);
		for (Seller obj: list) {
			System.out.println(obj);
		}
		System.out.println("=== teste 03: seller findAll ====");
		list= sellerDao.findAll();
		for (Seller obj: list) {
			System.out.println(obj);
		}
		System.out.println("=== teste 04: seller InsertSeller ====");
		Seller newSeller = new Seller(null,"Greg","greg@gmail.com", new Date(),4000.0,department);
		sellerDao.insert(newSeller);
		System.out.println(" Inserted new id = "+ newSeller.getId());
		
		System.out.println("=== teste 05: seller UpDateSeller ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha waine");
		sellerDao.update(seller);
		System.out.println("Update Completed!");
	}

}
