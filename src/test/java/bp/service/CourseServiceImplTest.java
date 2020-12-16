package bp.service;

import bp.entity.Course;
import bp.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CourseServiceImplTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-16
 */
@ExtendWith(SpringExtension.class)
public class CourseServiceImplTest {
    /**
     * Course repository mock
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
        this.service = new CourseServiceImpl(this.repositoryMock);
    }

    /**
     * Test for a {@link CourseServiceImpl#getCourse(Long)}
     */
    @Test
    public void getCourse() {
        // given
        Course course = new Course("Mathematic", "Mathematic - it's a cool!");
        course.setId(1L);

        // when
        Mockito
            .when(repositoryMock.findById(course.getId()))
            .thenReturn(Optional.of(course));

        Optional<Course> result1 = service.getCourse(course.getId());
        Optional<Course> result2 = service.getCourse(2L);

        // then
        assertTrue(result1.isPresent());
        assertEquals(course, result1.get());

        assertFalse(result2.isPresent());
    }

    /**
     * Test for a {@link CourseServiceImpl#createCourse(String, String)}
     */
    @Test
    public void createCourse() {
        // given
        String name = "Mathematic";
        String description = "Mathematic - it's a cool!";

        // when
        Course result = service.createCourse(name, description);
        Mockito
            .verify(repositoryMock, Mockito.atMostOnce())
            .save(result);

        // then
        assertNull(result.getId());
        assertEquals(name, result.getName());
        assertEquals(description, result.getDescription());
        assertNotNull(result.getCreatedAt());
        assertNotNull(result.getUpdatedAt());
    }

    /**
     * Test for a {@link CourseServiceImpl#deleteCourse(Course)}
     */
    @Test
    public void deleteCourse() {
        // given
        Course course = new Course("Mathematic", "Mathematic - it's a cool!");

        // when / then
        service.deleteCourse(course);
        Mockito
            .verify(repositoryMock, Mockito.atMostOnce())
            .delete(course);
    }
}
