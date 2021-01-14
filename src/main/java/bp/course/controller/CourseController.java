package bp.course.controller;

import bp.course.api.model.course.CourseCreateDto;
import bp.course.api.model.course.CourseDto;
import bp.course.model.Course;
import bp.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

/**
 * CourseController class
 *
 * @author Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since 2021-01-14
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
     * @param courseId a course id
     *
     * @return a course
     * @throws ResponseStatusException with 404 status code if course was not found
     */
    @GetMapping(name = "api_v1.0_courses_get", path = "/{courseId:\\d+}")
    @NonNull
    public ResponseEntity<CourseDto> getCourse(@PathVariable("courseId") String courseId) {
        Optional<Course> courseOptional = service.getCourse(Long.parseLong(courseId));
        if (courseOptional.isEmpty()) {
            String message = String.format("Course with id %s not found", courseId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }

        Course course = courseOptional.get();
        CourseDto courseDto = new CourseDto(course);

        return ResponseEntity.ok(courseDto);
    }

    /**
     * API endpoint to create a new {@link Course}
     *
     * @param courseCreateDto a course create DTO
     * @return a created course
     */
    @PostMapping(name = "api_v1.0_courses_create", path = "/")
    @NonNull
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CourseCreateDto courseCreateDto) {
        Course course = service.createCourse(courseCreateDto);
        CourseDto courseDto = new CourseDto(course);

        return ResponseEntity.ok(courseDto);
    }
}
