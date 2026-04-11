# EVALUACION 2 - ConstruccionDeSoftware2-MateoGuisao

## Informacion general
- Estudiante(s): Integrantes no informados en README.md
- Rama evaluada: main
- Commit evaluado: 000b77ad99551e500f3847b633c433d2376b34d7
- Fecha: 2026-04-11

---

## Tabla de calificacion

| Criterio | Peso | Puntaje (1-5) | Parcial |
|---|---|---|---|
| 1. Modelado de dominio | 20% | 1 | 0.20 |
| 2. Modelado de puertos | 20% | 1 | 0.20 |
| 3. Modelado de servicios de dominio | 20% | 1 | 0.20 |
| 4. Enums y estados | 10% | 1 | 0.10 |
| 5. Reglas de negocio criticas | 10% | 1 | 0.10 |
| 6. Bitacora y trazabilidad | 5% | 1 | 0.05 |
| 7. Estructura interna de dominio | 10% | 1 | 0.10 |
| 8. Calidad tecnica base en domain | 5% | 1 | 0.05 |
| **SUBTOTAL** | 100% | | **1.00** |

### Calculo
Nota base = Σ((puntaje_i / 5) * peso_i) / 20 = 20 / 20 = **1.00**

### Penalizaciones aplicadas
Nota base ajustada a minimo por ausencia total de codigo de dominio.

---

## Nota final
**0.0 / 5.0**

---

## Hallazgos

### Criticos
- **Sin codigo fuente:** El repositorio solo contiene README.md, LICENSE y .gitignore. No existe ningun archivo de codigo Java ni ninguna estructura de proyecto.
- **Ninguna entidad de dominio:** No hay ninguna clase, enum, interfaz ni servicio implementado.
- **Ninguna rama con codigo:** Tanto la rama main como la ausencia de rama develop confirman que no se realizaron commits de codigo.
- **Entrega nula:** El commit evaluado (000b77ad) corresponde al commit inicial de creacion del repositorio, sin ningun aporte de codigo fuente.
- **Integrantes no informados en README.md.**

---

## Recomendaciones
El estudiante debe comenzar el proyecto desde cero implementando al menos:
1. La estructura de paquetes del dominio: `domain/models/`, `domain/ports/`, `domain/services/`.
2. Las entidades basicas: Cliente, CuentaBancaria, Prestamo, Transferencia, Usuario, BitacoraOperacion, ProductoBancario.
3. Los enums de estados: EstadoCuenta, EstadoPrestamo, EstadoTransferencia, TipoCuenta, Moneda, RolSistema, EstadoUsuario.
4. Al menos tres puertos de salida del dominio como interfaces Java.
5. Al menos dos servicios de dominio con logica de negocio real.
