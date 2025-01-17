package applicaiton;

import java.util.List;

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

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1: seller findById ===");
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n === TESTE 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n === TESTE 3: seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
	}

} 

