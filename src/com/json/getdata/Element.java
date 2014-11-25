package com.json.getdata;

import java.util.List;

public class Element {
      public String id;
      public String name;
      public String email;
      public String address;
      public String gender;
      public Phone phone;

//      public List<Phone> phone;
      
      
      @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return id +"---" + name +"---" +email +"\n"
    			+address +"---" + gender + "---"+ phone ;
    }
      
}
