package bp.converter;

import bp.entity.Course;
import bp.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * StringToCourseConverterTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-20
 */
@ExtendWith(SpringExtension.class)
public class StringToCourseConverterTest {
    /**
     * Course service mock
     */
    @MockBean
    private CourseService serviceMock;

    /**
     * String to course converter
     */
    private StringToCourseConverter converter;

    /**
     * Sets up
     */
    @BeforeEach
    public void setUp() throws Exception {
        converter = new StringToCourseConverter(serviceMock);
    }

    /**
     * Test for {@link StringToCourseConverter#convert(String)}
     */
    @Test
    public void convert() throws Exception {
        // given
        String id = "2";
        Long courseId = Long.parseLong(id);

        Course course = new Course("Math", "Cool math");
        course.setId(courseId);

        // when
        Mockito
            .when(serviceMock.getCourse(courseId))
            .thenReturn(Optional.of(course));

        Course result = converter.convert(id);

        // then
        assertSame(course, result);
    }

    /**
     * Test for {@link StringToCourseConverter#convert(String)}
     */
    @Test
    public void convertWhenCourseNotFound() throws Exception {
        // given
        String courseId = "2";

        // when / then
        assertThrows(ResponseStatusException.class, () -> {
            Mockito
                .when(serviceMock.getCourse(Long.parseLong(courseId)))
                .thenReturn(Optional.empty());

            converter.convert(courseId);
        });
    }
}
