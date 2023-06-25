# BudgetMeApp
BudgetMeApp is a personal budgeting application created with principle learnt from Springboot course.

Transaction - id, date, category(dropdown), detail, spent, month(dropdown)

Home  - category spending balance monthwise (category, actual, planned, category balance, month, total actual, total planned, total balance)
Planning - category, planned, month

Table
transaction - id, date, category, detail, spent, month
planning - category, planned, month

Operations
Transaction tab - 
Api - CRUD

Home tab -
Monthy calculation - 
categorywise transaction addition same catgory spent addition in a month
*category balance = planned - actual
*total actual= sum of category actual
*total planned= sum of category planned 
*total balance = sum of planned -  sum of actual
Api - R
month based selection

Planning tab-
Api - CRUD
month based selection


Home
back processed(java) - category, actual, planned
front processed(js, html) - category balance, total actual, total planned, total balance

category - planning (those categories which are planned shows up)
actual - transaction (sum of transactions spent as per category)
planned - planning (planned as per categories)
select p.category, SUM(t.spent) as actual, p.planned from budgetme.transaction t INNER JOIN budgetme.planning p ON t.category=p.category 
WHERE t.month='JAN' GROUP BY category, planned ORDER BY category;

Go to root folder
mvnw spring-boot:run
