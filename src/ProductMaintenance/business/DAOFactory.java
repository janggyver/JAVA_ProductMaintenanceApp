/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductMaintenance.business;

/**
 *
 * @author eric
 */
public class DAOFactory {
    public static ProductDAO getProductDAO(){
        //ProductDAO pDAO = new ProductTextFile();
         ProductDAO pDAO = new ProductXMLFile();
        return pDAO;
    }

}
