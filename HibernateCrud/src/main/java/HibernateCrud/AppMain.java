package HibernateCrud;

import org.apache.log4j.Logger;

public class AppMain {
	public final static Logger logger = Logger.getLogger(AppMain.class);

	
	public static void main(String[] args)  {
		logger.info(".......Hibernate Crud Operations Example.......\n");
		 
        logger.info("\n=======CREATE RECORDS=======\n");
		//DbOperations.createRecord();
		//DbOperations.display_recrods();
		//DbOperations.updateRecord(54);
        DbOperations.deleteRecord(56);
        DbOperations.GetDetailsById(61);
	}
}
