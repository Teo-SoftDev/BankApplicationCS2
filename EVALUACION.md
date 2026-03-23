# EVALUACIÓN - BankApplicationCS2

## Información General
- **Estudiante(s):** Teo-SoftDev
- **Rama evaluada:** develop
- **Fecha de evaluación:** 2026-03-23

---

## Tabla de Calificación

| # | Criterio | Peso | Puntaje (1–5) | Nota ponderada |
|---|---|---|---|---|
| 1 | Modelado de dominio | 25% | 4 | 1.00 |
| 2 | Relaciones entre entidades | 15% | 5 | 0.75 |
| 3 | Uso de Enums | 15% | 4 | 0.60 |
| 4 | Manejo de estados | 5% | 3 | 0.15 |
| 5 | Tipos de datos | 5% | 1 | 0.05 |
| 6 | Separación Usuario vs Cliente | 10% | 5 | 0.50 |
| 7 | Bitácora | 5% | 3 | 0.15 |
| 8 | Reglas básicas de negocio | 5% | 3 | 0.15 |
| 9 | Estructura del proyecto | 10% | 5 | 0.50 |
| 10 | Repositorio | 10% | 2 | 0.20 |
| **TOTAL** | | **100%** | | **4.05 / 5 (base)** |

> Nota base = (4/5×0.25 + 5/5×0.15 + 4/5×0.15 + 3/5×0.05 + 1/5×0.05 + 5/5×0.10 + 3/5×0.05 + 3/5×0.05 + 5/5×0.10 + 2/5×0.10) × 5 = 0.81 × 5 = **4.05**

---

## Penalizaciones

| Penalización | Descuento | Nota resultante |
|---|---|---|
| Variables mal nombradas: `Transfer.OriginAccount` usa PascalCase en lugar de camelCase (`originAccount`) | -10% | 4.05 × 0.90 = **3.65** |

---

## Bonus

| Bonus | % |
|---|---|
| Código limpio y bien estructurado (servicios con responsabilidad única, ports bien definidos) | +2% |
| Nombres claros y consistentes en inglés | +1% |

> Nota con bonus = 3.645 × 1.03 = **3.75 → 3.8**

---

## Nota Final: **3.8 / 5.0**

---

## Análisis por Criterio

### 1. Modelado de dominio — 4/5
Entidades presentes: `Person` (abstracta), `Client extends Person`, `User extends Person`, `Product` (abstracta), `Account extends Product`, `Loan extends Product`, `Transfer`, `Binnacle`.  
**Fortaleza:** Todas las entidades clave del dominio bancario están representadas. La jerarquía `Product → Account / Loan` es un diseño sólido y correcto.  
**Problema:** `Client` es una clase única que usa el enum `ClientRole (NATURALCLIENT / BUSINESSCLIENT)` en lugar de tener subclases específicas `PersonClient` y `CorporateClient`. Una empresa típicamente tiene atributos distintos a una persona natural (NIT, representante legal, sector económico) que no pueden representarse con un solo enum. La jerarquía correcta sería `Client` (abstracta) → `PersonClient` / `CorporateClient`.

### 2. Relaciones entre entidades — 5/5
Todas las relaciones usan **referencias directas a objetos**, no IDs primitivos:
- `Account` → `Client holder` ✅
- `Loan` → `Client requestingClient`, `Account destinationAccount` ✅
- `Transfer` → `Account OriginAccount`, `Account DestinationAccount` ✅
- `Client` → `ArrayList<Product> productsList` ✅
- `Binnacle` → `User userId`, `Product productId` ✅

Este es el punto más sólido del proyecto: el modelo de objetos está correctamente enlazado sin dependencias en IDs primitivos.

### 3. Uso de Enums — 4/5
Enums implementados: `AccountState`, `AccountType`, `Currency`, `LoanState`, `LoanType`, `Role`, `UserState`, `ClientRole`, `ProdCategory` ✅  
**Problema 1:** `Transfer.loanState` usa el enum `LoanState` — semánticamente incorrecto. Una transferencia necesita su propio enum `TransferState` (PENDING, COMPLETED, REJECTED, etc.).  
**Problema 2:** `Binnacle.operationType` es `String` en lugar de un enum (`OperationType`) con valores como `DEPOSIT`, `WITHDRAWAL`, `TRANSFER`, `LOAN_APPROVAL`, etc.

### 4. Manejo de estados — 3/5
`Account` tiene `AccountState` ✅, `Loan` tiene `LoanState` ✅, `User` tiene `UserState` ✅.  
**Problema:** `Transfer` reutiliza `LoanState` como estado de la transferencia, lo cual es conceptualmente incorrecto. No hay métodos de transición de estado en ninguna entidad (sin `activate()`, `block()`, `approve()`, `reject()`).

### 5. Tipos de datos — 1/5
- **Montos monetarios:** `double currentBalance` (Account), `double requestedAmount`, `double approvedAmount`, `double interestRate` (Loan), `double amount` (Transfer) — todos deben ser `BigDecimal` para evitar errores de punto flotante en aplicaciones financieras ❌
- **Fechas:** `java.util.Date` en Account, Transfer; `java.sql.Date` en Person — ambas deben ser `java.time.LocalDate` o `java.time.LocalDateTime` ❌

### 6. Separación Usuario vs Cliente — 5/5
`Person` (abstracta) es la base común. `Client extends Person` con `clientRole: ClientRole` y `productsList: ArrayList<Product>` define la relación con los productos bancarios. `User extends Person` con `role: Role` (empleado bancario) y `userState: UserState` representa al administrador del sistema.  
Las dos jerarquías son completamente independientes, con responsabilidades claramente diferenciadas y sin contaminación cruzada. Separación excelente.

### 7. Bitácora — 3/5
`Binnacle` tiene estructura con referencias a entidades: `User userId` ✅ y `Product productId` ✅. Tiene `operationDate: Date` ✅.  
**Problema 1:** `operationType: String` — debería ser un enum `OperationType` para restringir los tipos de operación válidos.  
**Problema 2:** `details: String` es demasiado rígido — un campo de tipo `Map<String, Object>` o JSON string permitiría almacenar información variable según el tipo de operación.

### 8. Reglas básicas de negocio — 3/5
`CreateClient.createClient()` verifica duplicado por documento antes de guardar ✅ y lanza `BusinessException` descriptiva ✅.  
`CreateUser.createUser()` aplica la misma lógica ✅.  
**Problema:** `CreateAccount` y `ApprovalCompanyTransfers` están completamente vacíos — son clases sin implementación. Falta validación de saldo antes de transferencia, reglas de aprobación de préstamos, apertura de cuenta con saldo mínimo.

### 9. Estructura del proyecto — 5/5
Estructura de paquetes excelente con arquitectura hexagonal:
```
bankapp/
  domain/
    models/       ← entidades y enums de dominio
    ports/        ← interfaces de salida (ClientPort, UserPort)
    services/     ← casos de uso de dominio
    Exceptions/   ← excepciones de dominio
```
La correcta separación en `models`, `ports`, `services` y `Exceptions` demuestra comprensión de los principios de arquitectura hexagonal (puertos y adaptadores). Es el proyecto con la estructura más limpia del grupo.

### 10. Repositorio — 2/5
- **Nombre:** `BankApplicationCS2` — no sigue la convención del curso (`ConstruccionDeSoftware2-[NombreEstudiante]`) ❌
- **Commits:** 6 commits en `develop` ✅. Mensajes: "Creacion de las primeras clases", "Creation of classes and editing the existing classes", "Creation of user/client ports and services" — no siguen la convención ADD/CHG ❌
- **README:** Solo contiene el título del repositorio, sin descripción, tecnologías ni instrucciones ❌
- **Ramas:** `main` y `develop` ✅
- **Tag de entrega:** No existe ❌

---

## Fortalezas
- Arquitectura hexagonal correctamente aplicada con interfaces `ClientPort` / `UserPort` y servicios que dependen de ellas.
- Todas las relaciones entre entidades usan referencias a objetos (no IDs primitivos) — el mejor uso de relaciones del grupo.
- Jerarquía `Product` (abstracta) → `Account` / `Loan` es un diseño elegante que reduce duplicación.
- `Person` abstracta unifica los atributos comunes de `Client` y `User` sin mezclar sus responsabilidades.
- Enums bien nombrados y en inglés para la gran mayoría de catálogos del dominio.

## Oportunidades de mejora
- **Crítico:** Usar `BigDecimal` para todos los montos monetarios y `java.time.LocalDate`/`LocalDateTime` para fechas.
- **Importante:** Agregar subclases `PersonClient` y `CorporateClient` para modelar los diferentes atributos de cada tipo de cliente.
- **Importante:** Crear enum `TransferState` para `Transfer`; el campo `loanState: LoanState` es semánticamente incorrecto en una transferencia.
- Completar la implementación de `CreateAccount` y `ApprovalCompanyTransfers`.
- Agregar enum `OperationType` en `Binnacle` y usar `Map<String, Object>` para el campo `details`.
- Corregir la convención PascalCase en el atributo `Transfer.OriginAccount` → debe ser `originAccount`.
- Actualizar el README con descripción, tecnologías usadas y pasos de ejecución.
- Agregar tag de entrega: `git tag v1.0-entrega1`.
- Reemplazar prefijo de commits con convención ADD/CHG/FIX.
