
package org.lugons.c4sh; 

import java.util.Date; 
class MemoryDatabase extends Database 
{
	var tickets : Array[Ticket] = new Array[Ticket](0);
	var types : Array[TicketType] = new Array[TicketType](0);

	
	def addType(name : String) : Unit = 
	{
		types = types :+ new TicketType(types.length, name);
	}

	def registerTicket(ticketType : TicketType) : Unit = 
	{
		tickets = tickets :+ new Ticket(tickets.length, ticketType, new Date(), false, null);
	}
	def listTickets() : Array[Ticket] = 
	{
		return tickets; 
	}
	def listTypes() : Array[TicketType] = 
	{
		return types; 
	}
	def verify(ticket : Ticket) : Unit = 
	{
		for (id <- 0 to (tickets.length - 1)) 
		{
			if (tickets(id).id == ticket.id) 
			{
				tickets(id).verified = true; 
				tickets(id).verificationDate = new Date();;
			}
		}
	}
	def getTicket(id : Int) : Ticket = 
	{
		var ticket : Ticket = null;
		for (t : Ticket <- tickets) 
		{
			if (t.id == id) 
			{
				ticket = t; 
			}
		}
		return ticket;
	}
	def getType(id : Int) : TicketType = 
	{
		var ticket_type : TicketType = null;
		for (t : TicketType <- types) 
		{
			if (t.id == id) 
			{
				ticket_type = t;
			}
		}
		return ticket_type;
	}
	
	def getType(name : String) : TicketType = 
	{
		var ticket_type : TicketType = null; 
		for (t : TicketType <- types) 
		{
			if (t.name == name) 
			{
				ticket_type = t; 
			}
		}
		return ticket_type; 
	}
}
