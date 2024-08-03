/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**

The ProductTypes class represents a product type with an ID and a type name.

This class provides methods to access and modify the ID and type attributes.

It also overrides the toString() method to provide a string representation of the ProductTypes object.

@author Dunxing Yu
*/
public class ProductTypes {
    private String type;

    /**

    Constructs a new ProductTypes instance with default values for ID and type.
    */
    public ProductTypes() {
    }
    /**

    Constructs a new ProductTypes instance with the specified ID and type.
    @param id The unique identifier of the product type.
    @param type The name or description of the product type.
    */
    public ProductTypes(int id, String type) {
    this.type = type;
    }


    /**

    Retrieves the type name of the product type.
    @return The type name of the product type.
    */
    public String getType() {
    return type;
    }
    /**

    Sets the type name of the product type.
    @param type The new type name of the product type.
    */
    public void setType(String type) {
    this.type = type;
    }
    /**

    Returns a string representation of the ProductTypes object.
    @return A string representation of the ProductTypes object.
    */
    @Override
    public String toString() {
    return "ProductTypes{type=" + type + '}';
    }
}