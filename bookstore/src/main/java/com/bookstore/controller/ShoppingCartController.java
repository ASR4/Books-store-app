package com.bookstore.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.domain.ShoppingCart;
import com.bookstore.service.ShoppingCartService;
import com.cnb.domain.CartItem;
import com.cnb.domain.CnbUser;
import com.cnb.domain.ItemSku;
import com.cnb.service.CartItemService;
import com.cnb.service.ItemSkuService;
import com.cnb.service.TaskData;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private TaskData taskData;
	
	@Autowired
	private ItemSkuService itemSkuService;

	@RequestMapping("/cart")
	public String shoppingCart(Model model, Principal principal) {
		CnbUser user = taskData.getUser();
		ShoppingCart shoppingCart = user.getShoppingCart();
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		shoppingCartService.updateShoppingCart(shoppingCart);
		
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart", shoppingCart);
		
		return "shoppingCart";
	}

//	@RequestMapping("/addItem")
//	public String addItem(
//			@ModelAttribute("book") Book book,
//			@ModelAttribute("qty") String qty,
//			Model model, Principal principal
//			) {
//		User user = userService.findByUsername(principal.getName());
//		book = bookService.findOne(book.getId());
//		
//		if (Integer.parseInt(qty) > book.getInStockNumber()) {
//			model.addAttribute("notEnoughStock", true);
//			return "forward:/bookDetail?id="+book.getId();
//		}
//		
//		CartItem cartItem = cartItemService.addBookToCartItem(book, user, Integer.parseInt(qty));
//		model.addAttribute("addBookSuccess", true);
//		
//		return "forward:/bookDetail?id="+book.getId();
//	}
	
	//CNB
	@RequestMapping("/addItem")
	public String addItem(
			@ModelAttribute("itemSku") ItemSku itemSku,
			@ModelAttribute("qty") String qty,
			Model model, Principal principal
			) {
		CnbUser user = taskData.getUser();
		itemSku = itemSkuService.findOne(itemSku.getMasterSKU());
		
		if (Integer.parseInt(qty) > itemSku.getInventory()) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/itemSkuDetail?id=" + itemSku.getInventory();
		}
		
		CartItem cartItem = cartItemService.addItemSkuToCartItem(itemSku, user, Integer.parseInt(qty));
		model.addAttribute("addItemSkuSuccess", true);
		
		return "forward:/itemSkuDetail?id=" + itemSku.getInventory();
	}	
	
	@RequestMapping("/updateCartItem")
	public String updateShoppingCart(
			@ModelAttribute("id") Long cartItemId,
			@ModelAttribute("qty") int qty
			) {
		CartItem cartItem = cartItemService.findById(cartItemId);
		cartItem.setQty(qty);
		cartItemService.updateCartItem(cartItem);
		
		return "forward:/shoppingCart/cart";
	}
	
	@RequestMapping("/removeItem")
	public String removeItem(@RequestParam("id") Long id) {
		cartItemService.removeCartItem(cartItemService.findById(id));
		
		return "forward:/shoppingCart/cart";
	}
}
