package com.mycena.data;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderListRepository extends CrudRepository<OrderList, Long>{
	
	
	@Query(value="from OrderList where status = '3' ")
	List<OrderList> findByStatus();
	
	@Query(value="from OrderList where status < '3'")
	Iterable<OrderList> findUncompleteOrders();
	
	@Query(value="from OrderList where id > ?1 and status < '3'")
	Iterable<OrderList> findNewOrders(long id);
	
	@Query(value="from OrderList order by id desc")
	List<OrderList> findTopid();
	
	@Query(value="from OrderList where username = ?1 and status >= 0 and id = ?2")
	List<OrderList> findUserOrder(String username, long id);

	@Query(value="update OrderList  set status='2' where id = ?1")
	void changeStatusById(long id);
	
	@Query(value="update OrderList  set status='3' where id = ?1")
	void changeFinalStatusById(long id);
}
