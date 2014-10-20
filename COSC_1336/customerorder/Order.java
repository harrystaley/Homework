/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package customerorder;

/**
 *
 * @author staleyh
 */
public class Order {
        private final int orderNum;
    private final double orderAmount;
    private final double orderDiscount;

    public Order(int orderNumber, double orderAmt,
        double orderDisc)
    {
    orderNum = orderNumber;
    orderAmount = orderAmt;
    orderDiscount = orderDisc;
    }
    public int getOrderAmount()
    {
        return orderAmount;
    }
    public int getOrderDisc()
    {
        return orderDisc;
}
