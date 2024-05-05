package com.example.routes

import com.example.models.Order
import com.example.models.orderStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.listOrdersRoute() {
  get("order") {
    if (orderStorage.isNotEmpty()) {
      call.respond(orderStorage)
    } else {
      call.respondText("No orders found", status = HttpStatusCode.OK)
    }
  }
}

fun Route.getOrderRoute() {
  get("/order/{id?}") {
    val order = getOrderById(call) ?: return@get call.respondText(
      "Order not found",
      status = HttpStatusCode.NotFound
    )

    call.respond(order)
  }
}

fun Route.totalizeOrderRoute() {
  get("order/{id?}/total") {
    val order = getOrderById(call) ?: return@get call.respondText(
      "Order not found",
      status = HttpStatusCode.NotFound
    )
    val total = order.contents.sumOf { it.price * it.amount }

    call.respond(total)
  }
}

fun getOrderById(call: ApplicationCall): Order? {
  val id = call.parameters["id"] ?: return null
  val order = orderStorage.find { it.number == id } ?: return null

  return order
}

