
package org.lugons.c4sh;

trait Database {

	def registerTicket(ticketType : TicketType) : Unit; 
	def listTickets() : Array[Ticket];
	def listTypes() : Array[TicketType];
	def verify(ticket : Ticket) : Unit;
	def getTicket(id : Int) : Ticket; 
	def getType(id : Int) : TicketType;
	def getType(name : String) : TicketType;
	def addType(name : String) : Unit; 

}
