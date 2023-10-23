import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This abstract class implements the interface Item. This means that the
 * methods in Item are now being implemented in this abstract class. They are
 * defined here since every subclass does the same action.
 * 
 * @author Olivia Mellen
 *
 */
public abstract class Clothing implements Item {

    // these protected instance variables are
    // accessable to the subclasses Top and Bottom
    protected double price;
    protected int quantity;
    protected String size;
    protected String type;

    /**
     * This is the main constructor used for when customers add an item to their
     * cart. It will gather information about the type of apparel, size, and
     * quantity that the customer would like in this item. The constructor also
     * calls the method determinePrice() so that the price can be found using
     * the type and quantity of the clothing. Classes Top and Bottom use the
     * keybword super to send their data to the clothing class.
     * 
     * @param type     the kind of clothing the customer is ordering
     * @param size     the size of the item from XS to XL
     * @param quantity how many of this clothing the customer would like
     * @throws FileNotFoundException when determinePrice() is called, it checks
     *                               that there is a file
     */
    public Clothing(String type, String size, int quantity)
            throws FileNotFoundException {
        this.type = type;
        this.size = size;
        this.quantity = quantity;
        this.price = determinePrice(type, quantity);
    }

    /**
     * This is constructor is used when the customer would like to use an action
     * on an item that is not in their cart meaning size and quantity are
     * unnecessary information to gather.
     * 
     * @param type the king of clothing apparel the customer would like
     * @throws FileNotFoundException when determinePrice() is called, it checks
     *                               that there is a file
     */
    public Clothing(String type) throws FileNotFoundException {
        this.type = type;
        this.quantity = 1;
        this.size = "M";
        this.price = determinePrice(type, quantity);
    }

    /**
     * This method gives back the value of price.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * This method gives back the value of quantity.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * This method gives back the value of type.
     */
    public String getType() {
        return this.type;
    }

    /**
     * This method will print out a statement saying that the user liked an item
     * and states the value of type.
     */
    public void like() {
        System.out.println(
                "You liked " + this.type + " on Liv's Loungewear Website\n");
    }

    /**
     * This method will print out a statements saying that the user tried on an
     * item and state the value of that item.
     */
    public void tryOn() {
        System.out.println("You tried on " + this.type + ".   Looks good!\n");
    }

    /**
     * The user will import a message that they want to put a message on the
     * website. This method will then print out a statement saying that the
     * customer left a review on an item. Then state the value of the type and
     * the value of the message
     * 
     * @param message the review the user left on an item
     */
    public void writeReview(String message) {
        System.out.println("You left a review about " + this.type
                + " on Liv's Loungewear website: \n" + message + "\n");
    }

    /**
     * This method will determine the price of the newly added items to the
     * customer's cart. The customer will input the type and quantity (and size)
     * of the clothing item they would like. Using that information, this method
     * will give the price of the object. It uses the store_inventory.txt file
     * to find the original price of an item.
     * 
     * @param type     the kind of clothing item the customer would like
     * @param quantity the amount of this clothing item added
     * @return the price of the added item
     * @throws FileNotFoundException checks to make sure that the text file is
     *                               found
     */
    private double determinePrice(String type, int quantity)
            throws FileNotFoundException {
        double temp = 0;
        try (Scanner sc = new Scanner(new File("store_inventory.txt"))) {
            /*
            while (sc.hasNext()) {
                if (sc.next().equals(type)) {
                    temp = sc.nextDouble();
                }
            }
            */
            while (sc.hasNextLine()) {
                String[] row = sc.nextLine().split(" ");
                if (row[1].equals(type)) {
                    temp = Integer.parseInt(row[2]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return temp * quantity;
    }

}
