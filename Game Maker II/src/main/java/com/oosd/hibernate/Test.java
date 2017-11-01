package com.oosd.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table 
public class Test {

	 @Id  
	    @GeneratedValue  
	    private Integer id;  
	      
	    private String test; 
	      
	    public Test() {}

		public Test(Integer id, String test) {
			this.id = id;
			this.test = test;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTest() {
			return test;
		}

		public void setTest(String test) {
			this.test = test;
		}
}
