# trade-reporting-app
Trade Reporting Application for Complus Asset Management.

## Dependencies
1. spring-boot-starter-web
2. spring-boot-starter-data-jpa
3. spring-boot-starter-test
4. h2
5. lombok
6. opencsv
7. modelmapper
8. mockito-core
9. junit

## Setup
1. Create a `trade-reports` folder in the base directory. All the trade reports will be saved in this folder.
2. Open the project in IntelliJ.
3. The database is populated with test data present in `src/main/resources/data.sql` file.

## Starting the application
1. Build and run the application in IntelliJ.

## Testing the application
1. Run the tests in IntelliJ.

## Endpoints
* `api/v1/broker`: CRUD operations for Broker Object
* `api/v1/product`: CRUD operations for Product Object`
* `api/v1/trade`: CRUD operations for Trade Object
* `api/v1/trade-report`: Returns and generates trade reports based on query
  * GET `api/v1/trade-report/query?brokerName=<BROKER NAME>&productType=<PRODUCT TYPE>`: returns a list of trades in JSON format
  * GET `api/v1/trade-report/query/export-csv?brokerName=<BROKER_NAME>&productType=<PRODUCT_TYPE>`: creates a new report in `trade-reports` folder in CSV format

### Example
The endpoint was tested locally with Postman using the test data from `src/main/resources/data.sql` file.

```
Request:
GET localhost:8080/api/v1/trade-report/query?brokerName=Broker C&productType=FX Forward

Response:
[
    {
        "tradeRef": "Trade-2",
        "tradeDate": "2022-12-17T16:00:00.000+00:00",
        "quantity": 2000000,
        "buySell": "S",
        "price": 78.892093,
        "productId": "1",
        "productName": "AUDNZD FRD",
        "productType": "FX Forward",
        "brokerId": "3",
        "brokerName": "Broker C"
    },
    {
        "tradeRef": "Trade-4",
        "tradeDate": "2022-11-19T16:00:00.000+00:00",
        "quantity": 25000000,
        "buySell": "B",
        "price": 34.234264,
        "productId": "4",
        "productName": "EURUSD FRD",
        "productType": "FX Forward",
        "brokerId": "3",
        "brokerName": "Broker C"
    }
]
```