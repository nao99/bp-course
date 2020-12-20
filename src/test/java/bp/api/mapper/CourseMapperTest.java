package bp.api.mapper;

import bp.api.model.course.CourseUpdateDto;
import bp.entity.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CourseMapperTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-20
 */
public class CourseMapperTest {
    /**
     * Test for {@link CourseMapper#updateDtoToCourse(CourseUpdateDto, Course)}
     */
    @Test
    public void updateDtoToCourse() throws Exception {
        // given
        CourseUpdateDto updateDto1 = new CourseUpdateDto();
        updateDto1.setName("Math course");
        updateDto1.setDescription("Math is's a cool");

        CourseUpdateDto updateDto2 = new CourseUpdateDto();
        updateDto2.setDescription("Chemistry is's a cool");

        CourseUpdateDto updateDto3 = new CourseUpdateDto();
        updateDto3.setName("Chemistry course");

        CourseUpdateDto updateDto4 = new CourseUpdateDto();

        Course course = new Course("Chemistry", "Chemistry it's a cool");

        // when / then
        CourseMapper.updateDtoToCourse(updateDto1, course);
        assertEquals(updateDto1.getName(), course.getName());
        assertEquals(updateDto1.getDescription(), course.getDescription());

        CourseMapper.updateDtoToCourse(updateDto2, course);
        assertEquals(updateDto1.getName(), course.getName());
        assertEquals(updateDto2.getDescription(), course.getDescription());

        CourseMapper.updateDtoToCourse(updateDto3, course);
        assertEquals(updateDto3.getName(), course.getName());
        assertEquals(updateDto2.getDescription(), course.getDescription());

        CourseMapper.updateDtoToCourse(updateDto4, course);
        assertEquals(updateDto3.getName(), course.getName());
        assertEquals(updateDto2.getDescription(), course.getDescription());
    }
}
