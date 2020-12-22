package bp.service;

import bp.entity.Section;
import bp.exception.section.SectionConstraintException;
import bp.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * SectionServiceImpl class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-19
 */
@Service
public class SectionServiceImpl implements SectionService {
    /**
     * Section repository
     */
    private final SectionRepository repository;

    /**
     * SectionServiceImpl constructor
     *
     * @param repository a section repository
     */
    @Autowired
    public SectionServiceImpl(SectionRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Section> getSection(Long id) {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Section> getSectionsByCourseId(Long courseId) {
        return repository.findAllByCourseId(courseId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Section createSection(Long courseId, String name, String description) throws SectionConstraintException {
        Section section = new Section(courseId, name, description);
        try {
            repository.save(section);
        } catch (DataIntegrityViolationException e) {
            throw new SectionConstraintException(String.format("Course with \"%d\" id does not exist", courseId), e);
        }

        return section;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveSection(@NonNull Section section) {
        repository.save(section);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteSection(Section section) {
        repository.delete(section);
    }
}
