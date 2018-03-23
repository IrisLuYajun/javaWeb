package com.lyj.action;
import com.lyj.model.User;
import com.lyj.service.ProductService;
import com.lyj.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * �û���Action��
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//ģ����������
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	//ע��ҵ�����
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
	 * ��¼ִ�еķ���
	 * @return
	 */
	public String login() {
		System.out.println("Action�е�loginִ����....");
		//if(employee.getUsername() == null){
			//this.addActionError("�������û���������");
			//return "filure";
		//}
		//����ҵ������
		User existUser = userService.login(user);
	
		if(existUser == null) {
			//������
			this.addActionError("�û������������!");
			return "filure";
			
		}else{//����
			
			//�����󱣴浽session��ȥ��existUser�Ǹ��û������ƣ���ȡ��ʱ��ҲҪ�������ƴ���get����
			ActionContext.getContext().getSession().put("existUser", existUser);
			ActionContext.getContext().getSession().put("username", existUser.getUsername());
			System.out.println("�����û���session�ˣ�");
			if(existUser == null)
				return "filure";
			else
				return "success";
			
		}
		
		
		
	}
		
}
