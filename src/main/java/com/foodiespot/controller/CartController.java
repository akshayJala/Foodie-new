package com.foodiespot.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.foodiespot.dao.CartDao;
import com.foodiespot.dao.CategoryDao;
import com.foodiespot.dao.ProductDao;
import com.foodiespot.dao.SupplierDao;
import com.foodiespot.dao.UserDetailsDao;
import com.foodiespot.model.BillingAddress;
import com.foodiespot.model.Cart;
import com.foodiespot.model.Category;
import com.foodiespot.model.Product;
import com.foodiespot.model.Supplier;
import com.foodiespot.model.UserDetails;

@Controller
public class CartController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private ProductDao productDao;

	@Autowired
	private Product product;

	@Autowired
	Category category;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	Supplier supplier;

	@Autowired
	SupplierDao supplierDao;

	@Autowired
	UserDetails userDetails;

	@Autowired
	UserDetailsDao userDetailsDao;
	
	@Autowired
	Cart cart ;
	
	@Autowired
	CartDao cartDao ;
	
	@Autowired
	HttpSession session ;


	@RequestMapping(value = "viewProds/{productId}", method = RequestMethod.GET)
	public ModelAndView viewProduct(@PathVariable int productId) {
		product = productDao.getProduct(productId);
		ModelAndView modelAndView = new ModelAndView("user/viewProdDetails");
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	/*
	@RequestMapping(value = "viewProds/buyNow")
	public ModelAndView goToBilling(@ModelAttribute("billingAddress") BillingAddress billingAddress) {
		
		
		ModelAndView modelAndView = new ModelAndView("user/billingAddress");
		modelAndView.addObject("product", product);
		
		return modelAndView;
	}*/
	

	@RequestMapping(value = "viewProds/shippingAddress")
	public ModelAndView goToShipping() {
		
		
		ModelAndView modelAndView = new ModelAndView("user/shippingAddress");
		modelAndView.addObject("product", product);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "viewProds/orderSummary")
	public ModelAndView goToOrderSummary() {
		
		
		ModelAndView modelAndView = new ModelAndView("user/orderSummary");
		modelAndView.addObject("product", product);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "viewProds/addToCart/{productId}")
	public ModelAndView addToCart(@PathVariable(value="productId") int productId,
			@ModelAttribute("cart") Cart cart,
			@ModelAttribute("product") Product product) {
		product = productDao.getProduct(productId);
		String userId = session.getAttribute("user").toString();
		cart.setUserId(userId);
		cart.setPrice(product.getPrice());
		cart.setProductName(product.getProductName());
		cart.setQuantity(1);
		cart.setStatus('N');
		
		cartDao.saveCart(cart);
		
		List<Cart> cartList = cartDao.listCart(userId);
		int cartItemSize = cartList.size();
		
		session.setAttribute("cartItemSize", cartItemSize);
		System.out.println("CARTSIZE" + cartList.size());
		
		ModelAndView modelAndView = new ModelAndView("redirect:/viewProds/{productId}");
		modelAndView.addObject("product", product);
		modelAndView.addObject("cartList", cartList);
		//modelAndView.addObject("TotalRs", cartDao.getTotalRs(userId));
		return modelAndView;
	}
	
	
	
	
	@RequestMapping(value = "viewProds/buyNow/{productId}")
	public ModelAndView buyNow(@PathVariable(value="productId") int productId,
			@ModelAttribute("cart") Cart cart,
			@ModelAttribute("product") Product product) {
		product = productDao.getProduct(productId);
		String userId = session.getAttribute("user").toString();
		cart.setUserId(userId);
		cart.setPrice(product.getPrice());
		cart.setProductName(product.getProductName());
		cart.setQuantity(1);
		cart.setStatus('N');
		
		cartDao.saveCart(cart);
		
		List<Cart> cartList = cartDao.listCart(userId);
		int cartItemSize = cartList.size();
		
		session.setAttribute("cartItemSize", cartItemSize);
		System.out.println("CARTSIZE" + cartList.size());
		
		ModelAndView modelAndView = new ModelAndView("user/cart");
		modelAndView.addObject("product", product);
		modelAndView.addObject("cartList", cartList);
		modelAndView.addObject("TotalRs", cartDao.getTotalRs(userId));
		return modelAndView;
	}
	
	
	@RequestMapping(value = {"viewCartItems","viewProds/viewCartItems"})
	public ModelAndView goToCartItems() {
		
		String userId = session.getAttribute("user").toString();
		List<Cart> cartList = cartDao.listCart(userId);
		int cartItemSize = cartList.size();
		session.setAttribute("cartItemSize", cartItemSize);
		System.out.println("CARTSIZE" + cartList.size());
		
		ModelAndView modelAndView = new ModelAndView("user/cart");
		modelAndView.addObject("product", product);
		modelAndView.addObject("cartList", cartList);
		modelAndView.addObject("TotalRs", cartDao.getTotalRs(userId));
		return modelAndView;
	}
	/*@RequestMapping(value = "checkout")
	public ModelAndView goToBillingAddress(@ModelAttribute("billingAddress") BillingAddress billingAddress) {
		ModelAndView modelAndView = new ModelAndView("user/billingAddress");
		return modelAndView;
	}*/
	@RequestMapping(value = "/cart/delete/{cartId}")
	public ModelAndView deleteCartItem(@PathVariable(value="cartId") int cartId,@ModelAttribute("cart") Cart cart,
			@ModelAttribute("product") Product product) {
		//String userId = session.getAttribute("user").toString();
		//cartDao.getCartbyId(userId, cartId);
		cartDao.deleteCart(cartId);
		
		ModelAndView modelAndView = new ModelAndView("redirect:/viewCartItems");
		modelAndView.addObject("product", product);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/viewProds/checkout")
	public ModelAndView goToBillingAddress(@ModelAttribute("billingAddress") BillingAddress billingAddress) {
		ModelAndView modelAndView = new ModelAndView("redirect:/checkout");
		return modelAndView;
	}
	/*@RequestMapping(value = "/viewProds/buyNow")
	public ModelAndView goToBillingAddres(@ModelAttribute("billingAddress") BillingAddress billingAddress) {
		ModelAndView modelAndView = new ModelAndView("redirect:/checkout");
		return modelAndView;
	}*/
	
	
}

