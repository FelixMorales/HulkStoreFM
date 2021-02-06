package com.apirest.persistence;

import com.apirest.persistence.dao.AccessoryTypeDAO;
import com.apirest.persistence.dao.BrandDAO;
import com.apirest.persistence.dao.CartShopItemDAO;
import com.apirest.persistence.dao.ClothesDAO;
import com.apirest.persistence.dao.ClothesSizeDAO;
import com.apirest.persistence.dao.ClothesTypeDAO;
import com.apirest.persistence.dao.CountryDAO;
import com.apirest.persistence.dao.GenderDAO;
import com.apirest.persistence.dao.HeroDAO;
import com.apirest.persistence.dao.InventoryDAO;
import com.apirest.persistence.dao.MaterialTypeDAO;
import com.apirest.persistence.dao.ProductDAO;
import com.apirest.persistence.dao.ProductTypeDAO;
import com.apirest.persistence.dao.ToyTypeDAO;
import com.apirest.persistence.dao.UserDAO;
import com.apirest.persistence.dao.UtensilTypeDAO;

public class DAOFactory
{
    public static AccessoryTypeDAO createAccessoryTypeDAO(DBHandler handler)
    {
        return new AccessoryTypeDAO( handler );
    }

    public static BrandDAO createBrandDAO(DBHandler handler)
    {
        return new BrandDAO( handler );
    }

    public static ClothesDAO createClothesDAO(DBHandler handler)
    {
        return new ClothesDAO( handler );
    }

    public static ClothesSizeDAO createClothesSizeDAOO(DBHandler handler)
    {
        return new ClothesSizeDAO( handler );
    }

    public static ClothesTypeDAO createClothesTypeDAO(DBHandler handler)
    {
        return new ClothesTypeDAO( handler );
    }

    public static CountryDAO createCountryDAO(DBHandler handler)
    {
        return new CountryDAO( handler );
    }

    public static GenderDAO createGenderDAO(DBHandler handler)
    {
        return new GenderDAO( handler );
    }

    public static HeroDAO createHeroDAO(DBHandler handler)
    {
        return new HeroDAO( handler );
    }

    public static MaterialTypeDAO createMaterialTypeDAO(DBHandler handler)
    {
        return new MaterialTypeDAO( handler );
    }

    public static ProductDAO createProductDAO(DBHandler handler)
    {
        return new ProductDAO( handler );
    }

    public static ProductTypeDAO createProductTypeDAO(DBHandler handler)
    {
        return new ProductTypeDAO( handler );
    }

    public static ToyTypeDAO createToyTypeDAO(DBHandler handler)
    {
        return new ToyTypeDAO( handler );
    }

    public static UserDAO createUserDAO(DBHandler handler)
    {
        return new UserDAO( handler );
    }

    public static UtensilTypeDAO createUtensilTypeDAO(DBHandler handler)
    {
        return new UtensilTypeDAO( handler );
    }

    public static InventoryDAO createInventoryDAO(DBHandler handler)
    {
        return new InventoryDAO( handler );
    }

    public static CartShopItemDAO createCartShopItemDAO(DBHandler handler)
    {
        return new CartShopItemDAO( handler );
    }
}
