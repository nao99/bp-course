package bp.course.repository;

import bp.course.model.Lesson;
import org.springframework.data.repository.CrudRepository;

/**
 * LessonRepository interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-23
 */
public interface LessonRepository extends CrudRepository<Lesson, Long> {
}
