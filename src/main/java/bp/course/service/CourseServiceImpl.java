package bp.course.service;

import bp.course.api.model.course.CourseCreateDto;
import bp.course.api.model.section.SectionCreateDto;
import bp.course.model.Course;
import bp.course.model.Section;
import bp.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
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
    @NonNull
    private final CourseRepository repository;

    /**
     * CourseServiceImpl constructor
     *
     * @param repository a course repository
     */
    @Autowired
    public CourseServiceImpl(@NonNull CourseRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Course> getCourse(Long id) {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Course createCourse(CourseCreateDto courseCreateDto) {
        Course course = new Course(courseCreateDto.getName(), courseCreateDto.getDescription());
        for (SectionCreateDto sectionCreateDto : courseCreateDto.getSections()) {
            Section section = new Section(sectionCreateDto.getName(), sectionCreateDto.getDescription());
            course.addSection(section);
        }

        repository.save(course);

        return course;
    }
}
