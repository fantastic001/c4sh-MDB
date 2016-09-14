
package org.lugons.c4sh;

import java.util.Date;

object InputHandler {
	
	var database : Database = new MemoryDatabase();
	var end = false; 

	def process() : Unit = {
		println(">> ");
		var line = Console.readLine();
		var commands = line.split(" +");
		var operation : Array[String] => Unit = commands(0) match 
		{
			case "register" => register
			case "verify" => verify
			case "list-tickets" => listTickets
			case "list-types" => listTypes
			case "get" => getTicket
			case "add-type" => addType
			case "quit" => quit
		};
		operation(commands);
	}
	
	
	
	def quit(commands : Array[String]) : Unit = 
	{
		end = true; 
	}
	def addType(commands : Array[String]) : Unit = 
	{
		database.addType(commands(1));
	}

	def register(commands : Array[String]) : Unit = {
		database.registerTicket(database.getType(commands(1)));
	}
	def verify(commands : Array[String]) : Unit = {
		database.verify(database.getTicket(commands(1).toInt));
	}
	def listTickets(commands : Array[String]) : Unit = {
		var tickets = database.listTickets();
		for (ticket <- tickets) 
		{
			println(ticket.id + "\t" + ticket.ticketType.name + "\t" + ticket.registrationDate.toString());
		}
	}
	def listTypes(commands : Array[String]) : Unit = {
		var types = database.listTypes();
		for (ticketType <- types) 
		{
			println(ticketType.id + "\t" + ticketType.name + "\n");
		}
	}
	def getTicket(commands : Array[String]) : Unit = {
		var ticket = database.getTicket(commands(1).toInt);
		println(ticket.id + "\t" + ticket.ticketType.name + "\t" + ticket.registrationDate.toString() + "\t" + ticket.verificationDate.toString() + "\n");
	}
}
