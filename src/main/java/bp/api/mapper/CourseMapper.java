package bp.api.mapper;

import bp.api.model.course.CourseUpdateDto;
import bp.entity.Course;
import org.springframework.lang.NonNull;

/**
 * CourseMapper class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-20
 */
public class CourseMapper {
    /**
     * Maps all non nullable {@link CourseUpdateDto} fields to a {@link Course}
     *
     * @param updateDto a course updated dto
     * @param course    a course
     */
    public static void updateDtoToCourse(@NonNull CourseUpdateDto updateDto, @NonNull Course course) {
        if (null != updateDto.getName()) {
            course.setName(updateDto.getName());
        }

        if (null != updateDto.getDescription()) {
            course.setDescription(updateDto.getDescription());
        }
    }
}
