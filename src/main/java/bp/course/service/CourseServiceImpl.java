package bp.course.service;

import bp.course.api.model.course.CourseCreateDto;
import bp.course.api.model.course.CourseUpdateDto;
import bp.course.api.model.section.SectionCreateDto;
import bp.course.exception.course.CourseNotFoundException;
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
    @NonNull
    public Optional<Course> getCourse(@NonNull Long id) {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public Course createCourse(@NonNull CourseCreateDto courseCreateDto) {
        Course course = new Course(courseCreateDto.getName(), courseCreateDto.getDescription());
        for (SectionCreateDto sectionCreateDto : courseCreateDto.getSections()) {
            Section section = new Section(sectionCreateDto.getName(), sectionCreateDto.getDescription());
            course.addSection(section);
        }

        repository.save(course);

        return course;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCourse(
        @NonNull Long courseId,
        @NonNull CourseUpdateDto courseUpdateDto
    ) throws CourseNotFoundException {
        Optional<Course> courseOptional = repository.findById(courseId);
        if (courseOptional.isEmpty()) {
            throw new CourseNotFoundException(String.format("Course with id \"%d\" not found", courseId));
        }

        Course course = courseOptional.get();
        if (null != courseUpdateDto.getName()) {
            course.rename(courseUpdateDto.getName());
        }

        if (null != courseUpdateDto.getDescription()) {
            course.changeDescription(courseUpdateDto.getDescription());
        }

        repository.save(course);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public Section addSectionToCourse(
        @NonNull Long courseId,
        @NonNull SectionCreateDto sectionCreateDto
    ) throws CourseNotFoundException {
        Optional<Course> courseOptional = repository.findById(courseId);
        if (courseOptional.isEmpty()) {
            throw new CourseNotFoundException(String.format("Course with id \"%d\" not found", courseId));
        }

        Course course = courseOptional.get();
        Section section = new Section(sectionCreateDto.getName(), sectionCreateDto.getDescription());

        course.addSection(section);
        repository.save(course);

        return section;
    }
}
