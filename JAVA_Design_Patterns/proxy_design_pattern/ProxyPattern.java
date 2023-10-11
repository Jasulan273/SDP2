//Interface DatabaseExecuter defines a method for executing database queries.
interface DatabaseExecuter {
	void executeDatabase(String query) throws Exception;
}

//Concrete implementation of DatabaseExecuter interface.
class DatabaseExecuterImpl implements DatabaseExecuter {
	@Override
	public void executeDatabase(String query) throws Exception {
		System.out.println("Going to execute Query: " + query);
	}
}

//DatabaseExecuterProx acts as a proxy to control access to the real database executer.
class DatabaseExecuterProxy implements DatabaseExecuter {
	boolean ifAdmin;
	DatabaseExecuterImpl dbExecuter;

	public DatabaseExecuterProxy(String name, String passwd) {
		//Check if the user has admin privileges.
		if (name.equals("Admin") && passwd.equals("Admin@123")) {
			ifAdmin = true;
		}
		dbExecuter = new DatabaseExecuterImpl();
	}

	@Override
	public void executeDatabase(String query) throws Exception {
		if (ifAdmin) {
			// If the user is an admin, execute the query directly.
			dbExecuter.executeDatabase(query);
		} else {
			// If the user is not an admin, restrict certain queries (e.g., DELETE).
			if (query.equals("DELETE")) {
				throw new Exception("DELETE not allowed for non-admin user");
			} else {
				//Execute other queries for non-admin users.
				dbExecuter.executeDatabase(query);
			}
		}
	}
}

//Main class demonstrating the Proxy Pattern.
public class ProxyPattern {
	public static void main(String[] args) throws Exception {
		//Create a non-admin user proxy with incorrect query
		DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuter.executeDatabase("DELEE");

		//Create a non-admin user proxy with a DELETE query (should throw an exception)
		DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuterDELETE.executeDatabase("DELETE");

		//Create an admin user proxy to execute a DELETE query
		DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
		adminExecuter.executeDatabase("DELETE");
	}
}
