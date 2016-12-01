package cz.kuzna.core.inject;

/**
 * @author Radek Kuznik
 */
public interface ComponentBuilderContainer {

    ComponentBuilder getComponentBuilder(Class<?> clazz);
}