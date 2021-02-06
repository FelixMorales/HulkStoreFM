package com.apirest.logic.commands;

import com.apirest.common.entities.CartShopItem;
import com.apirest.common.entities.Clothes;
import com.apirest.common.entities.Inventory;
import com.apirest.common.entities.User;
import com.apirest.logic.commands.cartShopItem.AddCartShopItemCommand;
import com.apirest.logic.commands.cartShopItem.GetCartShopItemsByUser;
import com.apirest.logic.commands.inventory.atomic.SupplyInventoryCommand;
import com.apirest.logic.commands.product.atomic.AddClothesCommand;
import com.apirest.logic.commands.user.atomic.AddUserClientCommand;
import com.apirest.logic.commands.user.atomic.AuthenticateUserCommand;

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

    public static AddCartShopItemCommand createAddCartShopItemCommand( CartShopItem item )
    {
        return new AddCartShopItemCommand( item );
    }

    public static GetCartShopItemsByUser createGetCartShopItemsByUser( User user )
    {
        return new GetCartShopItemsByUser( user );
    }
}
