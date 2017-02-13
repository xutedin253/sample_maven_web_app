import objects.*;

class MessageSpec extends spock.lang.Specification  {
  def "message accepts string"() {
    given:
    def message = Mock(Message)
    1 * message.setMessage("Hello Fred") >> null
    1 * message.getMessage() >> "Hello Fred"

    when: "set text of the message"
    message.setMessage("Hello Fred")

    then: "expect text of the message"
    message.getMessage() == "Hello Fred"

  }
}

