package bp.controller;

import bp.api.mapper.CourseMapper;
import bp.api.model.course.CourseCreateDto;
import bp.api.model.course.CourseDto;
import bp.api.model.course.CourseUpdateDto;
import bp.entity.Course;
import bp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * CourseController class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-20
 */
@RestController
@RequestMapping(name = "api_v1.0_courses", path = "/api/v1.0/courses")
public class CourseController {
    /**
     * Course service
     */
    @NonNull
    private final CourseService service;

    /**
     * CourseController constructor
     *
     * @param service a course service
     */
    @Autowired
    public CourseController(@NonNull CourseService service) {
        this.service = service;
    }

    /**
     * API endpoint to get a {@link Course} by id
     *
     * @param course a course
     * @return a response with 200 status code and course content as a body
     */
    @GetMapping(name = "api_v1.0_courses_get_one", path = "/{courseId}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable(value = "courseId") Course course) {
        CourseDto courseDto = new CourseDto(course);
        return ResponseEntity.ok(courseDto);
    }

    /**
     * API endpoint to create a new {@link Course}
     *
     * @param createDto a validated course create dto
     * @return a response with 200 status code and course content as a body
     */
    @PostMapping(name = "api_v1.0_courses_create", path = "/")
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CourseCreateDto createDto) {
        Course course = service.createCourse(createDto.getName(), createDto.getDescription());
        CourseDto courseDto = new CourseDto(course);

        return ResponseEntity.ok(courseDto);
    }

    /**
     * API endpoint to updated a {@link Course}
     *
     * @param course    a course
     * @param updateDto a validated course update dto
     *
     * @return a response with 204 status code
     */
    @PutMapping(name = "api_v1.0_courses_update", path = "/{courseId}")
    public ResponseEntity<Void> updateCourse(
        @PathVariable(value = "courseId") Course course,
        @Valid @RequestBody CourseUpdateDto updateDto
    ) {
        CourseMapper.updateDtoToCourse(updateDto, course);
        service.saveCourse(course);

        return ResponseEntity.noContent().build();
    }

    /**
     * API endpoint to delete a {@link Course} by id
     *
     * @param course a course
     * @return a response with 204 status code
     */
    @DeleteMapping(name = "api_v1.0_courses_delete_one", path = "/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable(value = "courseId") Course course) {
        service.deleteCourse(course);
        return ResponseEntity.noContent().build();
    }
}
