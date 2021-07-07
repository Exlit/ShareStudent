package first.repository;

import first.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Student, Integer> {

}
