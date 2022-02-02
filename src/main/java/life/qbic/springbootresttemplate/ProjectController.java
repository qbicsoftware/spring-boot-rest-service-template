package life.qbic.springbootresttemplate;

import java.util.Optional;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

  final
  ProjectRepository projectRepository;

  @Autowired
  public ProjectController(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
  public ResponseEntity<Object> getProject(@PathVariable("id") String projectCode) {
    System.out.printf("Incoming request for project id: %s", projectCode);
    Optional<Project> project = projectRepository.findProject(projectCode);
    return project
        .map(value -> new ResponseEntity<Object>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>("No project found for id " + projectCode,
            HttpStatus.NOT_FOUND));
  }
}
