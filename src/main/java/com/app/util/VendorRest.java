package com.app.util;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.app.factory.VendorFactory;
import com.app.model.Vendor;
/**
 *provides restservices for vendor.
 */
@Path("/vendors")
public class VendorRest {
  /**
   * to get a particular vendor details.
   * @param id for vendorId
   * @return vendor object
   */
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Vendor findVendorById(@PathParam("id") final int id) {
    Vendor v = VendorFactory.findById(id);

    if (v == null) {
      throw new NotFoundException("Vendor with ID: " + id + " not found!");
    }

    return v;
  }
  /**
   * to add a new Vendor.
   * @param pass for password
   * @param name for name
   * @param phone for phone
   * @param email for email
   * @return string
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/addnew/{pass}/{name}/{phone}/{email}")
  public final String registerVendor(@PathParam("pass") final String pass, @PathParam("name") final String name,
      @PathParam("phone") final String phone, @PathParam("email") final String email) {
    Vendor v = new Vendor();
    String vendorName = name.replace("_", " ");
    String res = v.registerVendor(pass, vendorName, phone, email);
    return res;
  }

  /**
   * to update phone number.
   * @param id for Vendor id
   * @param ph for new phone number
   * @return string
   */
  @PUT
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/phone/{id}/{ph}")
  public final String updatePhone(@PathParam("id") final int id, @PathParam("ph") final String ph) {
    Vendor v = new Vendor();
    String res = v.updatePhone(id, ph);
    return res;
  }

  /**
   * to update the password.
   * @param id for Vendor id
   * @param pass for Vendor's new password
   * @return string
   */
  @PUT
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/password/{id}/{pass}")
  public final String updatePassword(@PathParam("id") final int id, @PathParam("pass") final String pass) {
    Vendor v = new Vendor();
    String res = v.updatePassword(id, pass);
    return res;
  }
  /**
   * to accept or deny Order.
   * @param oId Order id
   * @param stat Status
   * @param amt Amount
   * @return string
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/acceptdeny/{OId}/{stat}/{amt}")
  public final String acceptDenyOrder(@PathParam("OId") final int oId, @PathParam("stat") final String stat,
      @PathParam("amt") final double amt) {
    Vendor v = new Vendor();
    String msg = v.acceptDenyOrder(oId, stat, amt);
    return msg;
  }
}
