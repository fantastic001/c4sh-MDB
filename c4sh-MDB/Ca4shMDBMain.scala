
package org.lugons.c4sh

object C4shMDBMain {
	
	def main(args: Array[String]) { 
		while (!InputHandler.end) 
		{
			InputHandler.process();
		}
	}
}
