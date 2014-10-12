import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class ConectorCliente {
	
	
	Socket cliente;
	int puerto=9000;
	String ip="127.0.0.1";
	BufferedReader entrada, teclado;
	PrintStream salida;
	
	public void inici(){
		try{
			
			cliente=new Socket(ip,puerto);
			entrada=new BufferedReader (new InputStreamReader(cliente.getInputStream()));
			teclado=new BufferedReader (new InputStreamReader(System.in));
			
			String input, msg;
			do{
				
			input=teclado.readLine();
			salida=new PrintStream(cliente.getOutputStream());
			salida.println(input);
			msg=entrada.readLine();
			System.out.println(msg);
			
			}while(!input.equalsIgnoreCase("exit") && !msg.equalsIgnoreCase("exit"));
			
		}catch(Exception e){
			System.out.println("error");
		}
	}
	

}
