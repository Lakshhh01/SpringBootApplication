package com.laksh.SpringBootwithMysqlDatabase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Integer>{
	
	public Seller findTshirtById(int id);

}
