package com.laksh.SpringBootwithMysqlDatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//service layer//

@RestController
public class DataController {
	@Autowired
	TshirtRepository repo;			//interface ka reference
	
	@Autowired
	SellerRepository lrepo;
	
	@Autowired
	DataCollision datacollisionref;
	
//---------------------All entries---------------------------//
	
//	@RequestMapping("/DataIntakeFromUser")
	@GetMapping("/Tshirt")
	public List<Tshirt> getAllTshirtsData(){
		
		//internally-> select* from Tshirt;
		 List<Tshirt> data= repo.findAll();
		 return data;
		 
		 
	}
	
////--------------------------ByBrand----------------------------------//
	
	@GetMapping("/Tshirt/{brand}/brand")
	public List<Tshirt> getTshirtByBrand(@PathVariable(name="brand") String brandName){
		//select* from Tshirt where Brand="Nike";
		 List<Tshirt> data= repo.findByBrand("Nike");
		 return data;
		 
		 
	}
////-----------------------------Brand + Price------------------------------------//

	
	///ISKO KAISE KARU??--??DOUBT
	@GetMapping("/DataByBrandAndPrice")
	public List<Tshirt> getTshirtByBrandAndPrice(){
		
		 List<Tshirt> data= repo.findByBrandAndPrice("Max",500);
		 return data;
		 
		 
	}

//----------------------------Between Price range----------------------------//
	
	@GetMapping("/Tshirt/{DataByIdBetween}/DataByIdBetween")
	public List<Tshirt> getTshirtsByIdBetween(){
		
		 List<Tshirt> data= repo.findByIdBetween(100,106);
		 return data;
		 
		 
	}
//--------------------------For brandNames containing substrings------------------------------------------//
	
	@GetMapping("/Tshirt/{DataByBrandNamesCotaining}/DataByBrandNamesContaining")
	public List<Tshirt> getTshirtByBrandContaining(){
	
		List<Tshirt> data= repo.findByBrandContaining("le");
		return data;
		 
	}
//---------------------------for Brands Ending with-------------------------------------------//
	
	@GetMapping("/Tshirt/{DataByBrandNameEndingWith}/DataByBrandNameEndingWith")
	public List<Tshirt> getTshirtsByBrandEndingWith(){
		
		 List<Tshirt> data= repo.findByBrandEndingWith("er");
		 return data;
		 
		 
	}
	
	
	/* API's generated for clients->to connect with these methods
	 * jiske pas url h ,, wo client hai!!->client may be html, c, c++(http/Nonhttp)
	 *  http://localhost:8083/Data
		http://localhost:8083/DataByBrand
		http://localhost:8083/DataByIdBetween
		http://localhost:8083/DataByBrandNamesCotaining
		http://localhost:8083/DataByBrandNameEndingWith


	 */
	
//////////////////////Customised column Retreival////////////////////
	@GetMapping("/Tshirt/searchByColumnBrand")
	public List<Object[]> getColumnByBrands(){
		
		List<Object[]> data = repo.searchAllBrands();
		return data;
	}
	
	@GetMapping("/Tshirt/searchByColumnBrandAndPrice")
	public List<Object[]> getColumnByBrandsAndPrice(){
		
		List<Object[]> data = repo.searchAllBrandsAndPric();
		return data;
	}
	
	@GetMapping("/Tshirt/{price}/price")
	public List<Object[]> getColumnByPrice(@PathVariable(name="price") double price){
		
		List<Object[]> data = repo.searchUsingPrice(price);
		return data;
	}
	
	@GetMapping("/Tshirt/{brand}/FindSellerByBrand")
	public List<String> allsellers(@PathVariable(name="brand")String brand){
		return datacollisionref.allTshirts(brand);
	}
	
	
}
