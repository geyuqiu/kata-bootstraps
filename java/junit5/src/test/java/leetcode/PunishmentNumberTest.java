package leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PunishmentNumberTest {
    PunishmentNumber punishmentNumber = new PunishmentNumber();

    @Test
    void punishmentNumber() {
        assertEquals(10804657, punishmentNumber.punishmentNumber(1000));
    }
}
