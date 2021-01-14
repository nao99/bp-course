package bp.course.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

/**
 * AtLeastOneFieldNotNullValidator class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-20
 */
public class AtLeastOneFieldNotNullValidator implements ConstraintValidator<AtLeastOneFieldNotNull, Object> {
    /**
     * Fields
     */
    private String[] fields;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(AtLeastOneFieldNotNull annotation) {
        fields = annotation.fields();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) throws RuntimeException {
        if (null == value) {
            return true;
        }

        try {
            for (String fieldName : fields){
                Class<?> valueClass = value.getClass();

                Field field = valueClass.getDeclaredField(fieldName);
                field.setAccessible(true);

                Object property = field.get(value);
                field.setAccessible(false);

                if (null == property) {
                    continue;
                }

                return true;
            }
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
