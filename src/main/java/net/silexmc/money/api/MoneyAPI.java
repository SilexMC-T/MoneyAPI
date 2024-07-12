package net.silexmc.money.api;

import java.math.BigDecimal;
import java.util.UUID;

public interface MoneyAPI {
    BigDecimal getValue(UUID uniqueID, boolean total);

    String getValueToString(UUID uniqueID, boolean total);

    String getValueToFormat(UUID uniqueID, boolean total);

    default BigDecimal getValue(UUID uniqueID) {
        return this.getValue(uniqueID, false);
    }

    default String getValueToString(UUID uniqueID) {
        return this.getValueToString(uniqueID, false);
    }

    default String getValueToFormat(UUID uniqueID) {
        return this.getValueToFormat(uniqueID, false);
    }

    void setValue(UUID uniqueID, BigDecimal value);

    void addValue(UUID uniqueID, BigDecimal value);

    void takeValue(UUID uniqueID, BigDecimal value);

    boolean hasValue(UUID uniqueID, BigDecimal value);

    default void setValue(UUID uniqueID, Double value) {
        this.setValue(uniqueID, BigDecimal.valueOf(value));
    }

    default void addValue(UUID uniqueID, Double value) {
        this.addValue(uniqueID, BigDecimal.valueOf(value));
    }

    default void takeValue(UUID uniqueID, Double value) {
        this.takeValue(uniqueID, BigDecimal.valueOf(value));
    }

    default boolean hasValue(UUID uniqueID, Double value) {
        return this.hasValue(uniqueID, BigDecimal.valueOf(value));
    }
}
