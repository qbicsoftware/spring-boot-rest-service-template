package life.qbic.springbootresttemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ProjectLibrary implements ProjectRepository {

  private final List<Project> availableProjects;

  ProjectLibrary() {
    this.availableProjects = new ArrayList<>();
  }

  @PostConstruct
  public void init() {
    availableProjects.add(new Project("QABCD", "Awesome project", "It is just about awesomeness"));
    availableProjects.add(new Project("QTEST", "Test project", "Just a test project"));
  }

  @Override
  public Optional<Project> findProject(String code) {
    return availableProjects.stream()
        .filter((Project project) -> project.getCode().equals(code) )
        .findAny();
  }
}
