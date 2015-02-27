package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
public class ConnectFourTest{
	@Test
    public void testNewGameBoardShouldBeEmpty() {
        ConnectFour c = new ConnectFour();
        for(int col = 0; col < 7; col++) {
            assertEquals(ConnectFour.Location.EMPTY, c.getTopOfColumn(col));
            assertEquals(0, c.getHeightOfColumn(col));
        }
    }
    
    @Test
    public void testDropRedTokenInThirdColumnTheBlackTokenOnTopOfIt() {
        ConnectFour c = new ConnectFour();
        c.dropToken(2);
        assertEquals(ConnectFour.Location.RED, c.getTopOfColumn(2));
        assertEquals(1, c.getHeightOfColumn(2));
        c.dropToken(2);
        assertEquals(ConnectFour.Location.BLACK, c.getTopOfColumn(2));
        assertEquals(2, c.getHeightOfColumn(2));
    }
    
    @Test(expected=ColumnFullException.class)
    public void testDroppingOnAFullColumnShouldThrowException() throws Exception {
		ConnectFour c = new ConnectFour();
		int col = 3;
        for(int i = 0; i < 7; i++ ){
			c.dropToken(col);
		}
    }
    
}















