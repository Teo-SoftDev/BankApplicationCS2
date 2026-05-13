# 🎬 Inicio Rápido - Thunder Client (5 minutos)

## 1️⃣ INSTALAR

```
Ctrl+Shift+X  →  Busca "Thunder Client"  →  Install
```

## 2️⃣ ABRIR

Haz clic en el ícono de **rayo ⚡** en la barra lateral izquierda

## 3️⃣ IMPORTAR COLECCIÓN (Recomendado)

```
Thunder Client  →  Collections  →  ...  →  Import
→ Selecciona: thunder-client.json
→ ¡Listo! Todas las peticiones aparecerán
```

## 4️⃣ INICIAR LA APLICACIÓN

```bash
cd cs2
mvn spring-boot:run
```

Espera a ver: `Application started on http://localhost:8080`

## 5️⃣ HACER UNA PETICIÓN

### Opción A: Usar una petición guardada
1. Expande una carpeta en Thunder Client
2. Haz clic en una petición
3. Presiona `Ctrl+Enter` o haz clic en **Send**

### Opción B: Crear manual
1. New Request
2. Selecciona **GET**
3. Escribe: `http://localhost:8080/api/backoffice/clients/12345678`
4. Haz clic en **Send**

---

## 📍 PETICIONES MÁS USADAS

### Crear Cliente
```
POST /api/cashier/clients/natural

{
  "document": "12345678",
  "name": "Juan",
  "lastName": "Pérez",
  "email": "juan@example.com",
  "phone": "3001234567",
  "address": "Calle 1",
  "birthDate": "1990-01-01",
  "role": "CLIENTE"
}
```

### Buscar Cliente
```
GET /api/backoffice/clients/12345678
```

### Crear Cuenta
```
POST /api/advisor/accounts

{
  "accountNumber": "ACC001",
  "accountType": "SAVINGS",
  "clientDocument": "12345678",
  "currentBalance": 1000.00,
  "currencyType": "COP",
  "accountState": "ACTIVEACCOUNT"
}
```

### Crear Préstamo
```
POST /api/advisor/loans

{
  "loanType": "PERSONAL",
  "clientDocument": "12345678",
  "requestedAmount": 10000.00,
  "interestRate": 8.0,
  "termInMonths": 24
}
```

### Crear Transferencia
```
POST /api/employee/transfers

{
  "originAccountNumber": "ACC001",
  "destinationAccountNumber": "ACC002",
  "amount": 1000.00
}
```

### Aprobar Préstamo
```
POST /api/supervisor/loans/1/approve
```

---

## 🎯 WORKFLOW EJEMPLO

```
1. POST /api/users
   → Crear usuario

2. POST /api/cashier/clients/natural
   → Crear cliente
   
3. POST /api/advisor/accounts
   → Crear cuenta

4. POST /api/advisor/loans
   → Crear préstamo

5. POST /api/supervisor/loans/1/approve
   → Aprobar préstamo
```

---

## 💡 TIPS

- **Guardar peticiones**: Haz clic en Save
- **Ver respuesta**: Panel derecho después de Send
- **Error 404**: Verifica la URL
- **Error 400**: Revisa el JSON
- **Error 500**: Mira la consola de la app

---

## 📚 MÁS INFORMACIÓN

- Guía completa: `COMO_USAR_THUNDER_CLIENT.md`
- Todos los endpoints: `THUNDER_CLIENT_GUIDE.md`
- Referencia rápida: `QUICK_REFERENCE.md`
- Ejemplos con curl: `curl-examples.sh`

---

**¿Listo?** ⚡ Ahora abre Thunder Client e importa `thunder-client.json`
