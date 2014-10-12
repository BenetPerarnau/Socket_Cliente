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
			System.out.println("Conectat al servidor (127.0.0.1:9000)");
			//salida=new PrintStream(cliente.getOutputStream());
			String input="", msg="";
			do{
				if(!msg.equalsIgnoreCase("exit")){
					System.out.print("Client => ");	
					input=teclado.readLine();
					
					
						salida=new PrintStream(cliente.getOutputStream());
						salida.println(input);
					if(!input.equalsIgnoreCase("exit")){
						msg=entrada.readLine();
						System.out.println(msg);
					}else{
						System.out.println("Has desconectat la sesio");
					}
				}else{
					System.out.println("El servidor a tancat la sesio");
				}
			
			}while(!input.equalsIgnoreCase("exit") && !msg.equalsIgnoreCase("exit"));
			
		}catch(Exception e){
			System.out.println("El servidor no esta operatiu");
		}
	}
	

}
