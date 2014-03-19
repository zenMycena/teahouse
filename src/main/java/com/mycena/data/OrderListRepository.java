package com.mycena.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderListRepository extends CrudRepository<OrderList, Long>{
	List<OrderList> findByStatus(int status);
}
