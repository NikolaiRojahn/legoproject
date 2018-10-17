/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

/**
 *
 * @author nr
 */
public class CreateOrderException extends Exception {

    public CreateOrderException() {
    }

    public CreateOrderException(String string) {
        super(string);
    }

    public CreateOrderException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public CreateOrderException(Throwable thrwbl) {
        super(thrwbl);
    }
    
    
}
