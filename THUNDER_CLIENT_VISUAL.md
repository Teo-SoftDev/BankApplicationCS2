# 🖥️ Interfaz de Thunder Client - Guía Visual

## 📌 Pantalla Principal de Thunder Client

```
┌─────────────────────────────────────────────────────────────────┐
│ ⚡ Thunder Client                                            ▼ ║
├─────────────────────────────────────────────────────────────────┤
│                                                                   │
│ Sidebar Izquierdo:                                               │
│ ┌─────────────────────────────┐    ┌──────────────────────────┐ │
│ │ ⚡ Thunder Client          │    │ New Request              │ │
│ │                             │    │ GET ▼                    │ │
│ │ 📂 Collections              │    │                          │ │
│ │   📁 BackOffice             │    │ http://localhost:8080    │ │
│ │     • Get Client            │    │ /api/backoffice/clients/ │ │
│ │     • Get Account           │    │ 12345678                 │ │
│ │     • Approve Loan          │    │                          │ │
│ │   📁 Cashier                │    │ ┌──────────────────────┐ │ │
│ │     • Create Client         │    │ │ Headers              │ │ │
│ │     • Get Client            │    │ │ Body                 │ │ │
│ │   📁 Product Advisor        │    │ │ Params               │ │ │
│ │     • Create Account        │    │ │ Authorization        │ │ │
│ │     • Create Loan           │    │ └──────────────────────┘ │ │
│ │                             │    │                          │ │
│ │ 📌 Recent                   │    │  [Send] (Ctrl+Enter)    │ │
│ │ ⭐ Favorites                │    │                          │ │
│ │ 🔍 Search                   │    │                          │ │
│ │ ⚙️  Settings                 │    │                          │ │
│ │                             │    │                          │ │
│ └─────────────────────────────┘    └──────────────────────────┘ │
│                                                                   │
│                       Panel Derecha (Response)                   │
│                                                                  │
│                     Status: 200 OK (12ms)                       │
│                                                                  │
│                     {                                           │
│                       "id": 1,                                  │
│                       "document": "12345678",                   │
│                       "name": "Juan Pérez",                     │
│                       "email": "juan@example.com",              │
│                       "phone": "3001234567"                     │
│                     }                                           │
│                                                                  │
└─────────────────────────────────────────────────────────────────┘
```

---

## 🎛️ Secciones de una Petición

### 1. Barra de URL y Método

```
┌─────────────────────────────────────────────────────────┐
│ GET ▼ │ http://localhost:8080/api/backoffice/clients/123 │
│       │                                                  │
│ Opciones:                                               │
│ • GET     - Obtener datos                               │
│ • POST    - Crear datos                                 │
│ • PUT     - Actualizar todos los campos                 │
│ • PATCH   - Actualizar algunos campos                   │
│ • DELETE  - Eliminar datos                              │
└─────────────────────────────────────────────────────────┘
```

### 2. Pestaña Headers

```
┌─────────────────────────────────────────┐
│ Headers  Body  Params  Authorization    │
├─────────────────────────────────────────┤
│ Key                 Value                │
│ ────────────────────────────────────────│
│ Content-Type        application/json    │
│ Authorization       Bearer <token>      │
│                                         │
│ [+ Add Header]                          │
└─────────────────────────────────────────┘
```

### 3. Pestaña Body (JSON)

```
┌─────────────────────────────────────────┐
│ Headers  Body ▼  Params  Authorization  │
├─────────────────────────────────────────┤
│ JSON ▼                                   │
│                                         │
│ {                                       │
│   "document": "12345678",               │
│   "name": "Juan",                       │
│   "lastName": "Pérez",                  │
│   "email": "juan@example.com",          │
│   "phone": "3001234567",                │
│   "address": "Calle 1 #1",              │
│   "birthDate": "1990-01-01",            │
│   "role": "CLIENTE"                     │
│ }                                       │
│                                         │
└─────────────────────────────────────────┘
```

### 4. Panel de Respuesta

```
┌─────────────────────────────────────────────┐
│ Response (200 OK)  Tests  Headers  ...      │
├─────────────────────────────────────────────┤
│                                             │
│ Status: 200 OK                              │
│ Time: 45ms                                  │
│ Size: 234 bytes                             │
│                                             │
│ {                                           │
│   "id": 1,                                  │
│   "document": "12345678",                   │
│   "name": "Juan Pérez",                     │
│   "email": "juan@example.com",              │
│   "phone": "3001234567",                    │
│   "address": "Calle 1 #1",                  │
│   "birthDate": "1990-01-01",                │
│   "role": "CLIENTE"                         │
│ }                                           │
│                                             │
└─────────────────────────────────────────────┘
```

---

## 🔄 Cómo Enviar una Petición

```
1. Escribe/selecciona el método
   ↓
2. Escribe la URL
   ↓
3. Agrega Headers si necesitas (normalmente no)
   ↓
4. Para POST/PUT: Agrega el Body (JSON)
   ↓
5. Haz clic en [Send] o Ctrl+Enter
   ↓
6. ¡Ves la respuesta a la derecha!
```

---

## 📂 Estructura de Carpetas en Colecciones

```
🏦 Bank Application
├── 📁 BackOffice
│   ├── Get Client
│   ├── Get Account
│   ├── Approve Loan
│   └── Approve Transfer
│
├── 📁 Cashier
│   ├── Create Natural Client
│   ├── Create Business Client
│   ├── Get Client
│   └── Update Balance
│
├── 📁 Product Advisor
│   ├── Create Account
│   ├── Create Loan
│   ├── Get Account
│   └── Get Loan
│
├── 📁 Company Employee
│   ├── Create Transfer
│   ├── Get Account
│   ├── Get Transfer
│   └── Get Loan
│
├── 📁 Company Supervisor
│   ├── Approve Loan
│   ├── Approve Transfer
│   ├── Find Loans by Client
│   └── Find Transfers by Client
│
└── 📁 General
    ├── Create User
    ├── Create Account
    ├── Create Loan
    └── Create Transfer
```

---

## 🎯 Colores de Status HTTP

```
✅ Verde     200-299   Éxito
⚠️  Amarillo  300-399   Redirección
❌ Rojo      400-499   Error del cliente
🔴 Rojo oscuro 500-599  Error del servidor
```

---

## 🖱️ Botones Principales

```
┌──────────────────────────────────────┐
│ [Send]        Envía la petición      │
│ [Save]        Guarda la petición     │
│ [...]         Más opciones           │
│ [X]           Cierra la petición     │
└──────────────────────────────────────┘
```

---

## 💾 Guardando Peticiones

```
Después de crear una petición:
1. Haz clic en [Save]
2. Dale un nombre descriptivo
   Ej: "Crear Cliente Natural"
3. Selecciona una carpeta o crea una
4. Haz clic en [Save]

La petición se guardará y aparecerá 
en tu lista de Collections
```

---

## 🔐 Headers Comunes

```json
{
  "Content-Type": "application/json",
  "Accept": "application/json",
  "Authorization": "Bearer YOUR_TOKEN"
}
```

Para nuestro proyecto, **solo necesitas**:
```
Content-Type: application/json
```

---

## 📊 Ciclo Completo de Petición

```
┌────────────────────────────────────────────────────────┐
│                 TÚ (Thunder Client)                    │
│              [Tu Máquina - Puerto 3000]                │
│                                                        │
│ 1. Escribes la petición                                │
│    GET /api/backoffice/clients/12345678               │
│                                                        │
│    ↓ (Red - Internet/Local)                            │
│                                                        │
│ 2. ┌──────────────────────────────────────────────┐  │
│    │  SERVIDOR SPRING BOOT (localhost:8080)       │  │
│    │                                               │  │
│    │  BackOfficeController                        │  │
│    │  → BackOfficeUseCase                         │  │
│    │  → Servicios de Dominio                      │  │
│    │  → Base de Datos                             │  │
│    └──────────────────────────────────────────────┘  │
│                                                        │
│    ↓ (Red - Respuesta)                                │
│                                                        │
│ 3. Recibes la respuesta (JSON)                        │
│    {                                                  │
│      "id": 1,                                         │
│      "document": "12345678",                          │
│      "name": "Juan Pérez"                             │
│    }                                                  │
│                                                        │
│ 4. ¡Listo! Ves el resultado en Thunder Client         │
│                                                        │
└────────────────────────────────────────────────────────┘
```

---

## ⌨️ Atajos de Teclado

```
Ctrl+Enter      Enviar petición
Ctrl+S          Guardar petición
Ctrl+Shift+N    Nueva petición
Tab             Autocompletar
Enter           En campos de búsqueda
```

---

## 🆘 Panel de Errores

```
Si ves un error, Thunder Client lo mostrará en rojo:

❌ Connection refused
   → La app no está corriendo
   → Ejecuta: mvn spring-boot:run

❌ 404 Not Found
   → La URL es incorrecta
   → Verifica el endpoint

❌ 400 Bad Request
   → El JSON tiene errores
   → Valida en jsonlint.com

❌ 500 Internal Server Error
   → Error en la app
   → Mira la consola
```

---

¡Ahora ya sabes cómo usar Thunder Client! 🎉
