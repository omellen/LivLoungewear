import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The class implements the Item class. This will include items like rings,
 * necklaces, etc.
 * 
 * @author Olivia Mellen
 *
 */
public class Accessory implements Item {

    private String type;
    private int quantity;
    private double price;

    /**
     * This will be the main constructor that is used when a customer wants to
     * add to their cart or do any action to an object within their cart.
     * 
     * @param type     the kind of accessory that the customer would like
     * @param quantity the amount of the accessory added to the cart
     * @throws FileNotFoundException checks there is a file for determinePrice()
     */
    public Accessory(String type, int quantity) throws FileNotFoundException {
        this.type = type;
        this.quantity = quantity;
        this.price = determinePrice(type, quantity);
    }

    /**
     * This constructor is for any action taken on an item that is not in the
     * customers cart.
     * 
     * @param type the kind of accessory that the customer would like
     * @throws FileNotFoundException checks there is a file for determinePrice()
     */
    public Accessory(String type) throws FileNotFoundException {
        this.type = type;
    }

    /**
     * This is a clone constructor.
     * 
     * @param src class being copied
     * @throws FileNotFoundException checks if there is a file
     */
    public Accessory(Accessory src) throws FileNotFoundException {
        this.type = src.type;
        this.quantity = src.quantity;
    }

    /**
     * This method gives back the value of price.
     */
    @Override
    public double getPrice() {
        return this.price;
    }

    /**
     * This method gives back the value of quantity.
     */
    @Override
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * This method gives back the value of type.
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * This method will print out a statement saying that the user liked an item
     * and states the value of type.
     */
    @Override
    public void like() {
        System.out.println(
                "You liked " + this.type + " on Liv's Loungewear Website\n");
    }

    /**
     * This method will print the item that the customer is inspecting.
     */
    public void inspectAccessory() {
        System.out.println("The employee takes the " + type + " out of the case for you to take a look.\n");
    }

    /**
     * This method will add a message to the accessory.
     * 
     * @param message the words being engraved
     */
    public void engraveMessage(String message) {
        System.out.println("The message " + message + " is now engraved on " + this.type + "\n");
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
            while (sc.hasNext()) {
                if (sc.next().equals(type)) {
                    temp = sc.nextDouble();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return temp * quantity;
    }

    /**
     * This method will determine what will be printed when the user prints the
     * Top object. Within the print statement, it will include the type,
     * quantity, size, and price.
     */
    public String toString() {
        return "Top: \n"
                + "Type: " + type + "\n"
                + "Quantity: " + quantity + "\n"
                + "Price: " + price + "\n";
    }
    
    /**
     * This will clone this current object.
     */
    public Accessory clone(){
        Accessory a = null;
        try {
            a = new Accessory(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return a;
    }
}
