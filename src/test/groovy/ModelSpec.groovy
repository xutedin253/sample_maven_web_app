import data.*;
import objects.*;

class ModelSpec extends spock.lang.Specification {

  def userid = 0

  def "model.newUser"() {
    given:
    def user = new User();
    user.setName("Jake")
    user.setAge(42)
    System.setProperty "DBCONN", "jdbc:postgresql://ec2-54-235-204-221.compute-1.amazonaws.com:5432/d19m0j1erhvr7v?user=wxojhmodfpbmsv&password=80cfef5defecd78ff44e5e2bab48a26b06f930d1f57e097a6be957be98358c53&sslmode=require"
    
    when: "test create of new user"
    userid = Model.singleton().newUser(user)

    then: "check new user id"
    userid > 0
  }

  def "model.deleteUser"() {
    when:
    System.setProperty "DBCONN", "jdbc:postgresql://ec2-54-235-204-221.compute-1.amazonaws.com:5432/d19m0j1erhvr7v?user=wxojhmodfpbmsv&password=80cfef5defecd78ff44e5e2bab48a26b06f930d1f57e097a6be957be98358c53&sslmode=require"    

    then:
    Model.singleton().deleteUser(userid)  
  }

}