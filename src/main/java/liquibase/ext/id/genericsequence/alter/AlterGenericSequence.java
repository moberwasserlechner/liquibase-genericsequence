package liquibase.ext.id.genericsequence.alter;

import liquibase.change.AbstractChange;
import liquibase.database.Database;
import liquibase.statement.SqlStatement;

public class AlterGenericSequence extends AbstractChange {
	
	// rename
	// set new start point
	// set new increment number
	// just rename but no changes on current count
	// - there fore a select statement is needed
	

  public AlterGenericSequence() {
    super("alterGenericSequence", "Alter GenericSequence", 15);
  }

	@Override
	public SqlStatement[] generateStatements(Database arg0) {
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConfirmationMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
