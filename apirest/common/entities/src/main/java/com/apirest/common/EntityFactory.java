package com.apirest.common;

import com.apirest.common.entities.Accessories;
import com.apirest.common.entities.AccessoryType;
import com.apirest.common.entities.Brand;
import com.apirest.common.entities.CartShopItems;
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

    public static CartShopItems createCartShopItems(){
       return new CartShopItems(  );
    }

    public static Clothes createClothes(){
        return new Clothes(  );
    }

    public static ClothesType createClothesType(){
        return new ClothesType(  );
    }

    public static ClothesSize createClothesSize(){
        return new ClothesSize(  );
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

    public static Inventory createInventory(){
        return new Inventory(  );
    }

    public static MaterialType createMaterialType(){
        return new MaterialType(  );
    }

    public static Product createProduct(){
        return new Product(  );
    }

    public static ProductType createProductType(){
        return new ProductType(  );
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
}
