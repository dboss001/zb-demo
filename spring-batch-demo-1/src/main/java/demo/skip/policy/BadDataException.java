package demo.skip.policy;

public class BadDataException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Object obj;

	public BadDataException(Object p_obj) {
		obj = p_obj;
	}

    public BadDataException(String message)
    {
       super(message);
    }
    
    public Object getData() {
    	return obj;
    }
}
