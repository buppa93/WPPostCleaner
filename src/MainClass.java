import java.sql.SQLException;
import java.util.Iterator;

import database.DatabaseConnectionException;
import database.DbEngine;
import interfaces.WPUserInterface;
import model.WPUser;

/**
 * @author giuseppe
 *
 */
public class MainClass 
{

	//example command WPPostsCloner -o host:port/dbname -d host:port/dbname
	//url example: host:port/dbname
	/**
	 * @param args
	 * @throws BadCommandException 
	 * @throws BadUrlException 
	 */
	public static void main(String[] args) throws BadCommandException, BadUrlException 
	{
		int argsLen = args.length;
		String srcDb = "";
		String destDb = "";
		String srcPass = "";
		String destPass = "";
		String srcUser = "";
		String destUser = "";
		
		args = new String[4];
		/***** Debug input ****/
		args[0] = "-o";
		args[1] = "localhost:3306/test_src";
		args[2] = "-d";
		args[3] = "localhost:3306/test_dest";
		argsLen = args.length;
		
		if(argsLen < 4)
		{
			System.out.println("Args len OK");
			try
			{
				throw new BadCommandException("You have an error in the arguments sintax");
			}
			catch(BadCommandException e)
			{
				e.toString();
				System.exit(1);
			}
		}
		else
		{
			for(int i=0; i<4; i++)
			{
				System.out.println("for -> " + i + "arg -> " + args[i]);
				switch(args[i])
				{
					case "-o":
						srcDb = args[i+1];
						if(!isUrlValid(srcDb))
						{
							try
							{
								throw new BadUrlException("You have an error in the origin url sintax");
							}
							catch(BadUrlException e)
							{
								e.toString();
								System.exit(1);
							}
						}
						break;
						
					case "-d":
						destDb = args[i+1];
						if(!isUrlValid(destDb))
						{
							try
							{
								throw new BadUrlException("You have an error in the destination url sintax");
							}
							catch(BadUrlException e)
							{
								e.toString();
								System.exit(1);
							}
						}
				}
			}
			
			/*
			System.out.print("Insert the origin database user: ");
			srcUser = Keyboard.readString();
			System.out.print("\nInsert the origin database password: ");
			srcPass = Keyboard.readString();
			
			System.out.print("\n\nInsert the destination database user: ");
			destUser = Keyboard.readString();
			System.out.print("\nInsert the destination database password: ");
			destPass = Keyboard.readString();
			*/
			
			srcUser = "root";
			srcPass = "180993";
			destUser = "root";
			destPass = "180993";
			DbEngine srcDbEngine = new DbEngine();
			try 
			{
				srcDbEngine.initConnection(srcDb, srcUser, srcPass);
			} 
			catch (DatabaseConnectionException e) 
			{
				e.printStackTrace();
				System.out.println("Fatal error: Failed to estabilish the connection with the origin database.");
				System.exit(1);
			}
			
			DbEngine destDbEngine = new DbEngine();
			try
			{
				destDbEngine.initConnection(destDb, destUser, destPass);
			}
			catch(DatabaseConnectionException e)
			{
				e.printStackTrace();
				System.out.println("Fatal error: Failed to estabilish the connection with the destination database.");
				System.exit(1);
			}
			
			WPUserInterface srcUserInterface = new WPUserInterface(new WPUser(), srcDbEngine.getConnection());
			try 
			{
				srcUserInterface.readTable();
				Iterator<WPUser> itr = srcUserInterface.getReadValues().iterator();
				
				while(itr.hasNext())
				{
					WPUser usr = itr.next();
					System.out.println(usr.toString());
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				System.out.println("Error: Failed to read the origin users table.");
			}
		}
	}
	
	public static boolean isUrlValid(String url)
	{
		if(url.contains(":") && url.contains("/"))
			return true;
		else
			return false;
	}

}
