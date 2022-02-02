package life.qbic.springbootresttemplate

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * <p>Tests written with Spock</p>
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjectControllerSpec extends Specification {

  def projectRepository = Stub(ProjectRepository)
  def projectController = new ProjectController(projectRepository)

  MockMvc mockMvc = MockMvcBuilders.standaloneSetup(projectController).build()


  def "when a non-existing project is requested, then the controller returns NOT_FOUND"() {
    given:
    projectRepository.findProject(_ as String) >> Optional.empty()
    when: "a non-existing project is requested"
    def response = mockMvc.perform(MockMvcRequestBuilders.get("/projects/{id}", "QSTTS")).andReturn().getResponse()
    then: "the controller returns NOT_FOUND"
    response.getStatus() == HttpStatus.NOT_FOUND.value()
  }

}
