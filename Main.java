import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ShoppingCart> products = new ArrayList<ShoppingCart>();
        products.add(new ShoppingCart("Leather wallet", 1100, 18, 1));
        products.add(new ShoppingCart("Umbrella", 900, 12, 4));
        products.add(new ShoppingCart("Cigarette", 200, 28, 3));
        products.add(new ShoppingCart("Honey", 100, 0, 2));

        double mgst = 0;
        String mgstProduct = "";
        for(ShoppingCart item : products){
            double gst = item.GST();
            double price = item.UnitPrice();
            double cgst = (gst * price) / 100;
            if (cgst > mgst)
            {
                mgst = cgst;
                mgstProduct = item.ProductName();
                }
        }
        System.out.println("Product with maximum GST amount: " + mgstProduct);
        double totalAmount = 0;
        double discount = 0;
        for(ShoppingCart item : products){
            double unitPrice = item.UnitPrice();
            int quantity = item.Qty();
            if (unitPrice >= 500){
                discount = (unitPrice * 5) / 100;
            }
            double gstAmount = (unitPrice * item.GST()) / 100;
            totalAmount += ((unitPrice - discount + gstAmount) * quantity);
        }
        System.out.println("Total amount to be paid "+totalAmount);
    }
private String _productName;
private double _unitPrice;
private double _gst;
private int _qty;
        
        public void productName(String name)
        {
            this._productName = name;
        }
        public String ProductName(){
            return _productName;
        }
        public double UnitPrice(){
            return _unitPrice;
        }
        public double GST(){
            return _gst;
        }
        public int Qty(){
            return _qty;
        }
    }    



