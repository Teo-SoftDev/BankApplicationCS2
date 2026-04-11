# EVALUACION 2 - BankApplicationCS2

## Informacion general
- Estudiante(s): Integrantes no informados en README.md
- Rama evaluada: develop
- Commit evaluado: 9804db6b4be8700ae63db8a415c8b78e1a7b37e6
- Fecha: 2026-04-11

---

## Tabla de calificacion

| Criterio | Peso | Puntaje (1-5) | Parcial |
|---|---|---|---|
| 1. Modelado de dominio | 20% | 3 | 0.60 |
| 2. Modelado de puertos | 20% | 2 | 0.40 |
| 3. Modelado de servicios de dominio | 20% | 2 | 0.40 |
| 4. Enums y estados | 10% | 3 | 0.30 |
| 5. Reglas de negocio criticas | 10% | 2 | 0.20 |
| 6. Bitacora y trazabilidad | 5% | 2 | 0.10 |
| 7. Estructura interna de dominio | 10% | 3 | 0.30 |
| 8. Calidad tecnica base en domain | 5% | 3 | 0.15 |
| **SUBTOTAL** | 100% | | **2.45** |

### Calculo
Nota base = Σ((puntaje_i / 5) * peso_i) / 20 = 49 / 20 = **2.45**

### Penalizaciones aplicadas
Ninguna penalizacion mayor aplicable. No hay JPA en domain, no hay codigo en espanol, no hay estados criticos en String.

---

## Nota final
**2.5 / 5.0**

---

## Hallazgos

### Positivos
- Buen modelado de entidades: Account (extiende Product), Client (extiende Person), User, Loan, Transfer, Binnacle, con herencia logica.
- Enums bien definidos: AccountState, AccountType, ClientRole, Currency, LoanState, LoanType, ProdCategory, Role, UserState.
- Dominio desacoplado de JPA (no hay @Entity en domain).
- Dos puertos con firmas semanticas: ClientPort y UserPort con validacion de existencia.
- Dos servicios con logica de negocio real (CreateClient, CreateUser): validan duplicados antes de guardar.
- BusinessException para errores de dominio.
- Estructura models/ports/services correctamente organizada.

### Negativos
- **Ports incompletos:** Solo ClientPort y UserPort. Faltan AccountPort, LoanPort, TransferPort, BinnaclePort. Los casos de uso de cuenta, prestamo y transferencia no tienen contrato de salida.
- **Servicios vacios:** CreateAccount y ApprovalCompanyTransfers estan completamente vacios, sin ninguna logica.
- **Bug critico en Transfer:** El campo `loanState` es de tipo `LoanState` en lugar de un tipo propio de transferencia (TransferState/TransferStatus). No existe enum TransferState.
- **ClientPort.findByDocument:** Recibe `Client` como parametro en lugar de `String document`, firma semanticamente incorrecta.
- **Binnacle basica:** Entidad Binnacle existe pero `operationType` como String; no hay BitacoraPort para append/query.
- **Puertos sin consultas:** ClientPort.findByDocument usa el objeto completo en lugar de solo el identificador. UserPort idem.
- **Sin reglas de transferencia:** No hay validacion de saldo, estado de cuenta, monto > 0, ni aprobacion por supervisor para alto monto empresarial.
- **Sin reglas de prestamo:** No hay servicios para aprobar/rechazar/desembolsar prestamos con sus transiciones de estado.
- **README sin integrantes:** No se informaron nombres de estudiantes.

---

## Recomendaciones
1. Crear AccountPort, LoanPort, TransferPort y BinnaclePort con firmas semanticas del negocio.
2. Implementar CreateAccount con validaciones: cuenta existente, cliente existente, estado inicial.
3. Corregir Transfer: reemplazar `loanState` por un enum propio `TransferStatus` con estados PENDING, AWAITING_APPROVAL, EXECUTED, REJECTED, EXPIRED.
4. Implementar ApprovalCompanyTransfers con logica de vencimiento a 60 minutos y verificacion de supervisor.
5. Agregar servicios de prestamo: CreateLoan, ApproveLoan, RejectLoan, DisburseLoan con transiciones de estado.
6. Corregir firmas de puertos: `findByDocument(String document)` en lugar de `findByDocument(Client client)`.
7. Incorporar nombres de integrantes en README.md.
