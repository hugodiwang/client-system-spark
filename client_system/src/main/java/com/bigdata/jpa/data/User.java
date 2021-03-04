package com.bigdata.jpa.data;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data; // to work we need to plugin lom
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//import java package in pom.xml with data decorator so we do not need to write get/set
@Data
@Document(collection = "user") // write the name of the collection
public class User implements java.io.Serializable{
  private static final long serialVersionUID = 1L;

  @Field("id") // mapping collection's id to user'id
  private int id;

  @Field("name")
  private String name;

  @Field("address")
  private String address;

}
