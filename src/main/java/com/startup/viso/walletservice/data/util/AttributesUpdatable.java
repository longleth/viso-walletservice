package com.startup.viso.walletservice.data.util;

public interface AttributesUpdatable<T> {

    /**
     * @apiNote
     *  - Functional method will be implemented by lambda code depends on client context
     *  - This functional method should be intentionally used by other utility classes
     * @param oldValue
     * @param newValue
     */
    void updateIfChanged(T oldValue, T newValue);

}
