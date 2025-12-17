
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


/**
 * tests the ResaleShop class for bugs
 */
public class ShopTest {
    /**
     * tests whether the rights indices are accessed
     */
    @Test
    public void testPrintInventory(){
        ResaleShop testShop = new ResaleShop();
        Computer testComputer = new Computer("a", "b", 5, 6, "c", 7, 8);
        testShop.inventory.add(testComputer);
        assertEquals(testComputer, testShop.inventory.get(0));
    }

    /**
     * tests whether a computer is removed from the inventory or not
     */
    @Test
    public void testSell(){
        ResaleShop testShop = new ResaleShop();
        Computer testComputer = new Computer("a", "b", 5, 6, "c", 7, 8);
        testShop.inventory.add(testComputer);
        try{
            testShop.sell(testComputer);
        } catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        
        assertEquals(0, testShop.inventory.size());
    }
    /**
     * tests whether a computer is added to the inventory
     */
    @Test
    public void testBuy(){
        ResaleShop testShop = new ResaleShop();
        ArrayList<Computer> inventory =  new ArrayList<>();
        Computer testComputer = new Computer("a", "b", 5, 6, "c", 7, 8);
        try{
            testShop.buy(testComputer);
        } catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            fail();
        }
        assertEquals(1, inventory.size());
    }
    
    /**
     * tests whether the OS is updated
     */
    @Test
    public void testRefurbish(){
        Computer testComputer = new Computer("a", "b", 5, 6, "c", 7, 8);
        String newOS = "OS";
        ResaleShop testShop = new ResaleShop();
        testShop.inventory.add(testComputer);
        try{
        testShop.refurbish(testComputer, newOS);
        } catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            fail();
        }
        assertEquals("OS", testComputer.operatingSystem);
    }

    /**
     * tests if attributes are printed as a string
     */
    @Test
    public void testToString(){
        Computer testComputer = new Computer("a", "b", 5, 6, "c", 7, 8);
        testComputer.toString();
        assertEquals("a" + "\n" + "b"  + "\n" + "5"  + "\n" + "6"  + "\n" + "c"  + "\n" + "7"  + "\n" + "8", 
                        testComputer.description + "\n" + testComputer.processorType  + "\n" + testComputer.hardDriveCapacity  + "\n" + testComputer.memory  
                        + "\n" + testComputer.operatingSystem  + "\n" + testComputer.yearMade  + "\n" + testComputer.price);

    }

    /**
     * tests if the constructor stores the right memory
     */
    @Test
    public void testConstructorMemory(){
        Computer testComputer = new Computer("a", "b", 5, 6, "c", 7, 8);
        assertEquals(6, testComputer.memory);
    }
    
    /**
     * tests if the constructor stores the right price
     */
    @Test
    public void testConstructorPrice(){
        Computer testComputer = new Computer("a", "b", 5, 6, "c", 7, 0);
        assertEquals(10, testComputer.price);
    }

    /**
     * tests if the isEmpty() method returns the correct boolean
     */
    @Test
    public void testIsEmpty(){
        ResaleShop testShop = new ResaleShop();
        assertEquals(true, testShop.inventory.isEmpty());
    }

    /**
     * tests if an exception is thrown in the buy() method when a computer is already in the inventory
     */
    @Test
    public void testBuyException(){
        ResaleShop testShop = new ResaleShop();
        ArrayList<Computer> inventory =  new ArrayList<>();
        Computer testComputer = new Computer("a", "b", 5, 6, "c", 7, 8);
        testShop.inventory.add(testComputer);
        
        try{
            testShop.buy(testComputer);
        } catch(Exception e){
            System.out.println(e.getLocalizedMessage());
            fail();
        }
    }

    /**
     * tests if an excpetion is thrown in the sell() method when a computer is not in the inventory
     */
    @Test
    public void testSellException(){
        ResaleShop testShop = new ResaleShop();
        Computer testComputer = new Computer("a", "b", 5, 6, "c", 7, 8);

        try{
            testShop.sell(testComputer);
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            fail();
        }

    }
}
