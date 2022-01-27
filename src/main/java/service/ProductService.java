package service;

import model.Product;

import java.util.ArrayList;

public class ProductService {
    private static final ArrayList<Product> products;
    private static final ArrayList<Product> items ;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "AK-47", 1000, 10, "Gun"));
        products.add(new Product(2, "MP-5", 899, 10, "Gun"));
        products.add(new Product(3, "BARRET-M99", 599, 10, "Gun"));
        products.add(new Product(4, "GLOCK", 699, 10, "Gun"));
        products.add(new Product(5, "DESERT EAGLE", 799, 10, "Gun"));
        items = new ArrayList<>();
    }
    public ArrayList<Product> getCartItems(){
        return items;
    }
    public ArrayList<Product> getProducts(){
        return products;
    }
    public Product getProduct(int id){
        for (Product p : products) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }
    public ArrayList<Product> sortByPriceUp(){
        products.sort((o1, o2) -> {
            if (o1.getPrice() > o2.getPrice()) return 1;
            else if (o1.getPrice() < o2.getPrice()) return -1;
            else return 0;
        });
        return products;
    }
    public ArrayList<Product> sortByPriceDown(){
        products.sort((o1, o2) -> {
            if (o1.getPrice() < o2.getPrice()) return 1;
            else if (o1.getPrice() > o2.getPrice()) return -1;
            else return 0;
        });
        return products;
    }
    public void addToCart(int id){
        for (Product p : products) {
            if (p.getId() == id){
                items.add(p);
                p.setQuantity(p.getQuantity() + 1);
            }
        }
    }
    public void removeFromCart(int id){
        Product product = null;
        for (Product p : products) {
            if (p.getId() == id){
                product = p;
            }
        }
        if (product != null){
            items.remove(product);
        }
    }
    public double payForCart(){
        double total = 0;
        for (Product p : items) {
            total += (p.getPrice() * p.getQuantity());
            items.remove(p);
        }
        return total;
    }
}
