package applicaiton;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	/*  DAO: para cada entidade, haverá um objeto responsável por fazer acesso a dados relacionado a esta entidade  
	 * ex: Cliente = ClienteDao/ Produto = ProdutoDao/ Pedido = PedidoDao
	 * cada DAO será definido por uma interface
	 * a injeção de dependência pode ser feita por meio do padrão de projeto Factory
	 */

	public static void main(String[] args) {
		
		Department obj = new Department(1, "Books");
		System.out.println(obj);
		
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		System.out.println(seller);
		

	}

}
