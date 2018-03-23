package com.lyj.service;


import java.util.List;

import com.lyj.model.Product;

/*
 * 商品管理的业务层接口
 */
public interface ProductService {
	List<Product> findAll();//获取所有商品信息
	Product show(int pid);//展示商品信息
	List<Product> findUnsoldForBuyer();//查询未购买商品
	List<Product> account();//查询账单（已购买商品）
	void buy(int pid);//购买某商品
	Product findById(int pid);//卖家编辑商品信息前需要找到该商品，将商品信息传到jsp
	void update(Product product);//更新商品信息
	int add(Product product);//卖家发布商品信息
	void delete(int pid);//删除某条商品
	void putCart(int pid);//添加购物车
	List<Product> findCart();//查找购物车商品
	void buyCart(List<Product> list);//购买购物车商品
}
