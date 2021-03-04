import com.mongodb.DB;
import com.mongodb.Mongo;
import org.junit.Test;


import java.net.UnknownHostException;
import java.util.Set;

public class TestMongoDB {
  @Test
  public void testMongoDB()  {
    try {
      Mongo mongo = new Mongo("192.168.0.139", 27017);
      DB db = mongo.getDB("testdb");
      Set<String> collections =  db.getCollectionNames();
      for(String s : collections){
        System.out.println(s);
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }


  }
}
