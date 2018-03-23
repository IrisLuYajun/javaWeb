package com.lyj.dao;

import java.util.List;

import com.lyj.model.Product;

public interface ProductDao {
	List<Product> findAll();//��ȡ������Ʒ����
	void update(Product product);//���Ҹ�����Ʒ��Ϣ
	Product show(int pid);//��ȡĳ����Ʒ����Ϣ
	List<Product> findUnsoldForBuyer();//��ѯδ������Ʒ
	List<Product> account();//��ѯ�˵����ѹ�����Ʒ��
	void buy(int pid);//����ĳ��Ʒ
	Product findById(int pid);//����ID����ĳ��Ʒ
	int add(Product product);//���ҷ�����Ʒ
    void delete(int pid);//ɾ��ĳ��Ʒ
	void putCart(int pid);//��ӹ��ﳵ
	List<Product> findCart();//���ҹ��ﳵ��Ʒ
	void buyCart(List<Product> list);//�����ﳵ����Ʒ
}
