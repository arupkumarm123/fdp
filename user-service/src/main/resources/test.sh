curl  -XPOST http://localhost:8060/fi-service/fi/3/metadata -v -d '{ "fiID" : 3 , "objectType" : "Transaction" , "fields" : {"type" : "type", "transactionDate" : "transactionDate" , "id" : "id" , "accountID": "accountID", "bankID" : "bankID"} }' -H "Content-Type: application/json" | jq "."