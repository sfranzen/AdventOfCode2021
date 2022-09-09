package nl.belastingdienst.douane.inleidingprogrammeren;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * Een begin van een project in TDD-stijl, aan de hand van de eerste drie
 * opdrachten van Advent of Code 2021. Deze zijn te vinden op
 * https://adventofcode.com/2021
 *
 * De studenten kunnen de eenmaal geteste algoritmes ook gebruiken om de
 * eigenlijke puzzels op te lossen. Daarvoor is de invoer veel langer en is
 * het handiger als ze eerst weten hoe je deze bijv. uit een tekstbestand kunt
 * uitlezen.
 */
public class SubmarineTests {
    // https://adventofcode.com/2021/day/1
    @Test
    void day1()
    {
        int[] exampleDepths = {199, 200, 208, 210, 200, 207, 240, 269, 260, 263};

        int count = Submarine.countIncrements(exampleDepths);
        System.out.println("Number of increments: " + count);

        assertThat(count).isEqualTo(7);
    }

    // https://adventofcode.com/2021/day/2
    @Test
    void day2()
    {
        String[] exampleCommands = {
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2",
        };

        Submarine sub = new Submarine();
        for (String command : exampleCommands)
            sub.updatePosition(command);

        Position pos = sub.position();
        System.out.println("New position: " + pos.toString());

        assertThat(pos.x).isEqualTo(15);
        assertThat(pos.y).isEqualTo(10);
    }

    // https://adventofcode.com/2021/day/3
    @Test
    void day3()
    {
        String[] exampleDiagnostics = {
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010",
        };

        int power = Submarine.calculatePower(exampleDiagnostics);
        System.out.println("Power: " + power);

        assertThat(power).isEqualTo(198);
    }
}
