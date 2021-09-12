package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.mockito.Mockito.mock;


class BoardTest{
    private static final int MAX_WIDTH = 2;
    private static final int MAX_HEIGHT = 3;

    private final Square[][] grid = {
        {mock(Square.class), mock(Square.class), mock(Square.class)},
        {mock(Square.class), mock(Square.class), mock(Square.class)}
    };
    private final Board board = new Board(grid);

    @Test
    void verifyWidth(){
        assertThat(board.getWidth()).isEqualTo(MAX_WIDTH);
    }
    @Test
    void verifyHeight(){
        assertThat(board.getHeight()).isEqualTo(MAX_HEIGHT);
    }

    @TestFactory
    Iterable<DynamicTest> verifySquares(){
        return Arrays.asList(
            testSquareAt(0,0),
            testSquareAt(1,1),
            testSquareAt(0,2)
        );
    }

    private DynamicTest testSquareAt(int x, int y) {
        return dynamicTest(
            x + "," + y,
            () -> assertThat(board.squareAt(x, y)).isEqualTo(grid[x][y])
        );
    }
}
