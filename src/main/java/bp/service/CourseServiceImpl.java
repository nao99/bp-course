package bp.service;

import bp.entity.Course;
import bp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * CourseServiceImpl class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-16
 */
@Service
public class CourseServiceImpl implements CourseService {
    /**
     * Course repository
     */
    private final CourseRepository repository;

    /**
     * CourseServiceImpl constructor
     *
     * @param repository a course repository
     */
    @Autowired
    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Course> getCourse(@NonNull Long id) {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Course createCourse(@NonNull String name, @Nullable String description) {
        Course course = new Course(name, description);
        repository.save(course);

        return course;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveCourse(@NonNull Course course) {
        repository.save(course);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteCourse(@NonNull Course course) {
        repository.delete(course);
    }
}
