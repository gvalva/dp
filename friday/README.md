# Family Friday
This application will take a list of employees and randomly assign them to tables that can seat 3-5 guests. 

## Application Architecture
In order to meet the seat requirements (min=3, max=5), a bottom up dynamic programming solution was used to determine the **minimum** number of tables. The tables were then placed in a list and each employee was randomly assigned to a table within the list.



## Dynamic Programming Approach
My first approach was to take the total number of employees and apply a modulus function for each table size. During unit testing, I quickly realized that the solution would not work. 

The second approach was to use bottom up dynamic programming. The solution was to solve how many tables were needed for zero people (SUM[0]), one person (SUM[1]), two people (SUM[2]), all the way until the the total. This was done for each table size and SUM[i] was used to store how many tables were needed. A separate array R[] was also used to keep track of the table size.

### Pseudocode

```
Given Inputs: 
	- int total : total # of employees
	- int[] tables: Array of table sizes [3,5]


Set SUM[i] equal to Infinity for all of i
Set R[i] equal to -1

SUM[0]=0
R[0]=-1

For table_index = 0 to tables length
	For each partial SUM[i] from i=1 to total
		If SUM[i] >= size of table at table_index
			If SUM[i - tables[table_index] + 1 < SUM[i]
				Set SUM[i] = SUM[i - tables[table_index] + 1
				Set R[i] = table_index
```

## Running the application

To run the application navigate to root of the application and run a `chmod 755 run.sh`. To build test and run the application `./run.sh`.
