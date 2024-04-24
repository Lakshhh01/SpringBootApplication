package com.laksh.SpringBootwithMysqlDatabase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class DataCollision {
	@Autowired
	TshirtRepository trepo;
	@Autowired
	SellerRepository srepo;
	
	public List<String> allTshirts(String name){
		List<String>  list= new ArrayList<>();
		
		//get listoftshirts by brand given//
		List<Tshirt> tshirtBrands =trepo.findByBrand(name);
		for(Tshirt  ref: tshirtBrands) {
			Integer tshirtId=ref.getId();
			Seller object=srepo.findTshirtById(tshirtId);
			list.add(object.sellerName);
			
			
		}
		return list;
		
	}

}
