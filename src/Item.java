
/**
 * This interface is implemented by all classes that are classified as items
 * within the store. These methods that are being implemented are for the
 * FrontEnd class to gather information about each item and create a receipt
 * with it.
 * 
 * @author Olivia Mellen
 *
 */
public interface Item {

    /**
     * This method will take the value of the instance variable price and return
     * it. This will be important so that the customer will know how much an
     * item is and add the price to their total.
     * 
     * @return the price of an item
     */
    public double getPrice();

    /**
     * This method will take the value of the instance variable quantity and
     * return it. This will determine the price of the item and added to the
     * receipt.
     * 
     * @return the number of items the customer is buying
     */
    public int getQuantity();

    /**
     * This method will take the value of the instance variable type and return
     * it. This will be added to the customer's final receipt.
     * 
     * @return the type of item that the customer is buying
     */
    public String getType();

    /**
     * This method is called when the user wants to "like" an item on the
     * store's website.
     */
    public void like();
}
