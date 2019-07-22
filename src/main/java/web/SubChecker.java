package web;

public class SubChecker implements OperationPossibilityChecker{

    @Override
    public boolean isPossible(Integer aCols, Integer aRows, Integer bCols, Integer bRows) {
        return (aCols != null) && (bCols != null) && (aRows != null) && (bRows != null) &&
                ((aCols.equals(bCols) && aRows.equals(bRows)));

    }
}



//
//    SELECT DISTINCT *
//        FROM USER_OBJECTS;
//
//
//        SELECT DISTINCT OBJECT_TYPE
//        FROM USER_OBJECTS;
//
//        SELECT DISTINCT OBJECT_NAME
//        FROM USER_OBJECTS
//        WHERE OBJECT_TYPE = 'TABLE';
//
//        SELECT table_name, column_name, data_type, data_length
//        FROM USER_TAB_COLUMNS;
//
//
//        SELECT *
//        FROM ALL_IND_COLUMNS
//        WHERE INDEX_OWNER = 'INTERNSHIP';
//
//        SELECT DISTINCT INDEX_TYPE FROM ALL_INDEXES;
//
//        SELECT uind.*
//        FROM USER_CONSTRAINTS constr
//        RIGHT JOIN USER_INDEXES uind on constr.INDEX_NAME=uind.INDEX_NAME
//        WHERE constr.CONSTRAINT_TYPE = 'P' ;
//
//        select *
//        FROM USER_CONSTRAINTS constr
//        where constr.INDEX_NAME in (select INDEX_NAME from USER_INDEXES) and constr.CONSTRAINT_TYPE = 'P';
//
//        explain plan for select *
//        FROM USER_INDEXES uind
//        where uind.INDEX_NAME in (select INDEX_NAME from USER_CONSTRAINTS where CONSTRAINT_TYPE = 'P');
//
//
//
//
//
//        create table USERS
//        (
//        USERNAME             NVARCHAR2(40) not null
//        primary key,
//        PASSWORD           NVARCHAR2(100) not null
//        );
//        INSERT INTO USERS
//        (USERNAME,PASSWORD)
//        VALUES  ('admin', '$2a$10$5a6vv3yJZuAbpUSU04vAce2d6MACeDHJeDspyulKzbR2.tAu5W2Tm');
//        create table USERROLES
//        (
//        ID int primary key,
//        USERNAME             NVARCHAR2(40) not null,
//        ROLE           NVARCHAR2(40) not null
//        );
//        INSERT INTO USERROLES
//        (USERNAME,ROLE)
//        VALUES  ('admin', 'ROLE_ADMIN');
//        INSERT INTO USERROLES
//        (USERNAME,ROLE)
//        VALUES  ('admin', 'ROLE_SUM_SUB');
//        INSERT INTO USERROLES
//        (USERNAME,ROLE)
//        VALUES  ('admin', 'ROLE_USER');
//        INSERT INTO USERROLES
//        (USERNAME,ROLE)
//        VALUES  ('admin', 'ROLE_MATH');
//        create table BINARYOPERATION
//        (
//        ID             NVARCHAR2(40) not null
//        primary key,
//        OPERATIONKIND           NVARCHAR2(40),
//        FIRSTOPERAND   CLOB,
//        SECONDOPERAND CLOB,
//        ANSWER         CLOB,
//        IDSESSION      NVARCHAR2(40),
//        TIME           TIMESTAMP(6)
//        );
//        create table SINGLEOPERATION
//        (
//        ID           NVARCHAR2(40) not null
//        primary key,
//        OPERATIONKIND         NVARCHAR2(40),
//        FIRSTOPERAND CLOB,
//        ANSWER       CLOB,
//        IDSESSION    NVARCHAR2(40),
//        TIME         TIMESTAMP(6)
//        );
//        create table CONSTANTS
//        (
//        KEY            NVARCHAR2(40) default NULL not null
//        primary key,
//        VALUE  CLOB
//        );
//        create table SESSIONS
//        (
//        ID        NVARCHAR2(40) default NULL not null
//        primary key,
//        IP        NVARCHAR2(25),
//        TIMESTART TIMESTAMP,
//        TIMEEND   TIMESTAMP
//        );
