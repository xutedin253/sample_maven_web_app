
import data.*;
import objects.*;
import spock.lang.IgnoreIf

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

@IgnoreIf({Model.singleton().getDBConnURL() == null})
class ModelSpec extends spock.lang.Specification {
  def "use persisted to database if connection available"() {
    given:
    def usr = new User();
    def userid = 0
    usr.setName("Jake Smith")
    usr.setAge(42)
    System.setProperty "DBCONN", "jdbc:postgresql://"
    
    when: "test create of new user"
    Model.singleton().getDBConnURL() != null
    userid = Model.singleton().newUser(usr)

    then: "check new user id"
    userid > 0
    notThrown(SQLException)
    Model.singleton().deleteUser(userid)  
  }
}

