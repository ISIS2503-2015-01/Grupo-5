import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

public class QuoteServerThread extends Thread
{

	//-----------------------------------------------
	// Atributos
	//-----------------------------------------------
	private int numPuerto; 
	protected DatagramSocket socket  = null;
	protected BufferedReader in = null;
	protected boolean moreQuotes = true;
	
	
	//-----------------------------------------------
	// Constructores
	//-----------------------------------------------
	 public QuoteServerThread(int puerto)
	 {
		 this("QuoteServerThread", puerto);
	 }

	 public QuoteServerThread(String name, int puerto)
	 {
		 super(name);
		 try 
		 {
			socket = new DatagramSocket(puerto);
			in = new BufferedReader(new FileReader(new File("../Data/one-liners.txt")));
		 } 
		 catch (SocketException e)
		 {
			e.printStackTrace();
		} catch (FileNotFoundException e) 
		{
			System.err.println("Could not open quote file. Serving time instead.");
		}
		 
	 }
	
	//-----------------------------------------------
	// Métodos
	//-----------------------------------------------
	
	
	
	public void run()
	{
		while(moreQuotes)
		{
			try
			{
				byte[] buf = new byte[256];
				
				//Recibir solicitud
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				
				//Decidir la respuesta
				String dString = null;
				if (in == null)
					dString =  new Date().toString();
				else
					dString = getNextQuote();
				
				buf = dString.getBytes();
				
				//Envía la respuesta a la dirección y al puerto del cliente
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				packet = new DatagramPacket(buf, buf.length, address, port);
				socket.send(packet);			
			}
			catch (IOException e) 
			{
                e.printStackTrace();
                moreQuotes = false;
            }
		}
		socket.close();
	}
	
	
	protected String getNextQuote()
	{
		String returnValue = null;
		
		try
		{
			if((returnValue = in.readLine()) == null)
			{
				in.close();
				moreQuotes = false;
				returnValue = "No more quotes. Goodbye.";
			}
		}
		catch (IOException e)
		{
			returnValue = "IOException ocurred in server.";
			e.printStackTrace();
		}
		
		return returnValue;
	}
}
