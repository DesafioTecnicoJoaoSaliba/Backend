#!/bin/bash

# Wait for SQL Server to start
sleep 30s

# Run the SQL script
/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P SqlServer2019! -i /scripts/init-database.sql
