package com.foodiespot.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
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
@RequestMapping(value = "/admin")
public class AdminController implements ServletContextAware {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
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

	private ServletContext servletContext;

	
	@ModelAttribute("Product")
	public Product myProduct() {
		return new Product();
	}
/*=======ADMIN Product-CRUD==============================================*/

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView goToAddProduct() {
		logger.info(" Admin-AddProduct (goToAddProduct GET method) begins here! ");
		List<Product> productList = productDao.getAllProduct();
		List<Category> categorylist = categoryDao.CategoryList();
		List<Supplier> supplierlist = supplierDao.SupplierList();

		ModelAndView mav = new ModelAndView("/admin/Products");

		boolean isProductClicked = true;
		mav.addObject("isProductClicked", isProductClicked);
		
		mav.addObject("categorylist", categorylist);
		mav.addObject("ProductList", productList);
		mav.addObject("supplierlist", supplierlist);
		Product product = new Product();
		mav.addObject("Product", product);
		logger.info(" Admin-AddProduct (goToAddProduct GET method) ends here! ");
		return mav;
	}
	/*@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String storeItem(ModelMap model,@RequestParam("file") MultipartFile file,@ModelAttribute("foodie") Product p,BindingResult result){
		// Binding Result is used if the form that has any error then it will
		// redirect to the same page without performing any functions
		if (result.hasErrors())
			return "/addProduct";
		System.out.println("hi "+p.getProductId());
		//productDao.addProduct(p);
		MultipartFile image = product.getImage();
		String fileName=null;
		try {
	        fileName = file.getOriginalFilename();
	        byte[] bytes = file.getBytes();
	        BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File("E:/DevOps/foodie/src/main/webapp/WEB-INF/resources/images/item" + fileName)));
	        buffStream.write(bytes);
	        buffStream.close();
	       // error= "You have successfully uploaded " + fileName;
	        System.out.println("---------->");
	    
		File oldName = new File("E:/DevOps/foodiespot/src/main/webapp/WEB-INF/resources/images/item" + fileName);
	    File newName = new File("E:/DevOps/foodiespot/src/main/webapp/WEB-INF/resources/images/item" + product.getProductId()+fileName.substring(fileName.indexOf(".")));
	    System.out.println("new file name:--------------->"+newName);
	    if(oldName.renameTo(newName)) {
	       System.out.println(p.getProductId());
	      // error=p.getName()+" added Successfully !";
	       System.out.println("uploaded");
	    } 
		} catch (Exception e) {
	    	//error="You failed to upload " + fileName + ": " + e.getMessage();
	    	System.out.println("failed");
	    }
	    return "redirect:/addProduct";
	}*/
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView ForAddingProducts(@Valid @ModelAttribute("foodiespot") Product product,BindingResult result ,
			@RequestParam("category") String category, @RequestParam("supplier" ) String supplier, 
			@RequestParam("image") MultipartFile image) {
		logger.info(" Admin-AddProduct (goToAddProduct POST method) begins here! ");
System.out.println("connect..");
product.setSupplier(supplierDao.getSupplierByName(supplier));
product.setCategory(categoryDao.getCategoryByName(category));
System.out.println("connect1..");
productDao.addProduct(product);
System.out.println("connect2..");

		if (!image.isEmpty()) {
			try {
				validateImage(image);
				System.out.println("connect3..");
			} catch (RuntimeException re) {
				System.out.println("connect4..");
				result.reject(re.getMessage());
				ModelAndView modelAndView = new ModelAndView("redirect:/admin/addProduct");
				return modelAndView;
			}

			try {
				System.out.println("connect5..");
				saveImage(product.getProductId() + ".jpeg", image);
				System.out.println("connect6..");
			} catch (IOException e) {
				System.out.println("connect7..");
				result.reject(e.getMessage());
				System.out.println("connect8..");
				ModelAndView modelAndView = new ModelAndView("redirect:/admin/addProduct");
				return modelAndView;
			}
		}
		System.out.println("connect9..");
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/addProduct");
		logger.info(" Admin-AddProduct (goToAddProduct POST method) ends here! ");

		return modelAndView;
	}

	@RequestMapping(value = "/edit/{Id}", method = RequestMethod.POST)
	public ModelAndView updation(@PathVariable("Id") int productId, @RequestParam(value = "productName") String productName,
		@RequestParam(value = "quantity") int quantity,@RequestParam(value = "price") float price,@RequestParam(value = "description") String description,
		@RequestParam(value = "category") String category1, @RequestParam(value = "supplier") String supplier1) { //
		logger.info(" Admin-EditProduct (Updation method) begins here with product name "+ product.getProductName());
		
		Product product1 = productDao.getProduct(productId) ;
		product1.setSupplier(supplierDao.getSupplierByName(supplier1));
		product1.setCategory(categoryDao.getCategoryByName(category1));
		product1.setPrice(price);
		product1.setDescription(description);
		product1.setProductName(productName);
		product1.setQuantity(quantity);
	
		productDao.editProduct(product1);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/addProduct");
		
		logger.info(" Admin-EditProduct (Updation method) ends here! ");
		return modelAndView;
	}

	@RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
	public ModelAndView deleteproduct(@PathVariable int productId) {
		logger.info(" Admin-DeleteProduct (deleteproduct method) begins here! ");
		productDao.deleteProduct(productId);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/addProduct");
		List<Product> productList = productDao.getAllProduct();
		modelAndView.addObject("ProductList", productList);
		logger.info(" Admin-DeleteProduct (deleteproduct method) ends here! ");
		return modelAndView;
	}

	
	 /*=================Admin-Category-CRUD========================*/
	

	@RequestMapping(value = "/Categories")
	public ModelAndView Categories() {
		logger.info(" Admin-Categories (Categories method) begins here! ");
		List<Category> categoryList = categoryDao.CategoryList();
		ModelAndView mav = new ModelAndView("admin/Categories");
		mav.addObject("Category", category);
		mav.addObject("CategoryList", categoryList);
		logger.info(" Admin-Categories (Categories method) ends here! ");
		return mav;
	}

	@RequestMapping(value = "/addCategory")
	public ModelAndView goToAddCategory() {
		logger.info(" Admin-AddCategory (goToAddCategory method) begins here! ");
		List<Category> categoryList = categoryDao.CategoryList();
		ModelAndView mav = new ModelAndView("admin/Categories");
		boolean isCategoryClicked = true;
		mav.addObject("isCategoryClicked", isCategoryClicked);
		mav.addObject("CategoryList", categoryList);
		mav.addObject("Category", category);
		logger.info(" Admin-AddCategory (goToAddCategory method) ends here! ");
		return mav;
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public ModelAndView ForAddingCategory(@ModelAttribute("Category") Category category, BindingResult result) {
		logger.info(" Admin-AddCategory (forAddingCategory - POST method) begins here! ");
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/addCategory");

		List<Category> categoryList = categoryDao.CategoryList();
		if (result.hasErrors()) {
			return modelAndView;
		} else {
			categoryDao.saveCategory(category);

			modelAndView.addObject("CategoryList", categoryList);
			logger.info(" Admin-AddCategory (forAddingCategory - POST method) ends here! ");
			return modelAndView;
		}
		
	}

	@RequestMapping(value = "/editC/{categoryId}", method = RequestMethod.POST)
	public ModelAndView updationCategory(@PathVariable("categoryId") int categoryId,
			@ModelAttribute("category") Category category) { 
		logger.info(" Admin-EDITCategory (updationCategory - POST method) begins here! ");
		category.setCategoryId(categoryId);
		categoryDao.updateCategory(category);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/addCategory");
		logger.info(" Admin-EDITCategory (updationCategory - POST method) ends here! ");
		return modelAndView;
	}

	@RequestMapping(value = "/deleteC/{categoryId}", method = RequestMethod.GET)
	public ModelAndView deleteCategory(@PathVariable int categoryId) {
		logger.info(" Admin-DeleteCategory (deleteCategory - GET method) begins here! ");
		categoryDao.deleteCategory(categoryId);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/addCategory");
		List<Category> categoryList = categoryDao.CategoryList();
		modelAndView.addObject("CategoryList", categoryList);
		logger.info(" Admin-DeleteCategory (deleteCategory - GET method) ends here! ");
		return modelAndView;
	}

	
	/*===========================Admin-Supplier-CRUD================*/
	 

	@RequestMapping(value = "/Suppliers")
	public ModelAndView Suppliers() {
		logger.info(" Admin-Suppliers (Suppliers - GET method) begins here! ");
		List<Supplier> supplierList = supplierDao.SupplierList();
		ModelAndView mav = new ModelAndView("admin/Suppliers");
		mav.addObject("Supplier", supplier);
		mav.addObject("SupplierList", supplierList);
		logger.info(" Admin-Suppliers (Suppliers - GET method) ends here! ");
		return mav;
	}

	@RequestMapping(value = "/addSupplier")
	public ModelAndView goToAddSupplier() {
		logger.info(" Admin-goToAddSupplier (goToAddSupplier - GET method) begins here! ");
		List<Supplier> supplierList = supplierDao.SupplierList();
		ModelAndView mav = new ModelAndView("admin/Suppliers");
		boolean isSupplierClicked = true;
		mav.addObject("isSupplierClicked", isSupplierClicked);
		mav.addObject("Supplier", supplier);
		mav.addObject("SupplierList", supplierList);
		logger.info(" Admin-goToAddSupplier (goToAddSupplier - GET method) ends here! ");
		return mav;
	}

	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
	public ModelAndView ForAddingSupplier(@ModelAttribute("Supplier") Supplier supplier, BindingResult result) {
		logger.info(" Admin-ForAddingSupplier (ForAddingSupplier - POST method) begins here! ");
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/addSupplier");

		List<Supplier> supplierList = supplierDao.SupplierList();
		if (result.hasErrors()) {
			return modelAndView;
		} else {
			supplierDao.saveSupplier(supplier);
			modelAndView.addObject("SupplierList", supplierList);
			logger.info(" Admin-ForAddingSupplier (ForAddingSupplier - POST method) ends here! ");
			return modelAndView;
		}
	}

	@RequestMapping(value = "/editS/{supplierId}", method = RequestMethod.POST)
	public ModelAndView updationSupplier(@PathVariable("supplierId") int supplierId,
			@ModelAttribute("supplier") Supplier supplier) { 
		logger.info(" Admin-updationSupplier (updationSupplier - POST method) begins here! ");
		supplier.setSupplierId(supplierId);
		supplierDao.updateSupplier(supplier);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/addSupplier");
		logger.info(" Admin-updationSupplier (updationSupplier - POST method) ends here! ");
		return modelAndView;
	}

	@RequestMapping(value = "/deleteS/{supplierId}", method = RequestMethod.GET)
	public ModelAndView deleteSupplier(@PathVariable int supplierId) {
		logger.info(" Admin-deleteSupplier (deleteSupplier - GET method) begins here! ");
		supplierDao.deleteSupplier(supplierId);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/addSupplier");
		List<Supplier> supplierList = supplierDao.SupplierList();
		modelAndView.addObject("SupplierList", supplierList);
		logger.info(" Admin-deleteSupplier (deleteSupplier - GET method) ends here! ");
		return modelAndView;
	}
	
	/*======================Functions Regarding Image Uploading=========*/

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

	private void validateImage(MultipartFile image) {
System.out.println("connect10...");
		if (!image.getContentType().equals("image/jpeg")) {
			System.out.println("connect11...");
			throw new RuntimeException("Only JPG images are accepted");
		
		}
	}

	private void saveImage(String filename, MultipartFile image) throws RuntimeException, IOException {
		System.out.println("connect12...");
		try {
			System.out.println("connect13...");
			File file = new File(servletContext.getRealPath("/") + "/WEB-INF/resources/images/" + filename);
		
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			System.out.println("Go to the location:  " + file.toString()
					+ " on your computer and verify that the image has been stored.");
		} catch (IOException e) {
			throw e;
		}
	}


}

