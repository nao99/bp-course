package bp.course.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CourseTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-26
 */
public class CourseTest {
    /**
     * Test for {@link Course#rename(String)
     */
    @Test
    public void rename() throws Exception {
        // given
        String newName = "Chemistry";
        Course course = new Course("Mathematic", "Some description");

        // when
        course.rename(newName);

        // then
        assertEquals(newName, course.getName());
    }

    /**
     * Test for {@link Course#rename(String)
     */
    @Test
    public void renameWithTooShortName() throws Exception {
        // given
        String newName = "AB";
        Course course = new Course("Mathematic", "Some description");

        // when / then
        assertThrows(IllegalArgumentException.class, () -> course.rename(newName));
    }

    /**
     * Test for {@link Course#rename(String)
     */
    @Test
    public void renameWithTooLongName() throws Exception {
        // given
        String newName = "A".repeat(256);
        Course course = new Course("Mathematic", "Some description");

        // when / then
        assertThrows(IllegalArgumentException.class, () -> course.rename(newName));
    }

    /**
     * Test for {@link Course#changeDescription(String)}
     */
    @Test
    public void changeDescription() throws Exception {
        // given
        String newDescription = "New description";
        Course course = new Course("Some name", "Old description");

        // when
        course.changeDescription(newDescription);

        // then
        assertEquals(newDescription, course.getDescription());
    }

    /**
     * Test for {@link Course#changeDescription(String)}
     */
    @Test
    public void changeDescriptionWithTooShortDescription() throws Exception {
        // given
        String newDescription = "AB";
        Course course = new Course("Some name", "Old description");

        // when / then
        assertThrows(IllegalArgumentException.class, () -> course.changeDescription(newDescription));
    }

    /**
     * Test for {@link Course#changeDescription(String)}
     */
    @Test
    public void changeDescriptionWithTooLongDescription() throws Exception {
        // given
        String newDescription = "A".repeat(8093);
        Course course = new Course("Some name", "Old description");

        // when / then
        assertThrows(IllegalArgumentException.class, () -> course.changeDescription(newDescription));
    }

    /**
     * Test for {@link Course#removeDescription()}
     */
    @Test
    public void removeDescription() throws Exception {
        // given
        Course course = new Course("Some name", "Old description");

        // when
        course.removeDescription();

        // then
        assertNull(course.getDescription());
    }

    /**
     * Test for {@link Course#addSection(Section)}
     */
    @Test
    public void addNewSection() throws Exception {
        // given
        Course course = new Course("Some name", "Old description");
        Section section = new Section("Mathematic", "Some description");

        // when
        course.addSection(section);

        // then
        assertEquals(1, course.getSections().size());
    }

    /**
     * Test for {@link Course#addSection(Section)}
     */
    @Test
    public void addDuplicatedSection() throws Exception {
        // given
        Course course = new Course("Some name", "Old description");
        Section section = new Section("Mathematic", "Some description");

        // when
        course.addSection(section);
        course.addSection(section);

        // then
        assertEquals(1, course.getSections().size());
    }

    /**
     * Test for {@link Course#removeSection(Section)}
     */
    @Test
    public void removeOldSection() throws Exception {
        // given
        Course course = new Course("Some name", "Old description");
        Section section = new Section("Mathematic", "Some description");

        // when
        course.addSection(section);
        course.removeSection(section);

        // then
        assertEquals(0, course.getSections().size());
    }

    /**
     * Test for {@link Course#removeSection(Section)}
     */
    @Test
    public void removeUnknownSection() throws Exception {
        // given
        Course course = new Course("Some name", "Old description");
        Section section = new Section("Mathematic", "Some description");

        // when
        course.removeSection(section);

        // then
        assertEquals(0, course.getSections().size());
    }
}
