import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is a subclass of Clothing. This is specifically for bottoms like
 * jeans, leggings, etc. Bottoms has three methods and three more methods that
 * can be used from the Clothing class.
 * 
 * @author Olivia Melln
 *
 */
public class Bottom extends Clothing {

    // the length of the bottom object, ex: long or short
    private String length;

    /**
     * This will be the main constructor that is used when a customer wants to
     * add to their cart or do any action to an object within their cart.
     * 
     * @param type     the kind of bottom, ex: jeans
     * @param size     pant shirt from XS to XL
     * @param quantity how many of the item the customer is buying
     * @throws FileNotFoundException checks there is a file for determinePrice()
     */
    public Bottom(String type, String size, int quantity)
            throws FileNotFoundException {
        super(type, size, quantity);
        getLength(type);
    }

    /**
     * This constructor is for any action taken on an item that is not in the
     * customers cart. For example: the user can write a review for an item they
     * saw in the store.
     * 
     * @param type the kind of bottoms, ex: jeans
     * @throws FileNotFoundException checks there is a file for determinePrice()
     */
    public Bottom(String type) throws FileNotFoundException {
        super(type);
        getLength(type);
    }
    
    /**
     * This is a clone constructor.
     * 
     * @param src class being copied
     * @throws FileNotFoundException checks if there is a file
     */
    public Bottom(Bottom src) throws FileNotFoundException {
        super(src.type, src.size, src.quantity);
    }

    /**
     * This will fold a pant in the customer's cart. Make sure to keep your tops
     * organized!
     */
    public void foldBottom() {
        System.out.println(super.type + " is now folded\n");
    }

    /**
     * This method will determine if the Bottom object can be cuffed and
     * responds accordingly.
     */
    public void cuffPants() {
        if (length.equals("Full")) {
            System.out.println(super.type + " are now cuffed!\n");
        } else if (length.equals("Short")) {
            System.out.print("We're sorry but the length of " + super.type
                    + " is too short and cannot be cuffed\n");
        } else {
            System.out.println(
                    "Sorry but " + super.type + " is not able to be cuffed :(\n");
        }
    }

    /**
     * This method will scan the store_inventory.txt file and search for the
     * keyword to determine the length of the bottoms: long, short, no-cuff. The
     * purpose of no-cuff is because this method will be used in cuffPants to
     * determine if based on the length of the pants whether the pants can be
     * cuffed or not.
     * 
     * @param type the kind of Bottoms
     * @throws FileNotFoundException checks to make sure that the text file is
     *                               found
     */
    private void getLength(String type) throws FileNotFoundException {
        String temp = "";
        try (Scanner sc = new Scanner(new File("store_inventory.txt"))) {
            
            while (sc.hasNext()) {
                if (sc.next().equals(type)) {
                    double temp1 = super.price;
                    if (sc.nextDouble() * super.quantity == (super.price)) {
                        temp = sc.next();
                    }

                }
            }
            /*
            while (sc.hasNextLine()) {
                String[] row = sc.nextLine().split(" ");
                if (row[1].equals(super.type)) {
                    temp = row[3];
                }
            }
            */
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        length = temp;
    }

    /**
     * This method will determine what will be printed when the user prints the
     * Bottom object. Within the print statement, it will include the type,
     * quantity, size, and price.
     */
    public String toString() {
        return "Bottom: \n"
                + "Type: " + super.type + "\n"
                + "Quantity: " + super.quantity + "\n"
                + "Size: " + super.size + "\n"
                + "Price: " + super.price + "\n";
    }
    
    /**
     * This will clone this current object.
     */
    public Bottom clone(){
        Bottom b = null;
        try {
            b = new Bottom(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return b;
    }

}
