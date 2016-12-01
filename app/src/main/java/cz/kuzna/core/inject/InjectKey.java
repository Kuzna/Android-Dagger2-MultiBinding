package cz.kuzna.core.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import dagger.MapKey;

/**
 * @author Radek Kuznik
 */
@MapKey
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectKey {
    Class<?> value();
}
