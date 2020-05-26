package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entites.enums.OrderStatus;
import entities.Clients;
import entities.Order;
import entities.OrderItem;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date ( DD/MM/YYYY): ");
		Date clientBirthDate = sdf.parse(sc.nextLine());
		
		Clients client = new Clients(clientName, clientEmail, clientBirthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.nextLine());
		
		Order order = new Order(new Date(), orderStatus, client);
		
		
		
				
		System.out.print("How many items to this order? ");
		int items =  sc.nextInt();
		for ( int i = 1; i<= items; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product Price: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			
			order.addItem(orderItem);
			
			
			
				
		}
		
		System.out.println("ORDER SUMMARY:");
		
		System.out.println(order);
		
		
		
		
		sc.close();
	}
}
