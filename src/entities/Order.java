package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entites.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Clients client;
	
	private List<OrderItem> orderItem  =  new ArrayList<>();
	
	
	public Order() {
			
	}


	public Order(Date moment, OrderStatus status, Clients client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}


	public Date getOrder() {
		return moment;
	}


	public void setOrder(Date moment) {
		this.moment = moment;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public Clients getClient() {
		return client;
	}


	public void setClient(Clients client) {
		this.client = client;
	}


	public List<OrderItem> getOrderItem() {
		return orderItem;
	}	
	
	
	public void addItem(OrderItem orderItem) {
		this.orderItem.add(orderItem);
		
	}
	
	public void removeItem(OrderItem orderItem) {
		this.orderItem.remove(orderItem);
	}
	
	public double total() {
		double sum = 0.0;
		for ( OrderItem o : orderItem) {
			sum += o.subTotal();
			
		}
		
		return sum;
	}


	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
 		sb.append("Order moment: ");
 		sb.append(sdf.format(moment) + "\n");
 		sb.append("Order status: ");
 		sb.append(status + "\n");
 		sb.append("Client: ");
 		sb.append(client + "\n");
 		sb.append("Order items:\n");
 		
 		for (OrderItem item : orderItem) {
 			sb.append(item + "\n");
 		}
 		sb.append("Total price: $");
 		sb.append(String.format("%.2f", total()));
 		return sb.toString();
 		
			
		}
	}
	
	
	
	

