#!/bin/bash

# Bank Application - Ejemplos de Peticiones con CURL
# Para usar estos comandos, abre una terminal y ejecuta:
# bash curl-examples.sh

BASE_URL="http://localhost:8080"

echo "================================"
echo "Bank Application - CURL Examples"
echo "================================"
echo ""

# ==================== BACKOFFICE ====================
echo "=== BACKOFFICE ==="

echo "1. Get Client by Document"
curl -X GET "$BASE_URL/api/backoffice/clients/12345678" \
  -H "Content-Type: application/json"
echo ""
echo ""

echo "2. Get Account by Number"
curl -X GET "$BASE_URL/api/backoffice/accounts/ACC001" \
  -H "Content-Type: application/json"
echo ""
echo ""

echo "3. Get Loan by ID"
curl -X GET "$BASE_URL/api/backoffice/loans/1" \
  -H "Content-Type: application/json"
echo ""
echo ""

echo "4. Find Loans by Client"
curl -X POST "$BASE_URL/api/backoffice/loans/by-client" \
  -H "Content-Type: application/json" \
  -d '{
    "document": "12345678",
    "user": {
      "id": 1,
      "username": "admin",
      "role": "ADMIN"
    }
  }'
echo ""
echo ""

echo "5. Get Transfer by ID"
curl -X GET "$BASE_URL/api/backoffice/transfers/1" \
  -H "Content-Type: application/json"
echo ""
echo ""

echo "6. Find Transfers by Client"
curl -X POST "$BASE_URL/api/backoffice/transfers/by-client" \
  -H "Content-Type: application/json" \
  -d '{
    "document": "12345678",
    "user": {
      "id": 1,
      "username": "admin",
      "role": "ADMIN"
    }
  }'
echo ""
echo ""

echo "7. Approve Loan"
curl -X POST "$BASE_URL/api/backoffice/loans/1/approve" \
  -H "Content-Type: application/json"
echo ""
echo ""

# ==================== CASHIER ====================
echo "=== CASHIER ==="

echo "8. Create Natural Client"
curl -X POST "$BASE_URL/api/cashier/clients/natural" \
  -H "Content-Type: application/json" \
  -d '{
    "document": "12345678",
    "name": "Juan",
    "lastName": "Pérez",
    "email": "juan@example.com",
    "phone": "3001234567",
    "address": "Calle 1 #1",
    "birthDate": "1990-01-01",
    "role": "CLIENTE"
  }'
echo ""
echo ""

echo "9. Create Business Client"
curl -X POST "$BASE_URL/api/cashier/clients/business" \
  -H "Content-Type: application/json" \
  -d '{
    "document": "900123456",
    "name": "Empresa XYZ",
    "lastName": "SAS",
    "email": "empresa@example.com",
    "phone": "6012345678",
    "address": "Calle 5 #50",
    "birthDate": "2000-01-01",
    "role": "EMPRESA"
  }'
echo ""
echo ""

echo "10. Update Account Balance"
curl -X POST "$BASE_URL/api/cashier/accounts/update-balance" \
  -H "Content-Type: application/json" \
  -d '{
    "accountNumber": "ACC001",
    "newBalance": 5000.00
  }'
echo ""
echo ""

# ==================== PRODUCT ADVISOR ====================
echo "=== PRODUCT ADVISOR ==="

echo "11. Create Account"
curl -X POST "$BASE_URL/api/advisor/accounts" \
  -H "Content-Type: application/json" \
  -d '{
    "accountNumber": "ACC001",
    "accountType": "SAVINGS",
    "clientDocument": "12345678",
    "currentBalance": 1000.00,
    "currencyType": "COP",
    "accountState": "ACTIVEACCOUNT"
  }'
echo ""
echo ""

echo "12. Create Loan"
curl -X POST "$BASE_URL/api/advisor/loans" \
  -H "Content-Type: application/json" \
  -d '{
    "loanType": "PERSONAL",
    "clientDocument": "12345678",
    "requestedAmount": 10000.00,
    "interestRate": 8.0,
    "termInMonths": 24
  }'
echo ""
echo ""

# ==================== COMPANY EMPLOYEE ====================
echo "=== COMPANY EMPLOYEE ==="

echo "13. Create Transfer"
curl -X POST "$BASE_URL/api/employee/transfers" \
  -H "Content-Type: application/json" \
  -d '{
    "originAccountNumber": "ACC001",
    "destinationAccountNumber": "ACC002",
    "amount": 1000.00
  }'
echo ""
echo ""

# ==================== COMPANY SUPERVISOR ====================
echo "=== COMPANY SUPERVISOR ==="

echo "14. Approve Transfer"
curl -X POST "$BASE_URL/api/supervisor/transfers/1/approve" \
  -H "Content-Type: application/json"
echo ""
echo ""

# ==================== USERS ====================
echo "=== USERS ==="

echo "15. Create User"
curl -X POST "$BASE_URL/api/users" \
  -H "Content-Type: application/json" \
  -d '{
    "document": "87654321",
    "name": "Admin",
    "lastName": "User",
    "email": "admin@example.com",
    "phone": "3009876543",
    "address": "Calle 10 #100",
    "username": "admin",
    "password": "password123",
    "role": "ADMIN",
    "userState": "ACTIVE"
  }'
echo ""
echo ""

# ==================== ACCOUNTS ====================
echo "=== ACCOUNTS ==="

echo "16. Create Account"
curl -X POST "$BASE_URL/api/accounts" \
  -H "Content-Type: application/json" \
  -d '{
    "accountNumber": "ACC003",
    "accountType": "CHECKING",
    "clientDocument": "12345678",
    "currentBalance": 2000.00,
    "currencyType": "COP",
    "accountState": "ACTIVEACCOUNT"
  }'
echo ""
echo ""

# ==================== LOANS ====================
echo "=== LOANS ==="

echo "17. Create Loan"
curl -X POST "$BASE_URL/api/loans" \
  -H "Content-Type: application/json" \
  -d '{
    "loanType": "MORTGAGE",
    "clientDocument": "12345678",
    "requestedAmount": 50000.00,
    "interestRate": 5.5,
    "termInMonths": 60
  }'
echo ""
echo ""

# ==================== TRANSFERS ====================
echo "=== TRANSFERS ==="

echo "18. Create Transfer"
curl -X POST "$BASE_URL/api/transfers" \
  -H "Content-Type: application/json" \
  -d '{
    "originAccountNumber": "ACC001",
    "destinationAccountNumber": "ACC002",
    "amount": 500.00
  }'
echo ""
echo ""

echo "================================"
echo "¡Ejemplos completados!"
echo "================================"
