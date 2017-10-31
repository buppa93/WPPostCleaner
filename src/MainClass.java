/**
 * PJDCC - Summary for class responsabilities.
 *
 * @author john doe <jdoe@myorg.com>
 * @since 1.2
 * @version 1.8 Changes done
 */
import java.sql.SQLException;
import java.util.Iterator;

import database.DatabaseConnectionException;
import database.DbEngine;
import interfaces.WPPostInterface;
import interfaces.WPPostMetaInterface;
import interfaces.WPUserInterface;
import interfaces.WPUserMetaInterface;
import interfaces.WriteWPPostException;
import interfaces.WriteWPPostMetaException;
import interfaces.WriteWPUserException;
import interfaces.WriteWPUserMetaException;
import keyboard.Keyboard;
import model.WPPost;
import model.WPPostMeta;
import model.WPUser;
import model.WPUserMeta;

/**
 * @author giuseppe
 *
 */
public class MainClass 
{
	protected static int wpUsersLength;
	protected static int wpUserMetaLength;
	protected static int wpPostLength;
	protected static int wpPostMetaLength;
	protected static int wpUsersCopyLength;
	protected static int wpUserMetaCopyLength;
	protected static int wpPostCopyLength;
	protected static int wpPostMetaCopyLength;
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
				//e.printStackTrace(); //TODO Debug mode... Remove this.
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
				//e.printStackTrace(); //TODO Debug mode... Remove this.
				System.out.println("Fatal error: Failed to estabilish the connection with the destination database.");
				System.exit(1);
			}
			
			// Reading from wp_users
			System.out.println("Reading records from table wp_users...");
			WPUserInterface srcUserInterface = new WPUserInterface(new WPUser(), srcDbEngine.getConnection());
			try 
			{
				srcUserInterface.readTable();
				
				if(srcUserInterface.getReadValues().isEmpty())
				{
					System.out.println("Pay Attention!: No records have been read from the table wp_users.");
					wpUsersLength = 0;
				}
				else
				{
					System.out.println("Read " + srcUserInterface.getReadValues().size()
							+ " records from table wp_users.");
					
					wpUsersLength = srcUserInterface.getReadValues().size();
					
					System.out.println("Do you want to list the records? (y/n)");
					String choose = Keyboard.readString();
					
					Iterator<WPUser> itr = srcUserInterface.getReadValues().iterator();
					
					if(choose.equalsIgnoreCase("y"))
					{
						int i = 1;
						while(itr.hasNext())
						{
							WPUser usr = itr.next();
							System.out.println(i + "--> " + usr.toString());
							i++;
						}
					}
					
					//Writing wp_users
					System.out.println("Writing to wp_users...");
					WPUserInterface dstUserInterface = new WPUserInterface(new WPUser(), destDbEngine.getConnection());
					
					dstUserInterface.setReadValues(srcUserInterface.getReadValues());
					dstUserInterface.writeTable();
					wpUsersCopyLength = dstUserInterface.getRowsWithErrors().size();
				}
			} 
			catch (SQLException e) 
			{
				//e.printStackTrace(); //TODO Debug mode... Remove this.
				System.out.println("Error: Failed to read the origin users table.");
			}
			
			
			
			//Reading wp_usermeta
			System.out.println("Reading records from table wp_usermeta...");
			WPUserMetaInterface wpUserMeta = new WPUserMetaInterface(new WPUserMeta(), srcDbEngine.getConnection());
			try 
			{
				wpUserMeta.readTable();
				
				if(wpUserMeta.getReadValues().isEmpty())
				{
					System.out.println("Pay Attention!: No records have been read from the table wp_usermeta.");
					wpUserMetaLength = 0;
				}
				else
				{
					System.out.println("Read " + wpUserMeta.getReadValues().size()
							+ " records from table wp_usermeta.");
					
					wpUserMetaLength = wpUserMeta.getReadValues().size();
					
					System.out.println("Do you want to list the records? (y/n)");
					String choose = Keyboard.readString();
					
					Iterator<WPUserMeta> itr = wpUserMeta.getReadValues().iterator();
					
					if(choose.equalsIgnoreCase("y"))
					{
						int i = 1;
						while(itr.hasNext())
						{
							WPUserMeta usrMeta = itr.next();
							System.out.println(i + "--> " + usrMeta.toString());
							i++;
						}
					}
					
					//Writing wp_users
					System.out.println("Writing to wp_usermeta...");
					WPUserMetaInterface dstUserMetaInterface = 
							new WPUserMetaInterface(new WPUserMeta(), destDbEngine.getConnection());
					
					dstUserMetaInterface.setReadValues(wpUserMeta.getReadValues());
					dstUserMetaInterface.writeTable();
					wpUserMetaCopyLength = dstUserMetaInterface.getRowsWithErrors().size();
				}
			} 
			catch (SQLException e) 
			{
				//e.printStackTrace(); //TODO Debug mode... Remove this.
				System.out.println("Error: Failed to read the origin wp_usermeta table.");
			}
			
			//Reading wp_posts
			System.out.println("Reading records from table wp_posts...");
			WPPostInterface wpPost = new WPPostInterface(new WPPost(), srcDbEngine.getConnection());
			
			try 
			{
				wpPost.readTable();
				
				if(wpPost.getReadValues().isEmpty())
				{
					System.out.println("Pay Attention!: No records have been read from the table wp_posts.");
					wpPostLength = 0;
				}
				else
				{
					System.out.println("Read " + wpPost.getReadValues().size()
							+ " records from table wp_posts.");
					
					wpPostLength = wpPost.getReadValues().size();
					
					System.out.println("Do you want to list the records? (y/n)");
					String choose = Keyboard.readString();
					
					Iterator<WPPost> itr = wpPost.getReadValues().iterator();
					
					if(choose.equalsIgnoreCase("y"))
					{
						int i = 1;
						while(itr.hasNext())
						{
							WPPost post = itr.next();
							System.out.println(i + "--> " + post.toString());
							i++;
						}
					}
					
					//Writing wp_posts
					System.out.println("Writing to wp_posts...");
					WPPostInterface dstPostInterface = new WPPostInterface(new WPPost(), destDbEngine.getConnection());
					
					dstPostInterface.setReadValues(wpPost.getReadValues());
					dstPostInterface.writeTable();
					wpPostCopyLength = dstPostInterface.getRowsWithErrors().size();
					
				}
			} 
			catch (SQLException e) 
			{
				//e.printStackTrace(); //TODO Debug mode... Remove this.
				System.out.println("Error: Failed to read the origin wp_posts table.");
			}
			
			//Reading wp_postmeta
			System.out.println("Reading records from table wp_postmeta...");
			WPPostMetaInterface wpPostMeta = new WPPostMetaInterface(new WPPostMeta(), srcDbEngine.getConnection());
			
			try 
			{
				wpPostMeta.readTable();

				if(wpPostMeta.getReadValues().isEmpty())
				{
					System.out.println("Pay Attention!: No records have been read from the table wp_postmeta.");
					wpPostMetaLength = 0;
				}
				else
				{
					System.out.println("Read " + wpPostMeta.getReadValues().size()
							+ " records from table wp_postmeta.");
					
					wpPostMetaLength = wpPostMeta.getReadValues().size();
					
					System.out.println("Do you want to list the records? (y/n)");
					String choose = Keyboard.readString();
					
					Iterator<WPPostMeta> itr = wpPostMeta.getReadValues().iterator();
					
					if(choose.equalsIgnoreCase("y"))
					{
						int i = 1;
						while(itr.hasNext())
						{
							WPPostMeta postMeta = itr.next();
							System.out.println(i + "--> " + postMeta.toString());
							i++;
						}
					}
					
					//Writing wp_postmeta
					System.out.println("Writing to wp_postmeta...");
					WPPostMetaInterface dstPostMetaInterface = 
							new WPPostMetaInterface(new WPPostMeta(), destDbEngine.getConnection());
					
					dstPostMetaInterface.setReadValues(wpPostMeta.getReadValues());
					dstPostMetaInterface.writeTable();
					wpPostMetaCopyLength = dstPostMetaInterface.getRowsWithErrors().size();
				}
			} 
			catch (SQLException e) 
			{
				//e.printStackTrace(); //TODO Debug mode... Remove this.
				System.out.println("Error: Failed to read the origin wp_postmeta table.");
			}
			
			summaryReport();
		}
	}
	
	private static void summaryReport() 
	{
		System.out.println("---------------------- Summary Report ----------------------");
		System.out.println("Read " + wpUsersLength + " records from wp_users table");
		System.out.println("Read " + wpUserMetaLength + "records from wp_usermeta table");
		System.out.println("Read " + wpPostLength + "records from wp_posts table");
		System.out.println("Read " + wpPostMetaLength + "records from wp_postmeta table");
		System.out.println("--------------------- Write Report");
		if(wpUsersCopyLength == 0)
		{
			System.out.println("Write " + wpUsersLength + " records of " + wpUsersLength + " in table wp_users");
		}
		else
		{
			int errors = wpUsersLength - wpUsersCopyLength;
			System.out.println("Write " + errors + " records of " + wpUsersLength + " in table wp_users");
		}
		
		if(wpUserMetaCopyLength == 0)
		{
			System.out.println("Write " + wpUserMetaLength + " records of " + wpUserMetaLength 
					+ " in table wp_usermeta");
		}
		else
		{
			int errors = wpUserMetaLength - wpUserMetaCopyLength;
			System.out.println("Write " + errors + " records of " + wpUserMetaLength 
					+ " in table wp_usermeta");
		}
		
		if(wpPostCopyLength == 0)
		{
			System.out.println("Write " + wpPostLength + " records of " + wpPostLength + " in table wp_posts");
		}
		else
		{
			int errors = wpPostLength - wpPostCopyLength;
			System.out.println("Write " + errors + " records of " + wpPostLength + " in table wp_posts");
		}
		
		if(wpPostMetaCopyLength == 0)
		{
			System.out.println("Write " + wpPostMetaLength + " records of " + wpPostMetaLength 
					+ " in table wp_postmeta");
		}
		else
		{
			int errors = wpPostMetaLength - wpPostMetaCopyLength;
			System.out.println("Write " + errors + " records of " + wpPostMetaLength 
					+ " in table wp_postmeta");
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
