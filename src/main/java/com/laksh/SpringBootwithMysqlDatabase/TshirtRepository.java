package com.laksh.SpringBootwithMysqlDatabase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


//Data Access layer//
public interface TshirtRepository extends JpaRepository<Tshirt, Integer>{

	
	
	/*
	 * IMPORTANT NOTE:->WHENEVER WE WANT TO PERFORM SQL QUERIES,, 
	 * WRITE YOUR MEHTOD NAMES(CAMEL CASE COMPULSARY) ACCORDING TO THAT QUERY,
	 * SO SPRINGBOOT RUN TIME PE METHOD IMPLEMENT KARLEGA
	 */
	//iska implementation kisne kiya??->DKDC
	//runtime pr sab body banegi and execution bhi R.T pr hi hoga//
	//SO ISKA BINA CODE LIKHE USE KAR SAKTE H//
	
	public List<Tshirt> findByBrand(String password);
	
	public List<Tshirt> findByBrandAndPrice(String Brand,double Price);
	
	public List<Tshirt> findByIdBetween(double minId,double maxId);
	
	/*
	// Add method to find T-shirts by ID between a range of values
    public List<Tshirt> findByIdGreaterThanEqualAndIdLessThanEqual(int minId, int maxId);
	 */
	
	public List<Tshirt> findByBrandContaining(String substring);
	
	public List<Tshirt> findByBrandEndingWith(String suffix);
	
	
	
	
////////////////////(projection)Customised Columns Query//////////////////////////
	
	@Query(value="select brand from Tshirt")			//-->yaha pr brand is avriable name from user ki konsa column chahiye, and Tshirt is classname//
	public List<Object[]> searchAllBrands();
	
	@Query(value="select brand,price from tshirt",nativeQuery = true)			//-->yaha pr brand is avriable name from user ki konsa column chahiye, and Tshirt is classname//
	public List<Object[]> searchAllBrandsAndPric();
	//native queries->ab , actual sql queries likh sakte ho
	//class aur varibale nahi likhne padege//
	
	
	
///////////////////////////using where clause/////////////////////////
	
	@Query(value="select brand,price from tshirt where price < ?1",nativeQuery = true)			//-->yaha pr brand is avriable name from user ki konsa column chahiye, and Tshirt is classname//
	public List<Object[]> searchUsingPrice(double price);

	
	
	public List<Tshirt> findByColour(String colorname);
	
}
