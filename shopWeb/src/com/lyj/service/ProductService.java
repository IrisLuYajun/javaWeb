package com.lyj.service;


import java.util.List;

import com.lyj.model.Product;

/*
 * ��Ʒ�����ҵ���ӿ�
 */
public interface ProductService {
	List<Product> findAll();//��ȡ������Ʒ��Ϣ
	Product show(int pid);//չʾ��Ʒ��Ϣ
	List<Product> findUnsoldForBuyer();//��ѯδ������Ʒ
	List<Product> account();//��ѯ�˵����ѹ�����Ʒ��
	void buy(int pid);//����ĳ��Ʒ
	Product findById(int pid);//���ұ༭��Ʒ��Ϣǰ��Ҫ�ҵ�����Ʒ������Ʒ��Ϣ����jsp
	void update(Product product);//������Ʒ��Ϣ
	int add(Product product);//���ҷ�����Ʒ��Ϣ
	void delete(int pid);//ɾ��ĳ����Ʒ
	void putCart(int pid);//��ӹ��ﳵ
	List<Product> findCart();//���ҹ��ﳵ��Ʒ
	void buyCart(List<Product> list);//�����ﳵ��Ʒ
}
