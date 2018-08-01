package exceptions;

public class UserCouldNotLogIn extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserCouldNotLogIn (String s)
	{
		super(s);
	}
}
