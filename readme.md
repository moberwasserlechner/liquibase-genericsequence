liquibase-genericsequence
=========================

Generic Sequence brings Hibernate's SequenceStyleGenerator to Liquibase

# Purpose
The main purpose of the genericSequence extension is to be able to use Hibernate’s SequenceStyleGenerator as a database-independent way of creating IDs for tables.

For more details please read the according section in the user guide, which might be found at 5.1.5. Enhanced identifier generators

Right now the extension supports

* CreateGenericSequence
* DropGenericSequence

# How it works
Depending on the used database the extension checks if sequences are supported or not. In the first case a sequence is used in the other case a table.

## Usage
You can use this extension as a child element in your changeSets.

Example:
```xml
<databaseChangeLog
    xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:ext="http://www.liquibase.org/xml/ns/dbchangelog-ext"
    xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-2.0.xsd
    http://www.liquibase.org/xml/ns/dbchangelog-ext http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-ext.xsd">
 
  <changeSet id="create_data_language" author="michael">
    <ext:createGenericSequence sequenceName="SQ_DATA_LANGUAGE" incrementBy="1" startValue="10000"/>
 
    <createTable tableName="DATA_LANGUAGE" remarks="This table stores the data language definitions.">
      <column name="ID" type="NUMBER(10)">
        <constraints primaryKeyName="PK_DATA_LANGUAGE" primaryKey="true"/>
      </column>
      <column name="ISO_CODE" type="VARCHAR(10)" >
        <constraints nullable="false" unique="true"/>
      </column>
    </createTable>
  </changeSet>
</databaseChangeLog>


See the schema file at for details.


