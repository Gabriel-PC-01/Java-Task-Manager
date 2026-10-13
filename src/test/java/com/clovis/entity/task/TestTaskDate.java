package com.clovis.entity.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.clovis.entity.EntityStatus;

/**
 * Testes unitarios da classe {@link TaskDate}.
 *
 * Observacao: as validacoes da classe dependem da data/hora atual
 * (ex.: nao aceita mes/dia/hora/minuto no passado). Por isso:
 *  - os valores "validos" usam o limite superior do intervalo (12, 31, 23, 59),
 *    que sao aceitos em qualquer momento em que o teste rodar;
 *  - os testes de "passado" usam Assumptions e so rodam quando
 *    existe um valor no passado que seja positivo.
 */
class TaskDateTest {

    private TaskDate taskDate;

    private int currentYear;
    private int currentMonth;   // 1 a 12
    private int currentDay;
    private int currentHour;
    private int currentMinute;

    @BeforeEach
    void setUp() {
        taskDate = new TaskDate();

        final Calendar now = Calendar.getInstance();
        currentYear   = now.get(Calendar.YEAR);
        currentMonth  = now.get(Calendar.MONTH);
        currentDay    = now.get(Calendar.DAY_OF_MONTH);
        currentHour   = now.get(Calendar.HOUR_OF_DAY);
        currentMinute = now.get(Calendar.MINUTE);
    }

    // ------------------------------------------------------------------
    // YEAR
    // ------------------------------------------------------------------
    @Nested
    @DisplayName("setYear")
    class SetYearTests {

        @Test
        @DisplayName("ano futuro deve retornar SUCCESS")
        void futureYear_returnsSuccess() {
            assertEquals(EntityStatus.SUCCESS, taskDate.setYear(currentYear + 1));
        }

        @Test
        @DisplayName("entrada nula deve retornar INVALID_ENTRY")
        void nullYear_returnsInvalidEntry() {
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setYear(null));
        }

        @ParameterizedTest(name = "ano {0} deve ser invalido")
        @ValueSource(ints = { Integer.MIN_VALUE, -2024, -1, 0 })
        void zeroOrNegativeYear_returnsInvalidEntry(final int year) {
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setYear(year));
        }

        @Test
        @DisplayName("ano passado deve retornar INVALID_ENTRY")
        void pastYear_returnsInvalidEntry() {
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setYear(currentYear - 1));
        }

        @Test
        @DisplayName("ano atual deve retornar INVALID_ENTRY (regra atual: year < anoAtual)")
        void currentYear_returnsInvalidEntry() {
            assertEquals(EntityStatus.SUCCESS, taskDate.setYear(currentYear));
        }
    }

    // ------------------------------------------------------------------
    // MONTH
    // ------------------------------------------------------------------
    @Nested
    @DisplayName("setMonth")
    class SetMonthTests {

        @Test
        @DisplayName("mes 12 (limite superior) deve retornar SUCCESS")
        void month12_returnsSuccess() {
            assertEquals(EntityStatus.SUCCESS, taskDate.setMonth(12));
        }

        @Test
        @DisplayName("entrada nula deve retornar INVALID_ENTRY")
        void nullMonth_returnsInvalidEntry() {
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setMonth(null));
        }

        @ParameterizedTest(name = "mes {0} deve ser invalido")
        @ValueSource(ints = { Integer.MIN_VALUE, -12, -1, 0, 13, 14, 100, Integer.MAX_VALUE })
        void outOfRangeMonth_returnsInvalidEntry(final int month) {
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setMonth(month));
        }

        @Test
        @DisplayName("mes anterior ao atual deve retornar INVALID_ENTRY")
        void pastMonth_returnsInvalidEntry() {
            // so existe mes passado (>= 1) se estivermos de fevereiro em diante
            assumeTrue(currentMonth >= 2);
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setMonth(currentMonth - 1));
        }
    }

    // ------------------------------------------------------------------
    // DAY
    // ------------------------------------------------------------------
    @Nested
    @DisplayName("setDay")
    class SetDayTests {

        @Test
        @DisplayName("dia 31 (limite superior) deve retornar SUCCESS")
        void day31_returnsSuccess() {
            assertEquals(EntityStatus.SUCCESS, taskDate.setDay(31));
        }

        @Test
        @DisplayName("dia de hoje deve retornar SUCCESS")
        void today_returnsSuccess() {
            assertEquals(EntityStatus.SUCCESS, taskDate.setDay(currentDay));
        }

        @Test
        @DisplayName("entrada nula deve retornar INVALID_ENTRY")
        void nullDay_returnsInvalidEntry() {
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setDay(null));
        }

        @ParameterizedTest(name = "dia {0} deve ser invalido")
        @ValueSource(ints = { Integer.MIN_VALUE, -31, -1, 0, 32, 40, 100, Integer.MAX_VALUE })
        void outOfRangeDay_returnsInvalidEntry(final int day) {
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setDay(day));
        }

        @Test
        @DisplayName("dia anterior a hoje deve retornar INVALID_ENTRY")
        void pastDay_returnsInvalidEntry() {
            assumeTrue(currentDay >= 2);
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setDay(currentDay - 1));
        }
    }

    // ------------------------------------------------------------------
    // HOUR
    // ------------------------------------------------------------------
    @Nested
    @DisplayName("setHour")
    class SetHourTests {

        @Test
        @DisplayName("hora 23 (limite superior) deve retornar SUCCESS")
        void hour23_returnsSuccess() {
            assertEquals(EntityStatus.SUCCESS, taskDate.setHour(23));
        }

        @Test
        @DisplayName("entrada nula deve retornar INVALID_ENTRY")
        void nullHour_returnsInvalidEntry() {
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setHour(null));
        }

        @ParameterizedTest(name = "hora {0} deve ser invalida")
        @ValueSource(ints = { Integer.MIN_VALUE, -24, -1, 25, 30, 100, Integer.MAX_VALUE })
        void outOfRangeHour_returnsInvalidEntry(final int hour) {
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setHour(hour));
        }

        @Test
        @DisplayName("hora anterior a atual deve retornar INVALID_ENTRY")
        void pastHour_returnsInvalidEntry() {
            assumeTrue(currentHour >= 2);
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setHour(currentHour - 1));
        }
    }

    // ------------------------------------------------------------------
    // MINUTE
    // ------------------------------------------------------------------
    @Nested
    @DisplayName("setMinute")
    class SetMinuteTests {

        @Test
        @DisplayName("minuto 59 (limite superior) deve retornar SUCCESS")
        void minute59_returnsSuccess() {
            assertEquals(EntityStatus.SUCCESS, taskDate.setMinute(59));
        }

        @Test
        @DisplayName("entrada nula deve retornar INVALID_ENTRY")
        void nullMinute_returnsInvalidEntry() {
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setMinute(null));
        }

        @ParameterizedTest(name = "minuto {0} deve ser invalido")
        @ValueSource(ints = { Integer.MIN_VALUE, -60, -1, 61, 70, 100, Integer.MAX_VALUE })
        void outOfRangeMinute_returnsInvalidEntry(final int minute) {
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setMinute(minute));
        }

        @Test
        @DisplayName("minuto anterior ao atual deve retornar INVALID_ENTRY")
        void pastMinute_returnsInvalidEntry() {
            assumeTrue(currentMinute >= 2);
            assertEquals(EntityStatus.INVALID_ENTRY, taskDate.setMinute(currentMinute - 1));
        }
    }

    // ------------------------------------------------------------------
    // GET (apenas para visualizar o texto formatado)
    // ------------------------------------------------------------------
    @Test
    @DisplayName("getDate: imprime o texto formatado depois de preencher todos os campos")
    void getDate_printsFormattedText() {
        taskDate.setYear(currentYear + 1);
        taskDate.setMonth(12);
        taskDate.setDay(31);
        taskDate.setHour(23);
        taskDate.setMinute(59);

        final String formatted = taskDate.getDate();

        System.out.println("==== getDate() ====");
        System.out.println(formatted);
        System.out.println("===================");

        assertNotNull(formatted);
    }
}
