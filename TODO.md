### 📌 Fallos y problemas encontrados
1. **Tablas inexistentes en H2**
    - `InvalidDataAccessResourceUsageException`: “Table 'USUARIOS' not found” al persistir usuario/incidencia en tests con H2.
2. **Repositorios auto-configurados con H2 vs Testcontainers**
    - `TestDatabaseAutoConfiguration` sustituye el DataSource sin H2 en classpath, o mal ajuste de `@AutoConfigureTestDatabase`.
3. **Falta de bean `TestRestTemplate`**
    - `UnsatisfiedDependencyException` en `IncidenciaIntegrationTest`: no se detecta `TestRestTemplate`.
4. **Comparaciones de `LocalDateTime` en mapper tests**
    - Mismatch en nanosegundos al mapear y volver a mapear (assertEquals fallido).
5. **Assert de Content-Type en controller tests**
    - Esperaba `application/json` pero obtenía `application/json;charset=UTF-8`.
6. **Mocking de servicios – UnnecessaryStubbingException**
    - Mockito en strict mode detecta stubbings innecesarios en tests de delete/update.
7. **Mocking de delete – NotFoundException inesperada**
    - En `Servicio.delete(...)` el mock de `findById` no devuelve el objeto y lanza NotFoundException en tests de borrado.
8. **Warning de `printStackTrace()`**
    - Se recomendó reemplazar con logging más robusto.
9. **Hang en Surefire al finalizar**
    - Mensaje “Surefire is going to kill self fork JVM…” debido a hilos no-daemon o llamadas a `System.exit(0)`.
10. **Errores de foreign keys al limpiar schema**
    - Durante el drop de tablas en H2 aparecen errores `Unsuccessful: alter table … drop foreign key …`.
11. **Configuración de Testcontainers**
    - Propiedades dinámicas (`@DynamicPropertySource`) faltaban o mal apuntadas, causando que MySQL no levante esquema.

---

> 🔧 Con esta lista tenemos tanto el plan de acción como un registro de los obstáculos que han surgido.
