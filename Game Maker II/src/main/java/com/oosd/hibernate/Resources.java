package com.oosd.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table 
public class Resources {
	
	 @Id  
	    @GeneratedValue  
	    
	    private Integer resId;	
	 	private String type;
	 	@Column(name="image", columnDefinition="Blob")
	 	private byte[] image;

	    public Resources () {
	    	
	    }
	    public Resources(Integer resId, byte[] blob) {	    	
	    		this.resId = resId;
	    		this.image = blob;    	
	    }
	    	    
		public Integer getResId() {
			return resId;
		}

		public void setResId(Integer resId) {
			this.resId = resId;
		}

		public byte[] getImage() {
			return image;
		}

		public void setImage(byte[] imageData) {
			this.image = imageData;
		}
		
		public String getType() {
			return type;
		}
		
		public void setType(String type) {
			this.type = type;
		}	
		
}
