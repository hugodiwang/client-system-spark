import com.bigdata.jpa.data.Person;
import com.bigdata.service.PersonService;
import com.bigdata.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
public class PersonTest {
  @Autowired
  PersonService personService;
  @Test
  public void runPerson(){
    //personService.insert();
    Person person = personService.findOne();
    System.out.println(person.getName());
  }
}
