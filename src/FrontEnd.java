import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the front end class. This class is where everything comes together
 * and creates different actions for our customers to do. It will allow for
 * customers to try item on or write a review and many more. the customer will
 * be able to add to their cart (an ArrayList) different items. This class will
 * ask for the name of the item, size (depending on the type of item), and
 * quantity. When the customer is done with their shopping, they may checkout.
 * This class will put together a receipt of all the items including the price
 * of each and total price.
 * 
 * @author Olivia Mellen
 *
 */
public class FrontEnd {
    static Scanner sc = new Scanner(System.in);

    // An ArrayList with the items the customer wants to purchase
    private static ArrayList<Object> cart = new ArrayList<Object>();

    // This message will display each time the system is ran in order to greet
    // the customer
    private static final String WELCOME = "Welcome to Liv's Loungewear! "
            + " We have a large assortment of items including\n"
            + "many different tops, bottoms, and accessories to choose from.";

    // This is the menu that is seen to give the customers options of what to do
    private static final String MENU = "1. Display Tops\n"
            + "2. Display Bottoms\n"
            + "3. Display Accessories\n"
            + "4. Add an item to cart\n"
            + "5. Checkout\n"
            + "\nType the number that you would like to do: ";

    // When a customer chooses to display tops, this message will appear
    // giving the customer a new list of options that they can do
    private static final String TOP_MENU = "     1. Leave a like\n"
            + "     2. Leave a Review\n"
            + "     3. Fold Top\n"
            + "     4. Embroyder Top\n"
            + "     5. Try on a Top\n"
            + "     6. Go back to main menu\n"
            + "Type the number you would like to do: ";

    // When a customer chooses to display bottoms, this message will appear
    // giving the customer a new list of options that they can do
    private static final String BOTTOM_MENU = "     1. Leave a like\n"
            + "     2. Leave a Review\n"
            + "     3. Fold Bottoms\n"
            + "     4. Try on Bottoms\n"
            + "     5. Cuff a pair of Bottoms\n"
            + "     6. Go back to main menu\n"
            + "Type the number you would like to do: ";

    // When a customer chooses to display accessories, this message will appear
    // giving the customer a new list of options that they can do
    private static final String ACCESSORY_MENU = "     1. Leave a like\n"
            + "     2. Take a closer look at an item\n"
            + "     3. Engrave a word\n"
            + "     4. Go back to main menu\n"    
            + "Type the number you would like to do: ";

    // this is a simple string that is used to asked the user for a message
    private static final String INPUT_NAME = "What item would you like to do this action with? ";

    // These strings will be added onto a present every item in the store
    // based on the category they are in
    private static String TOP_DISPLAY = "Top Collection:\n";
    private static String BOTTOM_DISPLAY = "Bottom Collection\n";
    private static String ACCESSORY_DISPLAY = "Accessory Collection:\n";

    // When the customer is finished, they will see this printed into the
    // console
    // including the items they purchased
    private static String RECEIPT = "____________________________\n"
            + "      Liv's Loungewear\n"
            + "           Receipt\n"
            + "      -----------------\n"
            + "\n";

    /**
     * This method will scan through the store_inventory.txt file and add items
     * to the three display variables above.
     * 
     * @throws FileNotFoundException checks there is a file
     */
    public static void getItemsFromFile() throws FileNotFoundException {
        try (Scanner file = new Scanner(new File("store_inventory.txt"))) {
            while (file.hasNextLine()) {
                String[] row = file.nextLine().split(" ");
                String itemCatagory = row[0];
                String itemName = row[1];

                switch (itemCatagory) {
                case "Top":
                    TOP_DISPLAY += "     " + itemName + "\n";
                    break;
                case "Bottom":
                    BOTTOM_DISPLAY += "     " + itemName + "\n";
                    break;
                case "Accessory":
                    ACCESSORY_DISPLAY += "     " + itemName + "\n";
                    break;
                default:
                    System.out.println("Invalid Item");
                    break;
                }
            }
        }
    }

    /**
     * This method will print a statement asking for user input and will return
     * that input back to the methods it is used in.
     * 
     * @param sc a scanner
     * @return a string of the message a user inputs
     */
    public static String getMessage() {
        System.out.println("What is your word you want to add? ");
        String message = sc.next();
        return message;
    }

    /**
     * This method will print the tops from the TOP_DISPLAY variable before then
     * printing the menu for tops. It will then call another method that will
     * determine what to do depending on what the user inputs.
     * 
     * @throws FileNotFoundException checks if there is a file
     */
    public static void displayTops() throws FileNotFoundException {
        System.out.println(TOP_DISPLAY);

        Top t = null;
        System.out.println(TOP_MENU);
        int input = sc.nextInt();
        if (input == 6) {
            return;
        }
        topAction(t, input);

    }

    /**
     * This method will go through the different options that the user may input
     * into the top menu. it will do correlating act that specifically the Top
     * class has incorporated.
     * 
     * @param sc    a scanner
     * @param t     a prewritten Top class
     * @param input what number the user inputed from the menu
     * @throws FileNotFoundException checks if there is a file
     */
    private static void topAction(Top t, int input)
            throws FileNotFoundException {
        System.out.println(INPUT_NAME);
        t = new Top(sc.next());

        switch (input) {
        case 1:
            t.like();
            break;
        case 2:
            String message = getMessage();
            t.writeReview(message);
            break;
        case 3:
            t.foldTop();
            break;
        case 4:
            String embroyder = getMessage();
            t.embroiderTop(embroyder);
            break;
        case 5:
            t.tryOn();
            break;
        default:
            System.out.println("Invalid Option");
        }

    }

    /**
     * This method will print the bottoms from the BOTTOM_DISPLAY variable
     * before then printing the menu for bottoms. It will then call another
     * method that will determine what to do depending on what the user inputs.
     * 
     * @throws FileNotFoundException checks if there is a file
     */
    public static void displayBottoms() throws FileNotFoundException {
        System.out.println(BOTTOM_DISPLAY);

        Bottom b = null;
        System.out.println(BOTTOM_MENU);
        int input = sc.nextInt();
        if (input == 6) {
            return;
        }
        bottomAction(b, input);

    }

    /**
     * This method will go through the different options that the user may input
     * into the bottom menu. it will do correlating act that specifically the
     * Bottom class has incorporated.
     * 
     * @param sc    a scanner
     * @param t     a prewritten Bottom class
     * @param input what number the user inputed from the menu
     * @throws FileNotFoundException checks if there is a file
     */
    private static void bottomAction(Bottom b, int input)
            throws FileNotFoundException {
        System.out.println(INPUT_NAME);
        String itemInput = sc.next();
        b = new Bottom(itemInput);

        switch (input) {
        case 1:
            b.like();
            break;
        case 2:
            String message = getMessage();
            b.writeReview(message);
            break;
        case 3:
            b.foldBottom();
            break;
        case 4:
            b.tryOn();
            break;
        case 5:
            b.cuffPants();
            break;
        default:
            System.out.println("Invalid Option");
        }

    }

    /**
     * This method will print the bottoms from the ACCESSORY_DISPLAY variable
     * before then printing the menu for bottoms. It will then call another
     * method that will determine what to do depending on what the user inputs.
     * 
     * @throws FileNotFoundException checks if there is a file
     */
    public static void displayAccessory() throws FileNotFoundException {
        System.out.println(ACCESSORY_DISPLAY);
        Accessory a = null;
        System.out.println(ACCESSORY_MENU);
        int input = sc.nextInt();
        if (input == 4) {
            return;
        }
        accessoryAction(a, input);

    }

    /**
     * This method will go through the different options that the user may input
     * into the accessory menu. it will do correlating act that specifically the
     * Accessory class has incorporated.
     * 
     * @param sc    a scanner
     * @param t     a prewritten Accessory class
     * @param input what number the user inputed from the menu
     * @throws FileNotFoundException checks if there is a file
     */
    private static void accessoryAction(Accessory a, int input)
            throws FileNotFoundException {
        System.out.println(INPUT_NAME);
        String itemInput = sc.next();
        a = new Accessory(itemInput);

        switch (input) {
        case 1:
            a.like();
            break;
        case 2:
            a.inspectAccessory();
            break;
        case 3:
            String word = getMessage();
            a.engraveMessage(word);
            break;
        default:
            System.out.println("Invalid Option");
        }

    }

    /**
     * When a user would like to add an item to their cart, this method will ask
     * what type of item and verify that it is the store's inventory. Once done,
     * it will send this information to the addCart() method.
     * 
     * @throws FileNotFoundException checks there is a file
     */
    public static void createItem() throws FileNotFoundException {
        System.out
                .println("What item would you like to add to your cart? "
                        + "(Please write in same format above)");
        String item = sc.next();
        String category = "";
        boolean correctInput = false;
        try (Scanner fileScanner = new Scanner(
                new File("store_inventory.txt"))) {

            while (fileScanner.hasNextLine()) {
                String[] row = fileScanner.nextLine().split(" ");
                if (row[1].equals(item)) {
                    category = row[0];
                    correctInput = true;
                }
            }
        }
        if (correctInput) {
            addToCart(category, item);
        }
    }

    /**
     * this method will allow a user to add to their cart. it ask for extra
     * information about the item and then add that to an array. Each time it is
     * creating an object and using the inputed data as parameters.
     * 
     * @param category whether the item is a top, bottom, or accessory
     * @param type     the kind of item
     * @param sc       a scanner
     * @throws FileNotFoundException checks there is a file
     */
    public static void addToCart(String category, String type)
            throws FileNotFoundException {
        String size = "";
        int quantity = 0;
        System.out.println("How many would you like? ");
        quantity = sc.nextInt();
        if (category.equals("Top") || category.equals("Bottom")) {
            System.out.println("What size would you like(XS - XL)? ");
            size = sc.next();
        }

        switch (category) {
        case "Top":
            cart.add(new Top(type, size, quantity));
            break;
        case "Bottom":
            cart.add(new Bottom(type, size, quantity));
            break;
        case "Accessory":
            cart.add(new Accessory(type, quantity));
            break;
        default:
            System.out.println("Can't create item");
        }

    }

    /**
     * This method will create a receipt that will include a all the items as
     * well as their price. It will also total up the prices and let the user
     * know of their final price.
     */
    public static void createReceipt() {
        double total = 0;
        for (int i = 0; (i < cart.size()); i++) {
            Object temp = cart.get(i);
            if (temp instanceof Accessory) {
                RECEIPT += ((Accessory) temp).getQuantity()
                        + "  " + ((Accessory) temp).getType()
                        + "\t\t$" + ((Accessory) temp).getPrice() + "\n";
                total += ((Accessory) temp).getPrice();
            } else if (temp instanceof Top) {
                RECEIPT += ((Top) temp).getQuantity()
                        + "  " + ((Top) temp).getType()
                        + "\t$" + ((Top) temp).getPrice() + "\n";
                total += ((Top) temp).getPrice();
            } else {
                RECEIPT += ((Bottom) temp).getQuantity()
                        + "  " + ((Bottom) temp).getType()
                        + "\t$" + ((Bottom) temp).getPrice() + "\n";
                total += ((Bottom) temp).getPrice();
            }
        }
        RECEIPT += "\t\tTotal = $" + total;
        System.out.print(RECEIPT);
    }

    /**
     * This method will create the original menu that a user will see when they
     * first run the program. They will also see this menu display when they are
     * finished with any other menus.
     * 
     * @param sc a scanner
     * @throws FileNotFoundException checks there is a file
     */
    public static void createMenu() throws FileNotFoundException {
        do {
            System.out.println(MENU);
            final int input = sc.nextInt();
            switch (input) {
            case 1:
                displayTops();
                break;
            case 2:
                displayBottoms();
                break;
            case 3:
                displayAccessory();
                break;
            case 4:
                createItem();
                break;
            case 5:
                createReceipt();
                return;
            default:
                System.out.println("Did not recognize option");
            }
        } while (true);
    }

    /**
     * This is the main method of the FrontEnd class.
     * 
     * @param args args array
     * @throws FileNotFoundException checks there is a file
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(WELCOME);
        getItemsFromFile();
        createMenu();

    }

}
