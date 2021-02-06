package com.apirest.logic.commands;

import com.apirest.common.entities.ShopCartItem;
import com.apirest.common.entities.Clothes;
import com.apirest.common.entities.Inventory;
import com.apirest.common.entities.User;
import com.apirest.logic.commands.purchase.composite.GeneratePurchaseDetail;
import com.apirest.logic.commands.shopCartItem.AddShopCartItemCommand;
import com.apirest.logic.commands.shopCartItem.GetShopCartItemsByUser;
import com.apirest.logic.commands.inventory.atomic.SupplyInventoryCommand;
import com.apirest.logic.commands.product.atomic.AddClothesCommand;
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

    public static AddClothesCommand createAddClothesCommand( Clothes clothes )
    {
        return new AddClothesCommand( clothes );
    }

    public static SupplyInventoryCommand createSupplyInventoryCommand( Inventory inventoryItem )
    {
        return new SupplyInventoryCommand( inventoryItem );
    }

    public static AddShopCartItemCommand createAddShopCartItemCommand( ShopCartItem item )
    {
        return new AddShopCartItemCommand( item );
    }

    public static GetShopCartItemsByUser createGetShopCartItemsByUser( User user )
    {
        return new GetShopCartItemsByUser( user );
    }

    public static GetShopCartItemsByUser createGetShopCartItemsByUser( User user, DBHandler handler )
    {
        return new GetShopCartItemsByUser( user, handler );
    }

    public static GeneratePurchaseDetail createGeneratePurchaseDetail( User user )
    {
        return new GeneratePurchaseDetail( user );
    }
}
