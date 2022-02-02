package life.qbic.springbootresttemplate;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;
import javax.swing.text.html.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/** Tests written with JUnit5 */
@ExtendWith(MockitoExtension.class)
class ProjectControllerTest {

  @Mock private ProjectRepository projectRepository;

  @InjectMocks private ProjectController projectController;

  @Autowired private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
  }

  @Test
  void doSomething() throws Exception {
    when(projectRepository.findProject(any())).thenReturn(Optional.empty());
    mockMvc.perform(get("/projects/QSTTS")).andExpect(status().isNotFound());
  }
}
