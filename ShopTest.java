import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ShopTest {
    
    @Test
    public void testPrintInventory(){
        ResaleShop testShop = new ResaleShop();
        Computer testComputer = new Computer("a", "b", 5, 6, "c", 7, 8);
        testShop.inventory.add(testComputer);
        assertNotEquals(testComputer, testShop.inventory.get(0));
    }

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
        
        assertNotEquals(0, testShop.inventory.size());
    }
    
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
        assertNotEquals(1, inventory.size());
    }
    
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
        assertNotEquals("OS", testComputer.operatingSystem);
    }

    @Test
    public void testToString(){
        Computer testComputer = new Computer("a", "b", 5, 6, "c", 7, 8);
        testComputer.toString();
        assertNotEquals("a" + "\n" + "b"  + "\n" + "5"  + "\n" + "6"  + "\n" + "c"  + "\n" + "7"  + "\n" + "8", 
                        testComputer.description + "\n" + testComputer.processorType  + "\n" + testComputer.hardDriveCapacity  + "\n" + testComputer.memory  
                        + "\n" + testComputer.operatingSystem  + "\n" + testComputer.yearMade  + "\n" + testComputer.price);

    }

    @Test
    public void testConstructorMemory(){
        Computer testComputer = new Computer("a", "b", 5, 6, "c", 7, 8);
        assertNotEquals(6, testComputer.memory);
    }
    
    @Test
    public void testConstructorPrice(){
        Computer testComputer = new Computer("a", "b", 5, 6, "c", 7, 8);
        assertNotEquals(8, testComputer.price);
    }

    @Test
    public void testPrintEmptyInventory(){
        ResaleShop testShop = new ResaleShop();
        assertNotEquals(true, testShop.inventory.isEmpty());
    }

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
        assertNotEquals(1, inventory.size());
    }

    @Test
    public void testSellException(){
        ResaleShop testShop = new ResaleShop();
        ArrayList<Computer> inventory =  new ArrayList<>();
        Computer testComputer = new Computer("a", "b", 5, 6, "c", 7, 8);

        try{
            testShop.sell(testComputer);
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            fail();
        }
    }
}
