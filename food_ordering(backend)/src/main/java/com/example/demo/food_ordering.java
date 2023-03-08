package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="food_ordering")

public class food_ordering {
@Id

@Column(name="restaurant")

private String restaurant;

@Column(name="maincourse")

private String mainCourse;

@Column(name="sideDish")

private String sideDish;

@Column(name="quantity")

private int quantity;

@Column(name="discount")

private int discount;

@Column(name="total")

private int total;

@Column(name="rating")

private int rating;

public food_ordering() {
	
}

public food_ordering(String restaurant,String mainCourse,String sideDish,
		int quantity,int discount,int total,int rating) {
	super();
	this.restaurant=restaurant;
	this.mainCourse=mainCourse;
	this.sideDish=sideDish;
	this.quantity=quantity;
	this.discount=discount;
	this.total=total;
	this.rating=rating;
	
}

public String getRestaurant() {

return restaurant;

}

public void setRestaurant(String restaurant) {

this.restaurant=restaurant;

}

public String getmainCourse() {

return mainCourse;

}

public void setmaincourse(String mainCourse) {

this.mainCourse=mainCourse;

}
public String getsideDish() {
	return sideDish;
}
public void setsideDish(String sideDish) {
	this.sideDish=sideDish;
}

public int getquantity() {

return quantity;

}

public void setquantity(int quantity) {

this.quantity=quantity;

}

public int getdiscount() {

return discount;

}

public void setdiscount(int discount) {

this.discount=discount;

}

public int gettotal() {

return total;

}

public void settotal(int total) {

this.total=total;

}

public int getrating() {

return rating;

}

public void setrating(int rating) {

this.rating=rating;;

}
}