package cz.kuzna.core.inject;

/**
 * @author Radek Kuznik
 */
public interface HasComponentBuilder {

    ComponentBuilder getComponentBuilder(Class<?> clazz);
}