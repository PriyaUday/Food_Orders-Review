package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface foodRepo extends JpaRepository<food_ordering, String> {

	
////Native Query 
//@Query(
//		value="select * from food_ordering f where f.mainCourse =?1",
//		nativeQuery = true)
//List <food_ordering> findAllfoodNative(String mainCourse);
//***********
	

////Param
//@Query(
//		value="select * from food_ordering f where f.mainCourse= :activestate",
//nativeQuery=true)
//		List<food_ordering> findAllRestaurantWithFood(@Param("activestate") String mainCourse);
//**********
	
	
////JQL Query
//	    @Query("select f from food_ordering f")
//		List<food_ordering> findAllfood();	
//*********************

////deletequery
//@Transactional	
//@Modifying
//@Query ("delete from food_ordering f where f.sideDish=:sideDish")
//int deletefoodBysideDish(@Param("sideDish") String sideDish );
//}
}

