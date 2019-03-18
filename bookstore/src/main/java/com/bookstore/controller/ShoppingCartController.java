package com.bookstore.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cnb.domain.CartItem;
import com.cnb.domain.CnbUser;
import com.cnb.domain.ItemSku;
import com.cnb.domain.ShoppingCart;
import com.cnb.service.CartItemService;
import com.cnb.service.ItemSkuService;
import com.cnb.service.ShoppingCartService;
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
//		ShoppingCart shoppingCart = user.getShoppingCart();
		ShoppingCart shoppingCart = new ShoppingCart();
		
		List<CartItem> cartItemList = cartItemService.findListOfCartFromShoppingCart();
		
		if(cartItemList == null) {
			return "index";
		}
		//TODO remove the print block
				System.out.println("[DEBUG] : In ShoppingCartController");
				for(CartItem cartI : cartItemList) {
					System.out.println("[DEBUG] : master sku : " + cartI.getItemSku().getMasterSKU());
//					System.out.println("[DEBUG] : quantity : " + cartI.getQty());
//					System.out.println("[DEBUG] : shopping cart list : " + cartI.getShoppingCart().getCartItemList());
//					System.out.println("[DEBUG] : shopping cart list : " + cartI.getShoppingCart().getId());
				}
		
		shoppingCartService.updateShoppingCart(shoppingCart, cartItemList);
		
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart", shoppingCart);
		
		return "cnbShoppingCart";
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
		
		cartItemService.addItemSkuToCartItem(itemSku, user, Integer.parseInt(qty));
		model.addAttribute("addItemSkuSuccess", true);
		
		return "forward:/itemSkuDetail?id=" + itemSku.getMasterSKU();
	}	
	
	@RequestMapping("/updateCartItem")
	public String updateShoppingCart(
			@ModelAttribute("id") Long cartItemId,
			@ModelAttribute("qty") int qty
			) {
		CartItem cartItem = cartItemService.findById(cartItemId);
		cartItem.setQty(qty);
		cartItemService.updateCartItem(cartItem, cartItem.getShoppingCart());
		
		return "forward:/shoppingCart/cart";
	}
	
	@RequestMapping("/removeItem")
	public String removeItem(@RequestParam("id") Long id) {
		cartItemService.removeCartItem(cartItemService.findById(id));
		
		return "forward:/shoppingCart/cart";
	}
}
