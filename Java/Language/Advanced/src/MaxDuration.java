package finance;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //@Target({ElementType.FIELD, ElementType.Method})
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxDuration {
	int value() default 4;
}

