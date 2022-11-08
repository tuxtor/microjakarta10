package com.vorozco.microjakarta10.resources;

import com.vorozco.microjakarta10.model.Order;
import com.vorozco.microjakarta10.repository.OrderRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("order")
@Produces("application/json")
@Consumes("application/json")
public class OrderResource {

    @Inject
    OrderRepository orderRepository;

    //List all
    @GET
    public List<Order> listAll() {
        return orderRepository.listAll();
    }

    //Get by id
    @GET
    @Path("{id}")
    public Order getOrder(@PathParam("id") Long id) {
        return orderRepository.read(id);
    }

    //Create
    @POST
    public Order createOrder(Order order) {
        orderRepository.create(order);
        return order;
    }

    //Update
    @PUT
    @Path("{id}")
    public Response updateOrder(@PathParam("id") Long id, Order order) {
        if(id.equals(order.getOrderNo())) {
            orderRepository.update(order);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    //Delete
    @DELETE
    @Path("{id}")
    public Response deleteOrder(@PathParam("id") Long id) {
        if(orderRepository.read(id) != null) {
            orderRepository.delete(id);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
