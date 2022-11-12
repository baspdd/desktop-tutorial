/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CalculateBonus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author duypham0705
 */
public class CalculateBonusTest {

    public CalculateBonusTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        calculateBonus = new CalculateBonus();
    }

    @AfterClass
    public static void tearDownClass() {
        calculateBonus = null;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calculate method, of class CalculateBonus.
     */
    static CalculateBonus calculateBonus = null;

// salary = 1000
// workingDay = 0
// staffPoint = 1
// level = 0 
//Return -1 
    @Test
    public void testCalculateUTCID01() {
        System.out.println("calculate");
        long salary = 1000;
        int workingDay = 0;
        int staffPoint = 1;
        int level = 0;
        double expResult = -1.0;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 0.0);
    }

// salary = 1000
// workingDay = 0
// staffPoint = 1
// level = 8 
//Return -1 
    @Test
    public void testCalculateUTCID02() {
        System.out.println("calculate");
        long salary = 1000;
        int workingDay = 0;
        int staffPoint = 1;
        int level = 8;
        double expResult = -1.0;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 0.0);
    }
// salary = 1000
// workingDay = 0
// staffPoint = 0
// level = 7 
//Return -1 

    @Test
    public void testCalculateUTCID03() {
        System.out.println("calculate");
        long salary = 1000;
        int workingDay = 0;
        int staffPoint = 0;
        int level = 7;
        double expResult = -1.0;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 0.0);
    }
// salary = 1000
// workingDay = 0
// staffPoint = 11
// level = 7 
//Return -1 

    @Test
    public void testCalculateUTCID04() {
        System.out.println("calculate");
        long salary = 1000;
        int workingDay = 0;
        int staffPoint = 11;
        int level = 7;
        double expResult = -1.0;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 0.0);
    }

// salary = 1000
// workingDay = -1
// staffPoint = 10
// level = 7 
//Return -1 
    @Test
    public void testCalculateUTCID05() {
        System.out.println("calculate");
        long salary = 1000;
        int workingDay = -1;
        int staffPoint = 10;
        int level = 7;
        double expResult = -1.0;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 0.0);
    }

// salary = 1000
// workingDay = 32
// staffPoint = 10
// level = 7 
//Return -1 
    @Test
    public void testCalculateUTCID06() {
        System.out.println("calculate");
        long salary = 1000;
        int workingDay = 32;
        int staffPoint = 10;
        int level = 7;
        double expResult = -1.0;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 0.0);
    }
// salary = 999
// workingDay = 31
// staffPoint = 7
// level = 7 
//Return -1 

    @Test
    public void testCalculateUTCID07() {
        System.out.println("calculate");
        long salary = 999;
        int workingDay = 31;
        int staffPoint = 7;
        int level = 7;
        double expResult = -1.0;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 0.0);
    }
// salary = 3000001
// workingDay = 31
// staffPoint = 7
// level = 7 
//Return -1 

    @Test
    public void testCalculateUTCID08() {
        System.out.println("calculate");
        long salary = 3000001;
        int workingDay = 31;
        int staffPoint = 7;
        int level = 7;
        double expResult = -1.0;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 0.0);
    }
// salary = 1000
// workingDay = 0
// staffPoint = 9
// level = 1 
//Return 2145 

    @Test
    public void testCalculateUTCID09() {
        System.out.println("calculate");
        long salary = 1000;
        int workingDay = 0;
        int staffPoint = 9;
        int level = 1;
        double expResult = 2145;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 1.0);
    }
// salary = 5000
// workingDay = 0
// staffPoint = 7
// level = 7 
//Return 7150 

    @Test
    public void testCalculateUTCID10() {
        System.out.println("calculate");
        long salary = 5000;
        int workingDay = 0;
        int staffPoint = 7;
        int level = 7;
        double expResult = 7150;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 1.0);
    }
// salary = 10000
// workingDay = 0
// staffPoint = 5
// level = 7 
//Return 11000 

    @Test
    public void testCalculateUTCID11() {
        System.out.println("calculate");
        long salary = 10000;
        int workingDay = 0;
        int staffPoint = 5;
        int level = 7;
        double expResult = 11000;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 1.0);
    }
// salary = 3000000
// workingDay = 0
// staffPoint = 1
// level = 7 
//Return 0 

    @Test
    public void testCalculateUTCID12() {
        System.out.println("calculate");
        long salary = 3000000;
        int workingDay = 0;
        int staffPoint = 1;
        int level = 7;
        double expResult = 0;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 1.0);
    }
// salary = 1000
// workingDay = 0
// staffPoint = 9
// level = 7 
//Return 1950 

    @Test
    public void testCalculateUTCID13() {
        System.out.println("calculate");
        long salary = 1000;
        int workingDay = 0;
        int staffPoint = 9;
        int level = 7;
        double expResult = 1950;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 1.0);
    }
// salary = 5000
// workingDay = 0
// staffPoint = 7
// level = 1 
//Return 7865 

    @Test
    public void testCalculateUTCID14() {
        System.out.println("calculate");
        long salary = 1000;
        int workingDay = 0;
        int staffPoint = 9;
        int level = 7;
        double expResult = 1950;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 1.0);
    }
// salary = 10000
// workingDay = 0
// staffPoint = 5
// level = 1 
//Return 12100 

    @Test
    public void testCalculateUTCID15() {
        System.out.println("calculate");
        long salary = 10000;
        int workingDay = 0;
        int staffPoint = 5;
        int level = 1;
        double expResult = 12100;
        double result = calculateBonus.calculate(salary, workingDay, staffPoint, level);
        assertEquals(expResult, result, 1.0);
    }

}
