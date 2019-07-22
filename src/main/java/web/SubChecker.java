package web;

public class SubChecker implements OperationPossibilityChecker{

    @Override
    public boolean isPossible(Integer aCols, Integer aRows, Integer bCols, Integer bRows) {
        return (aCols != null) && (bCols != null) && (aRows != null) && (bRows != null) &&
                ((aCols.equals(bCols) && aRows.equals(bRows)));
        String k = "create table USERS\n" +
                "(\n" +
                "  USERNAME             NVARCHAR2(40) not null\n" +
                "    primary key,\n" +
                "  PASSWORD           NVARCHAR2(100) not null\n" +
                ");" +
                "INSERT INTO USERS\n" +
                "(USERNAME,PASSWORD)\n" +
                "VALUES  ('admin', '$2a$10$5a6vv3yJZuAbpUSU04vAce2d6MACeDHJeDspyulKzbR2.tAu5W2Tm');\n" +
                "create table USERROLES\n" +
                "(\n" +
                "  ID int auto_increment primary key, \n" +
                "  USERNAME             NVARCHAR2(40) not null,\n" +
                "  ROLE           NVARCHAR2(40) not null\n" +
                "); " +
                "INSERT INTO USERROLES\n" +
                "(USERNAME,ROLE)\n" +
                "VALUES  ('admin', 'ROLE_ADMIN');\n" +
                "INSERT INTO USERROLES\n" +
                "(USERNAME,ROLE)\n" +
                "VALUES  ('admin', 'ROLE_SUM_SUB');\n" +
                "INSERT INTO USERROLES\n" +
                "(USERNAME,ROLE)\n" +
                "VALUES  ('admin', 'ROLE_USER');\n" +
                "INSERT INTO USERROLES\n" +
                "(USERNAME,ROLE)\n" +
                "VALUES  ('admin', 'ROLE_MATH');\n" +
                "create table BINARYOPERATION\n" +
                "(\n" +
                "  ID             NVARCHAR2(40) not null\n" +
                "    primary key,\n" +
                "  OPERATIONKIND           NVARCHAR2(40),\n" +
                "  FIRSTOPERAND   CLOB,\n" +
                "  SECONDOPERAND CLOB,\n" +
                "  ANSWER         CLOB,\n" +
                "  IDSESSION      NVARCHAR2(40),\n" +
                "  TIME           TIMESTAMP(6)\n" +
                ");" +
                "create table SINGLEOPERATION\n" +
                "(\n" +
                "  ID           NVARCHAR2(40) not null\n" +
                "    primary key,\n" +
                "  OPERATIONKIND         NVARCHAR2(40),\n" +
                "  FIRSTOPERAND CLOB,\n" +
                "  ANSWER       CLOB,\n" +
                "  IDSESSION    NVARCHAR2(40),\n" +
                "  TIME         TIMESTAMP(6)\n" +
                ");" +
                "create table CONSTANTS\n" +
                "(\n" +
                "  KEY            NVARCHAR2(40) default NULL not null\n" +
                "    primary key,\n" +
                "  VALUE  CLOB" +
                ");" +
                "create table SESSIONS\n" +
                "(\n" +
                "  ID        NVARCHAR2(40) default NULL not null\n" +
                "    primary key,\n" +
                "  IP        NVARCHAR2(25),\n" +
                "  TIMESTART TIMESTAMP,\n" +
                "  TIMEEND   TIMESTAMP\n" +
                ");"
    }
}
