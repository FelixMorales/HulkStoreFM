package com.apirest.logic.commands;

import com.apirest.common.entities.Product;
import com.apirest.common.entities.Purchase;
import com.apirest.common.entities.ShopCartItem;
import com.apirest.common.entities.Inventory;
import com.apirest.common.entities.User;
import com.apirest.logic.commands.inventory.atomic.GetAllAvailableStockCommand;
import com.apirest.logic.commands.inventory.atomic.GetAvailableProductStockCommand;
import com.apirest.logic.commands.inventory.atomic.GetInventoryStockCommand;
import com.apirest.logic.commands.product.atomic.AddProductCommand;
import com.apirest.logic.commands.product.atomic.GetProductsCommand;
import com.apirest.logic.commands.purchase.atomic.AddPurchaseCommand;
import com.apirest.logic.commands.purchase.composite.ExecutePurchaseCommand;
import com.apirest.logic.commands.purchase.composite.GeneratePurchaseDetailCommand;
import com.apirest.logic.commands.shopCartItem.AddShopCartItemCommand;
import com.apirest.logic.commands.shopCartItem.ClearShopCartItemsUserCommand;
import com.apirest.logic.commands.shopCartItem.GetShopCartItemsByUserCommand;
import com.apirest.logic.commands.inventory.atomic.SupplyInventoryCommand;
import com.apirest.logic.commands.user.atomic.AddUserClientCommand;
import com.apirest.logic.commands.user.atomic.AuthenticateUserCommand;
import com.apirest.persistence.DBHandler;

public class CommandFactory
{
    public static AddUserClientCommand createAddUserClientCommand( User user )
    {
        return new AddUserClientCommand( user );
    }

    public static AuthenticateUserCommand createAuthenticateUserCommand( User user )
    {
        return new AuthenticateUserCommand( user );
    }

    public static AddProductCommand createAddProductCommand( Product product )
    {
        return new AddProductCommand( product );
    }

    public static SupplyInventoryCommand createSupplyInventoryCommand( Inventory inventoryItem )
    {
        return new SupplyInventoryCommand( inventoryItem );
    }

    public static AddShopCartItemCommand createAddShopCartItemCommand( ShopCartItem item )
    {
        return new AddShopCartItemCommand( item );
    }

    public static GetShopCartItemsByUserCommand createGetShopCartItemsByUserCommand( User user )
    {
        return new GetShopCartItemsByUserCommand( user );
    }

    public static GetShopCartItemsByUserCommand createGetShopCartItemsByUserCommand( User user, DBHandler handler )
    {
        return new GetShopCartItemsByUserCommand( user, handler );
    }

    public static GeneratePurchaseDetailCommand createGeneratePurchaseDetailCommand( User user )
    {
        return new GeneratePurchaseDetailCommand( user );
    }

    public static GeneratePurchaseDetailCommand createGeneratePurchaseDetailCommand( User user, DBHandler handler )
    {
        return new GeneratePurchaseDetailCommand( user, handler );
    }

    public static ExecutePurchaseCommand createExecutePurchaseCommand( Purchase purchase )
    {
        return new ExecutePurchaseCommand( purchase );
    }

    public static ClearShopCartItemsUserCommand createClearShopCartItemsUserCommand( User user, DBHandler handler )
    {
        return new ClearShopCartItemsUserCommand( user, handler );
    }

    public static GetAvailableProductStockCommand createGetAvailableProductStockCommand( Product product, DBHandler handler )
    {
        return new GetAvailableProductStockCommand( product, handler );
    }

    public static GetInventoryStockCommand createGetInventoryStockCommand( Inventory inventory, DBHandler handler )
    {
        return new GetInventoryStockCommand( inventory, handler );
    }

    public static GetInventoryStockCommand createGetInventoryStockCommand( Inventory inventory )
    {
        return new GetInventoryStockCommand( inventory );
    }

    public static AddPurchaseCommand createAddPurchaseCommand( Purchase purchase, DBHandler handler )
    {
        return new AddPurchaseCommand( purchase, handler );
    }

    public static GetAllAvailableStockCommand createGetAllAvailableStockCommand( )
    {
        return new GetAllAvailableStockCommand( );
    }

    public static GetAvailableProductStockCommand createGetAvailableProductStockCommand( Product product )
    {
        return new GetAvailableProductStockCommand( product );
    }

    public static GetProductsCommand createGetProductsCommand( )
    {
        return new GetProductsCommand( );
    }
}
