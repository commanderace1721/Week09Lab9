package dataaccess;

/**
 *
 * @author Group CCC
 */
public class InventoryDBException extends Exception{

    /**
     * @author Haithem Khelif 
     * @version 1.0
     * @since 10-27-2020
     * @param message Takes a string and displays it as an error
     */
    public InventoryDBException(String message){
        super(message);
    }
}
