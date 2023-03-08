package com.example.demo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.Optional;
@Service

public class foodService {

@Autowired

private foodRepo food;

public food_ordering saveDetails(food_ordering r) {

return food.save(r);

}

public List <food_ordering> getAllDetails(){
//	Pageable pageable= PageRequest.of(pageNo,pageSize);
//	Page<food_ordering> page=food.findAll(pageable);
//	List<food_ordering> products=page.getContent();
//	products.forEach((p) ->{
//		System.out.println(p.toString());
		
	
//	return products;
return food.findAll();
}

public Optional<food_ordering> getDetails(String restaurant){

return food.findById(restaurant);

}

public void deleteById(@PathVariable String restaurant) {

	food.deleteById(restaurant);

}

public food_ordering updateDetails(food_ordering r) {

return food.saveAndFlush(r);

}

public List<food_ordering> findFoodsWithSorting(String field) {
return food.findAll(Sort.by(Sort.Direction.ASC,field));
}
////native
//public List <food_ordering> findAllRestaurantWithFood(String mainCourse){
//	return food.findAllfoodNative(mainCourse);
//}

////Param
//public List <food_ordering> findAllRestaurantWithFood(String mainCourse){
//return food.findAllRestaurantWithFood(mainCourse);
//}

////JQL
//public List<food_ordering> getAllDetails() {
//	return food.findAll();
//}

////deletequery
//public int deleteQueryById(String sideDish) {
//
//return food.deletefoodBysideDish(sideDish);
//
//}


@Autowired
EntityManager entityManager;

//this -> current obj in a method or const
public food_ordering readEM(int total){
	Query q = this.entityManager.createQuery("SELECT f FROM food_ordering f where f.total= :total");
	q.setParameter("total",total);
	return (food_ordering) q.getSingleResult();
}

}