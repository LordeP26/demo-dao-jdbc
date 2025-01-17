package applicaiton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	/*  DAO: para cada entidade, haverá um objeto responsável por fazer acesso a dados relacionado a esta entidade  
	 * ex: Cliente = ClienteDao/ Produto = ProdutoDao/ Pedido = PedidoDao
	 * cada DAO será definido por uma interface
	 * a injeção de dependência pode ser feita por meio do padrão de projeto Factory
	 */

	public static void main(String[] args) throws ParseException{
		
		Scanner sc = new Scanner(System.in);	
		
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1: seller findById ===");
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n === TESTE 2: seller findByDepartment ===");
		Department department = new Department(4, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n === TESTE 3: seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		/*
		System.out.println("\n === TESTE 4: seller insert ===");
		Seller newSeller = new Seller(null, "Monique ", "monique22022005@gmail.com", sdf.parse("22/02/2005"), 2400.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		*/
		
		System.out.println("\n === TESTE 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		/*System.out.println("\n === TESTE 6: seller delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		*/
		sc.close();
	}

} 


