package liquibase.ext.id.genericsequence.alter;

import liquibase.change.AbstractChange;
import liquibase.change.core.RenameTableChange;
import liquibase.database.Database;
import liquibase.database.core.OracleDatabase;
import liquibase.statement.SqlStatement;

/**
 * 
 * @author mowl-private
 *
 */
public class RenameGenericSequence extends AbstractChange {
	
	private String schemaName;
	private String oldName;
	private String newName;
	private Boolean forceTableUse = false;
	
	
	public RenameGenericSequence() {
		super("RenameGenericSequence", "Renames the generic sequence.", 15);
	}

	@Override
	public SqlStatement[] generateStatements(Database database) {
		AbstractChange change = null;
		if ((this.forceTableUse != null && this.forceTableUse) 
				|| !database.supportsSequences() 
				|| database.getDatabaseProductName().equals(OracleDatabase.PRODUCT_NAME) // oracle uses the same rename syntax for tables and sequences
	  ) {
			RenameTableChange rtc = new RenameTableChange();
			rtc.setSchemaName(this.schemaName);
			rtc.setOldTableName(this.oldName);
			rtc.setNewTableName(this.newName);
			change = rtc;
		} else {
			// TODO
			if (database.getTypeName().equals("oracle")) {

			}
			// rename sequence not supported by liquibase
		}
		
		return change.generateStatements(database);
	}

	@Override
	public String getConfirmationMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
