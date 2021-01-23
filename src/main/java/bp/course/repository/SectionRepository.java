package bp.course.repository;

import bp.course.model.Section;
import org.springframework.data.repository.CrudRepository;

/**
 * SectionRepository interface
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-23
 */
public interface SectionRepository extends CrudRepository<Section, Long> {
}
