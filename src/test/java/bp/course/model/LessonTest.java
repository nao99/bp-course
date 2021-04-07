package bp.course.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LessonTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-23
 */
public class LessonTest {
    /**
     * Test for {@link Lesson#rename(String)
     */
    @Test
    public void rename() throws Exception {
        // given
        String newName = "Fundamental principles";
        Lesson lesson = new Lesson("Fundamental principle", "Fundamental principles are...");

        // when
        lesson.rename(newName);

        // then
        assertEquals(newName, lesson.getName());
    }

    /**
     * Test for {@link Lesson#rename(String)
     */
    @Test
    public void renameWithTooShortName() throws Exception {
        // given
        String newName = "FP";
        Lesson lesson = new Lesson("Fundamental principle", "Fundamental principles are...");

        // when / then
        assertThrows(IllegalArgumentException.class, () -> lesson.rename(newName));
    }

    /**
     * Test for {@link Lesson#rename(String)
     */
    @Test
    public void renameWithTooLongName() throws Exception {
        // given
        String newName = "F".repeat(256);
        Lesson lesson = new Lesson("Fundamental principle", "Fundamental principles are...");

        // when / then
        assertThrows(IllegalArgumentException.class, () -> lesson.rename(newName));
    }

    /**
     * Test for {@link Lesson#changeContent(String)}
     */
    @Test
    public void changeContent() throws Exception {
        // given
        String newContent = "Fundamental principles are fundamental :)";
        Lesson lesson = new Lesson("Fundamental principle", "Fundamental principles are...");

        // when
        lesson.changeContent(newContent);

        // then
        assertEquals(newContent, lesson.getContent());
    }

    /**
     * Test for {@link Lesson#changeContent(String)}
     */
    @Test
    public void changeContentWithTooShortContent() throws Exception {
        // given
        String newContent = "FP";
        Lesson lesson = new Lesson("Fundamental principle", "Fundamental principles are...");

        // when / then
        assertThrows(IllegalArgumentException.class, () -> lesson.changeContent(newContent));
    }

    /**
     * Test for {@link Lesson#changeContent(String)}
     */
    @Test
    public void changeContentWithTooLongContent() throws Exception {
        // given
        String newContent = "F".repeat(8193);
        Lesson lesson = new Lesson("Fundamental principle", "Fundamental principles are...");

        // when / then
        assertThrows(IllegalArgumentException.class, () -> lesson.changeContent(newContent));
    }
}
