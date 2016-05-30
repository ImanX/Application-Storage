# Application-Storage
simply save and fetch data in Application 

###Example :
 ```Java

        ApplicationStorage defaultStorage = ApplicationStorage.getDefaultStorage(this);                                                  //Use default storage
        //Or
        ApplicationStorage privateStorage = ApplicationStorage.getPrivateStorage(this.getSharedPreferences("MY_APP_STORAGE", MODE_PRIVATE)); //Use custom storage


        /*Put value in private Storage */
        privateStorage.putString(STRING_KEY, "String Value");
        privateStorage.putInt(INTEGER_KEY, 999);
        privateStorage.putBoolean(BOOLEAN_KEY, true);

        /*Get value from private Storage */
        String  valueString  = privateStorage.getString(STRING_KEY);
        boolean valueBoolean = privateStorage.getBoolean(BOOLEAN_KEY);
        int     valueInteger = privateStorage.getInt(INTEGER_KEY);


        /*remove options*/
        privateStorage.removeValue(STRING_KEY);
        privateStorage.removeValues(new String[]{INTEGER_KEY, BOOLEAN_KEY});
        privateStorage.removeValues();

      
 ```
