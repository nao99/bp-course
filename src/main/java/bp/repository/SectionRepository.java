package bp.repository;

import bp.entity.Course;
import bp.entity.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SectionRepository interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-19
 */
@Repository
public interface SectionRepository extends CrudRepository<Section, Long> {
    /**
     * Finds all {@link Section}s by a {@link Course#id}
     *
     * @param courseId a course id
     * @return a list of sections
     */
    List<Section> findAllByCourseId(@NonNull Long courseId);
}
