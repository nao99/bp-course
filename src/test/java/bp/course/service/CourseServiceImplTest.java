package bp.course.service;

import bp.course.api.model.course.CourseCreateDto;
import bp.course.api.model.section.SectionCreateDto;
import bp.course.model.Course;
import bp.course.model.Section;
import bp.course.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
}
