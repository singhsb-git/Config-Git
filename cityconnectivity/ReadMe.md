## CityConnectivity

** Project details**

 This program determines if two cities are connected.  Two cities are considered connected if there’s a series of roads that can be traveled from one city to another. 
 
List of roads is available in a file. The file contains a list of city pairs (one pair per line, comma separated), which indicates that there’s a road between those cities. 

It will be deployed as a Spring Boot App and expose one endpoint: **http://localhost:8080/connected?origin=city1&destination=city2**

Swagger is enabled as - **http://localhost:8080/swagger-ui.html**

**Implementation details:**

The program responds with ‘yes’ if city1 is connected to city2, ’no’ if city1 is not connected to city2. Any unexpected input should result in a ’no’ response. 

## Example: 

 **city.csv** content is: 
 
 Boston, New York 
 
 Philadelphia, Newark
 
 Newark, Boston
 
 Trenton, Albany   
 
 
   http://localhost:8080/connected?origin=Boston&destination=Newark 
   
   Should return yes 
   
   http://localhost:8080/connected?origin=Boston&destination=Philadelphia 
   
   Should return yes 
   
   http://localhost:8080/connected?origin=Philadelphia&destination=Albany 
   
   Should return no   