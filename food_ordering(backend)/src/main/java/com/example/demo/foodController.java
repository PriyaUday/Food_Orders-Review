package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class foodController {

@Autowired

private foodService rs ;

@PostMapping("/addfood")

public String postDetails(@RequestBody food_ordering r)
{

	rs.saveDetails(r);

return "Value Added";}

@GetMapping("/getfood")

public List<food_ordering> getDetails(){

return rs.getAllDetails();

}

//@GetMapping("/getres/{restaurant}")
//
//public Optional<food_ordering> getbyId(@PathVariable("restaurant") String restaurant){
//	return rs.getDetails(restaurant);
//}

//Sort by field name
@GetMapping("/{field}")
private List<food_ordering> getFoodsWithSort(@PathVariable String field){
	List<food_ordering> allFoods = rs.findFoodsWithSorting(field);
	return allFoods;
}
////Native Query
//@GetMapping("/getdish/{mainCourse}")
//public List <food_ordering> findAllFood(@PathVariable("mainCourse") String mainCourse){
//	return rs.findAllRestaurantWithFood(mainCourse);
//}
////Param
//@GetMapping("/getmain/{mainCourse}")
//public List <food_ordering> findAllfood(@PathVariable("mainCourse") String mainCourse){
//return rs.findAllRestaurantWithFood(mainCourse);
//}

//JQL 
//@GetMapping("/getall")
//
//public List<food_ordering> findAllfood(){
//
//return rs.getAllDetails();
//}

@PutMapping("/upfood")

public String updatedet(@RequestBody food_ordering r){

	rs.updateDetails(r);
return "values updated";
}

@DeleteMapping("/delete/{restaurant}")
public String deleteById(@PathVariable String restaurant) {
	rs.deleteById(restaurant);
return "values deleted";
}

////deletequery
//@DeleteMapping("/deleteside/{sideDish}")
//public int deleteQById(@PathVariable("sideDish") String sideDish) {
//	 return rs.deleteQueryById(sideDish);
//	 //return "Deleted using Query!";
//}

//this -> current obj in a method or const//read
@GetMapping ("/readtotal/{total}")
private food_ordering read(@PathVariable int total){
return rs.readEM(total);
}

}