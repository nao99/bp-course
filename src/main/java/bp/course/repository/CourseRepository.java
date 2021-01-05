package bp.course.repository;

import bp.course.model.Course;
import org.springframework.data.repository.CrudRepository;

/**
 * CourseRepository interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-16
 */
public interface CourseRepository extends CrudRepository<Course, Long> {
}
