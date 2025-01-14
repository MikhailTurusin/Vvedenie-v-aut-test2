package org.max.home;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Тест кейс для тестирования методов порадокса
 */
public class GameTest {

    static List<Door> doors;

    @BeforeEach
    void initDoors () {
        doors = new ArrayList<>();
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
    }

    @Test
    @DisplayName("GameTest")
    @Description("")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Михаил")
    void checkNotRiskWin () {
        //given
        Player player = new Player("Игрок", false);
        Game game = new Game(player, doors);
        //when
        Door door = game.round(0);
        //then
        Assertions.assertTrue(door.isPrize());
    }

    @Test
    @DisplayName("GameTest")
    @Description("")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Михаил")
    void checkNotRiskLose() {
        //given
        Player player = new Player("Игрок", false);
        Game game = new Game(player, doors);
        //when
        Door door = game.round(1);
        //then
        Assertions.assertFalse(door.isPrize());
    }

    @Test
    @DisplayName("GameTest")
    @Description("")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Михаил")
    void checkRiskWin () {
        //given
        Player player = new Player("Игрок", true);
        Game game = new Game(player, doors);
        //when
        Door door = game.round(1);
        //then
        Assertions.assertTrue(door.isPrize());
    }

    @Test
    @DisplayName("GameTest")
    @Description("")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Михаил")
    void checkRiskLose () {
        //given
        Player player = new Player("Игрок", true);
        Game game = new Game(player, doors);
        //when
        Door door = game.round(0);
        //then
        Assertions.assertFalse(door.isPrize());
    }
}
