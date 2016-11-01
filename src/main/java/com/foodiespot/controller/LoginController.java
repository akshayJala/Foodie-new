package com.foodiespot.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.foodiespot.dao.CartDao;
import com.foodiespot.dao.CategoryDao;
import com.foodiespot.dao.ProductDao;
import com.foodiespot.dao.SupplierDao;
import com.foodiespot.dao.UserDetailsDao;
import com.foodiespot.model.Cart;
import com.foodiespot.model.Category;
import com.foodiespot.model.Product;
import com.foodiespot.model.Supplier;
import com.foodiespot.model.UserDetails;

@Controller
public class LoginController {

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

	@RequestMapping(value = "/") // , method=RequestMethod.GET)
	public String showlanding(ModelMap modalmap) {
		List<Product> productList = productDao.getAllProduct();
		List<Category> categoryList = categoryDao.CategoryList();
		List<Supplier> supplierList = supplierDao.SupplierList();
		//Following code will pull categoryNames and category wise products from database
		List<List> productByCategoryList = new ArrayList(new ArrayList<Product>(5));
		String[] categoryNameList = new String[categoryList.size()];
		for (int i = 0; i < categoryList.size(); i++) {
			categoryNameList[i] = categoryDao.getCategory(categoryDao.getCategory(i + 1).getCategoryId())
					.getCategoryName();
			List<Product> productsFromCategoryId = productDao.getProductsByCategoryId(i + 1);
			productByCategoryList.add(productsFromCategoryId);
			System.out.println("categoryNameList " + categoryNameList[i]);

		}

		
		modalmap.addAttribute("productByCategoryList", productByCategoryList);
		modalmap.addAttribute("categoryNameList", categoryNameList);

		System.out.println("productsFromCategoryId " + productByCategoryList.size());

		modalmap.addAttribute("ProductList", productList);
		modalmap.addAttribute("CategoryList", categoryList);
		modalmap.addAttribute("SupplierList", supplierList);
		modalmap.addAttribute("isProductClicked", true);
		modalmap.addAttribute("isCategoryClicked", true);
		modalmap.addAttribute("isSupplierClicked", true);
		return "index";
	}

	@RequestMapping(value = "/index") // , method=RequestMethod.GET)
	public String showindex(ModelMap modalmap, Principal principal, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String name = principal.getName();
		// UserDetailsDao.getUserDetails(name);
		logger.info("UserID " + name);

		session.setAttribute("user", name);
		
		
		List<Product> productList = productDao.getAllProduct();
		List<Category> categoryList = categoryDao.CategoryList();
		List<Supplier> supplierList = supplierDao.SupplierList();

		List<List> productByCategoryList = new ArrayList(new ArrayList<Product>(5));
		String[] categoryNameList = new String[categoryList.size()];
		for (int i = 0; i < categoryList.size(); i++) {
			categoryNameList[i] = categoryDao.getCategory(categoryDao.getCategory(i + 1).getCategoryId())
					.getCategoryName();
			List<Product> productsFromCategoryId = productDao.getProductsByCategoryId(i + 1);
			productByCategoryList.add(productsFromCategoryId);
			System.out.println("categoryNameList " + categoryNameList[i]);

		}
		modalmap.addAttribute("productByCategoryList", productByCategoryList);
		modalmap.addAttribute("categoryNameList", categoryNameList);
		
		
		List<Cart> cartList = cartDao.listCart(name);
		int cartItemSize = cartList.size();
		
		session.setAttribute("cartItemSize", cartItemSize);
		session.setAttribute("productByCategoryList", productByCategoryList);
		session.setAttribute("categoryNameList", categoryNameList);
		
		modalmap.addAttribute("ProductList", productList);
		modalmap.addAttribute("CategoryList", categoryList);
		modalmap.addAttribute("SupplierList", supplierList);
		modalmap.addAttribute("isProductClicked", true);
		modalmap.addAttribute("isCategoryClicked", true);
		modalmap.addAttribute("isSupplierClicked", true);
		return "index";
	}

	@RequestMapping(value = "/user/index") // , method=RequestMethod.GET)
	public String showindexforUser() {
		return "index";
	}

	@RequestMapping(value = "/admin/index") // , method=RequestMethod.GET)
	public String showindexforAdmin() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin() {
		return "Login";
	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String showLoginAgain() {
		return "Unsuccess";
	}

	@RequestMapping(value = "/ContactUs", method = RequestMethod.GET)
	public String showContactUs() {
		return "ContactUs";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView GoToHome(@RequestParam String name, @RequestParam String password, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Login (GoToHome method) begins ! ");
		HttpSession session = request.getSession();
		userDetails = userDetailsDao.isValidUser(name, password);

		ModelAndView mv = null;
		if (userDetails == null) {
			mv = new ModelAndView("Login");
			mv.addObject("errorMessage", "Invalid Credential , Please enter correct user name and password!");
		} else {
			if (userDetails.getRoleId().equals("ROLE_ADMIN")) {
				mv = new ModelAndView("redirect:/admin/addProduct");
				String fullName = userDetails.getFullName();
				String RoleId = userDetails.getRoleId();
				session.setAttribute("user", fullName);
				session.setAttribute("RoleId", RoleId);
				List<Product> productList = productDao.getAllProduct();
				List<Category> categoryList = categoryDao.CategoryList();
				List<Supplier> supplierList = supplierDao.SupplierList();
				mv.addObject("ProductList", productList);
				mv.addObject("CategoryList", categoryList);
				mv.addObject("SupplierList", supplierList);
			} else if (userDetails.getRoleId().equals("ROLE_USER")) {
				mv = new ModelAndView("redirect:/user/index");
				String fullName = userDetails.getFullName();
				String RoleId = userDetails.getRoleId();
				session.setAttribute("user", fullName);
				session.setAttribute("RoleId", RoleId);
				session.setAttribute("userId", userDetails.getUserId());
			}
		}
		logger.info("Login (GoToHome method) Ends here! ");
		return mv;

	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public ModelAndView addproduct() {
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/addCategory");
		List<Product> productList = productDao.getAllProduct();
		modelAndView.addObject("ProductList", productList);

		return modelAndView;
	}

	@RequestMapping(value = "/addSupplier", method = RequestMethod.GET)
	public ModelAndView addproduc() {
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/addSupplier");
		List<Product> productList = productDao.getAllProduct();
		modelAndView.addObject("ProductList", productList);

		return modelAndView;
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView addproducs() {
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/addProduct");
		List<Product> productList = productDao.getAllProduct();
		modelAndView.addObject("ProductList", productList);

		return modelAndView;
	}

	@RequestMapping(value = "/logout")
	public String goToindex(HttpServletRequest request, HttpServletResponse response) {
		logger.info("User LogOut (GoToIndex method) begins here! ");
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		session.invalidate();
		logger.info("User LogOut (GoToIndex method) Ends here! ");
		return "index";
	}

	@RequestMapping(value = "admin/logout")
	public ModelAndView goToindexs(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Admin LogOut (GoToIndexs method) begins here! ");
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("redirect:/logout");
		session.setAttribute("user", null);
		session.invalidate();
		logger.info("Admin LogOut (GoToIndexs method) Ends here! ");
		return mv;
	}

	@RequestMapping(value = "user/logout")
	public ModelAndView goToindexsuser(HttpServletRequest request, HttpServletResponse response) {
		logger.info("User LogOut (GoToIndexsuser method) begins here! ");
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("redirect:/logout");
		session.setAttribute("user", null);
		session.invalidate();
		logger.info("User LogOut (GoToIndexs method) Ends here! ");
		return mv;
	}
	
	/*====================================================================*/
	/*
	@RequestMapping(value = "viewProds/{productId}", method = RequestMethod.GET)
	public ModelAndView viewProduct(@PathVariable int productId) {
		product = productDao.getProduct(productId);
		ModelAndView modelAndView = new ModelAndView("user/viewProdDetails");
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	
	@RequestMapping(value = "viewProds/buyNow")
	public ModelAndView goToBilling(@ModelAttribute("billingAddress") BillingAddress billingAddress) {
		
		
		ModelAndView modelAndView = new ModelAndView("user/billingAddress");
		modelAndView.addObject("product", product);
		
		return modelAndView;
	}
	

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
	
	//This method invokes when logged in user add a product to cart
	@RequestMapping(value = "viewProds/buyNow/{productId}")
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
	
	// this method starts when user clicks on cart icon on header
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
	@RequestMapping(value = "checkout")
	public ModelAndView goToBillingAddress(@ModelAttribute("billingAddress") BillingAddress billingAddress) {
		ModelAndView modelAndView = new ModelAndView("user/billingAddress");
		return modelAndView;
	} 
	
	//Responsible for deleting the cart item
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
	*/
}

