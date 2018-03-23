package com.lyj.action;
import com.lyj.model.User;
import com.lyj.service.ProductService;
import com.lyj.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 用户的Action类
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//模型驱动对象
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	//注入业务层类
	private UserService userService;
	private ProductService productService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	/*
	 * 登录执行的方法
	 * @return
	 */
	public String login() {
		System.out.println("Action中的login执行了....");
		//if(employee.getUsername() == null){
			//this.addActionError("请输入用户名或密码");
			//return "filure";
		//}
		//调用业务层的类
		User existUser = userService.login(user);
	
		if(existUser == null) {
			//不存在
			this.addActionError("用户名或密码错误!");
			return "filure";
			
		}else{//存在
			
			//将对象保存到session中去，existUser是该用户的名称，获取的时候也要将该名称传入get函数
			ActionContext.getContext().getSession().put("existUser", existUser);
			ActionContext.getContext().getSession().put("username", existUser.getUsername());
			System.out.println("保存用户到session了！");
			if(existUser == null)
				return "filure";
			else
				return "success";
			
		}
		
		
		
	}
		
}
