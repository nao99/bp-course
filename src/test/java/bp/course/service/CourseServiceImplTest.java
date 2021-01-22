package bp.course.service;

import bp.course.api.model.course.CourseCreateDto;
import bp.course.api.model.course.CourseUpdateDto;
import bp.course.api.model.section.SectionCreateDto;
import bp.course.exception.course.CourseNotFoundException;
import bp.course.model.Course;
import bp.course.model.Section;
import bp.course.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * CourseServiceImplTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-14
 */
@ExtendWith(SpringExtension.class)
public class CourseServiceImplTest {
    /**
     * Course repository
     */
    @MockBean
    private CourseRepository repositoryMock;

    /**
     * Course service
     */
    private CourseServiceImpl service;

    /**
     * Sets up
     */
    @BeforeEach
    public void setUp() throws Exception {
        service = new CourseServiceImpl(repositoryMock);
    }

    /**
     * Test for {@link CourseServiceImpl#getCourse(Long)}
     */
    @Test
    public void getCourse() throws Exception {
        // given
        Long courseId = 1L;

        // when / then
        verify(repositoryMock, atMostOnce())
            .findById(courseId);

        service.getCourse(courseId);
    }

    /**
     * Test for {@link CourseServiceImpl#createCourse(CourseCreateDto)}
     */
    @Test
    public void createCourse() throws Exception {
        // given
        SectionCreateDto sectionCreateDto = new SectionCreateDto();
        sectionCreateDto.setName("Lagrange equations");
        sectionCreateDto.setDescription("A little bit difficult theme");

        CourseCreateDto courseCreateDto = new CourseCreateDto();
        courseCreateDto.setName("Math");
        courseCreateDto.setDescription("The best science");
        courseCreateDto.setSections(List.of(sectionCreateDto));

        // when
        verify(repositoryMock, atMostOnce())
            .save(any());

        Course course = service.createCourse(courseCreateDto);

        // then
        assertNotNull(course);
        assertEquals(courseCreateDto.getName(), course.getName());
        assertEquals(courseCreateDto.getDescription(), course.getDescription());

        assertEquals(1, course.getSections().size());
        assertEquals(courseCreateDto.getSections().size(), course.getSections().size());

        Section section = course.getSections().iterator().next();

        assertEquals(sectionCreateDto.getName(), section.getName());
        assertEquals(sectionCreateDto.getDescription(), section.getDescription());
    }

    /**
     * Test for {@link CourseServiceImpl#updateCourse(Long, CourseUpdateDto)}
     */
    @Test
    public void updateCourse() throws Exception {
        // given
        Course course = new Course("Chemistry", "Chemistry it's a cool");
        Long courseId = 1L;

        CourseUpdateDto courseUpdateDto = new CourseUpdateDto();
        courseUpdateDto.setName("Math");
        courseUpdateDto.setDescription("Math it's a cool");

        // when
        when(repositoryMock.findById(courseId))
            .thenReturn(Optional.of(course));

        verify(repositoryMock, atMostOnce())
            .findById(courseId);

        verify(repositoryMock, atMostOnce())
            .save(any());

        service.updateCourse(courseId, courseUpdateDto);

        // then
        assertEquals(courseUpdateDto.getName(), course.getName());
        assertEquals(courseUpdateDto.getDescription(), course.getDescription());
    }

    /**
     * Test for {@link CourseServiceImpl#updateCourse(Long, CourseUpdateDto)}
     */
    @Test
    public void updateCourseWhenCourseNotFound() throws Exception {
        // given
        Long courseId = 1L;

        CourseUpdateDto courseUpdateDto = new CourseUpdateDto();
        courseUpdateDto.setName("Math");
        courseUpdateDto.setDescription("Math it's a cool");

        // when / then
        when(repositoryMock.findById(courseId))
            .thenReturn(Optional.empty());

        verify(repositoryMock, atMostOnce())
            .findById(courseId);

        assertThrows(CourseNotFoundException.class, () -> service.updateCourse(courseId, courseUpdateDto));
    }

    /**
     * Test for {@link CourseServiceImpl#addSectionToCourse(Long, SectionCreateDto)}
     */
    @Test
    public void addSectionToCourse() throws Exception {
        // given
        Course course = new Course("Chemistry", "Chemistry it's a cool");
        Long courseId = 1L;

        SectionCreateDto sectionCreateDto = new SectionCreateDto();
        sectionCreateDto.setName("Lagrange equations");
        sectionCreateDto.setDescription("Lagrange equations it's a cool");

        int courseSectionsCountBeforeAdding = course.getSections().size();

        // when
        when(repositoryMock.findById(courseId))
            .thenReturn(Optional.of(course));

        verify(repositoryMock, atMostOnce())
            .findById(courseId);

        verify(repositoryMock, atMostOnce())
            .save(any());

        Section section = service.addSectionToCourse(courseId, sectionCreateDto);

        // then
        assertEquals(courseSectionsCountBeforeAdding + 1, course.getSections().size());

        assertEquals(section.getName(), sectionCreateDto.getName());
        assertEquals(section.getDescription(), sectionCreateDto.getDescription());
    }

    /**
     * Test for {@link CourseServiceImpl#addSectionToCourse(Long, SectionCreateDto)}
     */
    @Test
    public void addSectionToCourseWhenCourseNotFound() throws Exception {
        // given
        Long courseId = 1L;

        SectionCreateDto sectionCreateDto = new SectionCreateDto();
        sectionCreateDto.setName("Lagrange equations");
        sectionCreateDto.setDescription("Lagrange equations it's a cool");

        // when / then
        when(repositoryMock.findById(courseId))
            .thenReturn(Optional.empty());

        verify(repositoryMock, atMostOnce())
            .findById(courseId);

        assertThrows(CourseNotFoundException.class, () -> service.addSectionToCourse(courseId, sectionCreateDto));
    }
}
