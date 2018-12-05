package web.servlet.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.impl.ProductDaoImpl;
import web.entity.Community;
import web.entity.Product;

/**
 * 产品管理
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductDaoImpl productDao=new ProductDaoImpl();
       
    public ProductServlet() {
        super();
    }

    @Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deleteProduct = productDao.deleteProduct(1);
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> listProduct = productDao.selectProduct();
		request.setAttribute("listProduct", listProduct);                  
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product=new Product();
		product.setCategoryId(1);
		product.setCategoryId(2);
		product.setProductName("");
		product.setProductPrice(new BigDecimal(100));
		product.setProductImages("");
		product.setProductDescriptionImages("");
		product.setInventory(1);
		product.setProductState("");
		product.setSuppliers("");
		
		int insertProduct = productDao.insertProduct(product);
	}


	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product=new Product();
		product.setCategoryId(1);
		product.setCategoryId(2);
		product.setProductName("");
		product.setProductPrice(new BigDecimal(100));
		product.setProductImages("");
		product.setProductDescriptionImages("");
		product.setInventory(1);
		product.setProductState("");
		product.setSuppliers("");
		int updateProduct = productDao.updateProduct(product);
	}


}
