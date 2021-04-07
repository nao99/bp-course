package bp.course.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SectionTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-01-05
 */
public class SectionTest {
    /**
     * Test for {@link Section#rename(String)
     */
    @Test
    public void rename() throws Exception {
        // given
        String newName = "Chemistry";
        Section section = new Section("Mathematic", "Some description");

        // when
        section.rename(newName);

        // then
        assertEquals(newName, section.getName());
    }

    /**
     * Test for {@link Section#rename(String)
     */
    @Test
    public void renameWithTooShortName() throws Exception {
        // given
        String newName = "AB";
        Section section = new Section("Mathematic", "Some description");

        // when / then
        assertThrows(IllegalArgumentException.class, () -> section.rename(newName));
    }

    /**
     * Test for {@link Section#rename(String)
     */
    @Test
    public void renameWithTooLongName() throws Exception {
        // given
        String newName = "A".repeat(256);
        Section section = new Section("Mathematic", "Some description");

        // when / then
        assertThrows(IllegalArgumentException.class, () -> section.rename(newName));
    }

    /**
     * Test for {@link Section#changeDescription(String)}
     */
    @Test
    public void changeDescription() throws Exception {
        // given
        String newDescription = "New description";
        Section section = new Section("Some name", "Old description");

        // when
        section.changeDescription(newDescription);

        // then
        assertEquals(newDescription, section.getDescription());
    }

    /**
     * Test for {@link Section#changeDescription(String)}
     */
    @Test
    public void changeDescriptionWithTooShortDescription() throws Exception {
        // given
        String newDescription = "AB";
        Section section = new Section("Some name", "Old description");

        // when / then
        assertThrows(IllegalArgumentException.class, () -> section.changeDescription(newDescription));
    }

    /**
     * Test for {@link Section#changeDescription(String)}
     */
    @Test
    public void changeDescriptionWithTooLongDescription() throws Exception {
        // given
        String newDescription = "A".repeat(4097);
        Section section = new Section("Some name", "Old description");

        // when / then
        assertThrows(IllegalArgumentException.class, () -> section.changeDescription(newDescription));
    }

    /**
     * Test for {@link Section#removeDescription()}
     */
    @Test
    public void removeDescription() throws Exception {
        // given
        Section section = new Section("Some name", "Old description");

        // when
        section.removeDescription();

        // then
        assertNull(section.getDescription());
    }

    /**
     * Test for {@link Section#addLesson(Lesson)}
     */
    @Test
    public void addNewLesson() throws Exception {
        // given
        Section section = new Section("Some name", "Old description");
        Lesson lesson = new Lesson("Fundamental principle", "Fundamental principles are...");

        // when
        section.addLesson(lesson);

        // then
        assertEquals(1, section.getLessons().size());
    }

    /**
     * Test for {@link Section#addLesson(Lesson)}
     */
    @Test
    public void addDuplicatedLesson() throws Exception {
        // given
        Section section = new Section("Some name", "Old description");
        Lesson lesson = new Lesson("Fundamental principle", "Fundamental principles are...");

        // when
        section.addLesson(lesson);
        section.addLesson(lesson);

        // then
        assertEquals(1, section.getLessons().size());
    }

    /**
     * Test for {@link Section#removeLesson(Lesson)}
     */
    @Test
    public void removeOldLesson() throws Exception {
        // given
        Section section = new Section("Some name", "Old description");
        Lesson lesson = new Lesson("Fundamental principle", "Fundamental principles are...");

        // when
        section.addLesson(lesson);
        section.removeLesson(lesson);

        // then
        assertEquals(0, section.getLessons().size());
    }

    /**
     * Test for {@link Section#removeLesson(Lesson)}
     */
    @Test
    public void removeUnknownLesson() throws Exception {
        // given
        Section section = new Section("Some name", "Old description");
        Lesson lesson = new Lesson("Fundamental principle", "Fundamental principles are...");

        // when
        section.removeLesson(lesson);

        // then
        assertEquals(0, section.getLessons().size());
    }
}
