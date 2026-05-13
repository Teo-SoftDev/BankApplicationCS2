# 🚀 Cómo Usar Thunder Client con Bank Application

## 📥 PASO 1: Instalar Thunder Client

1. Abre **Visual Studio Code**
2. Presiona `Ctrl+Shift+X` para abrir el marketplace de extensiones
3. Busca **"Thunder Client"**
4. Haz clic en **Install** (autor: Thunder Client)
5. Espera a que termine la instalación
6. Haz clic en **Reload** o reinicia VS Code

## 📍 PASO 2: Abrir Thunder Client

Después de instalar, verás un icono de rayo ⚡ en la barra lateral izquierda:

1. Haz clic en el icono del rayo
2. Se abrirá el panel de Thunder Client en la barra lateral
3. Verás opciones como "New Request", "Collections", etc.

## 🔧 PASO 3: Configurar Tu Primera Petición

### Opción A: Importar la colección (Recomendado)

1. En Thunder Client, haz clic en **"Collections"** (icono de carpeta)
2. Haz clic en el botón **"..."** (más opciones)
3. Selecciona **"Import"**
4. Navega a: `thunder-client.json` en la raíz de tu proyecto
5. Haz clic en **Open**
6. ¡Listo! Se importarán todas las peticiones organizadas por carpetas

### Opción B: Crear manualmente

1. En Thunder Client, haz clic en **"New Request"**
2. Selecciona el método HTTP (GET, POST, etc.)
3. En el campo **URL**, escribe: `http://localhost:8080/api/backoffice/clients/12345678`
4. Haz clic en **Send**

## 🔌 PASO 4: Asegúrate que tu aplicación esté corriendo

Antes de hacer peticiones:

```bash
# En la terminal, navega a la carpeta cs2
cd cs2

# Inicia la aplicación
mvn spring-boot:run
```

Deberías ver un mensaje como:
```
Application started on http://localhost:8080
```

## 📝 PASO 5: Hacer una petición GET simple

1. Crea una **New Request**
2. Selecciona **GET** en el dropdown
3. Escribe la URL: 
   ```
   http://localhost:8080/api/backoffice/clients/12345678
   ```
4. Haz clic en **Send** (o presiona `Ctrl+Enter`)
5. Verás la respuesta a la derecha

## 📤 PASO 6: Hacer una petición POST con JSON

### Ejemplo: Crear un cliente natural

1. Crea una **New Request**
2. Selecciona **POST** en el dropdown
3. Escribe la URL:
   ```
   http://localhost:8080/api/cashier/clients/natural
   ```
4. Haz clic en la pestaña **Body**
5. Selecciona **JSON** en el dropdown
6. Pega este contenido:
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
7. Haz clic en **Send**
8. Verás la respuesta con los datos del cliente creado

## 💾 PASO 7: Guardar una petición

1. Después de crear una petición, haz clic en **Save**
2. Dale un nombre descriptivo (ej: "Crear Cliente Natural")
3. Puedes guardarla en una carpeta específica o crear una nueva
4. Haz clic en **Save**

La petición se guardará automáticamente en tus colecciones.

## 🗂️ PASO 8: Organizar en Carpetas

1. En Thunder Client, ve a **Collections**
2. Haz clic derecho en una carpeta
3. Selecciona **New Folder**
4. Dale un nombre (ej: "BackOffice")
5. Arrastra tus peticiones a las carpetas correspondientes

## 🔍 PASO 9: Ver los detalles de la respuesta

Cuando hagas una petición:

- **Status**: Código HTTP (200, 201, 400, 500, etc.)
- **Headers**: Información de la respuesta
- **Body**: Los datos devueltos (en JSON)
- **Response Time**: Tiempo que tardó la petición

## 📊 PASO 10: Usar variables (Avanzado)

Para no escribir la URL completa cada vez:

1. En Thunder Client, ve a **Collections**
2. Haz clic en **Env** (Environment)
3. Crea una nueva variable:
   ```json
   {
     "base_url": "http://localhost:8080"
   }
   ```
4. En tus peticiones, usa:
   ```
   {{base_url}}/api/backoffice/clients/12345678
   ```

## 🧪 EJEMPLO COMPLETO: Crear un flujo

### 1. Crear un usuario
```
POST http://localhost:8080/api/users
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

### 2. Crear un cliente natural
```
POST http://localhost:8080/api/cashier/clients/natural
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

### 3. Crear una cuenta para ese cliente
```
POST http://localhost:8080/api/advisor/accounts
{
  "accountNumber": "ACC001",
  "accountType": "SAVINGS",
  "clientDocument": "12345678",
  "currentBalance": 1000.00,
  "currencyType": "COP",
  "accountState": "ACTIVEACCOUNT"
}
```

### 4. Crear un préstamo para ese cliente
```
POST http://localhost:8080/api/advisor/loans
{
  "loanType": "PERSONAL",
  "clientDocument": "12345678",
  "requestedAmount": 10000.00,
  "interestRate": 8.0,
  "termInMonths": 24
}
```

### 5. Buscar el cliente
```
GET http://localhost:8080/api/backoffice/clients/12345678
```

## ⚠️ ERRORES COMUNES

### Error: "Connection refused"
- **Causa**: La aplicación no está corriendo
- **Solución**: Ejecuta `mvn spring-boot:run` en la terminal

### Error: 404 Not Found
- **Causa**: La URL es incorrecta
- **Solución**: Verifica que la URL sea exacta (mayúsculas, slashes, etc.)

### Error: 400 Bad Request
- **Causa**: El JSON tiene errores o faltan campos
- **Solución**: Valida el JSON en https://jsonlint.com/

### Error: 500 Internal Server Error
- **Causa**: Error en el servidor
- **Solución**: Revisa la consola de la aplicación para ver el error

## 📱 ATAJOS ÚTILES

| Atajo | Función |
|-------|---------|
| `Ctrl+Enter` | Enviar petición |
| `Ctrl+S` | Guardar petición |
| `Ctrl+Shift+N` | Nueva petición |
| `Tab` | Autocompletar |

## 🎯 TIPS FINALES

1. **Guarda frecuentemente** tus peticiones
2. **Usa nombres descriptivos** para encontrarlas fácil
3. **Organiza en carpetas** por módulo o rol
4. **Usa variables de entorno** para las URLs base
5. **Prueba en orden**: Usuario → Cliente → Cuenta → Préstamo → Transferencia
6. **Lee los errores** en la respuesta para entender qué falta

---

¿Preguntas? Revisa el archivo `THUNDER_CLIENT_GUIDE.md` para más detalles sobre cada endpoint.
