
package org.lugons.c4sh

import java.util.Date; 

class Ticket (val m_id : Int, val m_tickettype : TicketType, val m_registrationdate : Date, val m_verified : Boolean, val m_verificationdate : Date){
	var id = m_id;
	var ticketType = m_tickettype; 
	var registrationDate = m_registrationdate; 
	var verified = m_verified; 
	var verificationDate = m_verificationdate;
}
