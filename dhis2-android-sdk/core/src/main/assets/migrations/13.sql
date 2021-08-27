CREATE TABLE DataInputPeriod (_id INTEGER PRIMARY KEY AUTOINCREMENT, dataSet TEXT NOT NULL, period TEXT NOT NULL, openingDate TEXT, closingDate TEXT, FOREIGN KEY (dataSet) REFERENCES DataSet (uid) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED);