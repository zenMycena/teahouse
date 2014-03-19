package com.mycena.data;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Long>{

	List<Orders> findByUid(UUID uid);
}
