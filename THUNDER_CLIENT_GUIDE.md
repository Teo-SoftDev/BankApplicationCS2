# Thunder Client - Guía de Peticiones para Bank Application

## Instalación de Thunder Client

1. Abre VS Code
2. Ve a la sección de Extensiones (Ctrl+Shift+X)
3. Busca "Thunder Client"
4. Instala la extensión de "Thunder Client"
5. Aparecerá un ícono de rayo en la barra lateral izquierda

## Cómo hacer peticiones

### 1. Abrir Thunder Client
- Haz clic en el ícono de rayo en la barra lateral izquierda
- Se abrirá el panel de Thunder Client

### 2. Crear una nueva petición
- Haz clic en "New Request" o usa el atajo
- Selecciona el método HTTP (GET, POST, etc.)
- Escribe la URL base: `http://localhost:8080`

### 3. Estructura de peticiones

Para POST con body JSON:
```
POST http://localhost:8080/api/clients/natural
Body (JSON):
{
  "document": "12345678",
  "name": "Juan Pérez",
  "email": "juan@example.com",
  "phone": "3001234567",
  "address": "Calle 1 #1",
  "role": "CLIENTE"
}
```

---

## ENDPOINTS POR CONTROLADOR

### 🏦 BackOffice Controller (`/api/backoffice`)

**GET** - Buscar cliente por documento
```
GET http://localhost:8080/api/backoffice/clients/12345678
```
Response:
```json
{
  "id": 1,
  "document": "12345678",
  "name": "Juan Pérez",
  "email": "juan@example.com",
  "phone": "3001234567",
  "address": "Calle 1 #1",
  "birthDate": "1990-01-01",
  "role": "CLIENTE"
}
```

**GET** - Buscar cuenta por número
```
GET http://localhost:8080/api/backoffice/accounts/ACC001
```

**GET** - Buscar préstamo por ID
```
GET http://localhost:8080/api/backoffice/loans/1
```

**POST** - Buscar préstamos por cliente
```
POST http://localhost:8080/api/backoffice/loans/by-client
Body (JSON):
{
  "document": "12345678",
  "user": {
    "id": 1,
    "username": "admin",
    "role": "ADMIN"
  }
}
```

**GET** - Buscar transferencia por ID
```
GET http://localhost:8080/api/backoffice/transfers/1
```

**POST** - Buscar transferencias por cliente
```
POST http://localhost:8080/api/backoffice/transfers/by-client
Body (JSON):
{
  "document": "12345678",
  "user": {
    "id": 1,
    "username": "admin",
    "role": "ADMIN"
  }
}
```

**POST** - Aprobar préstamo
```
POST http://localhost:8080/api/backoffice/loans/1/approve
```

**POST** - Aprobar transferencia
```
POST http://localhost:8080/api/backoffice/transfers/1/approve
```

---

### 👨‍💼 Cashier Controller (`/api/cashier`)

**POST** - Crear cliente natural
```
POST http://localhost:8080/api/cashier/clients/natural
Body (JSON):
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

**POST** - Crear cliente comercial
```
POST http://localhost:8080/api/cashier/clients/business
Body (JSON):
{
  "document": "900123456",
  "name": "Empresa XYZ",
  "lastName": "SAS",
  "email": "empresa@example.com",
  "phone": "6012345678",
  "address": "Calle 5 #50",
  "birthDate": "2000-01-01",
  "role": "EMPRESA"
}
```

**GET** - Buscar cliente por documento
```
GET http://localhost:8080/api/cashier/clients/12345678
```

**GET** - Buscar cuenta por número
```
GET http://localhost:8080/api/cashier/accounts/ACC001
```

**POST** - Actualizar saldo de cuenta
```
POST http://localhost:8080/api/cashier/accounts/update-balance
Body (JSON):
{
  "accountNumber": "ACC001",
  "newBalance": 5000.00
}
```

---

### 💼 Product Advisor Controller (`/api/advisor`)

**POST** - Crear cuenta
```
POST http://localhost:8080/api/advisor/accounts
Body (JSON):
{
  "accountNumber": "ACC001",
  "accountType": "SAVINGS",
  "clientDocument": "12345678",
  "currentBalance": 1000.00,
  "currencyType": "COP",
  "accountState": "ACTIVEACCOUNT"
}
```

**GET** - Buscar cuenta por número
```
GET http://localhost:8080/api/advisor/accounts/ACC001
```

**POST** - Crear préstamo
```
POST http://localhost:8080/api/advisor/loans
Body (JSON):
{
  "loanType": "MORTGAGE",
  "clientDocument": "12345678",
  "requestedAmount": 50000.00,
  "interestRate": 5.5,
  "termInMonths": 60
}
```

**GET** - Buscar préstamo por ID
```
GET http://localhost:8080/api/advisor/loans/1
```

---

### 👨‍💻 Company Employee Controller (`/api/employee`)

**POST** - Crear transferencia
```
POST http://localhost:8080/api/employee/transfers
Body (JSON):
{
  "originAccountNumber": "ACC001",
  "destinationAccountNumber": "ACC002",
  "amount": 1000.00
}
```

**GET** - Buscar cuenta por número
```
GET http://localhost:8080/api/employee/accounts/ACC001
```

**GET** - Buscar transferencia por ID
```
GET http://localhost:8080/api/employee/transfers/1
```

**GET** - Buscar préstamo por ID
```
GET http://localhost:8080/api/employee/loans/1
```

---

### 👔 Company Supervisor Controller (`/api/supervisor`)

**POST** - Aprobar préstamo
```
POST http://localhost:8080/api/supervisor/loans/1/approve
```

**POST** - Aprobar transferencia
```
POST http://localhost:8080/api/supervisor/transfers/1/approve
```

**POST** - Buscar préstamos por cliente
```
POST http://localhost:8080/api/supervisor/loans/by-client
Body (JSON):
{
  "document": "12345678",
  "user": {
    "id": 1,
    "username": "supervisor",
    "role": "SUPERVISOR"
  }
}
```

**POST** - Buscar transferencias por cliente
```
POST http://localhost:8080/api/supervisor/transfers/by-client
Body (JSON):
{
  "document": "12345678",
  "user": {
    "id": 1,
    "username": "supervisor",
    "role": "SUPERVISOR"
  }
}
```

---

### 👤 User Controller (`/api/users`)

**POST** - Crear usuario
```
POST http://localhost:8080/api/users
Body (JSON):
{
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
}
```

---

### 🏦 Account Controller (`/api/accounts`)

**POST** - Crear cuenta
```
POST http://localhost:8080/api/accounts
Body (JSON):
{
  "accountNumber": "ACC003",
  "accountType": "CHECKING",
  "clientDocument": "12345678",
  "currentBalance": 2000.00,
  "currencyType": "COP",
  "accountState": "ACTIVEACCOUNT"
}
```

---

### 💳 Loan Controller (`/api/loans`)

**POST** - Crear préstamo
```
POST http://localhost:8080/api/loans
Body (JSON):
{
  "loanType": "PERSONAL",
  "clientDocument": "12345678",
  "requestedAmount": 10000.00,
  "interestRate": 8.0,
  "termInMonths": 24
}
```

---

### 💸 Transfer Controller (`/api/transfers`)

**POST** - Crear transferencia
```
POST http://localhost:8080/api/transfers
Body (JSON):
{
  "originAccountNumber": "ACC001",
  "destinationAccountNumber": "ACC002",
  "amount": 500.00
}
```

---

## VALORES PARA LOS ENUMS

### AccountType
- SAVINGS
- CHECKING
- INVESTMENT

### Currency
- COP
- USD
- EUR

### AccountState
- ACTIVEACCOUNT
- INACTIVEACCOUNT

### LoanType
- PERSONAL
- MORTGAGE
- BUSINESS

### LoanState
- INSTUDY
- APPROVED
- REJECTED

### Role
- ADMIN
- CLIENTE
- EMPRESA
- SUPERVISOR
- BACKOFFICE
- CASHIER
- ADVISOR
- EMPLOYEE

### UserState
- ACTIVE
- INACTIVE

### TransferState
- PENDING
- COMPLETED
- REJECTED

---

## TIPS PARA THUNDER CLIENT

1. **Guardar peticiones**: Haz clic en el botón de guardar para que se guarden automáticamente
2. **Usar variables**: Puedes crear variables para reutilizar valores
3. **Historial**: Todas tus peticiones se guardan en el historial
4. **Colecciones**: Organiza tus peticiones en colecciones por módulo
5. **Tests**: Puedes agregar tests para validar respuestas
6. **Headers**: Agrega headers como `Content-Type: application/json` si es necesario

## PASOS PARA EMPEZAR

1. Inicia tu aplicación Spring Boot: `mvn spring-boot:run`
2. Abre Thunder Client en VS Code
3. Copia cualquier petición de esta guía
4. Pégala en Thunder Client
5. Haz clic en "Send"
6. Verás la respuesta en el panel derecho

---
