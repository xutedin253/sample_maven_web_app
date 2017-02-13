
import data.*;
import objects.*;
import spock.lang.IgnoreIf

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

@IgnoreIf({Model.singleton().getDBConnURL() == null})
class ModelSpec extends spock.lang.Specification {
  def "modelspec.newUser"() {
    given:
    def usr = new User();
    def userid = 0
    usr.setName("Jake Smith")
    usr.setAge(42)
    System.setProperty "DBCONN", "jdbc:postgresql://"
    //System.setProperty "DBCONN", "jdbc:postgresql://ec2-54-235-204-221.compute-1.amazonaws.com:5432/d19m0j1erhvr7v?user=wxojhmodfpbmsv&password=80cfef5defecd78ff44e5e2bab48a26b06f930d1f57e097a6be957be98358c53&sslmode=require"
    
    when: "test create of new user"
    Model.singleton().getDBConnURL() != null
    userid = Model.singleton().newUser(usr)

    then: "check new user id"
    userid > 0
    notThrown(SQLException)
    Model.singleton().deleteUser(userid)  
  }
}

