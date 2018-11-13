/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductMaintenance.business;

import java.util.ArrayList;

/**
 *
 * @author eric
 */
public interface ProductReader {
    Product getProduct(String code);
    ArrayList<Product> getProducts();
    String getProductsString();
}
