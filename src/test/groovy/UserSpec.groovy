import objects.*;

class UserSpec extends spock.lang.Specification  {
  def "user accepts name"() {
    given:
    def user = new User();

    when: "set name of the user"
    user.setName("Fred")

    then: "expect name of the user"
    user.getName() == "Fred"
  }

  def "user accepts age"() {
    given:
    def user = new User();

    when: "set age of the user"
    user.setAge(33)

    then: "expect age of the user"
    user.getAge() == 33
  }

  
}
