package com.mycena.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long>{
	
	@Query("from Message where id > :id")
    List<MenuItem> findWithMaxOrder(long id);
	
	MenuItem findByName(String name); 

}
