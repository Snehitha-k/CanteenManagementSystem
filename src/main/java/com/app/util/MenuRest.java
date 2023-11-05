package com.app.util;

import javax.ws.rs.GET;
//import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;

import com.app.factory.MenuFactory;
import com.app.model.Menu;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/menu")
public class MenuRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Menu[] listMenu() {
    final Menu[] menu = MenuFactory.showMenu();
    return menu;
  }
  /**
   * to get a particular food item details.
   * @param pid for vendorId
   * @return menu object
   */
  @GET
  @Path("{pid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Menu showProductDetails(@PathParam("pid") final int pid) {
    Menu m = MenuFactory.showProduct(pid);
    if (m == null) {
      throw new NotFoundException("Menu item with ID: " + pid + " not found!");
    }
    return m;
  }
  /**
   * to update product price.
   * @param pid for Product id.
   * @param vid for Vendor id.
   * @param price for new price.
   * @return string
   */
  @PUT
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/price/{pid}/{vid}/{price}")
  public final String updateProductPrice(@PathParam("pid") final int pid, @PathParam("vid") final int vid,
      @PathParam("price") final double price) {
    Menu m = new Menu();
    String res = m.updateProductPrice(pid, vid, price);
    return res;
  }
}
