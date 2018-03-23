package com.lyj.dao;

import java.util.List;

import com.lyj.model.Product;

public interface ProductDao {
	List<Product> findAll();//获取所有商品资料
	void update(Product product);//卖家更新商品信息
	Product show(int pid);//获取某个商品的信息
	List<Product> findUnsoldForBuyer();//查询未购买商品
	List<Product> account();//查询账单（已购买商品）
	void buy(int pid);//购买某商品
	Product findById(int pid);//根据ID查找某商品
	int add(Product product);//卖家发布商品
    void delete(int pid);//删除某商品
	void putCart(int pid);//添加购物车
	List<Product> findCart();//查找购物车商品
	void buyCart(List<Product> list);//购买购物车内商品
}
