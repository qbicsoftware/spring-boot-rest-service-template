package life.qbic.springbootresttemplate;

import java.util.Optional;

public interface ProjectRepository {

  Optional<Project> findProject(String code) ;

}
