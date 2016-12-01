package cz.kuzna.core.inject;

/**
 * @author Radek Kuznik
 */

public interface ComponentBuilder<M extends D2Module, C extends D2Component> {

    ComponentBuilder<M, C> module(M module);

    C build();
}