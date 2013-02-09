#Liquibase Generic Sequence
This liquibase extension brings Hibernate's SequenceStyleGenerator to Liquibase. 

## Goal
The main purpose of the generic sequence extension is to be able to use Hibernate’s SequenceStyleGenerator as a database-independent 
way of creating IDs for tables. If your project supports more than on database you will not have to worry whether to use tables or sequences. 
Liquibase knows which databases supports sequences and which do not. Based on this information either a sequence or a table is created. 

For more information see the hibernate user guide, section **5.1.5. Enhanced identifier generators**

## Features
See the schema file at [src/main/resources/liquibase/ext/id/genericsequence/xml/dbchangelog-ext.xsd] for details.

### CreateGenericSequence

#### Example
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
```

### DropGenericSequence
TBD
