package life.qbic.springbootresttemplate;

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
    System.out.printf("Incoming request for id: %s", projectCode);
    return new ResponseEntity<>("Worked", HttpStatus.OK);
  }

}
