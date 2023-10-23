import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is a subclass of Clothing. This is specifically for tops like tank
 * tops, longs sleeve shirts, etc. Tops has three methods and three more methods
 * that can be used from the Clothing class.
 * 
 * @author Olivia Mellen
 *
 */
public class Top extends Clothing {
    private String embroidery = "";

    /**
     * This will be the main constructor that is used when a customer wants to
     * add to their cart or do any action to an object within their cart.
     * 
     * @param type     the kind of shirt, ex: tank top
     * @param size     size shirt from XS to XL
     * @param quantity how many of the item the customer is buying
     * @throws FileNotFoundException checks there is a file for determinePrice()
     */
    public Top(String type, String size, int quantity)
            throws FileNotFoundException {
        super(type, size, quantity);
    }

    /**
     * This constructor is for any action taken on an item that is not in the
     * customers cart. For example: the user can write a review for an item they
     * saw in the store.
     * 
     * @param type the kind of shirt, ex: tank top
     * @throws FileNotFoundException checks there is a file for determinePrice()
     */
    public Top(String type) throws FileNotFoundException {
        super(type);
    }

    /**
     * This is a clone constructor.
     * 
     * @param src class being copied
     * @throws FileNotFoundException checks if there is a file
     */
    public Top(Top src) throws FileNotFoundException {
        super(src.type, src.size, src.quantity);
    }

    /**
     * This will fold a shirt in the customer's cart. Make sure to keep your
     * tops organized!
     */
    public void foldTop() {
        System.out.println(super.type + " is now folded");
    }

    /**
     * This method will add a message to the top of the customer's choice. The
     * print statements will vary depending on if the customer already
     * embroidered the shirt before.
     * 
     * @param message the text the customer would like on their top
     */
    public void embroiderTop(String message) {
        if (embroidery.length() > 0) {
            System.out.println("You changed the embroidery on " + this.type
                    + " from '" + this.embroidery + "' to '" + message + "'");
        } else {
            System.out.println("You added '" + message + "' on " + this.type);
        }
        embroidery = message;
    }

    /**
     * This method will determine what will be printed when the user prints the
     * Top object. Within the print statement, it will include the type,
     * quantity, size, and price.
     */
    public String toString() {
        return "Top: \n"
                + "Type: " + super.type + "\n"
                + "Quantity: " + super.quantity + "\n"
                + "Size: " + super.size + "\n"
                + "Price: " + super.price + "\n";
    }

    /**
     * This will clone this current object.
     */
    public Top clone(){
        Top t = null;
        try {
            t = new Top(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }
}
