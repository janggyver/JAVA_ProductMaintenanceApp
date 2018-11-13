/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductMaintenance.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eric
 */
public class ProductTextFile implements ProductDAO {

    private ArrayList<Product> products = null;
    private Path productsPath = null;
    private File productsFile = null;
    
    private final String FIELD_SEP = "\t";
    
    public ProductTextFile(){
        productsPath = Paths.get("products.txt");
        productsFile = productsPath.toFile();
        products = this.getProducts();
    }
    
    @Override
    public boolean addProduct(Product p) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        products.add(p);
        return this.saveProducts();
        
    }

    @Override
    public boolean updateProduct(Product newProduct) {
        //get the old product and remove it
        Product oldProduct = this.getProduct(newProduct.getCode());
        int i = products.indexOf(oldProduct);
        products.remove(i);
        
        //add the updated product
        products.add(i, newProduct);
        return this.saveProducts();
    }

    @Override
    public boolean deleteProduct(Product p) {
        products.remove(p);
        return this.saveProducts();
    }

    @Override
    public Product getProduct(String code) {
        for(Product p : products){
            if(p.getCode().equals(code)){
                return p;
            }
        }
        return null;
    }
    @Override
    public boolean saveProducts(){
        try(PrintWriter out = new PrintWriter(
                new BufferedWriter(
                new FileWriter(productsFile)))){
            //write all products in the array list to the file
            for(Product p : products){
                out.print(p.getCode() + FIELD_SEP);
                out.print(p.getDescription()+ FIELD_SEP);
                out.print(p.getPrice() + "\r\n");
            }
        }
        catch(IOException e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    @Override
    public ArrayList<Product> getProducts(){
        //if the products file has already been read, don't read it again
        if(products != null){
            return products;
        }
        products = new ArrayList<>();
        if(Files.exists(productsPath)){ // prevent the FileNotFoundException
            try(BufferedReader in =
                    new BufferedReader(
                    new FileReader(productsFile)))
            {
                //read all products stored in the file into the array list
                String line = in.readLine();
                while(line != null){
                    String[] columns = line.split(FIELD_SEP);
                    String code = columns[0];
                    String description = columns[1];
                    String price = columns[2];
                    
                    Product p = new Product(
                    code, description, Double.parseDouble(price));
                    
                    products.add(p);
                    line = in.readLine();
                }
            }
             catch (IOException ex) {
                System.out.println(ex);
                return null;
            }
            
        }
        return products;
    }

    
    @Override
    public String getProductsString() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return null;
    }
    
}
