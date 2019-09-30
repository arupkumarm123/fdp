curl -XPOST  http://localhost:8060/fi-service/fi -v -d '{ "name" : "icicbank" , "address" :"mumbai" , "intMethod" : "PROVIDED" , "authType" : "OAUTH" }' -H "Content-Type: application/json" | jq "."
 curl  -XPOST http://localhost:8060/fi-service/fi/4/endpoints -v -d '{"name" : "fi" , "desc" : "fi integration" , "fiID" : 4}' -H "Content-Type: application/json" | jq "."
 curl  -XPOST http://localhost:8060/fi-service/fi/4/endpoints/link -v -d '{ "endPointType" : "LINK" , "type" : "API" , "serviceDef" : {"url" : "http://localhost:9010/account" , "method" : "POST" } }' -H "Content-Type: application/json" | jq "."
 curl  -XPOST http://localhost:8060/fi-service/fi/4/endpoints/transaction -v -d '{ "endPointType" : "TRANSACTION" , "type" : "API" , "serviceDef" : {"url" : "http://localhost:9010/transaction" , "method" : "POST" } }' -H "Content-Type: application/json" | jq "."
 #curl  -XPOST http://localhost:8060/fi-service/account/4 -v -d '{"customerID" : 4 , "bankID" : 4 , "accountNumber" : 4001 , "accountType" : "SAVINGS" }' -H "Content-Type: application/json" | jq "."
 #curl  -XPOST http://localhost:8060/fi-service/transaction/4 -v -d '{"accountID" : 4 , "id": "cred-1",  "bankID" : 4 , "accountID" : 4001 , "amount" : 4000 , "type" : "CREDIT" }' -H "Content-Type: application/json" | jq "."

 curl  -XPOST http://localhost:8060/fi-service/fi/4/metadata -v -d '{ "fiID" : 4 , "objectType" : "Account" , "fields" : {"custID" : "customerID", "acctNumber" : "accountNumber", "acctType": "accountType" } }' -H "Content-Type: application/json" | jq "."
curl  -XPOST http://localhost:8060/fi-service/fi/4/metadata -v -d '{ "fiID" : 4 , "objectType" : "Transaction" , "fields" : {"type" : "type", "transactionDate" : "transactionDate" , "id" : "id" , "accID": "accountID", "bankID" : "bankID"} }' -H "Content-Type: application/json" | jq "."