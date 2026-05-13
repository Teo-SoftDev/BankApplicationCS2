# ⚡ Referencia Rápida de Endpoints - Bank Application

## Base URL
```
http://localhost:8080
```

---

## 📋 Tabla de Endpoints

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| **GET** | `/api/backoffice/clients/{document}` | Buscar cliente por documento |
| **GET** | `/api/backoffice/accounts/{accountNumber}` | Buscar cuenta por número |
| **GET** | `/api/backoffice/loans/{loanId}` | Buscar préstamo por ID |
| **POST** | `/api/backoffice/loans/by-client` | Buscar préstamos de un cliente |
| **GET** | `/api/backoffice/transfers/{transferId}` | Buscar transferencia por ID |
| **POST** | `/api/backoffice/transfers/by-client` | Buscar transferencias de un cliente |
| **POST** | `/api/backoffice/loans/{loanId}/approve` | Aprobar préstamo |
| **POST** | `/api/backoffice/transfers/{transferId}/approve` | Aprobar transferencia |
| **POST** | `/api/cashier/clients/natural` | Crear cliente natural |
| **POST** | `/api/cashier/clients/business` | Crear cliente comercial |
| **GET** | `/api/cashier/clients/{document}` | Buscar cliente |
| **GET** | `/api/cashier/accounts/{accountNumber}` | Buscar cuenta |
| **POST** | `/api/cashier/accounts/update-balance` | Actualizar saldo |
| **POST** | `/api/advisor/accounts` | Crear cuenta |
| **GET** | `/api/advisor/accounts/{accountNumber}` | Buscar cuenta |
| **POST** | `/api/advisor/loans` | Crear préstamo |
| **GET** | `/api/advisor/loans/{loanId}` | Buscar préstamo |
| **POST** | `/api/employee/transfers` | Crear transferencia |
| **GET** | `/api/employee/accounts/{accountNumber}` | Buscar cuenta |
| **GET** | `/api/employee/transfers/{transferId}` | Buscar transferencia |
| **GET** | `/api/employee/loans/{loanId}` | Buscar préstamo |
| **POST** | `/api/supervisor/loans/{loanId}/approve` | Aprobar préstamo |
| **POST** | `/api/supervisor/transfers/{transferId}/approve` | Aprobar transferencia |
| **POST** | `/api/supervisor/loans/by-client` | Buscar préstamos por cliente |
| **POST** | `/api/supervisor/transfers/by-client` | Buscar transferencias por cliente |
| **POST** | `/api/users` | Crear usuario |
| **POST** | `/api/accounts` | Crear cuenta |
| **POST** | `/api/loans` | Crear préstamo |
| **POST** | `/api/transfers` | Crear transferencia |

---

## 🔄 Flujo Recomendado de Pruebas

```
1. Crear Usuario
   POST /api/users

2. Crear Cliente (Natural o Business)
   POST /api/cashier/clients/natural
   POST /api/cashier/clients/business

3. Crear Cuenta para Cliente
   POST /api/advisor/accounts

4. Crear Préstamo para Cliente
   POST /api/advisor/loans

5. Crear Segunda Cuenta
   POST /api/advisor/accounts

6. Crear Transferencia
   POST /api/employee/transfers

7. Aprobar Préstamo
   POST /api/supervisor/loans/{id}/approve

8. Aprobar Transferencia
   POST /api/supervisor/transfers/{id}/approve
```

---

## 🎯 Ejemplos por Rol

### 👨‍💼 Cashier (Cajero)
```
POST /api/cashier/clients/natural
GET /api/cashier/clients/{document}
POST /api/cashier/accounts/update-balance
```

### 💼 Product Advisor (Asesor de Productos)
```
POST /api/advisor/accounts
POST /api/advisor/loans
GET /api/advisor/accounts/{accountNumber}
GET /api/advisor/loans/{loanId}
```

### 👨‍💻 Company Employee (Empleado)
```
POST /api/employee/transfers
GET /api/employee/accounts/{accountNumber}
GET /api/employee/transfers/{transferId}
```

### 👔 Company Supervisor (Supervisor)
```
POST /api/supervisor/loans/{loanId}/approve
POST /api/supervisor/transfers/{transferId}/approve
GET /api/supervisor/loans/by-client
GET /api/supervisor/transfers/by-client
```

### 🏦 BackOffice
```
GET /api/backoffice/clients/{document}
GET /api/backoffice/accounts/{accountNumber}
POST /api/backoffice/loans/{loanId}/approve
```

---

## 📦 Estructura de Requests

### POST - Crear Cliente Natural
```json
{
  "document": "12345678",
  "name": "Juan",
  "lastName": "Pérez",
  "email": "juan@example.com",
  "phone": "3001234567",
  "address": "Calle 1 #1",
  "birthDate": "1990-01-01",
  "role": "CLIENTE"
}
```

### POST - Crear Cuenta
```json
{
  "accountNumber": "ACC001",
  "accountType": "SAVINGS",
  "clientDocument": "12345678",
  "currentBalance": 1000.00,
  "currencyType": "COP",
  "accountState": "ACTIVEACCOUNT"
}
```

### POST - Crear Préstamo
```json
{
  "loanType": "PERSONAL",
  "clientDocument": "12345678",
  "requestedAmount": 10000.00,
  "interestRate": 8.0,
  "termInMonths": 24
}
```

### POST - Crear Transferencia
```json
{
  "originAccountNumber": "ACC001",
  "destinationAccountNumber": "ACC002",
  "amount": 1000.00
}
```

### POST - Buscar Préstamos por Cliente
```json
{
  "document": "12345678",
  "user": {
    "id": 1,
    "username": "admin",
    "role": "ADMIN"
  }
}
```

---

## 🔑 Valores de Enums

**AccountType**: SAVINGS, CHECKING, INVESTMENT
**Currency**: COP, USD, EUR
**AccountState**: ACTIVEACCOUNT, INACTIVEACCOUNT
**LoanType**: PERSONAL, MORTGAGE, BUSINESS
**LoanState**: INSTUDY, APPROVED, REJECTED
**Role**: ADMIN, CLIENTE, EMPRESA, SUPERVISOR, BACKOFFICE, CASHIER, ADVISOR, EMPLOYEE
**UserState**: ACTIVE, INACTIVE
**TransferState**: PENDING, COMPLETED, REJECTED

---

## ✅ Códigos de Estado HTTP

| Código | Significado |
|--------|------------|
| 200 | OK - Petición exitosa |
| 201 | Created - Recurso creado |
| 400 | Bad Request - Datos inválidos |
| 404 | Not Found - Recurso no encontrado |
| 500 | Server Error - Error en el servidor |

---

## 🛠️ Herramientas Recomendadas

- **Thunder Client** - Extensión de VS Code (recomendado)
- **Postman** - Aplicación de escritorio
- **curl** - Línea de comandos
- **REST Client** - Otra extensión de VS Code

---

## 📁 Archivos de Referencia

- `COMO_USAR_THUNDER_CLIENT.md` - Guía paso a paso
- `THUNDER_CLIENT_GUIDE.md` - Guía completa de endpoints
- `thunder-client.json` - Colección importable
- `curl-examples.sh` - Ejemplos con curl
- `QUICK_REFERENCE.md` - Este archivo

---

## 🚀 Quick Start

```bash
# 1. Iniciar la aplicación
cd cs2
mvn spring-boot:run

# 2. Abrir Thunder Client en VS Code
# - Presiona Ctrl+Shift+X
# - Busca "Thunder Client"
# - Instala

# 3. Importar colección
# - Abre Thunder Client (icono rayo)
# - Collections > ... > Import
# - Selecciona: thunder-client.json

# 4. ¡Hacer peticiones!
```

---
