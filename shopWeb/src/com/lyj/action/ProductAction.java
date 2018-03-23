package com.lyj.action;


import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lyj.model.Product;
import com.lyj.model.User;
import com.lyj.service.ProductService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	//模型驱动对象
	private Product product = new Product();
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//注入业务层类
	private ProductService productService;
	/*
	 * 查询
	 */
	public String findAll() {
		int uid = Integer.valueOf(ServletActionContext.getRequest().getParameter("uid"));
		List<Product> list = productService.findAll();
		ActionContext.getContext().getSession().put("allList", list);
		if(uid == 1){
			return "findAllForUser";
		}else if(uid == 2){
			return "findAllForUser";
		}else{
			return "findAll";
		}
		
		
	}
	
	/*
	 * 商品展示
	 */
	public String show(){
		System.out.println("pid="+ServletActionContext.getRequest().getParameter("pid"));
		int pid = Integer.valueOf(ServletActionContext.getRequest().getParameter("pid"));
		Product product = productService.show(pid);
		ActionContext.getContext().getSession().put("product", product);
		return "show";
	}
	/*
	 * 查询未购买商品
	 */
	public String findUnsoldForBuyer() {
		List<Product> list = productService.findUnsoldForBuyer();
		ActionContext.getContext().getSession().put("unsoldList", list);
		return "findUnsoldForBuyer";	
	}
	
	/*
	 * 查询账单（已购买商品）
	 */
	public String account() {
		List<Product> list = productService.account();
		double sum=0;//计算总价
		for(Product product:list){
			sum = sum+product.getPrice();
		}
		ActionContext.getContext().getSession().put("soldList", list);
		ActionContext.getContext().getSession().put("sum", sum);
		return "account";
	}
	/*
	 * 购买商品
	 */
	public String buyIt(){
		System.out.println("pid="+ServletActionContext.getRequest().getParameter("pid"));
		int pid = Integer.valueOf(ServletActionContext.getRequest().getParameter("pid"));
		productService.buy(pid);
		return "buy";
	}
	/*
	 * 卖家编辑商品信息
	 */
	public String edit() {
		int pid = Integer.valueOf(ServletActionContext.getRequest().getParameter("pid"));
		product = productService.findById( pid);
		return "edit";
	}
	/*
	 * 更新商品信息
	 */
	public String update() {
		//int pid = Integer.valueOf(ServletActionContext.getRequest().getParameter("pid"));
		productService.update(product);
		return "update";
	}
	/*
	 * 发布商品信息跳转
	 */
	public String add() {
		System.out.println("add执行了");
		int pid = productService.add(product);
		ActionContext.getContext().getSession().put("pid", pid);
		return "publicSuccess";
	}
	/*
	 * 卖家删除商品
	 */
	public String delete() {
		int pid = Integer.valueOf(ServletActionContext.getRequest().getParameter("pid"));
		productService.delete(pid);
		return "deleteSuccess";
	}
	/*
	 * 将商品加入购物车
	 */
	public String putCart(){
		int pid = Integer.valueOf(ServletActionContext.getRequest().getParameter("pid"));
		productService.putCart(pid);
		return "putCart";
	}
	/*
	 * 查找购物车商品
	 */
	public String findCart(){
		List<Product> list = productService.findCart();
		double sum=0;//计算总价
		for(Product product:list){
			sum = sum+product.getPrice();
		}
		ActionContext.getContext().getSession().put("cartList", list);
		ActionContext.getContext().getSession().put("sum", sum);
		return "findCart";
	}
	
	/*
	 * 购买购物车商品
	 */
	public String buyCart(){
		List<Product> list=null;
		if(ActionContext.getContext().getSession().containsKey("cartList") == true){
			list = (List<Product>) ActionContext.getContext().getSession().get("cartList");
			productService.buyCart(list);
			return "buyCartSuccess";
		}else{
			
			return "buyCartFailure";
		}
		//System.out.println("list长度="+list.size());
		
		
	}
	
}
