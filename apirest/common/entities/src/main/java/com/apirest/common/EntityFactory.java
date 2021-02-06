package com.apirest.common;

import com.apirest.common.entities.Accessories;
import com.apirest.common.entities.AccessoryType;
import com.apirest.common.entities.Brand;
import com.apirest.common.entities.CartShopItem;
import com.apirest.common.entities.Clothes;
import com.apirest.common.entities.ClothesSize;
import com.apirest.common.entities.ClothesType;
import com.apirest.common.entities.Country;
import com.apirest.common.entities.Gender;
import com.apirest.common.entities.Hero;
import com.apirest.common.entities.Inventory;
import com.apirest.common.entities.MaterialType;
import com.apirest.common.entities.Product;
import com.apirest.common.entities.ProductType;
import com.apirest.common.entities.Purchase;
import com.apirest.common.entities.PurchaseDetail;
import com.apirest.common.entities.Toy;
import com.apirest.common.entities.ToyType;
import com.apirest.common.entities.User;
import com.apirest.common.entities.Utensil;
import com.apirest.common.entities.UtensilType;

public class EntityFactory
{
    public static Accessories createAccessories()
    {
        return new Accessories();
    }

    public static AccessoryType createAccessoryTypes()
    {
        return new AccessoryType();
    }

    public static Brand createBrand()
    {
        return new Brand();
    }

    public static Brand createBrand(int id)
    {
        return new Brand(id);
    }

    public static CartShopItem createCartShopItem(){
       return new CartShopItem(  );
    }

    public static Clothes createClothes(){
        return new Clothes(  );
    }

    public static Clothes createClothes(Product product){
        return new Clothes( product );
    }

    public static ClothesType createClothesType(){
        return new ClothesType(  );
    }

    public static ClothesType createClothesType(int id){
        return new ClothesType( id );
    }

    public static ClothesSize createClothesSize(){
        return new ClothesSize(  );
    }

    public static ClothesSize createClothesSize(int id){
        return new ClothesSize( id );
    }

    public static Country createCountry(){
        return new Country(  );
    }

    public static Country createCountry(int id){
        return new Country( id );
    }

    public static Gender createGender(){
        return new Gender(  );
    }

    public static Gender createGender(int id){
        return new Gender( id );
    }

    public static Hero createHero(){
        return new Hero(  );
    }

    public static Hero createHero(int id){
        return new Hero( id );
    }

    public static Inventory createInventory(){
        return new Inventory(  );
    }

    public static MaterialType createMaterialType(){
        return new MaterialType(  );
    }

    public static MaterialType createMaterialType(int id){
        return new MaterialType( id );
    }

    public static Product createProduct(){
        return new Product(  );
    }

    public static ProductType createProductType(){
        return new ProductType(  );
    }

    public static ProductType createProductType(int id){
        return new ProductType( id );
    }

    public static Purchase createPurchase(){
        return new Purchase(  );
    }

    public static PurchaseDetail createPurchaseDetail(){
        return new PurchaseDetail(  );
    }

    public static Toy createToy(){
        return new Toy(  );
    }

    public static ToyType createToyType(){
        return new ToyType(  );
    }

    public static ToyType createToyType(int id){
        return new ToyType( id );
    }

    public static User createUser()
    {
        return new User();
    }

    public static Utensil createUtensil(){
        return new Utensil(  );
    }

    public static UtensilType createUtensilType(){
        return new UtensilType(  );
    }

    public static UtensilType createUtensilType(int id){
        return new UtensilType( id );
    }
}
