package com.mycena.data;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderListRepository extends CrudRepository<OrderList, Long>{
	
	
	@Query(value="from OrderList where status = '完成' ")
	List<OrderList> findByStatus();
	
	@Query(value="from OrderList where status <> '完成'")
	Iterable<OrderList> findUncompleteOrders();
	
	@Query(value="from OrderList where id > ?1 and status <> '完成'")
	Iterable<OrderList> findNewOrders(long id);
	
	@Query(value="from OrderList order by id desc")
	List<OrderList> findTopid();
	
	@Query(value="from OrderList where account = ?1 and uid = ?2")
	OrderList findUserOrder(String account, UUID uid);

	@Query(value="update OrderList  set status='準備中' where id = ?1")
	void changeStatusById(long id);
	
	@Query(value="update OrderList  set status='完成' where id = ?1")
	void changeFinalStatusById(long id);
	
	OrderList findByUid(UUID uid);
	
	List<OrderList> findByUsername(String username);
	
	List<OrderList> findByAccount(String account);
}
